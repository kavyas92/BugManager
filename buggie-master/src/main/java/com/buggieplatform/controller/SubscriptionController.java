package com.buggieplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.buggieplatform.entity.User;
import com.buggieplatform.repository.UserRepository;
import com.buggieplatform.service.SubscriptionService;

import javassist.tools.web.BadHttpRequest;

@Controller
@RequestMapping("subscribe")
public class SubscriptionController {

    @Autowired
    private UserRepository repository;
    
    @Autowired
	private SubscriptionService subService;

    
    @GetMapping
   	public ResponseEntity<List> getSubscriptionStatus(@RequestParam(value = "username", defaultValue = "tenantadmin") String username ) {
    	List list  = subService.getSubscriptionStatus(username);
    	return new ResponseEntity<List>(list, HttpStatus.OK);
   	}
    
  
    @PutMapping(path = "/{username}")
    public ResponseEntity<List> subscribe(@PathVariable("username") String username, @RequestBody User user) throws BadHttpRequest {
    	
        if (repository.exists(username)) {
            user.setUsername(username);
            List value = subService.subscribe(user);
            return new ResponseEntity<List>(value,HttpStatus.CREATED);
        } else {
        	return new ResponseEntity<List>(HttpStatus.BAD_REQUEST);
        }
    }
    
    

}