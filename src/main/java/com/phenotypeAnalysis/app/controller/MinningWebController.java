package com.phenotypeAnalysis.app.controller;

import java.util.logging.Logger;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web")
public class MinningWebController {
	private static final Logger LOGGER = Logger.getLogger(MinningWebController.class.getName());

	@RequestMapping("/home")
	public String welcome(ModelMap map) { 
		
		return "Home";
	}
	
}
