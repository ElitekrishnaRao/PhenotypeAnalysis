package com.phenotypeAnalysis.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phenotypeAnalysis.app.dao.Genotype;
import com.phenotypeAnalysis.app.dao.Images;
import com.phenotypeAnalysis.app.dao.Phenotype;
import com.phenotypeAnalysis.app.dao.Plant;
import com.phenotypeAnalysis.app.dao.Plant_Species;
import com.phenotypeAnalysis.app.dao.Treatment;
import com.phenotypeAnalysis.app.repository.GenotypeDaoService;
import com.phenotypeAnalysis.app.repository.ImageDaoService;
import com.phenotypeAnalysis.app.repository.PhenotypeDaoService;
import com.phenotypeAnalysis.app.repository.PlantDaoService;
import com.phenotypeAnalysis.app.repository.PlantSpeciesDaoService;
import com.phenotypeAnalysis.app.repository.TreatmentDaoService;
@Service
public class DatabaseQueryingServiceImpl implements DatabaseQueryingService {
	@Autowired
	PlantDaoService  plantDaoService;
	@Autowired
	PlantSpeciesDaoService  plantspeciesDaoService;
	@Autowired
	TreatmentDaoService  treatmentDaoService;
	@Autowired
	PhenotypeDaoService  phenotypeDaoService;
	@Autowired
	ImageDaoService  imageDaoService;
	@Autowired
	GenotypeDaoService  genotypeDaoService;
	
	@Override
	public List<Plant> getPlantData() {
		return plantDaoService.getPlantData();
	}
	@Override
	public List<Plant_Species> getPlantSpeciesData() {
		return plantspeciesDaoService.getPlantSpeciesData();
	}
	@Override
	public List<Treatment> getTreatmentData() {
		return treatmentDaoService.getTreatmentData();
	}
	@Override
	public List<Phenotype> getPhenotypeData() {
		return phenotypeDaoService.getPhenotypeData();
	}
	@Override
	public List<Images> getImageData() {
		return imageDaoService.getImageData();
	}
	@Override
	public List<Genotype> getGenotypeData() {
		return genotypeDaoService.getGenotypeData();
	}

}
