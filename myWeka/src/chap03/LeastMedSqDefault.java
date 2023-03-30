package chap03;

import weka.classifiers.functions.LeastMedSq;
import weka.classifiers.functions.LinearRegression;

public class LeastMedSqDefault {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		LeastMedSq model = new LeastMedSq();
		String fileName = "regression_outliers";
		ModelApply ma = new ModelApply(model, fileName);
		
		ma.plot2DInstances("outlier recognition", 0, 1); //�ð�ȭ
		
		System.out.println("[�� �� ���]");
		String result = ma.outlierWithCSV();
		
		System.out.println(model.toString());
		System.out.println(result);
		
	}
	
}
