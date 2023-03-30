package chap03;

import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

import org.netlib.util.intW;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AddClassification;
import weka.gui.visualize.Plot2D;

public class ModelApply {
	
	private Classifier model;
	private String fileName;
	private Instances data;
	
	
	
	
	private void loadCSVData() throws Exception {
		CSVLoader loader = new CSVLoader();
		loader.setSource(new File("C:/projects/Weka-3-9-6/data/" + this.fileName + ".csv"));
		this.data = loader.getDataSet();
	}
	
	public ModelApply(Classifier model, String fileName) throws Exception {
		this.model = model;
		this.fileName = fileName; //Ä¸ÃÄº»
		this.loadCSVData();
		
	}

	public String outlierWithCSV () throws Exception
			{
		int numFolds = 10;
		int numFold = 0;
		int seed = 1;

		Instances train = this.data.trainCV(numFolds, numFold, new Random(seed));
		Instances test = this.data.testCV(numFolds, numFold);

		train.setClassIndex(train.numAttributes() - 1);
		test.setClassIndex(train.numAttributes() - 1);

		Evaluation eval = new Evaluation(train);

		this.model.buildClassifier(train);
		eval.crossValidateModel(model, train, numFolds, new Random(seed));

		eval.evaluateModel(model, test);

		return eval.toSummaryString();
	}

	public void applyAddClassificationFilter()
			throws Exception {
		
			AddClassification filter = new AddClassification();
			filter.setClassifier(this.model);
			filter.setOutputClassification(true);
			this.data.setClassIndex(data.numAttributes() - 1);
			filter.setInputFormat(data);
			this.data = Filter.useFilter(this.data, filter);
		
	}

	public void eraseOutlier(String [] attributes , int targetIdx, int start, int end) throws Exception {
		
		ArrayList<Attribute> attrList = new ArrayList<Attribute>();
		
		for(String attribute : attributes) {
			attrList.add(new Attribute(attribute));
		}
		

		Instances eraseData = new Instances("ErasedData", attrList, 0);

		for (int i = 0; i < this.data.size(); i++) {
			Instance instance = data.get(i);
			int year = (int) instance.value(targetIdx);

			if (year >= start || year <= end) {
				eraseData.add(instance);
			}
		}
	}
	
	
	public void plot2DInstances(String graphTitle, int xIndex, int yIndex) throws Exception {
		Plot2D panel = new Plot2D();
		panel.setInstances(this.data);
		panel.setXindex(xIndex);
		panel.setYindex(yIndex);
		panel.setCindex(this.data.numAttributes() - 1);
		
		JFrame frame = new JFrame(graphTitle);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(panel);
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
