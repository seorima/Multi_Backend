package chap07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import weka.classifiers.functions.LinearRegression;


public class ToCSV {
	
	/*
	 * \
	 * Komoran을 적용해서 원하느 품사들로 이루어진 새로운 감상평을 csv파일로 생성하여 저장한 후 wekaExplorer 에서 성능검사를 수행하는 작업을 진행
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader ratings = new BufferedReader(new FileReader(new File("C:/projects/Weka-3-9-6/weka-main/data/ratings.txt")));
		BufferedWriter ratingsCSV = new BufferedWriter(new FileWriter(new File("C:/projects/Weka-3-9-6/weka-main/data/ratings.csv")));
		Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
		
		String header[], lineArr[];
		String line,convertLine = null;
		
		header = ratings.readLine().split("\t");
		
		while((line = ratings.readLine()) != null){
			line = line.replaceAll("'", " "); //문자열을 반환. string은 불변
			lineArr = line.split("\t");
			
			KomoranResult result = komoran.analyze(lineArr[1]);
			List<String> wordList = result.getMorphesByTags("NNG","NNP","NNB","NP","NR","VV","VA","VX","VCN","VCP","IC");
			convertLine = "";
			
			for(String word : wordList) {
				convertLine += word + " ";
			}
			
			
			
			ratingsCSV.append("'" + lineArr[1] + "'" + "," + lineArr[2] + "\n");
			
		}
		
		
		ratingsCSV.flush();
		
		System.out.print("작업완료");
	}
	
	
	
}
