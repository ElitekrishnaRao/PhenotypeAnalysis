package com.phenotypeAnalysis.app.repository;

import java.util.List;

import com.phenotypeAnalysis.app.dao.Treatment;

public interface TreatmentDaoService {
	
	public List<Treatment> getTreatmentData();

	public List<Treatment> getTreatmentDataBySpecies(int speciesId);

}
