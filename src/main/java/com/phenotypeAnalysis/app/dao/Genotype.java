package com.phenotypeAnalysis.app.dao;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Genotype {
	@Id
	private int genotype_Id;
	private String genotype;
	public int getGenotype_Id() {
		return genotype_Id;
	}
	public void setGenotype_Id(int genotype_Id) {
		this.genotype_Id = genotype_Id;
	}
	public String getGenotype() {
		return genotype;
	}
	public void setGenotype(String genotype) {
		this.genotype = genotype;
	}
	}
	

