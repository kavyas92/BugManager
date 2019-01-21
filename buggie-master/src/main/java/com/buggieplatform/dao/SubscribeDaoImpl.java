package com.buggieplatform.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buggieplatform.entity.Publish;
import com.buggieplatform.entity.Subscribe;
import com.buggieplatform.repository.SubscribeRepository;

@Transactional
@Repository
public class SubscribeDaoImpl implements SubscribeDao{

	@Autowired
	private SubscribeRepository repository;
	  
	@PersistenceContext	
	private EntityManager em;	
	


	@Override
	public List<Subscribe> getSubscribedFeature(String subscriberName) {
		Subscribe subscriptionList;
		Publish featureList;
		subscriptionList= repository.findOne(subscriberName);
		
		List<Subscribe> features;
		
		if (subscriptionList.getStandardFeatures()==false)
		{
			System.out.println("getPremiumFeatures "+subscriptionList.getPremiumFeatures());
			features= em.createQuery(
				    "SELECT c FROM Publish c WHERE c.featureType = :type or featureType = :both")
					.setParameter("type", "premium").setParameter("both", "premium/standard")
				    .getResultList();
		}
		else if(subscriptionList.getPremiumFeatures()==false) 
		{
			System.out.println("getStandardFeatures"+subscriptionList.getStandardFeatures());
			features= em.createQuery(
				    "SELECT c FROM Publish c WHERE c.featureType = :type or featureType = :both")
					.setParameter("type", "standard").setParameter("both", "premium/standard")
				    .getResultList();
			
		}
		
		else
			
		{
			features= em.createQuery(
				    "SELECT c FROM Publish c")
				    .getResultList();
			
			
		}
		//TODO Get the user name , get what are all his subscription from subscriber_list table 
		//and return the list of features from published_feature 
		System.out.println(features);
		return features;
		
		
	}

	@Override
	public Boolean subscribeFeature(Subscribe subscriberdata) {
		System.out.println("in dao"+subscriberdata);
		Subscribe subscribe;  
		 subscribe= repository.save(subscriberdata);
		 if(subscribe != null){
			 return true;
		 }
		 else{
			 return false;
		 }
	}
}
