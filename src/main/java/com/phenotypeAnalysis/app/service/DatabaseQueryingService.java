package com.phenotypeAnalysis.app.service;

import java.util.List;

import com.phenotypeAnalysis.app.dao.Plant;
import com.phenotypeAnalysis.app.dao.Plant_Species;
import com.phenotypeAnalysis.app.dao.Treatment;

public interface DatabaseQueryingService {
	public List<Plant> getPlantData();
	public List<Plant_Species> getPlantSpeciesData();
	public List<Treatment> getTreatmentData();
}
