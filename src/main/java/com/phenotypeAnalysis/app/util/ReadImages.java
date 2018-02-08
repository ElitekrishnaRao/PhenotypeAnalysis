package com.phenotypeAnalysis.app.util;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.phenotypeAnalysis.app.dao.Images;
import com.phenotypeAnalysis.app.dao.Plant;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class ReadImages {
	
	public static Set<Images> readImageData() throws IOException {

		File imageDir=new File("C:\\Users\\SIDDU\\Desktop\\Project\\Dataset\\SinglePlant");
		File[] subFiles=imageDir.getAbsoluteFile().listFiles();
		Images I=new Images();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		Set<Images> imageSet = new HashSet<Images>();

			for(File f : subFiles) {
				if (f.isDirectory()) {
					String s1= String.valueOf(f.getAbsoluteFile());
					String[] folderVal = s1.split ("_");
					String timestampVal = folderVal[folderVal.length - 2];
					String dateVal = folderVal[folderVal.length - 3];
					String plantNameVal = folderVal[folderVal.length - 4];
					
					File[] subsubFiles=f.getAbsoluteFile().listFiles();
					for(File folder1 : subsubFiles){
						if(folder1.isDirectory()) {
							String s2=String.valueOf(folder1.getAbsoluteFile());
							System.out.println(s2);
							if (s2.contains("Vis")) {
								if (s2.contains("SV_0")) {
									I.setView(0);
									I.setImage_Modality("RGB");
									try {
										Date dateValue=(Date)df.parse(dateVal);
										I.setDate(dateValue);
									}
									catch(Exception e)
									{
										e.printStackTrace();
									}
									I.setFile_Path(s2);
									imageSet.add(I);
									I=new Images();
								}
								if (s2.contains("SV_72")) {
								}
								if (s2.contains("SV_144")) {
								}
								if (s2.contains("SV_216")) {
								}
								if (s2.contains("SV_288")) {
								}
								if (s2.contains("TV_90")) {
								}
							}
						}
					}
				}
			}		
		return imageSet;
	}
	
	public static Set<Images> putImageDataByPlant(Plant p) throws IOException {
		
		File imageDir=new File("C:\\Users\\SIDDU\\Desktop\\Project\\Dataset\\SinglePlant");
		File[] subFiles=imageDir.getAbsoluteFile().listFiles();
		Images I=new Images();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Entered putImageDataByPlant");
		Set<Images> imageSet = new HashSet<Images>();

			for(File f : subFiles) {
				if (f.isDirectory()) {
					String s1= String.valueOf(f.getAbsoluteFile());
					String[] folderVal = s1.split ("_");
					String timestampVal = folderVal[folderVal.length - 2];
					String dateVal = folderVal[folderVal.length - 3];
					String plantNameVal = folderVal[folderVal.length - 4];
					
					if(p.getPlant_Name().equals(plantNameVal))
					{
						File[] subsubFiles=f.getAbsoluteFile().listFiles();
						for(File folder1 : subsubFiles){
							if(folder1.isDirectory()) {
								String s2=String.valueOf(folder1.getAbsoluteFile());
								
								if (s2.contains("Vis")) {
									if (s2.contains("SV_0")) {
										System.out.println(s2);
										I.setView(0);
										I.setImage_Modality("RGB");
										try {
											Date dateValue=(Date)df.parse(dateVal);
											I.setDate(dateValue);
										}
										catch(Exception e)
										{
											e.printStackTrace();
										}
										//I.setFile_Path(s2);
										I.setPlant(p);
										imageSet.add(I);
										System.out.println(imageSet);
										I=new Images();
									}
									if (s2.contains("SV_72")) {
									}
									if (s2.contains("SV_144")) {
									}
									if (s2.contains("SV_216")) {
									}
									if (s2.contains("SV_288")) {
									}
									if (s2.contains("TV_90")) {
									}
								}
							}
						}
					}
				}
			}		
			return imageSet;
	}
	
}
