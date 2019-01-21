package com.buggieplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.buggieplatform.entity.User;

@RepositoryRestResource(exported= false)
public interface UserRepository extends JpaRepository<User, String> {

}