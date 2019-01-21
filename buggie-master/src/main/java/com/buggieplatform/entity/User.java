package com.buggieplatform.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
public class User {

    @Id
    private String username;
    private String password;
    private String role;
    private String subscriptiontype;
    private String projectId;
    private String paymentType="credit";
    private int paymentStatus=0;

   
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSubscriptionType() {
        return subscriptiontype;
    }

    public void setSubscriptionType(String subscriptiontype) {
        this.subscriptiontype = subscriptiontype;
    }
    
    public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	

	public int getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	@Override
    public String toString() {
        return "User{" + "username='" + username + '\'' + ", password='" + password + '\'' + ", role='" + role + '\''
                + ", subcription_type='" + subscriptiontype + '\'' + ", projectId='" + projectId + '\''+   ", paymentStatus='" + paymentStatus +  ", paymentType='" + paymentType + '}';
    }

	
}