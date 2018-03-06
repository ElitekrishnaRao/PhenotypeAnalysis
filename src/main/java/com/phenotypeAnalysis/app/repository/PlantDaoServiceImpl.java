package com.phenotypeAnalysis.app.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.phenotypeAnalysis.app.dao.Plant;

@Repository
public class PlantDaoServiceImpl implements PlantDaoService {
	@Autowired
	PlantRepository populateDataPlantRepository;
	private List<Plant> plants;

	@Override
	public List<Plant> getPlantData() {
		// TODO Auto-generated method stub
		return populateDataPlantRepository.findAll();
	}
	
	@Override
	public List<Plant> getPlantDataBySpecies(int speciesId) {
		return populateDataPlantRepository.findById(speciesId);
	}

	@Override
	public List<Plant> getPlantDataBySpTrtmnts(int id, List<Integer> treatmentIds) {
		return populateDataPlantRepository.findBySpTrtmntIds(id, treatmentIds);
	}
}
