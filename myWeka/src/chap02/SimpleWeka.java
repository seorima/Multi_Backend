package chap02;

import java.io.*;
import java.util.*;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;

public class SimpleWeka {

	public static void main(String [] args) throws Exception {
		int numfolds = 10;
		int numfold = 0;
		int seed = 1;
		
		Instances data = new Instances(new BufferedReader(new FileReader(
															"C:/projects/Weka-3-9-6/weka-main/data/iris.arff")));
		
		Instances train = data.trainCV(numfolds, numfold, new Random(seed)); //훈련데이터
		Instances test = data.testCV(numfolds, numfold); // 검증데이터
		
		RandomForest model = new RandomForest();
		
		train.setClassIndex(train.numAttributes() - 1);
		test.setClassIndex(train.numAttributes() - 1);
		
		Evaluation eval = new Evaluation(train);
		eval.crossValidateModel(model, train, numfolds, new Random(seed));
		
		model.buildClassifier(train);//모델 학습 시작
		
		eval.evaluateModel(model, test); // 모델에 대한 평가 시작
		
		System.out.println(model);
		System.out.println(eval.toSummaryString());
		System.out.println(eval.toMatrixString());
	}
}
