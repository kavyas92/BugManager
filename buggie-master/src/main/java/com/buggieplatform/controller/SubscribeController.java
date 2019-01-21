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

import com.buggieplatform.entity.Subscribe;
import com.buggieplatform.entity.User;
import com.buggieplatform.repository.SubscribeRepository;
import com.buggieplatform.service.SubscribeService;

import javassist.tools.web.BadHttpRequest;

@Controller
@RequestMapping("subscriber")
public class SubscribeController {

   
    @Autowired
	private SubscribeService subscribeService;
    
    
  
    @GetMapping("/{subscriberName}")
    public ResponseEntity<List<Subscribe>> getSubscribedFeature(@PathVariable("subscriberName") String subscriberName){
    	List<Subscribe> features = subscribeService.getSubscribedFeature(subscriberName);
    	return new ResponseEntity<List<Subscribe>>(features, HttpStatus.OK);
    }
 
    
	@PostMapping(path="/subscribeFeature",consumes = "application/json")
    public ResponseEntity<List<Subscribe>> subscribeFeature(@RequestBody Subscribe featuredata) {
    	System.out.println("inside Subscribe Feature ");
    	Boolean status = subscribeService.subscribeFeature(featuredata);
    	if(status == true){
    		return new ResponseEntity<List<Subscribe>>(HttpStatus.CREATED);
    	}
    	else{
    		return new ResponseEntity<List<Subscribe>>(HttpStatus.BAD_REQUEST);
    	}
    }
 
}
