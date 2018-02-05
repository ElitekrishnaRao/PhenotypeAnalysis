package com.phenotypeAnalysis.app.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Phenotype")
public class Phenotype implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "phenotype_Id")
	private int phenotype_Id;
	@ManyToOne
	@JoinColumn(name = "image_Id", nullable = false)
	private Images images;
	@Temporal(TemporalType.DATE)
	private Date date;
	private int view;
	private String convex_Hull_Area;
	private String plant_Pixel_Area;
	private String areal_Density;
	private String bounding_Box_Ht;
	private String enclosing_Circle_Diameter;
	private String aspect_Ratio;	
	
	public Images getImages() {
		return images;
	}

	public void setImages(Images images) {
		this.images = images;
	}
	
	public int getPhenotypeId() {
		return phenotype_Id;
	}

	public void setPhenotypeId(int phenotype_Id) {
		this.phenotype_Id = phenotype_Id;
	}

	public int getPhenotype_Id() {
		return phenotype_Id;
	}

	public void setPhenotype_Id(int phenotype_Id) {
		this.phenotype_Id = phenotype_Id;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public String getConvex_Hull_Area() {
		return convex_Hull_Area;
	}

	public void setConvex_Hull_Area(String convex_Hull_Area) {
		this.convex_Hull_Area = convex_Hull_Area;
	}

	public String getPlant_Pixel_Area() {
		return plant_Pixel_Area;
	}

	public void setPlant_Pixel_Area(String plant_Pixel_Area) {
		this.plant_Pixel_Area = plant_Pixel_Area;
	}

	public String getAreal_Density() {
		return areal_Density;
	}

	public void setAreal_Density(String areal_Density) {
		this.areal_Density = areal_Density;
	}

	public String getBounding_Box_Ht() {
		return bounding_Box_Ht;
	}

	public void setBounding_Box_Ht(String bounding_Box_Ht) {
		this.bounding_Box_Ht = bounding_Box_Ht;
	}

	public String getEnclosing_Circle_Diameter() {
		return enclosing_Circle_Diameter;
	}

	public void setEnclosing_Circle_Diameter(String enclosing_Circle_Diameter) {
		this.enclosing_Circle_Diameter = enclosing_Circle_Diameter;
	}

	public String getAspect_Ratio() {
		return aspect_Ratio;
	}

	public void setAspect_Ratio(String aspect_Ratio) {
		this.aspect_Ratio = aspect_Ratio;
	}
	
}
