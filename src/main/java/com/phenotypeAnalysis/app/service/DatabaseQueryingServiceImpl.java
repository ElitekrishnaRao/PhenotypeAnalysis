package com.phenotypeAnalysis.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phenotypeAnalysis.app.dao.Plant;
import com.phenotypeAnalysis.app.repository.PlantDaoService;
@Service
public class DatabaseQueryingServiceImpl implements DatabaseQueryingService {
	@Autowired
	PlantDaoService  plantDaoService;
	@Override
	public List<Plant> getPlantData() {
		return plantDaoService.getPlantData();
	}

}
