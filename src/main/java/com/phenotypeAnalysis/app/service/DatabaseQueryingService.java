package com.phenotypeAnalysis.app.service;

import java.util.List;

import com.phenotypeAnalysis.app.dao.Plant;

public interface DatabaseQueryingService {
	public List<Plant> getPlantData();
}
