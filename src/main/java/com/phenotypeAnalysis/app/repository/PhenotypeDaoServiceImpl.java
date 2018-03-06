package com.phenotypeAnalysis.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.phenotypeAnalysis.app.dao.Phenotype;

@Repository
public class PhenotypeDaoServiceImpl implements PhenotypeDaoService{
	
	@Autowired
	PhenotypeRepository populateDataPhenotypeRepository;

	@Override
	public List<Phenotype> getPhenotypeData() {
		// TODO Auto-generated method stub
		return populateDataPhenotypeRepository.findAll();
	}

	@Override
	public List<Phenotype> getPhenotypeDataBySpPlnts(int id, List<Integer> plantIds) {
		// TODO Auto-generated method stub
		return populateDataPhenotypeRepository.findBySpPlntsIds(id, plantIds);
	}

	@Override
	public List<Phenotype> getphenMeansBySpPlntsId(int id, List<Integer> plantIds) {
		// TODO Auto-generated method stub
		return populateDataPhenotypeRepository.findphenMeansBySpPlntsId(id, plantIds);
	}
}
