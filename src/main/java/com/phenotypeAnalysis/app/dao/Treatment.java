package com.phenotypeAnalysis.app.dao;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//assuming that watering and phosphorus are string types for now

@Entity
@Table(name="Treatment")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Treatment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String environmentType;
	//private float Watering;
	//private float Phosphorus;
	private String experimentType;
	private String treatment;
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "treatment")
//	Set<Plant> PlantsList;
//	
//	@JsonIgnore
//	public Set<Plant> getPlantsList() {
//		return PlantsList;
//	}
//	public void setPlantsList(Set<Plant> plantsList) {
//		PlantsList = plantsList;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEnvironmentType() {
		return environmentType;
	}
	public void setEnvironmentType(String environmentType) {
		this.environmentType = environmentType;
	}
	public String getExperimentType() {
		return experimentType;
	}
	public void setExperimentType(String experimentType) {
		this.experimentType = experimentType;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
}
