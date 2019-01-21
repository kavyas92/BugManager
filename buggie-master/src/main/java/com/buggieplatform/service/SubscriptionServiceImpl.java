package com.buggieplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buggieplatform.dao.UserDao;
import com.buggieplatform.entity.User;


@Repository
public class SubscriptionServiceImpl implements SubscriptionService {
	
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PaymentFactory paymentFactory;
	
	
	
	@Override
	public List getSubscriptionStatus(String username) {
		
		return userDao.getSubStatus(username);
	}

	@Override
	public List subscribe(User user) {
		System.out.println("in service");
		  String type = user.getPaymentType();
		  System.out.println(type + "type");
		  PaymentService payment = paymentFactory.getPaymentType(type);
	      return payment.Payment(user);

	}

}
