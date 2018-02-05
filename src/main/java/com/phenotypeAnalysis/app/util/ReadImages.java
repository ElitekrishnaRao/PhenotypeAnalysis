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
		String[] subDir = imageDir.list();
		File[] subFiles=imageDir.getAbsoluteFile().listFiles();
		ArrayList<Images> s = new ArrayList<Images>();
		Images I=new Images();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Map  plantMap = getPlantMap();
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
									imageSet.add(I);
									I=new Images();
								}

								if (s2.contains("SV_72")) {
									//System.out.println(folder1);
									//I.setView(0);
									//I.setImage_Morality("Vis");
									//I.setDate(dateVal);
									//I.setPlant_Id((Integer)plantMap.get(plantNameVal));
									//I.setPlant_Name(plantNameVal);
									//s.add(I);
									//I=new Images();
								}
								if (s2.contains("SV_144")) {
									//System.out.println(folder1);
									//I.setView(0);
									//I.setImage_Morality("Vis");
									//I.setDate(dateVal);
									//I.setPlant_Id((Integer)plantMap.get(plantNameVal));
									//I.setPlant_Name(plantNameVal);
									//s.add(I);
									//I=new Images();
								}
								if (s2.contains("SV_216")) {
									//System.out.println(folder1);
									//I.setView(0);
									//I.setImage_Morality("Vis");
									//I.setDate(dateVal);
									//I.setPlant_Id((Integer)plantMap.get(plantNameVal));
									//I.setPlant_Name(plantNameVal);
									//s.add(I);
									//I=new Images();
								}
								if (s2.contains("SV_288")) {
									//System.out.println(folder1);
									//I.setView(0);
									//I.setImage_Morality("Vis");
									//I.setDate(dateVal);
									//I.setPlant_Id((Integer)plantMap.get(plantNameVal));
									//I.setPlant_Name(plantNameVal);
									//s.add(I);
									//I=new Images();
								}
								if (s2.contains("TV_90")) {
									//System.out.println(folder1);
									//I.setView(0);
									//I.setImage_Morality("Vis");
									//I.setDate(dateVal);
									//I.setPlant_Id((Integer)plantMap.get(plantNameVal));
									//I.setPlant_Name(plantNameVal);
									//s.add(I);
									//I=new Images();
								}
							}
						}
					}
				}
			}


		Configuration con= new Configuration().configure().addAnnotatedClass(Images.class);
		SessionFactory sf= con.buildSessionFactory();
		Session s1= sf.openSession();
		
		return imageSet;
	}

	private static Map getPlantMap() {
		Map<String, Integer> plantMap = new HashMap<String, Integer>();
		try{
			Configuration con1= new Configuration().configure().addAnnotatedClass(Plant.class);
			SessionFactory sf1= con1.buildSessionFactory();
			Session s2= sf1.openSession();
			s2.beginTransaction();
			Query queryResult=s2.createQuery("from Plant");
			List l =  queryResult.list();
			Iterator it2 = l.iterator();

			while(it2.hasNext())
			{
				Plant plantObj=(Plant)it2.next();
				plantMap.put(plantObj.getPlant_Name(), plantObj.getPlant_Id());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return plantMap;
	}
}
