package kosta.web.mvc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kosta.web.mvc.domain.Recommend;

public interface RecommendService {

	/**
	 * 추천등록
	 * */
	void insert(Recommend recommend);
	
	/**
	 * 추천삭제
	 * */
	void delete(Recommend recommend);
	
	/**
	 * 글에 해당하는 추천목록
	 * */
	List<Recommend> recommendList(Long bno);
	
	/**
	 * 전체추천목록
	 * */
	Page<Recommend> selectAll(Pageable pageable);
}
