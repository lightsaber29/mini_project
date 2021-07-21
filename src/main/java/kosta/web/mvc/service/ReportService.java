package kosta.web.mvc.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kosta.web.mvc.domain.Report;

public interface ReportService {

	/**
	 * 신고등록
	 * */
	void insert(Report report);
	
	/**
	 * 신고삭제 -> 신고처리상태가 0일 경우만 가능
	 * */
	void delete(Report report);
	
	/**
	 * 전체 신고목록
	 * */
	Page<Report> selectAll(Pageable pageable);
	
	/**
	 * 신고상태 수정
	 * */
	void update(Report report);
}
