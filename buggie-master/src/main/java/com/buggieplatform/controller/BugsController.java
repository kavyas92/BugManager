package com.buggieplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.buggieplatform.entity.Bugs;
import com.buggieplatform.entity.Report;
import com.buggieplatform.entity.User;
import com.buggieplatform.repository.BugRepository;
import com.buggieplatform.service.BugCloseServiceImpl;
import com.buggieplatform.service.BugOpenServiceImpl;
import com.buggieplatform.service.BugService;
import com.buggieplatform.service.BugWipServiceImpl;
import com.buggieplatform.service.ReportObserverImpl;
import com.buggieplatform.service.ReportServiceImpl;
import com.buggieplatform.service.ReportSubjectImpl;

import javassist.tools.web.BadHttpRequest;

@Controller
@RequestMapping("bugs")
public class BugsController {

    @Autowired
    private BugRepository repository;
    @Autowired
	private BugService bugService;
    @Autowired
    private BugOpenServiceImpl openBug;
    @Autowired
    private BugCloseServiceImpl closeBug;
    @Autowired
    private BugWipServiceImpl wipBug;
    @Autowired
    private ReportServiceImpl reportService;


    @GetMapping("allBugs")
    public ResponseEntity<List<Bugs>> getAllBugs(){
    	List<Bugs> list = bugService.getAllBugs();
    	return new ResponseEntity<List<Bugs>>((List<Bugs>) list, HttpStatus.OK);
    }
    
    @GetMapping(path="/{bugId}")
    public ResponseEntity<List> getBugDetails(@PathVariable("bugId") int bugId){
    	List bugDet = bugService.getBugDetails(bugId);
    	return  new ResponseEntity<List>(bugDet,HttpStatus.OK);
    }
    
    @GetMapping(path="/getByUser")
    public ResponseEntity<List> getBugDetailsByUsername(@RequestParam(value = "user") String user){
    	List bugDet = bugService.getBugDetailsByUser(user);
    	return  new ResponseEntity<List>(bugDet,HttpStatus.OK);
    }
    
    @GetMapping(path="/autoBugAllocation")
    public ResponseEntity<List> autoBugAllocation(@RequestParam(value = "createdby") String createdby){
    	List bugDet = bugService.autoAllocateBug(createdby);
    	return  new ResponseEntity<List>(bugDet,HttpStatus.OK);
    }

    
	@PostMapping(path="/createBugs",consumes = "application/json")
    public ResponseEntity<List> createBugs(@RequestBody Bugs bugdata) {
    	Boolean status = bugService.createBug(bugdata);
	Report rep=new Report();
    	
    	String open;
    	String close;
    	String wip;
    	
    	if(status == true){		
    	
    	ReportSubjectImpl subject = new ReportSubjectImpl();
        new ReportObserverImpl(subject);

        if(bugdata.getBugState().equals("OPEN")) {
        open=rep.setOpenState(bugdata.getBugState());
        }
        else
           	 open=rep.setOpenState("NA");
        if(bugdata.getBugState().equals("WIP")) {
        	wip=rep.setWipState(bugdata.getBugState());
        }
        else
           	 wip=rep.setWipState("NA");
        if(bugdata.getBugState().equals("CLOSE")) {
        	close=rep.setCloseState(bugdata.getBugState());
        }
        else
        	close=rep.setCloseState("NA");

  	    reportService.updateReport(rep);
  	      return new ResponseEntity<List>(HttpStatus.CREATED);
  	}
  	else{
  		return new ResponseEntity<List>(HttpStatus.BAD_REQUEST);
  	}
    }
    
    @DeleteMapping(path = "/{bugId}")
    public void delete(@PathVariable("username") String username) {
        repository.delete(username);
    }

    @PutMapping(path = "/{bugId}")
    public ResponseEntity<List> updateBug(@PathVariable("bugId") int bugId, @RequestBody Bugs bugdata){
        if (repository.findByBugId(bugId) != null) {
        	bugdata.setBugId(bugId);
        	System.out.println("bug"+bugdata + "id" + bugdata.getBugId());
            Boolean status = bugService.updateBug(bugdata);
            Report rep=new Report();

        	String open;
        	String close;
        	String wip;
            
            if(status == true){
            	
            	ReportSubjectImpl subject = new ReportSubjectImpl();
                new ReportObserverImpl(subject);
               
                if(bugdata.getBugState().equals("OPEN")) {
                open=rep.setOpenState(bugdata.getBugState());
                }
                else
                	 open=rep.setOpenState("NA");
                if(bugdata.getBugState().equals("WIP")) {
                	wip=rep.setWipState(bugdata.getBugState());
                }
                else
                	 wip=rep.setWipState("NA");
                if(bugdata.getBugState().equals("CLOSE")) {
                	close=rep.setCloseState(bugdata.getBugState());
                }
                else
               	 	wip=rep.setCloseState("NA");
          	    reportService.updateReport(rep);

            	return new ResponseEntity<List>(HttpStatus.CREATED);
            }
            else {
            	return new ResponseEntity<List>(HttpStatus.BAD_REQUEST);
            }
        } else {
        	return new ResponseEntity<List>(HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping(path = "/updateState",consumes = "application/json")
    public ResponseEntity<List> updateStateBug(@RequestBody Bugs bugdata){
    	
    	int bugId = bugdata.getBugId();
    	String state = bugdata.getBugState();
    	System.out.println("state :  :" +state.equals("wip"));
    	
    	 if(state.equals("OPEN") || state.equals("REOPEN")){
    		state = "OPEN";
	    	Boolean status = openBug.setStateBug(bugId,state);
	    	 if(status == true){
	         	return new ResponseEntity<List>(HttpStatus.CREATED);
	         }
	         else {
	         	return new ResponseEntity<List>(HttpStatus.BAD_REQUEST);
	         }
    	 }
    	 if(state.equals("CLOSE")){
 	    	Boolean status = closeBug.setStateBug(bugId,state);
 	    	 if(status == true){
 	         	return new ResponseEntity<List>(HttpStatus.CREATED);
 	         }
 	         else {
 	         	return new ResponseEntity<List>(HttpStatus.BAD_REQUEST);
 	         }
     	 }
    	if(state.equals("WIP")){
 	    	Boolean status = wipBug.setStateBug(bugId,state);
 	    	 if(status == true){
 	         	return new ResponseEntity<List>(HttpStatus.CREATED);
 	         }
 	         else {
 	         	return new ResponseEntity<List>(HttpStatus.BAD_REQUEST);
 	         }
     	 }
    	
    	 else{
    		 return new ResponseEntity<List>(HttpStatus.BAD_REQUEST);
    	 }

    }
}