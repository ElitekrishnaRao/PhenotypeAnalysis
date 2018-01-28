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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.phenotypeAnalysis.app.dao.Genotype;
import com.phenotypeAnalysis.app.dao.Plant;


// for future use - for testing purpose hardcoding Genotype with "A" and "B" using App.java

public class ReadGenotype {
	public static Set<Genotype> readGenotypeData() throws IOException {
		
		File src= new File("C:\\Users\\SIDDU\\Desktop\\LEMNATEC_RAE_WHEAT Phenotyping Results.xlsx");
		HSSFWorkbook workbook = new HSSFWorkbook();
		FileInputStream fis= new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet1=wb.getSheetAt(0);
		Iterator rows=sheet1.rowIterator();
		int noRows = 0;
		int noColumns = sheet1.getRow(0).getPhysicalNumberOfCells();
		Set<Genotype> genotypeSet = new HashSet<Genotype>();
		while( rows.hasNext() ) {
            XSSFRow row = (XSSFRow) rows.next();
            noRows++;                
        }
		
		System.out.println("Number of columns "+noRows);
		Set<Genotype> s = new HashSet<Genotype>();
		int count =0;
		for(int i=1; i<=noRows; i++)
		{
			count++;
			//for(int j=0; j<=noColumns;j++)
			//{
				if(sheet1.getRow(i)!=null){
				String plantName=sheet1.getRow(i).getCell(0).getStringCellValue();
				Genotype g = new Genotype();
				g.setGenotype("A");
				genotypeSet.add(g);
				}
			//}
		}
		Iterator it = s.iterator();
		int count1=0;
		Configuration con= new Configuration().configure().addAnnotatedClass(Plant.class);
        SessionFactory sf= con.buildSessionFactory();
        Session s1= sf.openSession();
        
        Transaction tx = s1.beginTransaction();
		while(it.hasNext())
		{
			count1++;
			Plant p  = (Plant)it.next();
	        s1.saveOrUpdate(p);
		}
		tx.commit();
		
		return genotypeSet;
	}
}
