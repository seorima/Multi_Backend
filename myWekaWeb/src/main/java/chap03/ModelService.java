package chap03;

import org.apache.commons.compress.harmony.unpack200.bytecode.forms.ThisFieldRefForm;

import weka.classifiers.Classifier;
import weka.classifiers.functions.LinearRegression;

public class ModelService {
	
	private Classifier model;
	private ModelApply modelApply;
	private String modelEvalInfo;
	
	public ModelService() throws Exception{  //modelservice 객체 생성
		this.model = new LinearRegression(); //모델 정보 제공
		String fileName = "regression_outliers";
		this.modelApply = new ModelApply(model, fileName);
		this.modelEvalInfo = this.modelApply.outlierWithCSV();
	}
	
	public String getModelInfo() {
		return model.toString();
	}
	
	public String getModelEvalInfo() {
		return this.modelEvalInfo;
	}
	
	
	public void visualize() throws Exception {
		modelApply.plot2DInstances("outlier recognition", 0, 1);
	}
	
	

}
