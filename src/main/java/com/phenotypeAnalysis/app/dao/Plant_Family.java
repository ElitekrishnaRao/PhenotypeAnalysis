package com.phenotypeAnalysis.app.dao;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Plant_Family {
	@Id
	private int Family_Id;
	private String Family_Name;
	
	public int getFamily_Id() {
		return Family_Id;
	}
	public void setFamily_Id(int family_Id) {
		Family_Id = family_Id;
	}
	
	public String getFamily_Name() {
		return Family_Name;
	}
	public void setFamily_Name(String family_Name) {
		Family_Name = family_Name;
	}
	
}




