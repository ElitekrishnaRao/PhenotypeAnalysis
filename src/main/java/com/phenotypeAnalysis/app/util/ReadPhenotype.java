package com.phenotypeAnalysis.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.phenotypeAnalysis.app.dao.Phenotype;
import com.phenotypeAnalysis.app.dao.Plant;

public class ReadPhenotype {
	
	public static Set<Phenotype> readPhenotypeData() throws IOException {
		
		File src= new File("C:\\Users\\SIDDU\\Desktop\\LEMNATEC_RAE_WHEAT Phenotyping Results.xlsx");
		HSSFWorkbook workbook = new HSSFWorkbook();
		FileInputStream fis= new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet1=wb.getSheetAt(0);
		XSSFRow row1 = sheet1.getRow(0);
		int length = row1.getLastCellNum();
		Iterator rows=sheet1.rowIterator();
		int noRows = 0;
		int noColumns = sheet1.getRow(0).getPhysicalNumberOfCells();
		Cell cell = null;
		
		while( rows.hasNext() ) {
            XSSFRow row = (XSSFRow) rows.next();
            noRows++;                
        }
		Set<Phenotype> phenotypeSet = new HashSet<Phenotype>();
		//columns names stored in Arraylist 
		ArrayList<String> columnsHeader=new ArrayList<String>();
		for( int i = 0 ; i < length ; i++ )
        {
             cell = row1.getCell(i);
             columnsHeader.add(cell.toString());
             //System.out.println(columnsHeader.get(i));
        }
		
		// Read plant_id and plant_name from plant table and write to an excel sheet
		// this helps to map corresponding plant id to plant name in below phenotypes table
		
		Map  plantMap = getPlantMap();
		Map<Integer, List> phen = new HashMap<Integer, List>();	
		int count =0;
		for(int i=1; i<=noRows; i++)
		{
			count++;
			Phenotype ph=new Phenotype();
			//ArrayList<Phenotype> s = new ArrayList<Phenotype>();
			
			for(int j=0; j<noColumns;j++)
			{
				if(sheet1.getRow(i)!=null){
					    if(columnsHeader.get(j).contains("SV_0") && columnsHeader.get(j).contains("convex_hull_area")){
					    	ph.setView(0);
					    	ph.setConvex_Hull_Area(sheet1.getRow(i).getCell(j).getRawValue());
					       }
					    if(columnsHeader.get(j).contains("SV_0") && columnsHeader.get(j).contains("plant_pixel_area"))
							ph.setPlant_Pixel_Area(sheet1.getRow(i).getCell(j).getRawValue());
					    if(columnsHeader.get(j).contains("SV_0") && columnsHeader.get(j).contains("areal_density"))
							ph.setAreal_Density(sheet1.getRow(i).getCell(j).getRawValue());
						if(columnsHeader.get(j).contains("aspect_ratio"))
						    ph.setAspect_Ratio(sheet1.getRow(i).getCell(j).getRawValue());
					    if(columnsHeader.get(j).contains("SV_0") && columnsHeader.get(j).contains("bounding_box_height"))
					    {
							ph.setBounding_Box_Ht(sheet1.getRow(i).getCell(j).getRawValue());
						    String plantName=sheet1.getRow(i).getCell(0).getStringCellValue();
							Date plantDate=sheet1.getRow(i).getCell(1).getDateCellValue();
							ph.setPlant_name(plantName);
							ph.setPlant_Id((Integer)plantMap.get(plantName));
							ph.setDate(plantDate);
							ph.setEnclosing_Circle_Diameter("null");
							phenotypeSet.add(ph);
							ph = new Phenotype();
					    }
					    
						
					    if(columnsHeader.get(j).contains("SV_72") && columnsHeader.get(j).contains("convex_hull_area")){
					    	ph.setView(72);
					    	ph.setConvex_Hull_Area(sheet1.getRow(i).getCell(j).getRawValue());
					       }
					    if(columnsHeader.get(j).contains("SV_72") && columnsHeader.get(j).contains("plant_pixel_area"))
							ph.setPlant_Pixel_Area(sheet1.getRow(i).getCell(j).getRawValue());
					    if(columnsHeader.get(j).contains("SV_72") && columnsHeader.get(j).contains("areal_density")){
							ph.setAreal_Density(sheet1.getRow(i).getCell(j).getRawValue());
							String plantName=sheet1.getRow(i).getCell(0).getStringCellValue();
							Date plantDate=sheet1.getRow(i).getCell(1).getDateCellValue();
							ph.setPlant_name(plantName);
							ph.setDate(plantDate);
							ph.setBounding_Box_Ht("null");
							ph.setEnclosing_Circle_Diameter("null");
							ph.setAspect_Ratio("null");
							ph.setPlant_Id((Integer)plantMap.get(plantName));
							phenotypeSet.add(ph);
						ph = new Phenotype();
					    }
					    
					    if(columnsHeader.get(j).contains("SV_144") && columnsHeader.get(j).contains("convex_hull_area")){
					    	ph.setView(144);
					    	ph.setConvex_Hull_Area(sheet1.getRow(i).getCell(j).getRawValue());
					       }
					    if(columnsHeader.get(j).contains("SV_144") && columnsHeader.get(j).contains("plant_pixel_area"))
							ph.setPlant_Pixel_Area(sheet1.getRow(i).getCell(j).getRawValue());
					    if(columnsHeader.get(j).contains("SV_144") && columnsHeader.get(j).contains("areal_density")){
							ph.setAreal_Density(sheet1.getRow(i).getCell(j).getRawValue());
							String plantName=sheet1.getRow(i).getCell(0).getStringCellValue();
							Date plantDate=sheet1.getRow(i).getCell(1).getDateCellValue();
							ph.setPlant_name(plantName);
							ph.setDate(plantDate);   
							ph.setPlant_Id((Integer)plantMap.get(plantName));
							ph.setBounding_Box_Ht("null");
							ph.setEnclosing_Circle_Diameter("null");
							ph.setAspect_Ratio("null");
							phenotypeSet.add(ph);
						ph = new Phenotype();
					    }    
						
					    if(columnsHeader.get(j).contains("SV_216") && columnsHeader.get(j).contains("convex_hull_area")){
					    	ph.setView(216);
					    	ph.setConvex_Hull_Area(sheet1.getRow(i).getCell(j).getRawValue());
					       }
					    if(columnsHeader.get(j).contains("SV_216") && columnsHeader.get(j).contains("plant_pixel_area"))
							ph.setPlant_Pixel_Area(sheet1.getRow(i).getCell(j).getRawValue());
					    if(columnsHeader.get(j).contains("SV_216") && columnsHeader.get(j).contains("areal_density")){
							ph.setAreal_Density(sheet1.getRow(i).getCell(j).getRawValue());
							String plantName=sheet1.getRow(i).getCell(0).getStringCellValue();
							Date plantDate=sheet1.getRow(i).getCell(1).getDateCellValue();
							ph.setPlant_name(plantName);
							ph.setPlant_Id((Integer)plantMap.get(plantName));
							ph.setDate(plantDate);
							ph.setBounding_Box_Ht("null");
							ph.setEnclosing_Circle_Diameter("null");
							ph.setAspect_Ratio("null");
							phenotypeSet.add(ph);
							ph = new Phenotype();
					    }
						
					    if(columnsHeader.get(j).contains("SV_288") && columnsHeader.get(j).contains("convex_hull_area")){
					    	ph.setView(288);
					    	ph.setConvex_Hull_Area(sheet1.getRow(i).getCell(j).getRawValue());
					       }
					    if(columnsHeader.get(j).contains("SV_288") && columnsHeader.get(j).contains("plant_pixel_area"))
							ph.setPlant_Pixel_Area(sheet1.getRow(i).getCell(j).getRawValue());
					    if(columnsHeader.get(j).contains("SV_288") && columnsHeader.get(j).contains("areal_density")){
							ph.setAreal_Density(sheet1.getRow(i).getCell(j).getRawValue());
							ph.setEnclosing_Circle_Diameter(sheet1.getRow(i).getCell(j).getRawValue());    
							String plantName=sheet1.getRow(i).getCell(0).getStringCellValue();
							Date plantDate=sheet1.getRow(i).getCell(1).getDateCellValue();
							ph.setPlant_name(plantName);
							ph.setDate(plantDate);
							ph.setPlant_Id((Integer)plantMap.get(plantName));
							ph.setBounding_Box_Ht("null");
							ph.setEnclosing_Circle_Diameter("null");
							ph.setAspect_Ratio("null");
							phenotypeSet.add(ph);
						    ph = new Phenotype();
					    }
			}
		}
			phen.put(count, (List) phenotypeSet);	
	}  
		
		
		Set s = 	phen.entrySet();	
		Iterator it = s.iterator();
		int count1=0;
		Configuration con= new Configuration().configure().addAnnotatedClass(Phenotype.class);
        SessionFactory sf= con.buildSessionFactory();
        Session s1= sf.openSession();
        
        Transaction tx = s1.beginTransaction();
		while(it.hasNext())
		{
			Map.Entry e  = (Map.Entry)it.next();
			List plants= (ArrayList)e.getValue();
			
			Iterator it1 = plants.iterator();
			while(it1.hasNext())
			{
				count1++;
				Phenotype phe  = (Phenotype)it1.next();
				phe.setPhenotypeId(count1);
				phe.setImage_Id(1);
		        s1.saveOrUpdate(phe);
			}
		}
		tx.commit(); 

return phenotypeSet;
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