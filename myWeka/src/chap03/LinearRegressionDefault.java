package chap03;

import weka.classifiers.functions.LinearRegression;

public class LinearRegressionDefault {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		LinearRegression model = new LinearRegression();
		String fileName = "regression_outliers";
		ModelApply ma = new ModelApply(model, fileName);
		
		ma.plot2DInstances("outlier recognition", 0, 1); //시각화
		
		System.out.println("[모델 평가 결과]");
		String result = ma.outlierWithCSV();
		
		System.out.println(model.toString());
		System.out.println(result);
		
	}

}
