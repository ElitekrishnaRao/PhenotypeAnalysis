package com.phenotypeAnalysis.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.phenotypeAnalysis.app.classifiers.Test;
import com.phenotypeAnalysis.app.classifiers.Train;
import weka.classifiers.Classifier;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.SMO;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.filters.unsupervised.attribute.Remove;
import weka.clusterers.EM;
import weka.clusterers.FilteredClusterer;

@Controller
@RequestMapping("/weka")
public class WekaRestController {
	@RequestMapping(value = "/wekaTest", method = RequestMethod.GET)
	public ResponseEntity<List<String>> predictions() throws IOException {
		List<String> acc = null;
		// calculate prediction for rules...
		// add result to list acc
		Instances trainSet = null;
		Instances testSet = null;

		CSVLoader loader = new CSVLoader();

		// loader.setSource(new
		// File("C:\\Users\\SIDDU\\Desktop\\ClassifierTrainData.csv"));
		// System.out.println(loader.getDataSet());
		// trainSet = loader.getDataSet();
		//
		// loader.setSource(new
		// File("C:\\Users\\SIDDU\\Desktop\\ClassifierTestData.csv"));
		// System.out.println(loader.getDataSet());
		// testSet = loader.getDataSet();
		

		 // J48, Naive Bayes with trainset (70%) and testset(30%) separately split 
		 loader.setSource(new
		 File("src/main/webapp/input files/CHA1.csv"));
		 System.out.println(loader.getDataSet());
		 Instances instances = loader.getDataSet();
		 int split = (int) (instances.size() * 0.7);
		 trainSet = new Instances(instances, 0, split);
		 testSet = new Instances(instances, split, instances.size() - split);
		 runJ48ClassifierTrainTest(trainSet, testSet);
		 runClassifierNaiveBayesTrainTest(trainSet,testSet);
		 runClassifierSVM(trainSet,testSet);
		 
		
		// J48, Naive Bayes with cross validation and filter
		 loader.setSource(new
		 File("src/main/webapp/input files/CHA1.csv"));
		 trainSet= loader.getDataSet();
		 runJ48ClassifierCV(trainSet);
		 runClassifierNaiveBayesCV(trainSet);

		runCluster(trainSet);
		return new ResponseEntity<List<String>>(acc, HttpStatus.OK);
	}

	public void runJ48ClassifierTrainTest(Instances trainSet, Instances testSet) {
		System.out.println("#####################  J48 With Trainset and Testset #####################");
		System.out.println("HI:" + trainSet.numAttributes());
		trainSet.setClassIndex(trainSet.numAttributes() - 1);
		testSet.setClassIndex(trainSet.numAttributes() - 1);
		Classifier model = null;
		Train train = new Train(trainSet);
		/*
		 * TRAIN
		 */
		try {
			model = train.getJ48Model();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * TEST
		 */
		Test test = new Test(trainSet, testSet);
		test.testModel(model);
		System.out.println("#####################  END OF J48  #####################");
		System.out.print("\n\n\n");

	}

	public void runJ48ClassifierTrain(Instances trainSet) {
		System.out.println("#####################  J48 With Trainset & Filter #####################");
		System.out.println("HI:" + trainSet.numAttributes());
		// trainSet.setClassIndex(trainSet.numAttributes() - 1);
		Classifier model = new J48();
		Remove rm = new Remove();
		rm.setAttributeIndices("1");
		FilteredClassifier fc = new FilteredClassifier();
		fc.setFilter(rm);
		trainSet.setClassIndex(trainSet.numAttributes() - 1);
		fc.setClassifier(model);
		Train train = new Train(trainSet);
		/*
		 * TRAIN
		 */
		try {
			model = train.getJ48Model(fc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(model);
		System.out.println("#####################  END OF J48  #####################");
		System.out.print("\n\n\n");
	}
	
	public void runClassifierSVM(Instances trainSet, Instances testSet) {
		System.out.println("#####################  SVM Classifier #####################");
		System.out.println("HI:" + trainSet.numAttributes());
		Classifier model = new SMO();
		Remove rm = new Remove();
		//rm.setAttributeIndices("1");
		FilteredClassifier fc = new FilteredClassifier();
		fc.setFilter(rm);
		//System.out.println(fc);
		trainSet.setClassIndex(trainSet.numAttributes() - 1);
		fc.setClassifier(model);
		Train train = new Train(trainSet);
		/*
		 * TRAIN
		 */
		try {
			model = train.getSVMModel(fc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * TEST
		 */
		Test test = new Test(trainSet, testSet);
		test.testModel(model);
		//System.out.println(model);
		System.out.println("#####################  END OF SVM  #####################");
		System.out.print("\n\n\n");
	}
	
	public void runJ48ClassifierCV(Instances trainSet) {
		System.out.println("#####################  J48 With Trainset & Cross Validation & Filter #####################");
		System.out.println("HI:" + trainSet.numAttributes());
		Classifier model = new J48();
		Remove rm = new Remove();
		//rm.setAttributeIndices("1");
		FilteredClassifier fc = new FilteredClassifier();
		fc.setFilter(rm);
		//System.out.println(fc);
		trainSet.setClassIndex(trainSet.numAttributes() - 1);
		fc.setClassifier(model);
		Test test = new Test(trainSet);
		test.testModelTrain(model);
		System.out.println("#####################  END OF J48  #####################");
		System.out.print("\n\n\n");
	}
	

	public void runClassifierNaiveBayesTrainTest(Instances trainSet, Instances testSet) {
		System.out.println("#####################  Naive Bayes With Trainset and Testset #####################");
		System.out.println("HI:" + trainSet.numAttributes());
		trainSet.setClassIndex(trainSet.numAttributes() - 1);
		testSet.setClassIndex(trainSet.numAttributes() - 1);
		Classifier model = new NaiveBayes();
		Train train = new Train(trainSet);
		/*
		 * TRAIN
		 */
		try {
			model = train.getNaiveBayes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * TEST
		 */
		Test test = new Test(trainSet, testSet);
		test.testModel(model);
		System.out.println("#####################  END OF Naive Bayes  #####################");
		System.out.print("\n\n\n");
	}
	
	public void runClassifierNaiveBayesTrain(Instances trainSet) {
		System.out.println("#####################  Naive Bayes With Trainset & Filter #####################");
		System.out.println("HI:" + trainSet.numAttributes());
		Classifier model = new NaiveBayes();
		Remove rm = new Remove();
		rm.setAttributeIndices("1");
		FilteredClassifier fc = new FilteredClassifier();
		fc.setFilter(rm);
		//System.out.println(fc);
		trainSet.setClassIndex(trainSet.numAttributes() - 1);
		fc.setClassifier(model);
		Train train = new Train(trainSet);
		/*
		 * TRAIN
		 */
		try {
			model = train.getNaiveBayes(fc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("#####################  END OF Naive Bayes  #####################");
		System.out.print("\n\n\n");
	}

	public void runClassifierNaiveBayesCV(Instances trainSet) {
		System.out.println("#####################  Naive Bayes With Trainset & Cross Validation & Filter #####################");
		System.out.println("HI:" + trainSet.numAttributes());
		Classifier model = new NaiveBayes();
		Remove rm = new Remove();
		//rm.setAttributeIndices("1");
		FilteredClassifier fc = new FilteredClassifier();
		fc.setFilter(rm);
		//System.out.println(fc);
		trainSet.setClassIndex(trainSet.numAttributes() - 1);
		fc.setClassifier(model);
		Test test = new Test(trainSet);
		test.testModelTrain(model);
		System.out.println("#####################  END OF Naive Bayes  #####################");
		System.out.print("\n\n\n");
	}
	
	public void runCluster(Instances trainSet) {
		System.out.println("#####################  Cluster #####################");
		EM model = new EM();
		Remove rm = new Remove();
		rm.setAttributeIndices("4");
		FilteredClusterer fc = new FilteredClusterer();
		fc.setFilter(rm);
		Train train = new Train(trainSet);
		try {
			model = train.getCluster(fc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("#####################  END OF Cluster  #####################");
		System.out.print("\n\n\n");
	}
}
