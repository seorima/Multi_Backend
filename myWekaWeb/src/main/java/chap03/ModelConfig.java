package chap03;

import org.netlib.util.booleanW;

public class ModelConfig {

	private String modelName;
	private boolean applyFilter;
	private boolean eraseOutlier;
	
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public boolean isApplyFilter() {
		return applyFilter;
	}
	public void setApplyFilter(boolean applyFilter) {
		this.applyFilter = applyFilter;
	}
	public boolean isEraseOutlier() {
		return eraseOutlier;
	}
	public void setEraseOutlier(boolean eraseOutlier) {
		this.eraseOutlier = eraseOutlier;
	}
	
	
	
}
