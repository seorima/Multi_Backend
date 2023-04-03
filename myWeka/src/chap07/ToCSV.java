package chap07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import weka.classifiers.functions.LinearRegression;


public class ToCSV {

	public static void main(String[] args) throws Exception {
		BufferedReader ratings = new BufferedReader(new FileReader(new File("C:/projects/Weka-3-9-6/weka-main/data/ratings.txt")));
		BufferedWriter ratingsCSV = new BufferedWriter(new FileWriter(new File("C:/projects/Weka-3-9-6/weka-main/data/ratings.csv")));
		
		String header[], lineArr[];
		String line;
		
		header = ratings.readLine().split("\t");
		
		while((line = ratings.readLine()) != null){
			line = line.replaceAll("'", " "); //문자열을 반환. string은 불변
			lineArr = line.split("\t");
			
			ratingsCSV.append("'" + lineArr[1] + "'" + "," + lineArr[2] + "\n");
			
		}
		
		
		ratingsCSV.flush();
		
		System.out.print("작업완료");
	}
	
	
	
}
