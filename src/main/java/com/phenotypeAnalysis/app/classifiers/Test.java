package com.phenotypeAnalysis.app.classifiers;

import java.util.Random;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

/**
 * A test case created by WEKA's documentation
 */
public class Test {
	private Instances instances;
    private Instances trainSet;
    private Instances testSet;
    public Test(Instances trainSet) {
        this.trainSet = trainSet;
    }
    public Test(Instances trainSet, Instances testSet) {
        this.trainSet = trainSet;
        this.testSet = testSet;
    }

    public void testModel(Classifier model) {
        Evaluation eTest = null;
        try {
            eTest = new Evaluation(trainSet); // training set
            eTest.evaluateModel(model, testSet); // testing set
            // Output statistics
            System.out.println(eTest.toSummaryString());
            System.out.println(eTest.toMatrixString());
            // Get the confusion matrix ??
            //double[][] cmMatrix = eTest.confusionMatrix();
            //System.out.println(cmMatrix);
            // Another test case, where we adapt one instance to the training set
            //Instance iUse = new DenseInstance(trainSet.numAttributes());
            // Specify that the instance belong to the training set
            // in order to inherit from the set description
            //iUse.setDataset(trainSet);
            // Get the likelihood of each classes
            // fDistribution[0] is the probability of being “positive”
            // fDistribution[1] is the probability of being “negative”
            //double[] fDistribution = model.distributionForInstance(iUse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void testModelTrain(Classifier model) {
        Evaluation eval = null;
        try {
        	eval = new Evaluation(trainSet);
            eval.crossValidateModel(model, trainSet, 10, new Random(1));
    	    System.out.println("Estimated Accuracy:"+Double.toString(eval.pctCorrect()));
    		System.out.println(model);
            // Output statistics
            System.out.println(eval.toSummaryString());
            System.out.println(eval.toMatrixString());
            // Another test case, where we adapt one instance to the training set
            Instance iUse = new DenseInstance(trainSet.numAttributes());
            // Specify that the instance belong to the training set
            // in order to inherit from the set description
            //iUse.setDataset(trainSet);
            // Get the likelihood of each classes
            // fDistribution[0] is the probability of being “positive”
            // fDistribution[1] is the probability of being “negative”
            //double[] fDistribution = model.distributionForInstance(iUse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//    public void testClusterModel(Classifier model) {
//        Evaluation eTest = null;
//        try {
//            eTest = new Evaluation(trainSet); // training set
//            eTest.evaluateModel(model, testSet); // testing set
//
//            // Output statistics
//            System.out.println(eTest.toSummaryString());
//
//            // Get the confusion matrix ??
//            double[][] cmMatrix = eTest.confusionMatrix();
//            System.out.println(cmMatrix);
//            // Another test case, where we adapt one instance to the training set
//            Instance iUse = new DenseInstance(trainSet.numAttributes());
//
//            // Specify that the instance belong to the training set
//            // in order to inherit from the set description
//            iUse.setDataset(trainSet);
//
//            // Get the likelihood of each classes
//            // fDistribution[0] is the probability of being “positive”
//            // fDistribution[1] is the probability of being “negative”
//            double[] fDistribution = model.distributionForInstance(iUse);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
}
