package com.buggieplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buggieplatform.dao.BugDao;
import com.buggieplatform.entity.Bugs;

@Repository
public class BugServiceImpl implements BugService{

	@Autowired
	private BugDao bugDao;
	
	@Override
	public Boolean createBug(Bugs bugdata) {
		System.out.println(bugdata.getUsername());
		return bugDao.createBug(bugdata);
	}
	@Override
	public Boolean updateBug(Bugs bugdata) {
		System.out.println(bugdata.getUsername());
		return bugDao.updateBug(bugdata);
	}
	
	@Override
	public List<Bugs> getAllBugs(){
		return bugDao.getAllBugs();
	}

	@Override
	public List getBugDetails(int bugId) {
		return bugDao.getBugDetails(bugId);
	}
	@Override
	public List getBugDetailsByUser(String username) {
		return bugDao.getBugDetailsByUser(username);
	}
	@Override
	public List autoAllocateBug(String createdby) {
		// TODO Auto-generated method stub
		return bugDao.autoAllocateBug(createdby);
	}

}
