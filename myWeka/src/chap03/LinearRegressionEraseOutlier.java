package chap03;

import weka.classifiers.functions.LinearRegression;

public class LinearRegressionEraseOutlier {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		LinearRegression model = new LinearRegression();
		String fileName = "regression_outliers";
		ModelApply ma = new ModelApply(model, fileName);
		ma.eraseOutlier(new String[] {"year", "phone calls"}, 0, 63,70);
		
		ma.plot2DInstances("outlier recognition", 0, 1); //�ð�ȭ
		
		System.out.println("[�� �� ���]");
		String result = ma.outlierWithCSV();
		System.out.println(model.toString());
		System.out.println(result);
		
	}

}
