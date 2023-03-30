package chap03;

import weka.classifiers.functions.LinearRegression;

public class LinearRegressionAddFilter {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		LinearRegression model = new LinearRegression();
		String fileName = "regression_outliers";
		ModelApply ma = new ModelApply(model, fileName);
		ma.applyAddClassificationFilter();
		
		ma.plot2DInstances("outlier recognition", 0, 2); //�ð�ȭ
		
		System.out.println("[�� ���� & �� ���]");
		String result = ma.outlierWithCSV();
		
		System.out.println(model.toString());
		System.out.println(result);
		
	}

	
}
