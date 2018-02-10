package com.phenotypeAnalysis.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

	public static Phenotype readPhenotypeData(Plant p, String date, Integer view) throws IOException {

		File src = new File("C:\\Users\\SIDDU\\Desktop\\LEMNATEC_RAE_WHEAT Phenotyping Results.xlsx");
		HSSFWorkbook workbook = new HSSFWorkbook();
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		XSSFRow row1 = sheet1.getRow(0);
		int length = row1.getLastCellNum();
		Iterator rows = sheet1.rowIterator();
		int noRows = 0;
		int noColumns = sheet1.getRow(0).getPhysicalNumberOfCells();
		Cell cell = null;

		while (rows.hasNext()) {
			XSSFRow row = (XSSFRow) rows.next();
			noRows++;
		}
		
		// columns names stored in Arraylist
		ArrayList<String> columnsHeader = new ArrayList<String>();
		for (int i = 0; i < length; i++) {
			cell = row1.getCell(i);
			columnsHeader.add(cell.toString());
			// System.out.println(columnsHeader.get(i));
		}
		
		DateFormat dfExcel = new SimpleDateFormat("dd-MM-yyyy");
		Phenotype ph = new Phenotype();
		
		for (int i = 1; i <=1500; i++) {
			Date dateVal = sheet1.getRow(i).getCell(1).getDateCellValue();
			if(p.getPlant_Name().equals(sheet1.getRow(i).getCell(0).getStringCellValue()) && dateVal!=null && date.equals(dfExcel.format(dateVal))){
				for (int j = 0; j < noColumns; j++) {
					if (sheet1.getRow(i) != null) {
						if(view==0)
						{
							if (columnsHeader.get(j).contains("SV_0") && columnsHeader.get(j).contains("convex_hull_area")) {
								ph.setView(0);
								ph.setConvex_Hull_Area(sheet1.getRow(i).getCell(j).getRawValue());
							}
							if (columnsHeader.get(j).contains("SV_0") && columnsHeader.get(j).contains("plant_pixel_area"))
								ph.setPlant_Pixel_Area(sheet1.getRow(i).getCell(j).getRawValue());
							if (columnsHeader.get(j).contains("SV_0") && columnsHeader.get(j).contains("areal_density"))
								ph.setAreal_Density(sheet1.getRow(i).getCell(j).getRawValue());
							if (columnsHeader.get(j).contains("aspect_ratio"))
								ph.setAspect_Ratio(sheet1.getRow(i).getCell(j).getRawValue());
							if (columnsHeader.get(j).contains("SV_0") && columnsHeader.get(j).contains("bounding_box_height")) {
								ph.setBounding_Box_Ht(sheet1.getRow(i).getCell(j).getRawValue());
								String plantName = sheet1.getRow(i).getCell(0).getStringCellValue();
								Date plantDate = sheet1.getRow(i).getCell(1).getDateCellValue();
								ph.setDate(plantDate);
								ph.setEnclosing_Circle_Diameter("null");
							}
							//return ph;
						}
						
						else if (view==72)
						{
							if (columnsHeader.get(j).contains("SV_72") && columnsHeader.get(j).contains("convex_hull_area")) {
								ph.setView(72);
								ph.setConvex_Hull_Area(sheet1.getRow(i).getCell(j).getRawValue());
							}
							if (columnsHeader.get(j).contains("SV_72") && columnsHeader.get(j).contains("plant_pixel_area"))
								ph.setPlant_Pixel_Area(sheet1.getRow(i).getCell(j).getRawValue());
							if (columnsHeader.get(j).contains("SV_72") && columnsHeader.get(j).contains("areal_density")) {
								ph.setAreal_Density(sheet1.getRow(i).getCell(j).getRawValue());
								String plantName = sheet1.getRow(i).getCell(0).getStringCellValue();
								Date plantDate = sheet1.getRow(i).getCell(1).getDateCellValue();
								ph.setDate(plantDate);
								ph.setBounding_Box_Ht("null");
								ph.setEnclosing_Circle_Diameter("null");
								ph.setAspect_Ratio("null");
							}
						}
						
						
						
						else if(view==144)
						{
							if (columnsHeader.get(j).contains("SV_144") && columnsHeader.get(j).contains("convex_hull_area")) {
								ph.setView(144);
								ph.setConvex_Hull_Area(sheet1.getRow(i).getCell(j).getRawValue());
							}
							if (columnsHeader.get(j).contains("SV_144") && columnsHeader.get(j).contains("plant_pixel_area"))
								ph.setPlant_Pixel_Area(sheet1.getRow(i).getCell(j).getRawValue());
							if (columnsHeader.get(j).contains("SV_144") && columnsHeader.get(j).contains("areal_density")) {
								ph.setAreal_Density(sheet1.getRow(i).getCell(j).getRawValue());
								String plantName = sheet1.getRow(i).getCell(0).getStringCellValue();
								Date plantDate = sheet1.getRow(i).getCell(1).getDateCellValue();
								ph.setDate(plantDate);
								ph.setBounding_Box_Ht("null");
								ph.setEnclosing_Circle_Diameter("null");
								ph.setAspect_Ratio("null");
							}
						}
					
						else if(view==216)
						{
							if (columnsHeader.get(j).contains("SV_216") && columnsHeader.get(j).contains("convex_hull_area")) {
								ph.setView(216);
								ph.setConvex_Hull_Area(sheet1.getRow(i).getCell(j).getRawValue());
							}
							if (columnsHeader.get(j).contains("SV_216") && columnsHeader.get(j).contains("plant_pixel_area"))
								ph.setPlant_Pixel_Area(sheet1.getRow(i).getCell(j).getRawValue());
							if (columnsHeader.get(j).contains("SV_216") && columnsHeader.get(j).contains("areal_density")) {
								ph.setAreal_Density(sheet1.getRow(i).getCell(j).getRawValue());
								String plantName = sheet1.getRow(i).getCell(0).getStringCellValue();
								Date plantDate = sheet1.getRow(i).getCell(1).getDateCellValue();
								ph.setDate(plantDate);
								ph.setBounding_Box_Ht("null");
								ph.setEnclosing_Circle_Diameter("null");
								ph.setAspect_Ratio("null");
							}
						}
						
						else if(view==288)
						{
							if (columnsHeader.get(j).contains("SV_288") && columnsHeader.get(j).contains("convex_hull_area")) {
								ph.setView(288);
								ph.setConvex_Hull_Area(sheet1.getRow(i).getCell(j).getRawValue());
							}
							if (columnsHeader.get(j).contains("SV_288") && columnsHeader.get(j).contains("plant_pixel_area"))
								ph.setPlant_Pixel_Area(sheet1.getRow(i).getCell(j).getRawValue());
							if (columnsHeader.get(j).contains("SV_288") && columnsHeader.get(j).contains("areal_density")) {
								ph.setAreal_Density(sheet1.getRow(i).getCell(j).getRawValue());
								ph.setEnclosing_Circle_Diameter(sheet1.getRow(i).getCell(j).getRawValue());
								String plantName = sheet1.getRow(i).getCell(0).getStringCellValue();
								Date plantDate = sheet1.getRow(i).getCell(1).getDateCellValue();
								ph.setDate(plantDate);
								ph.setBounding_Box_Ht("null");
								ph.setEnclosing_Circle_Diameter("null");
								ph.setAspect_Ratio("null");	
							}
						}
						
						else System.out.println("View not specified"); 
						
					}
				}
			}
		}

		return ph;
	}

}