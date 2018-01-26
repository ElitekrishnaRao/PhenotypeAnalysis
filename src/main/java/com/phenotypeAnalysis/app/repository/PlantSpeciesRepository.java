package com.phenotypeAnalysis.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phenotypeAnalysis.app.dao.Plant_Species;

@Repository
public interface PlantSpeciesRepository extends JpaRepository<Plant_Species, Integer> {

}
