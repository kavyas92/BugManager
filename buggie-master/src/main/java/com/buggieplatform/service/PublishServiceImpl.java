package com.buggieplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buggieplatform.dao.PublishDao;
import com.buggieplatform.entity.Publish;

@Repository
public class PublishServiceImpl implements PublishService{

	@Autowired
	private PublishDao featureDao;

	@Override
	public Boolean publishFeature(Publish featuredata) {
		System.out.println(featuredata.getFeatureName());
		return featureDao.publishFeature(featuredata);
	}
	

	


	/*
	@Override
	public List getAllFeature(){
		return featureDao.getAllFeature();
	}
*/




}
