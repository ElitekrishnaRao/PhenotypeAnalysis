package com.phenotypeAnalysis.app.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

//assuming that watering and phosphorus are string types for now

@Entity
public class Treatment {

	@Id
	private int treatment_Id;
	private String treatment_Type;
	//private float Watering;
	//private float Phosphorus;
	private String watering;
	private String phosphorus;
	
	
	public int getTreatment_Id() {
		return treatment_Id;
	}
	public void setTreatment_Id(int treatment_Id) {
		this.treatment_Id = treatment_Id;
	}
	public String getTreatment_Type() {
		return treatment_Type;
	}
	public void setTreatment_Type(String treatment_Type) {
		this.treatment_Type = treatment_Type;
	}
	public String getWatering() {
		return watering;
	}
	public void setWatering(String watering) {
		this.watering = watering;
	}
	public String getPhosphorus() {
		return phosphorus;
	}
	public void setPhosphorus(String phosphorus) {
		this.phosphorus = phosphorus;
	}
	
	
	
	
}
