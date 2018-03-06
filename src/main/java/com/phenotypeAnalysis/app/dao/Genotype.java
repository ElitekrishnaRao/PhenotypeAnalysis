package com.phenotypeAnalysis.app.dao;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Genotype")
public class Genotype {
	@Id
	private int id;
	private String genotypeName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGenotypeName() {
		return genotypeName;
	}
	public void setGenotypeName(String genotypeName) {
		this.genotypeName = genotypeName;
	}
	}
	

