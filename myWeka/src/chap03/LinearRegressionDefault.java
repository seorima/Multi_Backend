package chap03;

import weka.classifiers.functions.LinearRegression;

public class LinearRegressionDefault {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		LinearRegression model = new LinearRegression();
		String fileName = "regression_outliers";
		ModelApply ma = new ModelApply(model, fileName);
		
		ma.plot2DInstances("outlier recognition", 0, 1); //�ð�ȭ
		
		System.out.println("[�� �� ���]");
		String result = ma.outlierWithCSV(); //������ ��� �����ϰ�..
		
		System.out.println(model.toString()); //����ϰ�
		System.out.println(result);
		
	}

}
