package com.phenotypeAnalysis.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phenotypeAnalysis.app.dao.Genotype;
import com.phenotypeAnalysis.app.dao.Images;
import com.phenotypeAnalysis.app.dao.Phenotype;
import com.phenotypeAnalysis.app.dao.Plant;
import com.phenotypeAnalysis.app.dao.Plant_Species;
import com.phenotypeAnalysis.app.dao.Treatment;
import com.phenotypeAnalysis.app.service.DatabaseQueryingService;
import com.phenotypeAnalysis.app.service.PopulateService;

@Controller
@RequestMapping("/web")
public class MinningWebController {
	private static final Logger LOGGER = Logger.getLogger(MinningWebController.class.getName());
	
	@Autowired
	PopulateService populateService;
	@Autowired
	DatabaseQueryingService databaseQueryingService;

	@RequestMapping("/home")
	public ModelAndView  welcome(ModelMap map) { 
		return new ModelAndView("Home");
	}
	
	@RequestMapping("/query")
	public ModelAndView  databaseQuerying(ModelMap map) { 
		
		List<Plant> plantData = databaseQueryingService.getPlantData();
		map.put("plantData",plantData);
		
		List<Plant_Species> plantspeciesData = databaseQueryingService.getPlantSpeciesData();
		map.put("plantspeciesData",plantspeciesData);
		
		List<Treatment> treatmentData = databaseQueryingService.getTreatmentData();
		map.put("treatmentData",treatmentData);
		
		List<Phenotype> phenotypeData = databaseQueryingService.getPhenotypeData();
		map.put("phenotypeData",phenotypeData);
		
		List<Images> imageData = databaseQueryingService.getImageData();
		map.put("imageData",imageData);
		
		List<Genotype> genotypeData = databaseQueryingService.getGenotypeData();
		map.put("genotypeData",genotypeData);
		return new ModelAndView("DatabaseQuerying");
	}
	
	@RequestMapping("/stats")
	public ModelAndView despStatsVisuals(ModelMap map) { 
		
		return new ModelAndView("DespStatsVisuals");
	}
	
	@RequestMapping("/mine")
	public ModelAndView dataMining(ModelMap map) { 
		return new ModelAndView("DataMining");
	}
	
	@RequestMapping("/results")
	public ModelAndView  dBQueryResults(ModelMap map) { 
		return new ModelAndView("DBQueryResults");
	}
	
	@RequestMapping("/populteDb")
	public String populateDb(ModelMap map) { 
		populateService.populatePlantData();
		return "Home";
	}
}
