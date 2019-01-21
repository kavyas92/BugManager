package com.buggieplatform.service;

import org.springframework.stereotype.Repository;

import com.buggieplatform.entity.Tenant;

@Repository
public interface Command {
	void execute(Tenant data);
}
