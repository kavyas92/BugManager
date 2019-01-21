package com.buggieplatform.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.buggieplatform.entity.Tenant;

@Repository
public class CommandInvoker {
	private List<Command> cmdList = new ArrayList<Command>(); 

	   public void takeOrder(Command cmd){
		   System.out.println("in take order" +  cmd);
	      cmdList.add(cmd);		
	   }

	   public void placeOrders(Tenant tenantdata){
		  
	      for (Command list : cmdList) {
	         list.execute(tenantdata);
	         
	      }
	      cmdList.clear();
	   
	   }
}
