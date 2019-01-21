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
@RequestMapping("publish")
public class PublishController {

   
    @Autowired
	private PublishService publishService;
    

    
	@PostMapping(path="/publishFeature",consumes = "application/json")
    public ResponseEntity<List<Publish>> publishFeature(@RequestBody Publish featuredata) {
    	System.out.println("inside Publish create");
    	Boolean status = publishService.publishFeature(featuredata);
    	if(status == true){
    		return new ResponseEntity<List<Publish>>(HttpStatus.CREATED);
    	}
    	else{
    		return new ResponseEntity<List<Publish>>(HttpStatus.BAD_REQUEST);
    	}
    }
 
}
