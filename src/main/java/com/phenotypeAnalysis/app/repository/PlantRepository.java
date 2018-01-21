package com.phenotypeAnalysis.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phenotypeAnalysis.app.dao.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer>{

}
