package kosta.web.mvc.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kosta.web.mvc.domain.Board;
import kosta.web.mvc.domain.Reply;

public interface BoardService {

	/**
	 * 전체 목록
	 * */
	Page<Board> selectAll(Pageable pageable);
	
	/**
	 * 글 등록
	 * */
	void insert(Board board);
	
	/**
	 * 글 상세보기
	 * */
	Board selectBy(Long bno, boolean state);
	
	/**
	 * 글 수정
	 * */
	Board update(Board board);
	
	/**
	 * 글 삭제
	 * */
	void delete(Long bno);
	
	/**
	 * 작성자 글 검색
	 * */
	Page<Board> selectByMem(Long mno, Pageable pageable);
	
	/**
	 * 내용 글 검색
	 * */
	Page<Board> selectByContent(String content, Pageable pageable);
	
	/**
	 * 제목 글 검색
	 * */
	Page<Board> selectBySubject(String subject, Pageable pageable);
	
	/**
	 * 글에 해당하는 답변목록
	 * */
	Page<Reply> replyList(Long bno, Pageable pageable);
	
	
}
