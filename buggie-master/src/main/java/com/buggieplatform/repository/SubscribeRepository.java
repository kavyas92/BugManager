package com.buggieplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.buggieplatform.entity.Subscribe;

import ch.qos.logback.classic.net.SyslogAppender;

@RepositoryRestResource(exported= false)
public interface SubscribeRepository extends JpaRepository<Subscribe, String> {


	//Feature getAllFeature();

}