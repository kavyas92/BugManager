package com.buggieplatform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
//@Table(name="subscriberList")
public class Subscribe
{
    

    
	
    @Id	
    @Column(name="subscriberName")
    private String subscriberName;
    
    @Column(name="standardFeatures")
    private Boolean standardFeatures;

    
    @Column(name="premiumFeatures")
    private Boolean premiumFeatures;

    public Subscribe()
    {
        super();
    }

    public Subscribe(String subscriberName, Boolean premiumFeatures ,Boolean standardFeatures)
    {
        super();
        this.standardFeatures=standardFeatures;
        this.subscriberName = subscriberName;
        this.premiumFeatures = premiumFeatures;

    }



	public String getSubscriberName() {
		return subscriberName;
	}

	public void setFeatureName(String subscriberName) {
		this.subscriberName = subscriberName;
	}

	public Boolean getStandardFeatures() {
		return standardFeatures;
	}

	public void setStandardFeatures(Boolean standardFeatures) {
		this.standardFeatures = standardFeatures;
	}

	public Boolean getPremiumFeatures() {
		return premiumFeatures;
	}

	public void setPremiumFeatures(Boolean premiumFeatures) {
		this.premiumFeatures = premiumFeatures;
	}


   
}