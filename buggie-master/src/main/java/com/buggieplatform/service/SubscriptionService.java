package com.buggieplatform.service;

import java.util.List;

import com.buggieplatform.entity.User;

public interface SubscriptionService {
	
	List getSubscriptionStatus(String username);
	List subscribe(User user);

}
