package com.phenotypeAnalysis.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.phenotypeAnalysis.app.dao.Treatment;

@Repository
public class TreatmentDaoServiceImpl implements TreatmentDaoService {
	@Autowired
	TreatmentRepository populateDataTreatmentRepository;

	@Override
	public List<Treatment> getTreatmentData() {
		// TODO Auto-generated method stub
		return populateDataTreatmentRepository.findAll();
	}
}
