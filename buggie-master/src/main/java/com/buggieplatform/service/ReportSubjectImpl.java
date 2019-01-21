package com.buggieplatform.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.buggieplatform.entity.Report;
@Repository
public class ReportSubjectImpl {
	   private List<ReportServiceImpl> observers = new ArrayList<ReportServiceImpl>();
	   private Report report;
	private Object username;
	private int id;
	private String openState;
	private String closeState;
	private Object wipState;


	   public void attach(ReportServiceImpl observer){
	      observers.add(observer);		
	   }

	   public void notifyObserver(){
	      for (ReportServiceImpl observer : observers) {
	         observer.updateReport(this.report);
	      }
	   }

	public void setUsername(String username) {
			this.username=username;
		
	}

	public void setReportId(int id) {
			this.id=id;
		
	}

	public void setOpenState(String openState) {
		this.openState=openState;
		
	}

	public void setCloseState(String closeState) {
		this.closeState=closeState;
		
	}

	public void setWipState(String wipState) {
		this.wipState=wipState;
		
	} 
}
