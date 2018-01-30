package com.phenotypeAnalysis.app.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Phenotype")
public class Phenotype implements Serializable {
	@Id
	private int phenotypeId;
	public int getPhenotypeId() {
		return phenotypeId;
	}

	public void setPhenotypeId(int phenotypeId) {
		this.phenotypeId = phenotypeId;
	}

	private int Plant_Id;
	private int Image_Id;
	@Temporal(TemporalType.DATE)
	private Date Date;
	private int view;
	private String Convex_Hull_Area;
	private String Plant_Pixel_Area;
	private String Areal_Density;
	private String Bounding_Box_Ht;
	private String Enclosing_Circle_Diameter;
	private String Aspect_Ratio;
	private String Plant_name;
	
	
		
	public int getPlant_Id() {
		return Plant_Id;
	}

	public void setPlant_Id(int plant_Id) {
		Plant_Id = plant_Id;
	}

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

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public String getConvex_Hull_Area() {
		return Convex_Hull_Area;
	}

	public void setConvex_Hull_Area(String convex_Hull_Area) {
		Convex_Hull_Area = convex_Hull_Area;
	}

	public String getPlant_Pixel_Area() {
		return Plant_Pixel_Area;
	}

	public void setPlant_Pixel_Area(String plant_Pixel_Area) {
		Plant_Pixel_Area = plant_Pixel_Area;
	}

	public String getAreal_Density() {
		return Areal_Density;
	}

	public void setAreal_Density(String areal_Density) {
		Areal_Density = areal_Density;
	}

	public String getBounding_Box_Ht() {
		return Bounding_Box_Ht;
	}

	public void setBounding_Box_Ht(String bounding_Box_Ht) {
		Bounding_Box_Ht = bounding_Box_Ht;
	}

	public String getEnclosing_Circle_Diameter() {
		return Enclosing_Circle_Diameter;
	}

	public void setEnclosing_Circle_Diameter(String enclosing_Circle_Diameter) {
		Enclosing_Circle_Diameter = enclosing_Circle_Diameter;
	}

	public String getAspect_Ratio() {
		return Aspect_Ratio;
	}

	public void setAspect_Ratio(String aspect_Ratio) {
		Aspect_Ratio = aspect_Ratio;
	}

	public String getPlant_name() {
		return Plant_name;
	}

	public void setPlant_name(String plant_name) {
		Plant_name = plant_name;
	}

	@Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Phenotype)) {
            return false;
        }
        Phenotype p = (Phenotype) o;
        return p.Plant_Id == this.Plant_Id;
    }

    //Idea from effective Java : Item 9
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Plant_name.hashCode();
        return result;
    }

	
}
