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
	private int id;
	private String speciesName;
	//private int Family_Id;
	 
	@Enumerated(EnumType.STRING)
    private Family family;
	
	public enum Family { grasses, Unknown }
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpeciesName() {
		return speciesName;
	}
	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}
	public Family getFamily() {
		return family;
	}
	public void setFamily(Family family) {
		this.family = family;
	}
	
	/*public int getFamily_Id() {
		return Family_Id;
	}
	public void setFamily_Id(int family_Id) {
		Family_Id = family_Id;
	} */
	
	
	
	

	
}
