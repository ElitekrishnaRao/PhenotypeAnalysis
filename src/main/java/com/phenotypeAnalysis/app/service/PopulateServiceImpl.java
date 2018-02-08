package com.phenotypeAnalysis.app.service;

import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phenotypeAnalysis.app.dao.Genotype;
import com.phenotypeAnalysis.app.dao.Images;
import com.phenotypeAnalysis.app.dao.Phenotype;
import com.phenotypeAnalysis.app.dao.Plant;
import com.phenotypeAnalysis.app.dao.Plant_Species;
import com.phenotypeAnalysis.app.dao.Treatment;
import com.phenotypeAnalysis.app.repository.PopulateDaoService;
import com.phenotypeAnalysis.app.util.ReadPhenotype;
import com.phenotypeAnalysis.app.util.ReadPlant;
import com.phenotypeAnalysis.app.util.ReadPlantSpecies;
import com.phenotypeAnalysis.app.util.ReadTreatment;
import com.phenotypeAnalysis.app.util.ReadGenotype;
import com.phenotypeAnalysis.app.util.ReadImages;

@Service
public class PopulateServiceImpl implements PopulateService{

	@Autowired
	PopulateDaoService populateDaoService;
	
	@Override
	public void populatePlantData() {
		// TODO Auto-generated method stub
		try {
			Set<Plant> plantSet = ReadPlant.readPlantData();
			populateDaoService.populatePlantData(plantSet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void populatePlantSpeciesData() {
		// TODO Auto-generated method stub
		try {
			Set<Plant_Species> plantspeciesSet = ReadPlantSpecies.readPlantSpeciesData();
			populateDaoService.populatePlantSpeciesData(plantspeciesSet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void populateTreatmentData() {
		// TODO Auto-generated method stub
		try {
			Set<Treatment> treatmentSet = ReadTreatment.readTreatmentData();
			populateDaoService.populateTreatmentData(treatmentSet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void populatePhenotypeData() {
		//Set<Phenotype> phenotypeSet = ReadPhenotype.readPhenotypeData();
		populateDaoService.populatePhenotypeData(null);
	}
	
	@Override
	public void populateImageData() {
		//Set<Images> imageSet = ReadImages.readImageData();
		populateDaoService.populateImageData(null);
	}
	
	@Override
	public void populateGenotypeData() {
		// TODO Auto-generated method stub
		try {
			Set<Genotype> genotypeSet = ReadGenotype.readGenotypeData();
			populateDaoService.populateGenotypeData(genotypeSet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
