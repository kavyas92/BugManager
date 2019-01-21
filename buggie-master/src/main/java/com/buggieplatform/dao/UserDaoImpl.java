package com.buggieplatform.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buggieplatform.entity.User;
import com.buggieplatform.repository.UserRepository;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository repository;
	  
	@PersistenceContext	
	private EntityManager em;	
	
	@Override
	public List<User> getLogin(String username, String pwd) {
		System.out.println(username +" : "+pwd);
		String hql = "FROM User as atcl WHERE atcl.username = ? and atcl.password = ?";
		System.out.println("hql query*******************"+ hql);
		return em.createQuery(
			    "SELECT c FROM User c WHERE c.username =:username and c.password =:pwd")
				.setParameter("username", username)
			    .setParameter("pwd", pwd)
			    .setMaxResults(10)
			    .getResultList();
		
	}

	@Override
	public List<User> getAllUsers() {
		String hql = "FROM User as atcl ORDER BY atcl.username";
		return (List<User>) em.createQuery(hql).getResultList();
	}

	@Override
	public Boolean createUser(User userData) {
		System.out.println("in dao");
		User usr;  
		 usr = repository.save(userData);
		 if(usr != null){
			 return true;
		 }
		 else{
			 return false;
		 }
		
	}

	@Override
	public User getUserDetails(String username) {
		User userDetails;
		userDetails = repository.findOne(username);
		return userDetails;
	}

	@Override
	public List<User> getUserSet(String role) {
		
		String hql = "FROM User as atcl WHERE atcl.role = ?";
		return em.createQuery(
			    "SELECT c FROM User c WHERE c.role =:role")
				.setParameter("role", role)
			    .setMaxResults(10)
			    .getResultList();
	}

	@Override
	public List getSubStatus(String username) {
		List subScribeDetails = null;
		User details = repository.findOne(username);
		subScribeDetails.add(0, details.getPaymentStatus());
		subScribeDetails.add(1, details.getPaymentType());
		return subScribeDetails;
	}
	
	@Override
	public List subscribeUser(User user){
		String username= user.getUsername();
		String paymentType = user.getPaymentType();
		String subscriptionType = user.getSubscriptionType();
		List usr;  
		usr = (List) repository.save(user);
		return usr;
		
	
	}
}
