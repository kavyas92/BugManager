package com.buggieplatform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="bugs")
public class Bugs
{
    @Id
    @Column(name = "bugId")
    @GeneratedValue
    private int bugId;
    
    @Column(name="bugTitle")
    private String bugTitle;
    @Column(name="bugDesc")
    private String bugDesc;
    @Column(name="bugState")
    private String bugState;
    @Column(name="createdBy")
    private String createdBy;
    @Column(name="username")
    private String username;

    public Bugs()
    {
        super();
    }

    public Bugs(int bugId, String bugTitle, String bugDesc, String bugState, String createdBy, String username)
    {
        super();
        this.bugId = bugId;
        this.bugTitle = bugTitle;
        this.bugDesc = bugDesc;
        this.bugState = bugState;
        this.createdBy = createdBy;
        this.username = username;
    }

	public int getBugId() {
		return bugId;
	}

	public void setBugId(int bugId) {
		this.bugId = bugId;
	}

	public String getBugTitle() {
		return bugTitle;
	}

	public void setBugTitle(String bugTitle) {
		this.bugTitle = bugTitle;
	}

	public String getBugDesc() {
		return bugDesc;
	}

	public void setBugDesc(String bugDesc) {
		this.bugDesc = bugDesc;
	}

	public String getBugState() {
		return bugState;
	}

	public void setBugState(String bugState) {
		this.bugState = bugState;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

   
}