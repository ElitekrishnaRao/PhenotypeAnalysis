package com.phenotypeAnalysis.app.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

//assuming that watering and phosphorus are string type for now

@Entity
public class Treatment {

	@Id
	private int Treatment_Id;
	private String Treatment_Type;
	//private float Watering;
	//private float Phosphorus;
	private String Watering;
	private String Phosphorus;
	
	public int getTreatment_Id() {
		return Treatment_Id;
	}
	public void setTreatment_Id(int treatment_Id) {
		Treatment_Id = treatment_Id;
	}
	public String getTreatment_Type() {
		return Treatment_Type;
	}
	public void setTreatment_Type(String treatment_Type) {
		Treatment_Type = treatment_Type;
	}
	/** public float getWatering() {
		return Watering;
	}
	public void setWatering(float watering) {
		Watering = watering;
	}
	public float getPhosphorus() {
		return Phosphorus;
	}
	public void setPhosphorus(float phosphorus) {
		Phosphorus = phosphorus;
	} **/
	public String getWatering() {
		return Watering;
	}
	public void setWatering(String watering) {
		Watering = watering;
	}
	public String getPhosphorus() {
		return Phosphorus;
	}
	public void setPhosphorus(String phosphorus) {
		Phosphorus = phosphorus;
	}
	
	
}
