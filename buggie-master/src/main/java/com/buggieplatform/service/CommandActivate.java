package com.buggieplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buggieplatform.dao.TenantDao;
import com.buggieplatform.entity.Tenant;
import com.buggieplatform.entity.TenantProject;

@Repository
public class CommandActivate implements Command {

	@Autowired
	private TenantProject tenProject;
	 
	@Autowired
	private TenantDao tenantDao;
	
	public CommandActivate(TenantProject tenProject){
		this.tenProject = tenProject;	
	}
	
	@Override
	public void execute(Tenant data) {
		// TODO Auto-generated method stub
		tenProject.activate(data);
//		tenantDao.updateProject(id, data);
		
	}

}
