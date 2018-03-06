package com.phenotypeAnalysis.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.phenotypeAnalysis.app.dao.Treatment;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Integer>{
	@Query("SELECT t FROM Treatment t WHERE t.id in (select distinct treatmentId from Plant p where p.speciesId=:speciesId)")
	//@Query("SELECT t FROM Treatment t WHERE t in (select distinct treatment from Plant p where p.speciesId=:speciesId)")
    public List<Treatment> findById(@Param("speciesId") int speciesId);
}


