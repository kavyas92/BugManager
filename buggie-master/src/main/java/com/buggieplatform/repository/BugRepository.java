package com.buggieplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.buggieplatform.entity.Bugs;

import ch.qos.logback.classic.net.SyslogAppender;

@RepositoryRestResource(exported= false)
public interface BugRepository extends JpaRepository<Bugs, String> {


	Bugs findByBugId(int bugId);

}