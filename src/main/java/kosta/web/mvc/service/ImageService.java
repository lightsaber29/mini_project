package kosta.web.mvc.service;

import java.util.List;

import kosta.web.mvc.domain.Image;

public interface ImageService {

	/**
	 * 사진등록
	 * */
	void insert(Image image);
	
	/**
	 * 사진삭제
	 * */
	void delete(Long bno);
	
	/**
	 * 글번호에 해당하는 사진 검색
	 * */
	List<Image> selectByBno(Long bno);
}
