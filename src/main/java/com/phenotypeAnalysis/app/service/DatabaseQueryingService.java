package com.phenotypeAnalysis.app.service;

import java.util.List;

import com.phenotypeAnalysis.app.dao.Genotype;
import com.phenotypeAnalysis.app.dao.Image;
import com.phenotypeAnalysis.app.dao.Phenotype;
import com.phenotypeAnalysis.app.dao.Plant;
import com.phenotypeAnalysis.app.dao.Species;
import com.phenotypeAnalysis.app.dao.Treatment;

public interface DatabaseQueryingService {
	public List<Plant> getPlantData();
	public List<Species> getPlantSpeciesData();
	public List<Treatment> getTreatmentData();
	public List<Phenotype> getPhenotypeData();
	public List<Image> getImageData();
	public List<Genotype> getGenotypeData();
	//public List<Plant> findAllBySpeciesId(int i);
	public List<Plant> getPlantDataBySpecies(int id);
	public List<Treatment> getTreatmentDataBySpecies(int id);
	public List<Phenotype> getphenotypesListBySpPlntsIds(int id, List<Integer> plantIds);
	public List<Plant> getPlantDataBySpTrtmnts(int id, List<Integer> treatmentIds);
	public List<Phenotype> getphenMeansBySpPlntsId(int id, List<Integer> plantIds);
}
