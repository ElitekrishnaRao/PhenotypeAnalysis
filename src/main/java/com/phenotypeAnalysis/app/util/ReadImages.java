package com.phenotypeAnalysis.app.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFRow;

import com.phenotypeAnalysis.app.dao.Image;
import com.phenotypeAnalysis.app.dao.Plant;

public class ReadImages {
	
	public static Set<Image> putImageDataByPlant(Plant p) throws IOException {
		
		File imageDir=new File("C:\\Users\\SIDDU\\git\\PhenotypeAnalysis\\src\\main\\webapp\\img\\plantimages");
		File baseDir = new File("C:\\Users\\SIDDU\\git\\PhenotypeAnalysis\\src\\main\\webapp\\");
		File[] subFiles=imageDir.getAbsoluteFile().listFiles();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dfExcel = new SimpleDateFormat("dd-MM-yyyy");
		//System.out.println("Entered putImageDataByPlant");
		Set<Image> imageSet = new HashSet<Image>();
		
			for(File f : subFiles) {
				if (f.isDirectory()) {
					String s1= String.valueOf(f.getAbsoluteFile());
					String[] folderVal = s1.split ("_");
					String timestampVal = folderVal[folderVal.length - 2];
					String dateVal = folderVal[folderVal.length - 3];
					String plantNameVal = folderVal[folderVal.length - 4];
					
					if(p.getName().equals(plantNameVal))
					{
						//Images I=new Images();
						File[] subsubFiles=f.getAbsoluteFile().listFiles();
						for(File folder1 : subsubFiles){
							if(folder1.isDirectory()) {
								String s2=String.valueOf(folder1.getAbsolutePath().substring(baseDir.getAbsolutePath().length()+1))+"\\0_0_0.png";
								Date dateValue=null;
								if (s2.contains("Vis")) {
									Image I=new Image();
									if (s2.contains("SV_0")) {
										//System.out.println(s2);
										I.setView(0);
										I.setImageModality("RGB");
										try {
											dateValue=(Date)df.parse(dateVal);
											I.setDate(dateValue);
										}
										catch(Exception e)
										{
											e.printStackTrace();
										}
										I.setFilePath(s2);
										I.setPlant(p);
										//Getphenotype
										I.setPhenotypes(ReadPhenotype.readPhenotypeData(I, p,dfExcel.format(dateValue),0));
										imageSet.add(I);
										
									}
									
									if (s2.contains("SV_72")) {
										I.setView(72);
										I.setImageModality("RGB");
										try {
											dateValue=(Date)df.parse(dateVal);
											I.setDate(dateValue);
										}
										catch(Exception e)
										{
											e.printStackTrace();
										}
										I.setFilePath(s2);
										I.setPlant(p);
										//Getphenotype
										I.setPhenotypes(ReadPhenotype.readPhenotypeData(I, p,dfExcel.format(dateValue),72));
										imageSet.add(I);
									}
									
									/*
									if (s2.contains("SV_144")) {
										I.setView(144);
										I.setImage_Modality("RGB");
										try {
											dateValue=(Date)df.parse(dateVal);
											I.setDate(dateValue);
										}
										catch(Exception e)
										{
											e.printStackTrace();
										}
										I.setPlant(p);
										//Getphenotype
										I.setPhenotypes(ReadPhenotype.readPhenotypeData(p,dfExcel.format(dateValue),144));
										imageSet.add(I);
									}
									if (s2.contains("SV_216")) {
										I.setView(216);
										I.setImage_Modality("RGB");
										try {
											dateValue=(Date)df.parse(dateVal);
											I.setDate(dateValue);
										}
										catch(Exception e)
										{
											e.printStackTrace();
										}
										I.setPlant(p);
										//Getphenotype
										I.setPhenotypes(ReadPhenotype.readPhenotypeData(p,dfExcel.format(dateValue),216));
										imageSet.add(I);
									}
									if (s2.contains("SV_288")) {
										I.setView(288);
										I.setImage_Modality("RGB");
										try {
											dateValue=(Date)df.parse(dateVal);
											I.setDate(dateValue);
										}
										catch(Exception e)
										{
											e.printStackTrace();
										}
										I.setPlant(p);
										//Getphenotype
										I.setPhenotypes(ReadPhenotype.readPhenotypeData(p,dfExcel.format(dateValue),288));
										imageSet.add(I);
									}
									if (s2.contains("TV_90")) {
									}
									*/
								}
							}
						}
					}
				}
			}		
			System.out.println(imageSet.size());
			return imageSet;
	}
	
}
