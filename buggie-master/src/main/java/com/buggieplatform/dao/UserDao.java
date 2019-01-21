package com.buggieplatform.dao;

import java.util.List;

import com.buggieplatform.entity.User;


public interface UserDao {
	List getLogin(String username, String pwd);
    List<User> getAllUsers();
    List<User> getUserSet(String role);
    Boolean createUser(User userData);
    User getUserDetails(String username);
    List getSubStatus(String username);
	List subscribeUser(User user);
}
