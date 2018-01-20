package com.phenotypeAnalysis.app.dao;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Genotype {
	@Id
	private int Genotype_Id;
	private String Genotype;
	
	public int getGenotype_Id() {
		return Genotype_Id;
	}
	public void setGenotype_Id(int genotype_Id) {
		Genotype_Id = genotype_Id;
	}
	public String getGenotype() {
		return Genotype;
	}
	public void setGenotype(String genotype) {
		Genotype = genotype;
	}
	

	
	}
	

