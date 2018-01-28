package com.phenotypeAnalysis.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.phenotypeAnalysis.app.dao.Genotype;

@Repository
public class GenotypeDaoServiceImpl implements GenotypeDaoService{
	@Autowired
	GenotypeRepository populateDataGenotypeRepository;

	@Override
	public List<Genotype> getGenotypeData() {
		// TODO Auto-generated method stub
		return populateDataGenotypeRepository.findAll();
	}
}
