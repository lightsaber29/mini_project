package kosta.web.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.web.mvc.domain.Board;
import kosta.web.mvc.domain.Member;
import kosta.web.mvc.domain.Recommend;
import kosta.web.mvc.service.BoardService;
import kosta.web.mvc.service.RecommendService;

@Controller
@RequestMapping("/recommend")
public class RecommendController {

	@Autowired
	private RecommendService recommendService;
	
	/**
	 * 추천등록
	 * */
	@RequestMapping("/insert/{bno}")
	public String insert(@PathVariable Long bno) {
		Recommend recommend = new Recommend();
		recommend.setBoard(new Board(bno));
		//회원정보필요
		recommend.setMember(new Member(100L));
		recommendService.insert(recommend);
		
		return "redirect:/board/detail/"+bno+"?flag=1";
	}
	
	/**
	 * 추천삭제
	 * */
	@RequestMapping("/delete/{bno}")
	public String delete(@PathVariable Long bno) {
		Recommend recommend = new Recommend();
		recommend.setBoard(new Board(bno));
		//회원정보필요
		recommend.setMember(new Member(100L));
		recommendService.delete(recommend);
		
		return "redirect:/board/detail/"+bno+"?flag=1";
	}
	
	/**
	 * 글에 해당하는 추천목록
	 * */
	
	/**
	 * 전체추천목록
	 * */
	@RequestMapping("/list")
	public void list() {}
	
	/**
	 * 예외처리
	 * */
	@ExceptionHandler(RuntimeException.class)
	public ModelAndView error(RuntimeException e) {
		return new ModelAndView("error/errorView", "errMsg",e.getMessage());
	}
}
