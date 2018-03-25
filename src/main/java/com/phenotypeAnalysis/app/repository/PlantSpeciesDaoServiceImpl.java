package com.phenotypeAnalysis.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.phenotypeAnalysis.app.dao.Species;

@Repository
public class PlantSpeciesDaoServiceImpl implements PlantSpeciesDaoService{
	@Autowired
	PlantSpeciesRepository populateDataPlantSpeciesRepository;

	@Override
	public List<Species> getPlantSpeciesData() {
		// TODO Auto-generated method stub
		return populateDataPlantSpeciesRepository.findAll();
	}
	
	
}
