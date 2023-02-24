package chap03;

import java.util.Scanner;

public class BinSearch {

	int binarySearch(int[] arr, int key) {
		int result=-1;
		int pl,pr,pc;
		
		pl=0;
		pr = arr.length-1;
		
		
		while(true) {
			pc = (pl + pr) / 2;
			
			if(arr[pc] == key) {
				result = pc;
				break;
			}
			else if(arr[pc] < key) {
				pl = pc+1;
			}
			else {
				pr = pc-1;
			}
			if(pl>pr) {
				break;
			}
		}
		
		
		return result;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int[] arr = {5,7,15,28,29,31,39,58,68,70,95};
		int key =sc.nextInt();
		
		BinSearch exam = new BinSearch();
		
		System.out.println(exam.binarySearch(arr,key))	;
		
		

	}

}
