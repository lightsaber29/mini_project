package kosta.web.mvc.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kosta.web.mvc.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

	Page<Board> findByMemberMno(Long mno, Pageable pageable);

	Page<Board> findBySubjectContaining(String subject, Pageable pagealbe);
	
	Page<Board> findByContentContaining(String content, Pageable pageable);
	
	@Query("update Board b set  b.readnum=b.readnum+1 where b.bno=?1")
	@Modifying
	void readnumUpdate(Long bno);
	
	@Query("update Board b set  b.recommend=b.recommend+1 where b.bno=?1")
	@Modifying
	void recommendIncrease(Long bno);
	
	@Query("update Board b set  b.recommend=b.recommend-1 where b.bno=?1")
	@Modifying
	void recommendDecrease(Long bno);
}
