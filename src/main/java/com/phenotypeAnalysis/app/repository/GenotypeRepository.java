package com.phenotypeAnalysis.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phenotypeAnalysis.app.dao.Genotype;

public interface GenotypeRepository extends JpaRepository<Genotype, Integer>{

}
