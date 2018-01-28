package com.phenotypeAnalysis.app.repository;

import java.util.List;
import com.phenotypeAnalysis.app.dao.Genotype;

public interface GenotypeDaoService {
	public List<Genotype> getGenotypeData();
}
