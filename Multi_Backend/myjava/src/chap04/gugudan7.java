package chap04;

import java.util.Scanner;

public class gugudan7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for(int k=2;k<=9;k++) {
			System.out.printf("[ %d ´Ü ] \t", k);
			
		}
		System.out.println();
		for(int i=1;i<=9;i++) {
			for(int j=2;j<=9;j++) {
				System.out.printf("%d * %d = %d \t", j,i,i*j);
			}
			System.out.println();
		}
	}

}
