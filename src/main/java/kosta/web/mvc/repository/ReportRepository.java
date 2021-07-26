package kosta.web.mvc.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import kosta.web.mvc.domain.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {

	//Page<Report> findByMemberMno(Long mno, Pageable pageable);
	
	List<Report> findByMemberMno(Long mno);
	
	Report findByMemberMnoAndBoardBno(Long mno, Long bno);
}
