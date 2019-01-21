package com.buggieplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buggieplatform.dao.UserDao;
import com.buggieplatform.entity.User;

@Repository
public class DebitPaymentImpl implements PaymentService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List Payment(User user) {
		return userDao.subscribeUser(user);
	}

}
