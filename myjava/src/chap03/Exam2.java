package chap03;

import java.util.Scanner;

public class Exam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int money=0;
		
		System.out.println("계산하실 금액을 입력하세요 : ");
		money=sc.nextInt();
		
		System.out.println("구매하실 금액을 입력하세요 : ");
		money-=sc.nextInt();
		
		System.out.println();
		
		System.out.println("거스름돈 : "+money);
		
		System.out.println("500원 짜리 동전: "+money / 500);
		
		money %=500;
		System.out.println("100원 짜리 동전: "+ money/100);
		
		money %=100;
		System.out.println("50원 짜리 동전: "+ money/50);
		
		money %=50;
		System.out.println("10원 짜리 동전: "+ money/10);
		
		money %=10;
		System.out.println("나머지 거스름돈: "+ money);
		
		
		
	}

}
