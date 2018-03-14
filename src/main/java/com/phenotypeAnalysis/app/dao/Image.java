package com.phenotypeAnalysis.app.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.*;



@Entity
@Table(name="Image")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Image implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id")
	private int id;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String imageModality;
	private int daySequence;
	private int view;
	private String filePath;
	
	@ManyToOne
	//@JoinColumn(name = "id", nullable = false,insertable=false, updatable=false)
    private Plant plant;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="image")
	Phenotype phenotypes;
	
	@JsonIgnore
	public Phenotype getPhenotypes() {
		return phenotypes;
	}
	public void setPhenotypes(Phenotype phenotypes) {
		this.phenotypes = phenotypes;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getImageModality() {
		return imageModality;
	}
	public void setImageModality(String imageModality) {
		this.imageModality = imageModality;
	}
	public int getDaySequence() {
		return daySequence;
	}
	public void setDaySequence(int daySequence) {
		this.daySequence = daySequence;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Plant getPlant() {
		return plant;
	}
	public void setPlant(Plant plant) {
		this.plant = plant;
	}
}
