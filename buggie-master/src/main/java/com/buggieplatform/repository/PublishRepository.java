package com.buggieplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.buggieplatform.entity.Publish;

import ch.qos.logback.classic.net.SyslogAppender;

@RepositoryRestResource(exported= false)
public interface PublishRepository extends JpaRepository<Publish, String> {


	//Feature getAllFeature();

}