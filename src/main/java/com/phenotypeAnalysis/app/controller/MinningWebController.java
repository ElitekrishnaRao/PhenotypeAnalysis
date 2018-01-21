package com.phenotypeAnalysis.app.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phenotypeAnalysis.app.dao.Plant;
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
		return new ModelAndView("DatabaseQuerying");
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
