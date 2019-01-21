package com.buggieplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buggieplatform.dao.TenantDao;
import com.buggieplatform.entity.Tenant;
import com.buggieplatform.entity.TenantProject;

@Repository
public class CommandDeactivate implements Command{

	@Autowired
	private TenantProject tenProject;
	
	@Autowired
	private TenantDao tenantDao;
	
	public CommandDeactivate(TenantProject tenProject){
		this.tenProject = tenProject;	
	}
	
	@Override
	public void execute(Tenant data) {
		System.out.println("in deactivate **********************"+this.tenProject);
		//tenantDao.updateProject(id,data);
		tenProject.activate(data);
		
	}

}
