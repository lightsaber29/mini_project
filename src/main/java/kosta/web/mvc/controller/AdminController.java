package kosta.web.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kosta.web.mvc.domain.Report;
import kosta.web.mvc.service.ReportService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ReportService reportService;
	
	/**
	 * admin index
	 * */
	@RequestMapping("/index")
	public void index() {}
	
	/**
	 * 전체 신고목록
	 * */
	@RequestMapping("/reportList")
	public void reportList(Model model , @RequestParam(defaultValue = "1")  int nowPage) {
		Pageable pageable = PageRequest.of((nowPage-1), 3, Direction.DESC, "reportNo");
		Page<Report> pageList = reportService.selectAll(pageable);

		  int blockCount=3;
		  int temp = (nowPage-1) % blockCount ; 
	      int startPage = nowPage - temp;
	      
		 model.addAttribute("pageList", pageList); //뷰페이지에서 ${pageList.메소드이름}
		 model.addAttribute("blockCount", blockCount); 
		 model.addAttribute("nowPage", nowPage); 
		 model.addAttribute("startPage", startPage); 
	}
	
	/**
	 * 신고상태 수정
	 * */
	@RequestMapping("/update")
	public void update() {}
	
	/**
	 * 예외처리
	 * */
	@ExceptionHandler(RuntimeException.class)
	public ModelAndView error(RuntimeException e) {
		return new ModelAndView("error/errorView", "errMsg",e.getMessage());
	}
}
