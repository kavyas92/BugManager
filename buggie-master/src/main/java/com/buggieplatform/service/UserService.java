package com.buggieplatform.service;

import java.util.List;

import com.buggieplatform.entity.User;

public interface UserService {

	
     List getLogin(String username, String pwd);
     List<User> getAllUsers();
     User getUserDetails(String username);
     List<User> getUserSet(String role);
     Boolean createUser(User userdata);
}
