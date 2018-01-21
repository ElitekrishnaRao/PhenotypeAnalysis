package com.phenotypeAnalysis.app.repository;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phenotypeAnalysis.app.dao.Plant;

@Repository
public class PopulateDaoServiceImpl implements PopulateDaoService {
	
	@Autowired
	PlantRepository populateDataPlantRepository;

	@Override
	public void populatePlantData(Set<Plant> plantSet) {
		for (Plant plant : plantSet) {
			populateDataPlantRepository.save(plant);
		}
	}

}
