package com.phenotypeAnalysis.app.classifiers;

import java.util.Random;

import weka.classifiers.Classifier;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.functions.SMO;
import weka.classifiers.functions.supportVector.PolyKernel;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.J48;
import weka.clusterers.EM;
import weka.clusterers.FilteredClusterer;
import weka.core.Instances;
import weka.core.pmml.jaxbbindings.Cluster;
import weka.filters.unsupervised.attribute.Remove;

public class Train {
	private Instances instances;

	public Train(Instances instances) {
		this.instances = instances;
	}

	
	 // Weka implementation of C4.5
	public Classifier getJ48Model() throws Exception {
		Classifier model = new J48();
		model.buildClassifier(instances);
		System.out.println(model);
		return model;
	}

	public Classifier getJ48Model(FilteredClassifier fc) throws Exception {
		Classifier model = new J48();
		fc.buildClassifier(instances);
		System.out.println(fc);
		return model;
	}
	public Classifier getSVMModel(FilteredClassifier fc) throws Exception {
		Classifier model = new SMO();
		((PolyKernel) ((SMO) model).getKernel()).setExponent(2);
		fc.buildClassifier(instances);
		System.out.println(fc);
		return model;
	}
	public Classifier getNaiveBayes() throws Exception {
		Classifier model = new NaiveBayes();
		model.buildClassifier(instances);
		System.out.println(model);
		return model;
	}
	public Classifier getNaiveBayes(FilteredClassifier fc) throws Exception {
		Classifier model = new NaiveBayes();
		fc.buildClassifier(instances);
		System.out.println(fc);
		return model;
	}

	public EM getCluster(FilteredClusterer fc) throws Exception {
		String[] options = new String[2];
		options[0] = "-I"; // max. iterations
		options[1] = "100";
		EM clusterer = new EM();
		clusterer.setOptions(options);
		fc.buildClusterer(instances);
		System.out.println(fc);
		return clusterer;
	}

}
