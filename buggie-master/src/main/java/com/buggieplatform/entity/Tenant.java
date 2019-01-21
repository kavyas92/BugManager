package com.buggieplatform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tenant")
public class Tenant
{
	@Id
	@Column(name = "tenantId")
	@GeneratedValue
    private int tenantId;
    @Column(name = "tenantUsername")
    private String tenantUsername;
    @Column(name="projectId")
    private String projectId;
    @Column(name="projectTitle")
    private String projectTitle;
    @Column(name="projectState")
    private String projectState;
    @Column(name="membershipStatus")
    private String membershipStatus;
  

    public Tenant()
    {
        super();
    }

    public Tenant(int tenantId, String tenantUsername, String projectId, String projectTitle, String projectState, String membershipStatus)
    {
        super();
        this.tenantId = tenantId;
        this.tenantUsername = tenantUsername;
        this.projectId = projectId;
        this.projectTitle = projectTitle;
        this.projectState = projectState;
        this.membershipStatus = membershipStatus;
    }
    

	public int getTenantId() {
		return tenantId;
	}

	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantUsername() {
		return tenantUsername;
	}

	public void setTenantUsername(String tenantUsername) {
		this.tenantUsername = tenantUsername;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getProjectState() {
		return projectState;
	}

	public void setProjectState(String projectState) {
		this.projectState = projectState;
	}

	public String getMembershipStatus() {
		return membershipStatus;
	}

	public void setMembershipStatus(String membershipStatus) {
		this.membershipStatus = membershipStatus;
	}

	

   
}