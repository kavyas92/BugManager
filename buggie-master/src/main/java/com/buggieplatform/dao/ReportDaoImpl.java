//package com.buggieplatform.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.buggieplatform.entity.Bugs;
//import com.buggieplatform.entity.Report;
//import com.buggieplatform.repository.BugRepository;
//import com.buggieplatform.repository.ReportRepository;
//
//@Transactional
//@Repository
//public class ReportDaoImpl implements ReportDao{
//
////	@Autowired
////	private ReportRepository reportRepository;
////	  
////	@PersistenceContext	
////	private EntityManager em;	
////	
////	@Override
////	public Boolean createReport(Report report1) {
////		// TODO Auto-generated method stub
////		System.out.println("in dao"+report1);
////		Report report;  
////		 report = reportRepository.save(report1);
////		 if(report != null){
////			 return true;
////		 }
////		 else{
////			 return false;
////		 }
////	}
////	
////	@Override
////	public Boolean updateReport(Report report1) {
////		
////		System.out.println("in dao"+report1);
////		Report report;  
////		 report = reportRepository.save(report1);
////		 if(report != null){
////			 return true;
////		 }
////		 else{
////			 return false;
////		 }
////	}
////	
////	@Override
////	public List<Report> getAllReports() {
////		List<Report> reportList;
////		reportList= reportRepository.findAll();
////		return reportList;
////	}
//
////	@Override
////	public List getReportDetails(int reportId) {
////		List reportList;
////		return  em.createQuery(
////			    "SELECT c FROM Reports c WHERE c.reportId =:reportId")
////				.setParameter("reportId", reportId)
////			    .setMaxResults(1)
////			    .getResultList();
////	}
//
//}
