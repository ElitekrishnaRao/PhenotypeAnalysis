package com.phenotypeAnalysis.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.phenotypeAnalysis.app.dao.Image;
import com.phenotypeAnalysis.app.dao.Phenotype;
import com.phenotypeAnalysis.app.dao.Plant;
import com.phenotypeAnalysis.app.dao.Treatment;
import com.phenotypeAnalysis.app.service.DatabaseQueryingService;

public class ReadPlant {

	public static Set<Plant> readPlantData() throws IOException {
		File src = new File("C:\\Users\\SIDDU\\Desktop\\LEMNATEC_RAE_WHEAT Phenotyping Results.xlsx");
		HSSFWorkbook workbook = new HSSFWorkbook();
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		XSSFRow row1 = sheet1.getRow(3);
		System.out.println(row1);
		Iterator rows = sheet1.rowIterator();
		int noRows = 0;
		while (rows.hasNext()) {
			XSSFRow row = (XSSFRow) rows.next();
			noRows++;
		}
		Set<Plant> plantsSet = new HashSet<Plant>();
		int count = 0;
//		DatabaseQueryingService treatmentDb = null;
//		List<Treatment> t1= treatmentDb.getTreatmentData();
//		if(t1.iterator().hasNext())
//		{
//			System.out.println(t1);
//		}
		
		for (int i = 1; i <= noRows; i++) {
			count++;
			if (sheet1.getRow(i) != null) {
				String plantName = sheet1.getRow(i).getCell(0).getStringCellValue();
				int genotypeId = (int) sheet1.getRow(i).getCell(2).getNumericCellValue();
				int treatmentId = (int) sheet1.getRow(i).getCell(4).getNumericCellValue();
				//setting plant
				Plant plant = new Plant();
				plant.setName(plantName);
				plant.setSpeciesId(1);
				
//				Treatment t = new Treatment();
//				System.out.println(t.getId()+"-----"+treatmentId);
//				if(t.getId() == treatmentId)
//			    plant.setTreatment(t);
				plant.setTreatmentId(treatmentId);
				plant.setGenotypeId(genotypeId);
				
				//Setting images
				Set<Image> imagesSet = ReadImages.putImageDataByPlant(plant);
				plant.setImagesList(imagesSet);
							
				//Adding plant to list
				plantsSet.add(plant);
				System.out.println("plantName " + plantName); 
				
			}
		}
		return plantsSet;
	}
}
