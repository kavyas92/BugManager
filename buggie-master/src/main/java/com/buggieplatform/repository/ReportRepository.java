//package com.buggieplatform.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//
//import com.buggieplatform.entity.Report;
//
//import ch.qos.logback.classic.net.SyslogAppender;
//
//@RepositoryRestResource(exported= false)
//public interface ReportRepository extends JpaRepository<Report, String> {
//
//
//	Report findByReportId(int reportId);
//
//} 

package com.buggieplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.buggieplatform.entity.Bugs;
import com.buggieplatform.entity.Report;

import ch.qos.logback.classic.net.SyslogAppender;

@RepositoryRestResource(exported= false)
public interface ReportRepository extends JpaRepository<Report, String> {


}