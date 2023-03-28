package chap02;

import java.io.*;

import weka.core.Debug.Random;
import weka.core.Instances;

public class SimpleWeka {
	
	
	public static void main(String [] args) throws Exception {
		int numfolds = 10;
		int numfold = 0;
		int seed =1 ;
		
		
		Instances data =  new Instances(new BufferedReader(new FileReader("C:/projects/Weka-3-9-6/data/iris.arff")));
		
		Instances train = data.trainCV(numfolds,numfold, new Random(seed)); // 훈련데이터
		Instances test = data.testCV(numfolds,numfold); // 검증데이터
		
	}

}
