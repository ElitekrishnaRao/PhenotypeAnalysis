package com.phenotypeAnalysis.app.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Phenotype")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Phenotype implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Temporal(TemporalType.DATE)
	private Date date;
	private int view;
	private double convexHullArea;
	private double plantPixelArea;
	private double arealDensity;
	private double boundingBoxHt;
	private double enclosingCircleDiameter;
	private double aspectRatio;
	
	@OneToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "id", nullable = false,insertable=false, updatable=false)
	private Image image;
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
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

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public double getConvexHullArea() {
		return convexHullArea;
	}

	public void setConvexHullArea(double d) {
		this.convexHullArea = d;
	}

	public double getPlantPixelArea() {
		return plantPixelArea;
	}

	public void setPlantPixelArea(double plantPixelArea) {
		this.plantPixelArea = plantPixelArea;
	}

	public double getArealDensity() {
		return arealDensity;
	}

	public void setArealDensity(double arealDensity) {
		this.arealDensity = arealDensity;
	}

	public double getBoundingBoxHt() {
		return boundingBoxHt;
	}

	public void setBoundingBoxHt(double boundingBoxHt) {
		this.boundingBoxHt = boundingBoxHt;
	}

	public double getEnclosingCircleDiameter() {
		return enclosingCircleDiameter;
	}

	public void setEnclosingCircleDiameter(double enclosingCircleDiameter) {
		this.enclosingCircleDiameter = enclosingCircleDiameter;
	}

	public double getAspectRatio() {
		return aspectRatio;
	}

	public void setAspectRatio(double aspectRatio) {
		this.aspectRatio = aspectRatio;
	}
	
}
