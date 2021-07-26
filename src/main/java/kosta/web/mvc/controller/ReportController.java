package kosta.web.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.web.mvc.domain.Board;
import kosta.web.mvc.domain.Member;
import kosta.web.mvc.domain.Report;
import kosta.web.mvc.service.BoardService;
import kosta.web.mvc.service.ReportService;

@Controller
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ReportService reportService;
	
	/**
	 * 신고 폼
	 * */
	@RequestMapping("/reportForm/{bno}")
	public ModelAndView reportForm(@PathVariable Long bno) {
		Board board = boardService.selectBy(bno, false);
		return new ModelAndView("report/reportForm", "board", board);
	}
	
	/**
	 * 신고등록
	 * */
	@RequestMapping("/insert/{bno}")
	public String insert(@PathVariable Long bno,String reportContent) {
		Board board = boardService.selectBy(bno, false);
		//회원정보 필요 - 신고인
		Report report = new Report(null, board, new Member(21070701L), reportContent, null, 0);
		reportService.insert(report);
		
		return "redirect:/board/list";
	}
	
	/**
	 * 내가 한 신고목록
	 * */
	@RequestMapping("/list")
	public void list(Model model) {
		//회원정보필요
		Member member = new Member(100L);
		List<Report> reportList= reportService.selectByMem(member.getMno());
		model.addAttribute("reportList", reportList);
	}
	
	/**
	 * 신고삭제 -> 신고처리상태가 0일 경우만 가능
	 * */
	@RequestMapping("/delete/{reportNo}")
	public String delete(@PathVariable Long reportNo) {
		reportService.delete(new Report(reportNo));
		return "redirect:/report/list";
	}
	
	/**
	 * 예외처리
	 * */
	@ExceptionHandler(RuntimeException.class)
	public ModelAndView error(RuntimeException e) {
		return new ModelAndView("error/errorView", "errMsg",e.getMessage());
	}
}
