package com.phenotypeAnalysis.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.phenotypeAnalysis.app.dao.Phenotype;

@Repository
public interface PhenotypeRepository extends JpaRepository<Phenotype, Integer> {
	@Query("select Ph from Phenotype Ph where image in (select I from Image I where I.plant in (SELECT p FROM Plant p WHERE p.speciesId = :speciesId AND p.id in :plantIds))")
    public List<Phenotype> findBySpPlntsIds(@Param("speciesId") int speciesId, @Param("plantIds") List<Integer> plantIds);
	
	@Query("select Ph.image.plant.id, Ph.image.view, AVG(Ph.convexHullArea) as AvgCHA, AVG(Ph.plantPixelArea) as AvgPPA, round(AVG(Ph.arealDensity),2) as AvgAD, AVG(Ph.boundingBoxHt) as AvgBBH, AVG(Ph.enclosingCircleDiameter) as AvgECD,AVG(Ph.aspectRatio) as AvgAR from Phenotype Ph where image in (select I from Image I where I.plant in (SELECT p FROM Plant p WHERE p.speciesId = :speciesId AND p.id in :plantIds)) GROUP BY Ph.image.plant.id, Ph.image.view ")
    public List<Phenotype> findphenMeansBySpPlntsId(@Param("speciesId") int speciesId, @Param("plantIds") List<Integer> plantIds);
}
