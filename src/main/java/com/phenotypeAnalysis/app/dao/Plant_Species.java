package com.phenotypeAnalysis.app.dao;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Plant_Species {
	@Id
	private int Species_Id;
	private String Species_Name;
	
	public int getSpecies_Id() {
		return Species_Id;
	}
	public void setSpecies_Id(int species_Id) {
		Species_Id = species_Id;
	}
	public String getSpecies_Name() {
		return Species_Name;
	}
	public void setSpecies_Name(String species_Name) {
		Species_Name = species_Name;
	}
}
