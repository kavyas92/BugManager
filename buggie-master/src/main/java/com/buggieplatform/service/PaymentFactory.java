package com.buggieplatform.service;

import org.springframework.stereotype.Repository;

@Repository
public class PaymentFactory {
	
	public PaymentService getPaymentType(String paymentType){
		 if(paymentType == null){
	         return null;
	      }		
	      if(paymentType.equalsIgnoreCase("DEBIT")){
	         return new DebitPaymentImpl();
	         
	      } else if(paymentType.equalsIgnoreCase("CREDIT")){
	         return new CreditPaymentImpl();
	         
	      } else if(paymentType.equalsIgnoreCase("NA")){
	         return null;
	      }
	      
	      return null;
	}

}
