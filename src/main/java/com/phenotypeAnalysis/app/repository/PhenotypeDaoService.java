package com.phenotypeAnalysis.app.repository;

import java.util.List;

import com.phenotypeAnalysis.app.dao.Phenotype;

public interface PhenotypeDaoService {
	
	public List<Phenotype> getPhenotypeData();

	public List<Phenotype> getPhenotypeDataBySpPlnts(int id, List<Integer> plantIds);

	public List<Phenotype> getphenMeansBySpPlntsId(int id, List<Integer> plantIds);
	
}
