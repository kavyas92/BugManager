package com.buggieplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buggieplatform.dao.BugDao;
import com.buggieplatform.entity.Bugs;
import com.buggieplatform.repository.BugRepository;

@Repository
public class BugOpenServiceImpl implements BugState {

	@Autowired
	private BugDao bugDao;

	@Autowired
	private BugRepository repository;
	
	@Override
	public Boolean setStateBug(int bugId, String state) {
		Bugs bugdata = repository.findByBugId(bugId);
		bugdata.setBugId(bugId);
		bugdata.setBugState(state);
		return bugDao.updateBug(bugdata);

	}

}
