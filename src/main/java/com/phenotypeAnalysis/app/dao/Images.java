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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.*;


@Entity
@Table(name="Images")
public class Images {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_Id")
	private int image_Id;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String image_Modality;
	private int day_Sequence;
	private int view;
	private String file_Path;
	@ManyToOne
	@JoinColumn(name = "plant_Id", nullable = false)
    private Plant plant;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "images")
	Set<Phenotype> phenotypes;
	
	public Set<Phenotype> getPhenotypes() {
		return phenotypes;
	}
	public void setPhenotypes(Set<Phenotype> phenotypes) {
		this.phenotypes = phenotypes;
	}
	public int getImage_Id() {
		return image_Id;
	}
	public void setImage_Id(int image_Id) {
		this.image_Id = image_Id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getImage_Modality() {
		return image_Modality;
	}
	public void setImage_Modality(String image_Modality) {
		this.image_Modality = image_Modality;
	}
	public int getDay_Sequence() {
		return day_Sequence;
	}
	public void setDay_Sequence(int day_Sequence) {
		this.day_Sequence = day_Sequence;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public String getFile_Path() {
		return file_Path;
	}
	public void setFile_Path(String file_Path) {
		this.file_Path = file_Path;
	}
	public Plant getPlant() {
		return plant;
	}
	public void setPlant(Plant plant) {
		this.plant = plant;
	}
}
