package kosta.web.mvc.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kosta.web.mvc.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

	List<Board> findByMemberMno(Long mno);

	public Collection<Board> findBySubjectContaining(String subject);
	
	public Collection<Board> findByContentContaining(String content);
	
	@Query("update Board b set  b.readnum=b.readnum+1 where b.bno=?1")
	@Modifying
	void readnumUpdate(Long bno);
	
	@Query("update Board b set  b.recommend=b.recommend+1 where b.bno=?1")
	@Modifying
	void recommendUpdate(Long bno);
}
