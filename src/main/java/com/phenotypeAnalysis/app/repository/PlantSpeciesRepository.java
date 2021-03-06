package com.phenotypeAnalysis.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.phenotypeAnalysis.app.dao.Species;

@Repository
public interface PlantSpeciesRepository extends JpaRepository<Species, Integer> {

}
