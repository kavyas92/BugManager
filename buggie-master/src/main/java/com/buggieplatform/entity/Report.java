package com.buggieplatform.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.buggieplatform.service.ReportServiceImpl;


@Entity
@Table(name="report")
public class Report
{
	
	//private List<ReportServiceImpl> observers = new ArrayList<ReportServiceImpl>();
    @Id
    @Column(name = "reportId")
    @GeneratedValue
    private int reportId;
    
    
    @Column(name="username")
    private String username;
    @Column(name="openState")
    private String openState;
    @Column(name="closeState")
    private String closeState;
    @Column(name="wipState")
    private String wipState;


    public Report()
    {
        super();
    }

    public Report(int reportId, String username, String openState, String closeState, String wipState)
    {
        super();
        this.reportId = reportId;
        this.username = username;
        this.openState = openState;
        this.closeState = closeState;
        this.wipState = wipState;
    }

	public int getReportId() {
		return reportId;
	}

	public int setReportId(int reportId) {
		this.reportId = reportId;
		return reportId;
	}

	private void notifyObserver() {
		System.out.println("Check the database for new log");
	}

	public String getOpenState() {
		return openState;
	}

	public String setOpenState(String openState) {
		this.openState = openState;
		notifyObserver();
		return openState;
	}

	public String getCloseState() {
		return closeState;
	}

	public String setCloseState(String closeState) {
		this.closeState = closeState;
		notifyObserver();
		return closeState;
	}

	public String getWipState() {
		return wipState;
	}

	public String setWipState(String wipState) {
		this.wipState = wipState;
		notifyObserver();
		return wipState;
	}

	public String getUsername() {
		return username;
	}

	public String setUsername(String username) {
		this.username = username;
		notifyObserver();
		return username;
	}
   
}