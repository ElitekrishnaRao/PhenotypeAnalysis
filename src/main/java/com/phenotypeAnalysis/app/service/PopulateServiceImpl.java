package com.phenotypeAnalysis.app.service;

import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phenotypeAnalysis.app.dao.Plant;
import com.phenotypeAnalysis.app.repository.PopulateDaoService;
import com.phenotypeAnalysis.app.util.ReadPlant;

@Service
public class PopulateServiceImpl implements PopulateService{

	@Autowired
	PopulateDaoService populateDaoService;
	
	@Override
	public void populatePlantData() {
		// TODO Auto-generated method stub
		try {
			Set<Plant> plantSet = ReadPlant.readPlantData();
			populateDaoService.populatePlantData(plantSet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
