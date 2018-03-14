package com.phenotypeAnalysis.app.classifiers;

import weka.classifiers.Classifier;
import weka.classifiers.trees.J48;
import weka.core.Instances;

public class Train {
	private Instances instances;

    public Train(Instances instances) {
        this.instances = instances;
    }

    /**
     * Weka implementation of C4.5
     */
    public Classifier getJ48Model() throws Exception {
        Classifier model = new J48();
        model.buildClassifier(instances);

        return model;
    }
}
