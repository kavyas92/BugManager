package com.buggieplatform.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buggieplatform.entity.Bugs;
import com.buggieplatform.repository.BugRepository;

@Transactional
@Repository
public class BugDaoImpl implements BugDao{

	@Autowired
	private BugRepository repository;
	  
	@PersistenceContext	
	private EntityManager em;	
	
	@Override
	public Boolean createBug(Bugs bugdata) {
		
		System.out.println("in dao"+bugdata);
		Bugs bug;  
		 bug = repository.save(bugdata);
		 if(bug != null){
			 return true;
		 }
		 else{
			 return false;
		 }
	}
	
	@Override
	public Boolean updateBug(Bugs bugdata) {
		
		System.out.println("in dao"+bugdata);
		Bugs bug;  
		 bug = repository.save(bugdata);
		 if(bug != null){
			 return true;
		 }
		 else{
			 return false;
		 }
	}
	@Override
	public List<Bugs> getAllBugs(){
		List<Bugs> bugList;
		bugList= repository.findAll();
		return bugList;
	}

	@Override
	public List getBugDetails(int bugId) {
		List bugList;
		return  em.createQuery(
			    "SELECT c FROM Bugs c WHERE c.bugId =:bugId")
				.setParameter("bugId", bugId)
			    .setMaxResults(1)
			    .getResultList();
	}

	@Override
	public List getBugDetailsByUser(String username) {
		List bugList;
		return  em.createQuery(
			    "SELECT c FROM Bugs c WHERE c.username =:username")
				.setParameter("username", username)
			    .getResultList();
	}

	@Override
	public List autoAllocateBug(String createdBy) {
		//SELECT username,COUNT(*)  FROM buggiee.bugs WHERE bug_state = "CLOSE" AND created_by="admin" GROUP BY username;
		return  em.createQuery(
			    "SELECT username,COUNT(*)  FROM Bugs WHERE bugState = 'CLOSE' AND createdBy=:createdBy GROUP BY username")
				.setParameter("createdBy", createdBy)
			    .getResultList();
	}
	

}
