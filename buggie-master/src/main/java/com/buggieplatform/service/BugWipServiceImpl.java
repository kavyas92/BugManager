package com.buggieplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buggieplatform.dao.BugDao;
import com.buggieplatform.entity.Bugs;
import com.buggieplatform.repository.BugRepository;

@Repository
public class BugWipServiceImpl implements BugState {

	@Autowired
	private BugDao bugDao;
	
	@Autowired
	private BugRepository repository;
	
	@Override
	public Boolean setStateBug(int bugId, String state) {

		Bugs bugdata = repository.findByBugId(bugId);
		bugdata.setBugId(bugId);
		bugdata.setBugState(state);
		System.out.println("in wip" + bugdata.getBugState());
		return bugDao.updateBug(bugdata);
	}

}
