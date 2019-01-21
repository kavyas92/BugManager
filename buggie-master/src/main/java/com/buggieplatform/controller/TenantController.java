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

import com.buggieplatform.entity.Bugs;
import com.buggieplatform.entity.Tenant;
import com.buggieplatform.entity.TenantProject;
import com.buggieplatform.entity.User;
import com.buggieplatform.repository.TenantRepository;
import com.buggieplatform.repository.UserRepository;
import com.buggieplatform.service.CommandActivate;
import com.buggieplatform.service.CommandDeactivate;
import com.buggieplatform.service.CommandInvoker;
import com.buggieplatform.service.TenantService;
import com.buggieplatform.service.UserService;

import javassist.tools.web.BadHttpRequest;

@Controller
@RequestMapping("tenant")
public class TenantController {

  
    @Autowired
	private TenantService tenantService;

    
    @GetMapping("/allTenants")
   	public ResponseEntity<List<Tenant>> getAll() {
   		List<Tenant> list = tenantService.getAll();
   		return new ResponseEntity<List<Tenant>>((List<Tenant>) list, HttpStatus.OK);
   	}

    
    @GetMapping("allProjects/{username}")
	public ResponseEntity<List<Tenant>> getAllUsers(@PathVariable("username") String username) {
		List<Tenant> list = tenantService.getAllProjects(username);
		return new ResponseEntity<List<Tenant>>((List<Tenant>) list, HttpStatus.OK);
	}


    @PostMapping(path="/createProjects",consumes = "application/json")
    public ResponseEntity<List> createUser(@RequestBody Tenant userdata) {
    	System.out.println("inside create");
    	Boolean status = tenantService.createTenant(userdata);
    	System.out.println(status);
    	if(status == true){
    		return new ResponseEntity<List>(HttpStatus.CREATED);
    	}
    	else{
    		return new ResponseEntity<List>(HttpStatus.BAD_REQUEST);
    	}
    }
    
    
    @PutMapping(path = "/projectState")
    public ResponseEntity<List> updateBug(@RequestBody Tenant tenantdata){
    	System.out.println("inside update");
    	String projectState = tenantdata.getProjectState();
   
    	
    	TenantProject commandState = new TenantProject();
    	
    	CommandActivate commandActivate = new CommandActivate(commandState);
    	CommandDeactivate commandDectivate = new CommandDeactivate(commandState);
    	
    	CommandInvoker invoker = new CommandInvoker();
    	if(projectState.equals("active")){	
        	invoker.takeOrder(commandActivate);
    	}
    	if(projectState.equals("deactive")){
        	invoker.takeOrder(commandDectivate);
    	}
    	
        invoker.placeOrders(tenantdata);
        
    	return new ResponseEntity<List>(HttpStatus.CREATED);
    	

    }
    
    
    
 

}