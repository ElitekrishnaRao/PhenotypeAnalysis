package com.phenotypeAnalysis.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phenotypeAnalysis.app.dao.Image;

public interface ImageRepository extends JpaRepository<Image, Integer>{

}
