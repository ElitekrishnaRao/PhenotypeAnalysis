package com.phenotypeAnalysis.app.repository;

import java.util.Set;

import com.phenotypeAnalysis.app.dao.Plant;

public interface PopulateDaoService {
  public void populatePlantData(Set<Plant> plantSet);
}
