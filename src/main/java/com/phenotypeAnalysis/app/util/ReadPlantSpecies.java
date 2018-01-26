package com.phenotypeAnalysis.app.util;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.phenotypeAnalysis.app.dao.Plant;
import com.phenotypeAnalysis.app.dao.Plant_Species;

public class ReadPlantSpecies {
	public static Set<Plant_Species> readPlantSpeciesData() throws IOException {
		Set<Plant_Species> plantspeciesSet = new HashSet<Plant_Species>();
		
		return plantspeciesSet;
	}
}
