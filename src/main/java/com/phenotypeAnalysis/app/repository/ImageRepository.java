package com.phenotypeAnalysis.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phenotypeAnalysis.app.dao.Images;

public interface ImageRepository extends JpaRepository<Images, Integer>{

}
