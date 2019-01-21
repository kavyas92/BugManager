package com.buggieplatform.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buggieplatform.dao.TenantDao;

@Repository
public class TenantProject {
	
	@Autowired
	   private TenantDao tenantDao;
	   public void activate(Tenant data){
		   System.out.println("in activate"+data.getProjectState());
		   tenantDao.updateProject(data);
	     // System.out.println("Stock [ Name: "+name+",   Quantity: " + quantity +" ] bought");
	   }
	   public void deactivate(Tenant data){
		   System.out.println("in deactivate");
		   tenantDao.updateProject(data);
	      //System.out.println("Stock [ Name: "+name+",  Quantity: " + quantity +" ] sold");
	   }
}
