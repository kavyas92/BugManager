package com.buggieplatform.service;

import java.util.List;

import com.buggieplatform.entity.Bugs;

public interface BugService {
	
	Boolean createBug(Bugs bugdata);
	List<Bugs> getAllBugs();
    List getBugDetails(int bugId);
    List getBugDetailsByUser(String username);
	Boolean updateBug(Bugs bugdata);
	List autoAllocateBug(String createdby);
}
