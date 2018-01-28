package com.phenotypeAnalysis.app.service;

import java.util.List;

import com.phenotypeAnalysis.app.dao.Genotype;
import com.phenotypeAnalysis.app.dao.Images;
import com.phenotypeAnalysis.app.dao.Phenotype;
import com.phenotypeAnalysis.app.dao.Plant;
import com.phenotypeAnalysis.app.dao.Plant_Species;
import com.phenotypeAnalysis.app.dao.Treatment;

public interface DatabaseQueryingService {
	public List<Plant> getPlantData();
	public List<Plant_Species> getPlantSpeciesData();
	public List<Treatment> getTreatmentData();
	public List<Phenotype> getPhenotypeData();
	public List<Images> getImageData();
	public List<Genotype> getGenotypeData();
}
