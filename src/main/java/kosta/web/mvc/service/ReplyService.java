package kosta.web.mvc.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kosta.web.mvc.domain.Reply;

public interface ReplyService {

	/**
	 * 댓글등록
	 * */
	void insert(Reply reply);
	
	/**
	 * 댓글수정
	 * */
	Reply update(Reply reply);
	
	/**
	 * 댓글삭제
	 * */
	void delete(Long rno);
	
	/**
	 * 댓글검색
	 * */
	Reply selectBy(Long rno);
	
	
	
}
