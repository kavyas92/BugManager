package com.buggieplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buggieplatform.entity.Report;
import com.buggieplatform.repository.BugRepository;
import com.buggieplatform.repository.ReportRepository;
@Repository
public class ReportObserverImpl extends ReportServiceImpl{
	
	@Autowired
	private ReportRepository reportRepo;
	private ReportSubjectImpl reportSubject;
    private Report rep;
	public ReportObserverImpl(ReportSubjectImpl reportSubject) {
		this.reportSubject=reportSubject;
		this.reportSubject.attach(this);
	}
	
	@Override
	public void updateReport(Report rep) {
		
		reportRepo.save(rep);
	}
}

