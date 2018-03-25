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

import com.phenotypeAnalysis.app.dao.Image;
import com.phenotypeAnalysis.app.dao.Phenotype;
import com.phenotypeAnalysis.app.dao.Plant;

public class ReadPhenotype {

	public static Phenotype readPhenotypeData(Image I, Plant p, String date, Integer view) throws IOException {

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
			if(p.getName().equals(sheet1.getRow(i).getCell(0).getStringCellValue()) && dateVal!=null && date.equals(dfExcel.format(dateVal))){
				for (int j = 0; j < noColumns; j++) {
					if (sheet1.getRow(i) != null) {
						if(view==0)
						{
							if (columnsHeader.get(j).contains("SV_0") && columnsHeader.get(j).contains("convex_hull_area")) {
								//ph.setView(0);
								ph.setConvexHullArea(sheet1.getRow(i).getCell(j).getNumericCellValue());
							}
							if (columnsHeader.get(j).contains("SV_0") && columnsHeader.get(j).contains("plant_pixel_area"))
								ph.setPlantPixelArea(sheet1.getRow(i).getCell(j).getNumericCellValue());
							if (columnsHeader.get(j).contains("SV_0") && columnsHeader.get(j).contains("areal_density"))
								ph.setArealDensity(sheet1.getRow(i).getCell(j).getNumericCellValue());
							if (columnsHeader.get(j).contains("aspect_ratio"))
								ph.setAspectRatio(sheet1.getRow(i).getCell(j).getNumericCellValue());
							if (columnsHeader.get(j).contains("SV_0") && columnsHeader.get(j).contains("bounding_box_height")) {
								ph.setBoundingBoxHt(sheet1.getRow(i).getCell(j).getNumericCellValue());
								String plantName = sheet1.getRow(i).getCell(0).getStringCellValue();
								Date plantDate = sheet1.getRow(i).getCell(1).getDateCellValue();
								//ph.setDate(plantDate);
								//ph.setEnclosingCircleDiameter("");
								ph.setImage(I);
							}
							//return ph;
						}
						
						else if (view==72)
						{
							if (columnsHeader.get(j).contains("SV_72") && columnsHeader.get(j).contains("convex_hull_area")) {
								//ph.setView(72);
								ph.setConvexHullArea(sheet1.getRow(i).getCell(j).getNumericCellValue());
							}
							if (columnsHeader.get(j).contains("SV_72") && columnsHeader.get(j).contains("plant_pixel_area"))
								ph.setPlantPixelArea(sheet1.getRow(i).getCell(j).getNumericCellValue());
							if (columnsHeader.get(j).contains("SV_72") && columnsHeader.get(j).contains("areal_density")) {
								ph.setArealDensity(sheet1.getRow(i).getCell(j).getNumericCellValue());
								String plantName = sheet1.getRow(i).getCell(0).getStringCellValue();
								Date plantDate = sheet1.getRow(i).getCell(1).getDateCellValue();
								//ph.setDate(plantDate);
								//ph.setBoundingBoxHt("null");
								//ph.setEnclosingCircleDiameter("null");
								//ph.setAspectRatio("null");
								ph.setImage(I);
							}
						}
						
						
						
						else if(view==144)
						{
							if (columnsHeader.get(j).contains("SV_144") && columnsHeader.get(j).contains("convex_hull_area")) {
								//ph.setView(144);
								ph.setConvexHullArea(sheet1.getRow(i).getCell(j).getNumericCellValue());
							}
							if (columnsHeader.get(j).contains("SV_144") && columnsHeader.get(j).contains("plant_pixel_area"))
								ph.setPlantPixelArea(sheet1.getRow(i).getCell(j).getNumericCellValue());
							if (columnsHeader.get(j).contains("SV_144") && columnsHeader.get(j).contains("areal_density")) {
								ph.setArealDensity(sheet1.getRow(i).getCell(j).getNumericCellValue());
								String plantName = sheet1.getRow(i).getCell(0).getStringCellValue();
								Date plantDate = sheet1.getRow(i).getCell(1).getDateCellValue();
								//ph.setDate(plantDate);
//								ph.setBoundingBoxHt("null");
//								ph.setEnclosingCircleDiameter("null");
//								ph.setAspectRatio("null");
								ph.setImage(I);
							}
						}
					
						else if(view==216)
						{
							if (columnsHeader.get(j).contains("SV_216") && columnsHeader.get(j).contains("convex_hull_area")) {
								//ph.setView(216);
								ph.setConvexHullArea(sheet1.getRow(i).getCell(j).getNumericCellValue());
							}
							if (columnsHeader.get(j).contains("SV_216") && columnsHeader.get(j).contains("plant_pixel_area"))
								ph.setPlantPixelArea(sheet1.getRow(i).getCell(j).getNumericCellValue());
							if (columnsHeader.get(j).contains("SV_216") && columnsHeader.get(j).contains("areal_density")) {
								ph.setArealDensity(sheet1.getRow(i).getCell(j).getNumericCellValue());
								String plantName = sheet1.getRow(i).getCell(0).getStringCellValue();
								Date plantDate = sheet1.getRow(i).getCell(1).getDateCellValue();
								//ph.setDate(plantDate);
								//ph.setBoundingBoxHt("null");
								//ph.setEnclosingCircleDiameter("null");
								//ph.setAspectRatio("null");
								ph.setImage(I);
							}
						}
						
						else if(view==288)
						{
							if (columnsHeader.get(j).contains("SV_288") && columnsHeader.get(j).contains("convex_hull_area")) {
								//ph.setView(288);
								ph.setConvexHullArea(sheet1.getRow(i).getCell(j).getNumericCellValue());
							}
							if (columnsHeader.get(j).contains("SV_288") && columnsHeader.get(j).contains("plant_pixel_area"))
								ph.setPlantPixelArea(sheet1.getRow(i).getCell(j).getNumericCellValue());
							if (columnsHeader.get(j).contains("SV_288") && columnsHeader.get(j).contains("areal_density")) {
								ph.setArealDensity(sheet1.getRow(i).getCell(j).getNumericCellValue());
								ph.setEnclosingCircleDiameter(sheet1.getRow(i).getCell(j).getNumericCellValue());
								String plantName = sheet1.getRow(i).getCell(0).getStringCellValue();
								Date plantDate = sheet1.getRow(i).getCell(1).getDateCellValue();
								//ph.setDate(plantDate);
								//ph.setBoundingBoxHt("null");
								//ph.setEnclosingCircleDiameter("null");
								//ph.setAspectRatio("null");	
								ph.setImage(I);
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