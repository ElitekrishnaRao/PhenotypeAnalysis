package com.phenotypeAnalysis.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.phenotypeAnalysis.app.dao.Images;

@Repository
public class ImageDaoServiceImpl implements ImageDaoService {
	@Autowired
	ImageRepository populateDataImageRepository;

	@Override
	public List<Images> getImageData() {
		// TODO Auto-generated method stub
		return populateDataImageRepository.findAll();
	}
		
	
}
