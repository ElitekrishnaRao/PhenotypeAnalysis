package com.phenotypeAnalysis.app.dao;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Plant_Species")
public class Plant_Species {
	@Id
	private int Species_Id;
	private String species_Name;
	//private int Family_Id;
	 
	@Enumerated(EnumType.STRING)
    private Family family;
	
	public enum Family { Grasses, Unknown }
	
	public int getSpecies_Id() {
		return Species_Id;
	}
	public void setSpecies_Id(int species_Id) {
		Species_Id = species_Id;
	}
	
	/*public int getFamily_Id() {
		return Family_Id;
	}
	public void setFamily_Id(int family_Id) {
		Family_Id = family_Id;
	} */
	
	public String getSpecies_Name() {
		return species_Name;
	}
	public void setSpecies_Name(String species_Name) {
		this.species_Name = species_Name;
	}
	public Family getFamily() {
		return family;
	}
	public void setFamily(Family family) {
		this.family = family;
	}
	

	
}
