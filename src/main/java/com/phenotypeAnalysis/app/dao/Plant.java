package com.phenotypeAnalysis.app.dao;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Plant")
public class Plant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "plant_Id")
	private int plant_Id;
	@Column(name = "plant_Name")
	private String plant_Name;
	@Column(name = "treatment_Id")
	private int treatment_Id;
	@Column(name = "species_Id")
	private int species_Id;
	@Column(name = "genotype_Id")
	private int genotype_Id;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "plant")
	Set<Images> ImagesList;

	public Set<Images> getImagesList() {
		return ImagesList;
	}

	public int getPlant_Id() {
		return plant_Id;
	}

	public void setPlant_Id(int plant_Id) {
		this.plant_Id = plant_Id;
	}

	public String getPlant_Name() {
		return plant_Name;
	}

	public void setPlant_Name(String plant_Name) {
		this.plant_Name = plant_Name;
	}

	public int getTreatment_Id() {
		return treatment_Id;
	}

	public void setTreatment_Id(int treatment_Id) {
		this.treatment_Id = treatment_Id;
	}

	public int getSpecies_Id() {
		return species_Id;
	}

	public void setSpecies_Id(int species_Id) {
		this.species_Id = species_Id;
	}

	public int getGenotype_Id() {
		return genotype_Id;
	}

	public void setGenotype_Id(int genotype_Id) {
		this.genotype_Id = genotype_Id;
	}

	public void setImagesList(Set<Images> imagesList) {
		ImagesList = imagesList;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Plant)) {
			return false;
		}
		Plant p = (Plant) o;
		return p.plant_Id == this.plant_Id;
	}

	// Idea from effective Java : Item 9
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + plant_Name.hashCode();
		return result;
	}
}
