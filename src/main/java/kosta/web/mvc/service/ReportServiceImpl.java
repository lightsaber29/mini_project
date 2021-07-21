package kosta.web.mvc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kosta.web.mvc.domain.Report;
import kosta.web.mvc.repository.ReportRepository;
@Service
@Transactional
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportRepository rpRep;
	
	@Override
	public void insert(Report report) {
		rpRep.save(report);
	}

	@Override
	public void delete(Report report) {
		Report dbReport = rpRep.findById(report.getReportNo()).orElse(null);
		if(dbReport.getReportState()!=0) {
			throw new RuntimeException("관리자에 의해 신고처리가 된 글은 삭제할 수 없습니다.");
		}
		rpRep.deleteById(report.getReportNo());
	}

	@Override
	public Page<Report> selectAll(Pageable pageable) {
		return rpRep.findAll(pageable);
	}

	@Override
	public void update(Report report) {
		Report dbReport = rpRep.findById(report.getReportNo()).orElse(null);
		dbReport.setReportState(report.getReportState());
	}

}
