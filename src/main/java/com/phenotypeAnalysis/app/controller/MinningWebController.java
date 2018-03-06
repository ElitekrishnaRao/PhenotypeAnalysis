package com.phenotypeAnalysis.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.phenotypeAnalysis.app.dao.Genotype;
import com.phenotypeAnalysis.app.dao.Image;
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
		List<Plant_Species> plantspeciesData = databaseQueryingService.getPlantSpeciesData();
		map.put("plantspeciesData",plantspeciesData);
		List<Plant> plantData = databaseQueryingService.getPlantData();
		map.put("plantData",plantData);
		List<Treatment> treatmentData = databaseQueryingService.getTreatmentData();
		map.put("treatmentData",treatmentData);
		List<Phenotype> phenotypeData = databaseQueryingService.getPhenotypeData();
		map.put("phenotypeData",phenotypeData);
		List<Image> imageData = databaseQueryingService.getImageData();
		map.put("imageData",imageData);
		List<Genotype> genotypeData = databaseQueryingService.getGenotypeData();
		map.put("genotypeData",genotypeData);
		return new ModelAndView("DatabaseQuerying");
	}
	
	@RequestMapping("/plantsbyspecies/{id}")
	@ResponseBody
	@JsonIgnore
	public String plantsListBySpeciesId(@PathVariable("id") int id) throws JsonProcessingException { 
		ObjectMapper objectMapper = new ObjectMapper();
    	//Set pretty printing of json
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    	
		List<Plant> plantData = databaseQueryingService.getPlantDataBySpecies(id);
		/* for(Plant p : plantData) {
			System.out.println(p.getPlant_Id());
		}*/
		String arrayToJson = objectMapper.writeValueAsString(plantData);
		return arrayToJson.toString();
	}
	
	@RequestMapping("/plantsbysptrtmnts/{id}/{treatmentIds}")
	@ResponseBody
	@JsonIgnore
	public String plantsListBySpTrtmntIds(@PathVariable("id") int id,@PathVariable("treatmentIds") List<Integer> treatmentIds) throws JsonProcessingException { 
		ObjectMapper objectMapper = new ObjectMapper();
    	//Set pretty printing of json
    	objectMapper.enable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS );
    	
		List<Plant> plantsListBySpTrtmnt = databaseQueryingService.getPlantDataBySpTrtmnts(id, treatmentIds);
		/* for(Plant p : plantData) {
			System.out.println(p.getPlant_Id());
		}*/
		String arrayToJson = objectMapper.writeValueAsString(plantsListBySpTrtmnt);
		return arrayToJson.toString();
	}
	
	@RequestMapping("/treatmentsbyspecies/{id}")
	@ResponseBody
	@JsonIgnore
	public String treatmentsListBySpeciesId(@PathVariable("id") int id) throws JsonProcessingException { 
		ObjectMapper objectMapper = new ObjectMapper();
    	//Set pretty printing of json
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		List<Treatment> treatmentData = databaseQueryingService.getTreatmentDataBySpecies(id);
		String arrayToJson = objectMapper.writeValueAsString(treatmentData);
		return arrayToJson.toString();
	}
	
	@RequestMapping("/phenotypesbyspplnts/{id}/{plantIds}")
	@ResponseBody
	@JsonIgnore
	public String phenotypesListBySpPlntsIds(@PathVariable("id") int id,@PathVariable("plantIds") List<Integer> plantIds) throws JsonProcessingException { 
		//System.out.println(plantIds);
		ObjectMapper objectMapper = new ObjectMapper();
    	//Set pretty printing of json
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		List<Phenotype> phenotypeData = databaseQueryingService.getphenotypesListBySpPlntsIds(id, plantIds);
		String arrayToJson = objectMapper.writeValueAsString(phenotypeData);
		return arrayToJson.toString();
	}
	
	@RequestMapping("/phenmeansbyspplnts/{id}/{plantIds}")
	@ResponseBody
	@JsonIgnore
	public String phenMeansBySpPlntsIds(@PathVariable("id") int id,@PathVariable("plantIds") List<Integer> plantIds) throws JsonProcessingException { 
		ObjectMapper objectMapper = new ObjectMapper();
    	//Set pretty printing of json
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		List<Phenotype> phenotypeMeanData = databaseQueryingService.getphenMeansBySpPlntsId(id, plantIds);
		String arrayToJson = objectMapper.writeValueAsString(phenotypeMeanData);
		return arrayToJson.toString();
	}
	
	@RequestMapping("/stats")
	public ModelAndView despStatsVisuals(ModelMap map) { 
		List<Plant_Species> plantspeciesData = databaseQueryingService.getPlantSpeciesData();
		map.put("plantspeciesData",plantspeciesData);
		List<Plant> plantData = databaseQueryingService.getPlantData();
		map.put("plantData",plantData);
		List<Treatment> treatmentData = databaseQueryingService.getTreatmentData();
		map.put("treatmentData",treatmentData);
		List<Phenotype> phenotypeData = databaseQueryingService.getPhenotypeData();
		map.put("phenotypeData",phenotypeData);
		List<Image> imageData = databaseQueryingService.getImageData();
		map.put("imageData",imageData);
		List<Genotype> genotypeData = databaseQueryingService.getGenotypeData();
		map.put("genotypeData",genotypeData);
		return new ModelAndView("DespStatsVisuals");
	}
	
	
	
	@RequestMapping("/mining")
	public ModelAndView  dBQueryResults(ModelMap map) { 
		return new ModelAndView("DataMining");
	}
	
	@RequestMapping("/populteDb")
	public String populateDb(ModelMap map) { 
		populateService.populatePlantData();
		return "Home";
	}
}
