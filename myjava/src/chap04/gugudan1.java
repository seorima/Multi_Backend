package chap04;

import java.util.Scanner;

public class gugudan1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int dan;
		
		System.out.println("구구단의 단을 입력하세요");
		dan=sc.nextInt();
		
		System.out.printf("\n [ %d 단 ] %n", dan);
		
		for(int i=1;i<=9;i++) {
			System.out.println(dan+" * "+ i + " = "+(dan*i));
		}
		
	}

}
