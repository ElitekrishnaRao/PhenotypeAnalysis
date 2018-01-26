package com.phenotypeAnalysis.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phenotypeAnalysis.app.dao.Treatment;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Integer>{

}


