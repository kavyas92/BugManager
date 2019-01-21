package com.buggieplatform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
//@Table(name="publishedFeature")
public class Publish
{
    


	@Id
    @Column(name = "SNO")
    @GeneratedValue
    private int SNO;
	
    @Column(name="featureName")
    private String featureName;
    @Column(name="featureType")
    private String featureType;

    public Publish()
    {
        super();
    }

    public Publish(String featureName, String featureType)
    {
        super();
        this.featureName = featureName;
        this.featureType = featureType;

    }



	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public String getFeatureType() {
		return featureType;
	}

	public void setFeatureType(String featureType) {
		this.featureType = featureType;
	}


   
}