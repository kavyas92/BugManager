package com.buggieplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.buggieplatform.entity.Tenant;

import ch.qos.logback.classic.net.SyslogAppender;

@RepositoryRestResource(exported= false)
public interface TenantRepository extends JpaRepository<Tenant, String> {


	//Tenant findBytenantUsername(String tenantUsername);

}