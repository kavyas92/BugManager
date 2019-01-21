package com.buggieplatform.dao;

import java.util.List;

import com.buggieplatform.entity.Subscribe;

public interface SubscribeDao {

	List<Subscribe> getSubscribedFeature(String subscriberName);
	Boolean subscribeFeature(Subscribe subscriberdata);

}
