package kosta.web.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.web.mvc.domain.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {

}
