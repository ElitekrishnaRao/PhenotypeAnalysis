package com.phenotypeAnalysis.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.phenotypeAnalysis.app.dao.Plant;

public class ReadPlant {

	public static Set<Plant> readPlantData() throws IOException {
		File src = new File("C:\\Users\\SIDDU\\Desktop\\LEMNATEC_RAE_WHEAT Phenotyping Results.xlsx");
		HSSFWorkbook workbook = new HSSFWorkbook();
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(1);
		XSSFRow row1 = sheet1.getRow(3);
		Iterator rows = sheet1.rowIterator();
		int noRows = 0;
		while (rows.hasNext()) {
			XSSFRow row = (XSSFRow) rows.next();
			noRows++;
		}
		System.out.println("Number of columns " + noRows);
		Set<Plant> plantsSet = new HashSet<Plant>();
		int count = 0;
		for (int i = 1; i <= noRows; i++) {
			count++;
			if (sheet1.getRow(i) != null) {
				String plantName = sheet1.getRow(i).getCell(0).getStringCellValue();
				Plant p = new Plant();
				p.setPlant_Name(plantName);
				p.setFamily_Id(1);
				p.setSpecies_Id(1);
				p.setTreatment_Id(1);
				p.setGenotype_Id(1);
				plantsSet.add(p);
				System.out.println("plantName " + plantName);
			}
		}
		return plantsSet;
	}
}
