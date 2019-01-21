package com.buggieplatform.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buggieplatform.entity.Publish;
import com.buggieplatform.repository.PublishRepository;

@Transactional
@Repository
public class PublishDaoImpl implements PublishDao{

	@Autowired
	private PublishRepository repository;
	  
	@PersistenceContext	
	private EntityManager em;	
	

/*
	@Override
	public List getAllFeature(){
		List featureList;
		featureList= repository.findAll();
		
		return featureList;
	}
	
*/
	@Override
	public Boolean publishFeature(Publish featuredata) {
		System.out.println("in dao"+featuredata);
		Publish feature;  
		 feature = repository.save(featuredata);
		 if(feature != null){
			 return true;
		 }
		 else{
			 return false;
		 }
	}
}
