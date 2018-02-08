package com.phenotypeAnalysis.app.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFRow;

import com.phenotypeAnalysis.app.dao.Images;
import com.phenotypeAnalysis.app.dao.Plant;

public class ReadImages {
	
	public static Set<Images> putImageDataByPlant(Plant p) throws IOException {
		
		File imageDir=new File("C:\\Users\\SIDDU\\Desktop\\Project\\Dataset\\SinglePlant");
		File[] subFiles=imageDir.getAbsoluteFile().listFiles();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dfExcel = new SimpleDateFormat("dd-MM-yyyy");
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
						Images I=new Images();
						File[] subsubFiles=f.getAbsoluteFile().listFiles();
						for(File folder1 : subsubFiles){
							if(folder1.isDirectory()) {
								String s2=String.valueOf(folder1.getAbsoluteFile());
								Date dateValue=null;
								if (s2.contains("Vis")) {
									if (s2.contains("SV_0")) {
										System.out.println(s2);
										I.setView(0);
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
										//Getphenomtype
										I.setPhenotypes(ReadPhenotype.readPhenotypeData(p,dfExcel.format(dateValue)));
										imageSet.add(I);
										
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
			System.out.println(imageSet.size());
			return imageSet;
	}
	
}
