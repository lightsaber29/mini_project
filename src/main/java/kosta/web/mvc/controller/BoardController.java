package kosta.web.mvc.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kosta.web.mvc.domain.Board;
import kosta.web.mvc.domain.Member;
import kosta.web.mvc.service.BoardService;
import kosta.web.mvc.service.ImageService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ImageService imageService;
	
	/**
	 * 전체 목록 or 조건검색
	 * */
	@RequestMapping("/list")
	public void list(Model model , @RequestParam(defaultValue = "1")  int nowPage, String keyword, String condition) {
		// List<FreeBoard> list = freeService.selectAll();
		
		Pageable pageable = PageRequest.of((nowPage-1), 3, Direction.DESC, "bno");
		Page<Board> pageList = null;//= boardService.selectAll(pageable);
		
		if(condition == null) {
			pageList = boardService.selectAll(pageable);
		}else if(condition.equals("subject")) {
			pageList = boardService.selectBySubject(keyword, pageable);
		}else if(condition.equals("content")) {
			pageList = boardService.selectByContent(keyword, pageable);
		}
		
		
		  int blockCount=3;
		  int temp = (nowPage-1) % blockCount ; 
	      int startPage = nowPage - temp;
	      
		 model.addAttribute("pageList", pageList); //뷰페이지에서 ${pageList.메소드이름}
		 model.addAttribute("blockCount", blockCount); 
		 model.addAttribute("nowPage", nowPage); 
		 model.addAttribute("startPage", startPage); 
	}
	
	/**
	 * 글 등록 폼 띄우기
	 * */
	@RequestMapping("/writeForm")
	public void writeForm() {}
	
	/**
	 * 글 등록
	 * */
	@RequestMapping("/insert")
	public String insert(Board board, MultipartHttpServletRequest mtfRequest, HttpSession session) {
		System.out.println("***************************");
		String content = board.getContent().replace("<", "&lt;");
		String subject = board.getSubject().replace("<", "&lt;");
		board.setContent(content);
		board.setSubject(subject);
		//회원정보필요
		board.setMember(new Member(100L));
		
		boardService.insert(board);
		
		//여기서 이미지업로드 같이 하기
		List<MultipartFile> fileList = mtfRequest.getFiles("file");
		System.out.println("있긴하니파일이"+fileList.size());
		int index = 1;
		if(fileList != null) {
			ServletContext application = session.getServletContext();
			String path = application.getRealPath("/WEB-INF/save/");
			for(MultipartFile mf : fileList) {
				String originFileName = mf.getOriginalFilename();
				String safeFile = path + System.currentTimeMillis() +"_"+index+ "_"+originFileName /*mno추가하기*/;
				System.out.println("파일경로임당"+safeFile);
				index++;
				//이미지 테이블에넣기
				try {
					mf.transferTo(new java.io.File(safeFile));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}
		
		
		return "redirect:/board/list";
		
	}
	
	/**
	 * 글 상세보기
	 * */
	@RequestMapping("/detail/{bno}")
	public ModelAndView detail(@PathVariable Long bno, String flag) {
		boolean state = flag == null? true : false;
		Board board = boardService.selectBy(bno, state);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/detail");
		mv.addObject("board", board);
		return mv;
		
	}
	
	/**
	 * 글 수정 폼
	 * */
	@RequestMapping("/updateForm")
	public void updateForm() {}
	
	/**
	 * 글 수정
	 * */
	@RequestMapping("/update")
	public void update() {}
	
	/**
	 * 글 삭제
	 * */
	@RequestMapping("/delete")
	public void delete() {}
	
	
	
	/**
	 * 예외처리
	 * */
	@ExceptionHandler(RuntimeException.class)
	public ModelAndView error(RuntimeException e) {
		return new ModelAndView("error/errorView", "errMsg",e.getMessage());
	}
}
