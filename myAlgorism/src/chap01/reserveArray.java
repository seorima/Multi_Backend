package chap01;

import java.util.Scanner;



public class reserveArray {

	public static int[] reserveArray(int[] arr,int n) {

		int tmp=0;
		
		for(int i=0;i<n/2;i++) {
			tmp=arr[i];
			arr[i]=arr[n-1-i];
			arr[n-1-i]=tmp;
		}
		
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int[] arr = new int[n];
		
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		
		
		reserveArray(arr,n);
		
		for(int i=0;i<n;i++) {
			System.out.print(arr[i] + " ");
		}
		
	}

}
