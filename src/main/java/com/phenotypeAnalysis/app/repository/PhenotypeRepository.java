package com.phenotypeAnalysis.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phenotypeAnalysis.app.dao.Phenotype;

@Repository
public interface PhenotypeRepository extends JpaRepository<Phenotype, Integer> {

}
