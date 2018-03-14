package com.phenotypeAnalysis.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.phenotypeAnalysis.app.classifiers.Test;
import com.phenotypeAnalysis.app.classifiers.Train;

import weka.classifiers.Classifier;
import weka.core.Instances;

@Controller
@RequestMapping("/weka")
public class WekaRestController {
	@RequestMapping(value = "/wekaTest", method = RequestMethod.GET)
	public ResponseEntity<List<String>> predictions() {
		List<String> acc = null;
		// calculate prediction for rules...
		// add result to list acc
		Instances trainSet=null;
		Instances testSet=null;
		runClassifier(trainSet,testSet);
		return new ResponseEntity<List<String>>(acc, HttpStatus.OK);
	}
	
	public  void runClassifier(Instances trainSet, Instances testSet) {
        System.out.println("#####################  J48  #####################");

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

}
