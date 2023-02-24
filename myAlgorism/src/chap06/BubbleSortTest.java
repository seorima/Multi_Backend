package chap06;

import java.util.Scanner;

public class BubbleSortTest {
	
	void swap(int[] arr, int idx1, int idx2) {
		int tmp;
		tmp = arr[idx1];
		arr[idx1] = arr[idx1];
		arr[idx1] = tmp;
	}
	
	void bubbleSort(int[] arr) {
		int lastIdx = arr.length-1;
		
		for(int i=0;i<lastIdx;i++) {
			for(int j=lastIdx;j>i;j--) {
				if(arr[j-1]>arr[j]) {
					this.swap(arr,j-1,j);
				}
			}
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[6];
		
		for(int i=0;i<6;i++) {
			arr[i] = sc.nextInt();
		}
		
		
		sc.close();
	}

}
