package com.phenotypeAnalysis.app.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.phenotypeAnalysis.app.dao.Images;
import com.phenotypeAnalysis.app.dao.Plant;

public class ReadImages {
	
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
