package com.phenotypeAnalysis.app.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/web")
public class MinningWebController {
	private static final Logger LOGGER = Logger.getLogger(MinningWebController.class.getName());

	@RequestMapping("/home")
	public ModelAndView  welcome(ModelMap map) { 
		return new ModelAndView("Home");
	}
	
	@RequestMapping("/query")
	public ModelAndView  databaseQuerying(ModelMap map) { 
		return new ModelAndView("DatabaseQuerying");
	}
	
	@RequestMapping("/results")
	public ModelAndView  dBQueryResults(ModelMap map) { 
		return new ModelAndView("DBQueryResults");
	}
	
}
