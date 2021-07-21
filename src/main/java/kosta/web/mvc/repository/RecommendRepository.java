package kosta.web.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.web.mvc.domain.Recommend;

public interface RecommendRepository extends JpaRepository<Recommend, Long> {

	List<Recommend> findByBoardBno(Long bno);
	
	Recommend findByMemberMnoAndBoardBno(Long mno, Long bno);
}
