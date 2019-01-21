package com.buggieplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buggieplatform.entity.Publish;
import com.buggieplatform.entity.User;
import com.buggieplatform.repository.PublishRepository;
import com.buggieplatform.service.BugCloseServiceImpl;
import com.buggieplatform.service.BugOpenServiceImpl;
import com.buggieplatform.service.PublishService;
import com.buggieplatform.service.BugWipServiceImpl;

import javassist.tools.web.BadHttpRequest;

@Controller
@RequestMapping("publishspecial")
public class PublishSpecialDecoratorController extends PublishController{

   
    @Autowired
	private PublishService publishService;
    
    @Autowired
    private PublishController publishController;
    
	@PostMapping(path="/publishFeature",consumes = "application/json")
    public ResponseEntity<List<Publish>> publishFeature(@RequestBody Publish featuredata) {
		
		//Running the actual publishFeature Method to publish the feature for first Subscription type
		
		
		System.out.println("Before modif"+featuredata.getFeatureType());

		publishController.publishFeature(featuredata);
		

		System.out.println("After Add"+featuredata.getFeatureType());

		//Doing additional Functionality to add the same feature for the other Subscription type
		if (featuredata.getFeatureType().contentEquals("standard"))
		{
			featuredata.setFeatureType("premium/standard");
			
			
		}
		
		else 
		{
			featuredata.setFeatureType("premium/standard");
		}
		System.out.println("After modif"+featuredata.getFeatureType());
		Boolean status = publishService.publishFeature(featuredata);
    	
    	
    	
    	if(status == true){
    		return new ResponseEntity<List<Publish>>(HttpStatus.CREATED);
    	}
    	else{
    		return new ResponseEntity<List<Publish>>(HttpStatus.BAD_REQUEST);
    	}
   
    	
    	
    }
 
}
