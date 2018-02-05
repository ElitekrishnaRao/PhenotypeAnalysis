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

import com.phenotypeAnalysis.app.dao.Images;
import com.phenotypeAnalysis.app.dao.Phenotype;
import com.phenotypeAnalysis.app.dao.Plant;

public class ReadPlant {

	public static Set<Plant> readPlantData() throws IOException {
		File src = new File("C:\\Users\\SIDDU\\Desktop\\LEMNATEC_RAE_WHEAT Phenotyping Results.xlsx");
		HSSFWorkbook workbook = new HSSFWorkbook();
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
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
		for (int i = 1; i <= 4; i++) {
			count++;
			if (sheet1.getRow(i) != null) {
				String plantName = sheet1.getRow(i).getCell(0).getStringCellValue();
				int genotypeId = (int) sheet1.getRow(i).getCell(2).getNumericCellValue();
				int treatmentId = (int) sheet1.getRow(i).getCell(4).getNumericCellValue();
				//setting plant
				Plant plant = new Plant();
				plant.setPlant_Name(plantName);
				plant.setSpecies_Id(1);
				plant.setTreatment_Id(treatmentId);
				plant.setGenotype_Id(genotypeId);
				
				//Setting images
				Set<Images> imagesList = new HashSet<Images>();
				Images I=new Images();
				I.setView(0);
				I.setImage_Modality("RGB");
				I.setPlant(plant);
				
				//setting phenomtype
				Set<Phenotype> phenotypesSet =  new HashSet<Phenotype>();
				Phenotype ph=new Phenotype();
				ph.setView(0);
				ph.setEnclosing_Circle_Diameter("0.5");
				ph.setBounding_Box_Ht("20");
				ph.setAspect_Ratio("10");
				ph.setImages(I);
				phenotypesSet.add(ph);
				
				//Adding phenomtype to image
				I.setPhenotypes(phenotypesSet);
				imagesList.add(I);
				
				//Adding images to plan
				plant.setImagesList(imagesList);
				
				//Adding plant to list
				plantsSet.add(plant);
				System.out.println("plantName " + plantName);
			}
		}
		return plantsSet;
	}
}
