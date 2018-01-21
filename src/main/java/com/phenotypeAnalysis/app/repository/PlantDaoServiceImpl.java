package com.phenotypeAnalysis.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phenotypeAnalysis.app.dao.Plant;

@Repository
public class PlantDaoServiceImpl implements PlantDaoService {
	@Autowired
	PlantRepository populateDataPlantRepository;

	@Override
	public List<Plant> getPlantData() {
		// TODO Auto-generated method stub
		return populateDataPlantRepository.findAll();
	}

}
