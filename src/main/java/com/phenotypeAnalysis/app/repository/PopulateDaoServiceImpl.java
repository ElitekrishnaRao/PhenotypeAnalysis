package com.phenotypeAnalysis.app.repository;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phenotypeAnalysis.app.dao.Plant;
import com.phenotypeAnalysis.app.dao.Genotype;
import com.phenotypeAnalysis.app.dao.Image;
import com.phenotypeAnalysis.app.dao.Phenotype;
import com.phenotypeAnalysis.app.dao.Species;
import com.phenotypeAnalysis.app.dao.Treatment;

@Repository
public class PopulateDaoServiceImpl implements PopulateDaoService {
	
	@Autowired
	PlantRepository populateDataPlantRepository;
	@Autowired
	PlantSpeciesRepository populateDataPlantSpeciesRepository;
	@Autowired
	TreatmentRepository populateDataTreatmentRepository;
	@Autowired
	PhenotypeRepository populateDataPhenotypeRepository;
	@Autowired
	ImageRepository populateDataImageRepository;
	@Autowired
	GenotypeRepository populateDataGenotypeRepository;

	@Override
	public void populatePlantData(Set<Plant> plantSet) {
		for (Plant plant : plantSet) {
			populateDataPlantRepository.save(plant);
		}
	}
	@Override
	public void populatePlantSpeciesData(Set<Species> plantspeciesSet) {
		for (Species plantspecies : plantspeciesSet) {
			populateDataPlantSpeciesRepository.save(plantspecies);
		}
	}
	@Override
	public void populateTreatmentData(Set<Treatment> treatmentSet) {
		for (Treatment treatment : treatmentSet) {
			populateDataTreatmentRepository.save(treatment);
		}
	}
	@Override
	public void populatePhenotypeData(Set<Phenotype> phenotypeSet) {
		for (Phenotype phenotype : phenotypeSet) {
			populateDataPhenotypeRepository.save(phenotype);
		}
	}
	@Override
	public void populateImageData(Set<Image> imageSet) {
		for (Image image : imageSet) {
			populateDataImageRepository.save(image);
		}
	}
	@Override
	public void populateGenotypeData(Set<Genotype> genotypeSet) {
		for (Genotype genotype : genotypeSet) {
			populateDataGenotypeRepository.save(genotype);
		}
	}

}
