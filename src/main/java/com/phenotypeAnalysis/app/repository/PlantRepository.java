package com.phenotypeAnalysis.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.phenotypeAnalysis.app.dao.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer>{
	
	@Query("SELECT p FROM Plant p WHERE p.speciesId = :speciesId")
    public List<Plant> findById(@Param("speciesId") int speciesId);
	
	//@Query("SELECT p FROM Plant p inner join p.treatment  WHERE p.speciesId =:speciesId AND p.treatment in :treatmentIds")
	@Query("SELECT p FROM Plant p WHERE p.speciesId =:speciesId AND p.treatmentId in :treatmentIds")
	public List<Plant> findBySpTrtmntIds(@Param("speciesId") int speciesId, @Param("treatmentIds") List<Integer> treatmentIds);
	
}
