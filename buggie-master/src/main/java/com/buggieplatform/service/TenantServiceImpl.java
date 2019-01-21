package com.buggieplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buggieplatform.dao.BugDao;
import com.buggieplatform.dao.TenantDao;
import com.buggieplatform.entity.Bugs;
import com.buggieplatform.entity.Tenant;

@Repository
public class TenantServiceImpl implements TenantService{
	@Autowired
	private TenantDao tenantDao;
	
	@Override
	public Boolean createTenant(Tenant bugdata) {
		//System.out.println(bugdata.getTenantUsername());
		return tenantDao.createTenant(bugdata);
	}
	@Override
	public List<Tenant> getAll() {
		return tenantDao.getAll();
	}


	@Override
	public List<Tenant> getAllProjects(String username) {
		return tenantDao.getAllTenants(username);
	}

}
