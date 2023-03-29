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
		
		Instances train = data.trainCV(numfolds, numfold, new Random(seed)); //�Ʒõ�����
		Instances test = data.testCV(numfolds, numfold); // ����������
		
		RandomForest model = new RandomForest();
		
		train.setClassIndex(train.numAttributes() - 1);
		test.setClassIndex(train.numAttributes() - 1);
		
		Evaluation eval = new Evaluation(train);
		eval.crossValidateModel(model, train, numfolds, new Random(seed));
		
		model.buildClassifier(train);//�� �н� ����
		
		eval.evaluateModel(model, test); // �𵨿� ���� �� ����
		
		System.out.println(model);
		System.out.println(eval.toSummaryString());
		System.out.println(eval.toMatrixString());
	}
}
