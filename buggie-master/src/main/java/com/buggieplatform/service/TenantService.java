package com.buggieplatform.service;

import java.util.List;

import com.buggieplatform.entity.Tenant;

public interface TenantService {

	
	List<Tenant> getAll();
     List<Tenant> getAllProjects(String username);
     Boolean createTenant(Tenant tenantdata);
}
