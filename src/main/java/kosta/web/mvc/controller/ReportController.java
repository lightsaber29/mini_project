package kosta.web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report")
public class ReportController {

	/**
	 * 신고 폼
	 * */
	@RequestMapping("/writeForm")
	public void writeForm() {}
	
	/**
	 * 신고등록
	 * */
	@RequestMapping("/insert")
	public void insert() {}
	
	/**
	 * 신고삭제 -> 신고처리상태가 0일 경우만 가능
	 * */
	@RequestMapping("/delete")
	public void delete() {}
	
	/**
	 * 전체 신고목록
	 * */
	@RequestMapping("/list")
	public void list() {}
	
	/**
	 * 신고상태 수정
	 * */
	@RequestMapping("/update")
	public void update() {}
}
