package com.buggieplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buggieplatform.dao.UserDao;
import com.buggieplatform.entity.User;


@Repository
public class CreditPaymentImpl implements PaymentService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public List Payment(User user) {
		String cardNo;
		return userDao.subscribeUser(user);
	}

}
