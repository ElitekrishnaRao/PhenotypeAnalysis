package com.phenotypeAnalysis.app.repository;

import java.util.List;

import com.phenotypeAnalysis.app.dao.Plant;

public interface PlantDaoService {

	public List<Plant> getPlantData();

	//public List<Plant> findAllBySpeciesId(String speciesId);
	
	public List<Plant> getPlantDataBySpecies(int speciesId);

	public List<Plant> getPlantDataBySpTrtmnts(int id, List<Integer> treatmentIds);
}
