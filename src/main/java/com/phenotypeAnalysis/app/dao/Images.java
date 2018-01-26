package com.phenotypeAnalysis.app.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.*;


@Entity
public class Images {
	@Id
	@Column(name = "Image_Id")
	private int Image_Id;
	@Temporal(TemporalType.DATE)
	private Date Date;
	private int Plant_Id;
	private String Plant_Name;
	private String Image_Morality;
	private int Day_Sequence;
	private int View;
	@ManyToOne
    @JoinColumn(name="Plant_Ids")
    private Plant plant;
	public int getImage_Id() {
		return Image_Id;
	}
	public void setImage_Id(int image_Id) {
		Image_Id = image_Id;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public int getPlant_Id() {
		return Plant_Id;
	}
	public void setPlant_Id(int plant_Id) {
		Plant_Id = plant_Id;
	}
	public String getImage_Morality() {
		return Image_Morality;
	}
	public void setImage_Morality(String image_Morality) {
		Image_Morality = image_Morality;
	}


	public int getView() {
		return View;
	}
	public void setView(int view) {
		View = view;
	}

	public String getPlant_Name() {
		return Plant_Name;
	}

	public void setPlant_Name(String plant_Name) {
		Plant_Name = plant_Name;
	}

	public int getDay_Sequence() {
		return Day_Sequence;
	}

	public void setDay_Sequence(int day_Sequence) {
		Day_Sequence = day_Sequence;
	}
}
