package com.buggieplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buggieplatform.dao.SubscribeDao;
import com.buggieplatform.entity.Subscribe;

@Repository
public class SubscribeServiceImpl implements SubscribeService{

	@Autowired
	private SubscribeDao subscribeDao;

	@Override
	public Boolean subscribeFeature(Subscribe subscriberdata) {
		System.out.println(subscriberdata.getPremiumFeatures());
		return subscribeDao.subscribeFeature(subscriberdata);
	}


	@Override
	public List<Subscribe> getSubscribedFeature(String subscriberName) {
		return subscribeDao.getSubscribedFeature(subscriberName);		
	}
	

	



}
