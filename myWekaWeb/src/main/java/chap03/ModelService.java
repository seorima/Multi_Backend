package chap03;

import org.apache.commons.compress.harmony.unpack200.bytecode.forms.ThisFieldRefForm;

import weka.classifiers.Classifier;
import weka.classifiers.functions.LeastMedSq;
import weka.classifiers.functions.LinearRegression;

public class ModelService {
	
	private Classifier model;
	private ModelApply modelApply;
	private int yIndex;
	
	public ModelService() throws Exception{  //modelservice 객체 생성
		this.model = new LinearRegression(); //모델 정보 제공
		String fileName = "regression_outliers";
		this.modelApply = new ModelApply(model, fileName);
		this.yIndex = 1;
	}
	
	public String getModelInfo() throws Exception { 
		String result = "";
		result +="\n\n[모델 평가 정보]"+ this.modelApply.outlierWithCSV();
		result = "\n[모델 정보]" + this.model.toString()+result;
		
		return result;
		
	}
	
	public void visualize() throws Exception {
		modelApply.plot2DInstances("outlier recognition", 0, this.yIndex);
	}
	
	
	public void configModel(ModelConfig config) throws Exception {
		
		modelApply.loadCSVData();
	
		if(config.getModelName().equals("LinearRegression")) {
			this.model = new LinearRegression(); //객체 생성후 자기자신에게 넣고, 그다음에 주입
			modelApply.setModel(this.model);
		}
		else {
			this.model = new LeastMedSq();
			modelApply.setModel(this.model);
		}
		
		if(config.isEraseOutlier()) {
			modelApply.eraseOutlier(new String[] {"year","phone calls"}, 0, 63, 70);
		}
		if(config.isApplyFilter()) {
			modelApply.applyAddClassificationFilter();
			this.yIndex = 2;
		}else {
			this.yIndex = 1;//맞냐?
		}
		
	}
	

}
