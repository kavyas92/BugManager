package com.buggieplatform.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.buggieplatform.dao.UserDao;
import com.buggieplatform.entity.User;

@Repository
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public List getLogin(String username, String pwd) {
		List usr = userDao.getLogin(username,pwd);
		return usr;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> usr = userDao.getAllUsers();
		return usr;
	}

	@Override
	public Boolean createUser(User userdata) {
		return  userDao.createUser(userdata);
		
	}

	@Override
	public User getUserDetails(String username) {
		
		return userDao.getUserDetails(username);
	}

	@Override
	public List<User> getUserSet(String role) {
		return userDao.getUserSet(role);
	}
}
