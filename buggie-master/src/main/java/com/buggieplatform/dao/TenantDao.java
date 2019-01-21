package com.buggieplatform.dao;

import java.util.List;

import com.buggieplatform.entity.Tenant;

public interface TenantDao {
	Boolean createTenant(Tenant tenantdata);
	List<Tenant> getAllTenants(String username);
	List<Tenant> getAll();
	void updateProject(Tenant data);
}
