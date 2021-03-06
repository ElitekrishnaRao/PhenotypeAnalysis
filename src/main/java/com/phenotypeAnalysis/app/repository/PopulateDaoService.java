package com.phenotypeAnalysis.app.repository;

import java.util.Set;

import com.phenotypeAnalysis.app.dao.Genotype;
import com.phenotypeAnalysis.app.dao.Image;
import com.phenotypeAnalysis.app.dao.Phenotype;
import com.phenotypeAnalysis.app.dao.Plant;
import com.phenotypeAnalysis.app.dao.Species;
import com.phenotypeAnalysis.app.dao.Treatment;

public interface PopulateDaoService {
  public void populatePlantData(Set<Plant> plantSet);
  public void populatePlantSpeciesData(Set<Species> plantspeciesSet);
  public void populateTreatmentData(Set<Treatment> treatmentSet);
  public void populatePhenotypeData(Set<Phenotype> phenotypeSet);
  public void populateImageData(Set<Image> imageSet);
  public void populateGenotypeData(Set<Genotype> genotypeSet);
}
