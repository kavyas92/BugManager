package com.buggieplatform.service;

import java.util.List;

import com.buggieplatform.entity.Subscribe;

public interface SubscribeService {
	
	List<Subscribe> getSubscribedFeature(String subscriberName);
	Boolean subscribeFeature(Subscribe subscriberdata);
}
