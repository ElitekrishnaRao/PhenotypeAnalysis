package com.phenotypeAnalysis.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
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
		//return new ModelAndView("DatabaseQuerying");
		
		List<Plant_Species> plantspeciesData = databaseQueryingService.getPlantSpeciesData();
		map.put("plantspeciesData",plantspeciesData);
		//return new ModelAndView("DatabaseQuerying");
		
		List<Treatment> treatmentData = databaseQueryingService.getTreatmentData();
		map.put("treatmentData",treatmentData);
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
	
	/* @RequestMapping("/query1")
	public String  databaseQuerying1(ModelMap map) { 
		//List<Plant> plantData = databaseQueryingService.getPlantData();
		List<Integer> plantdata = new ArrayList<Integer>();
		plantdata.add(1);
		plantdata.add(2);
		plantdata.add(3);
		String json = new Gson().toJson(plantdata);
		return json;
	}*/
	
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
