package com.buggieplatform.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buggieplatform.entity.Bugs;
import com.buggieplatform.entity.Tenant;
import com.buggieplatform.repository.BugRepository;
import com.buggieplatform.repository.TenantRepository;


@Transactional
@Repository
public class TenantDaoImpl implements TenantDao {

	@Autowired
	private TenantRepository repository;
	
	@PersistenceContext	
	private EntityManager em;	

	@Override
	public List<Tenant> getAllTenants(String tenantUsername) {
		
		
		List<Tenant> proList;
		return  em.createQuery(
			    "SELECT c FROM Tenant c WHERE c.tenantUsername =:tenantUsername")
				.setParameter("tenantUsername", tenantUsername)
			    .getResultList();
	}

	@Override
	public Boolean createTenant(Tenant tenantdata) {
	
			
			System.out.println("in dao"+tenantdata);
			Tenant ten = null;  
			 ten = repository.save(tenantdata);
			 if(ten != null){
				 return true;
			 }
			 else{
				 return false;
			 }
	
		
	}

	@Override
	public void updateProject(Tenant data) {
		System.out.println("in dao"+data.getProjectState());
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tenant> getAll() {
		return  repository.findAll();
	}

//	@Override
//	public Boolean updateProject(String id, Tenant data) {
//		
//		System.out.println("in dao"+id);
//		Tenant ten;  
//		 ten = repository.save(data);
//		 if(ten != null){
//			 return true;
//		 }
//		 else{
//			 return false;
//		 }
//	}


}
