package com.phenotypeAnalysis.app.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Plant")
public class Plant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Plant_Id")
	private int Plant_Id;
	@Column(name = "plant_name")
	private String plant_Name;
	@Column(name = "treatment_Id")
	private int Treatment_Id;
	// @Column(name = "family_Id")
	// private int Family_Id;
	@Column(name = "species_id")
	private int Species_Id;
	@Column(name = "Genotype_Id")
	private int Genotype_Id;
	@OneToMany(cascade = CascadeType.ALL)
	Set<Images> ImagesList;
	public Set<Images> getImagesList() {
		return ImagesList;
	}

	public void setImagesList(Set<Images> imagesList) {
		ImagesList = imagesList;
	}

	public int getGenotype_Id() {
		return Genotype_Id;
	}

	public void setGenotype_Id(int genotype_Id) {
		Genotype_Id = genotype_Id;
	}

	public String getPlant_Name() {
		return plant_Name;
	}

	public void setPlant_Name(String plant_Name) {
		this.plant_Name = plant_Name;
	}

	public int getPlant_Id() {
		return Plant_Id;
	}

	public void setPlant_Id(int plant_Id) {
		Plant_Id = plant_Id;
	}

	public int getTreatment_Id() {
		return Treatment_Id;
	}

	public void setTreatment_Id(int treatment_Id) {
		Treatment_Id = treatment_Id;
	}

	public int getSpecies_Id() {
		return Species_Id;
	}

	public void setSpecies_Id(int species_Id) {
		Species_Id = species_Id;
	}

	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;
		if (!(o instanceof Plant)) {
			return false;
		}
		Plant p = (Plant) o;
		return p.Plant_Id == this.Plant_Id;
	}

	// Idea from effective Java : Item 9
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + plant_Name.hashCode();
		return result;
	}
}
