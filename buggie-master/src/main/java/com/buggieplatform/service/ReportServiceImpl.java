package com.buggieplatform.service;

import org.springframework.stereotype.Repository;

import com.buggieplatform.entity.Report;

@Repository
public abstract class ReportServiceImpl {
	protected ReportSubjectImpl reportSubject;

	public abstract void updateReport(Report ret);
}
