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
import com.buggieplatform.service.UserService;

import javassist.tools.web.BadHttpRequest;

@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository repository;
    @Autowired
	private UserService userService;

    
    @GetMapping("allUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> list = userService.getAllUsers();
		return new ResponseEntity<List<User>>((List<User>) list, HttpStatus.OK);
	}

    @GetMapping(path = "/{username}")
	public ResponseEntity<User> getUserDetails(@PathVariable("username") String username) {
		User list = userService.getUserDetails(username);
		return new ResponseEntity<User>(list, HttpStatus.OK);
	}
    
    @GetMapping(path = "/getUserSet")
   	public ResponseEntity<List<User>> getUserSet(@RequestParam(value = "role", defaultValue = "tenantadmin") String roleType ) {
    	List<User> list  = userService.getUserSet(roleType);
    	return new ResponseEntity<List<User>>((List<User>) list, HttpStatus.OK);
   	}
    
    @PostMapping(path = "/login" ,consumes = "application/json")
	public ResponseEntity<List> getLogin(@RequestBody User userdata) {
    	
    	String username= userdata.getUsername();
		String pwd=userdata.getPassword();
		List u = userService.getLogin(username,pwd);
		if(u.isEmpty()){
			return new ResponseEntity<List>(u,HttpStatus.UNAUTHORIZED);
		}
		else{
			return new ResponseEntity<List>(HttpStatus.OK);
		}
              
	}

    @PostMapping(path="/create",consumes = "application/json")
    public ResponseEntity<List> createUser(@RequestBody User userdata) {
    	System.out.println("inside create");
    	Boolean status = userService.createUser(userdata);
    	if(status == true){
    		return new ResponseEntity<List>(HttpStatus.CREATED);
    	}
    	else{
    		return new ResponseEntity<List>(HttpStatus.BAD_REQUEST);
    	}
    }
    
    
    @DeleteMapping(path = "/{username}")
    public void delete(@PathVariable("username") String username) {
        repository.delete(username);
    }

    @PutMapping(path = "/{username}")
    public User update(@PathVariable("username") String username, @RequestBody User user) throws BadHttpRequest {
        if (repository.exists(username)) {
            user.setUsername(username);
            return repository.save(user);
        } else {
            throw new BadHttpRequest();
        }
    }

}