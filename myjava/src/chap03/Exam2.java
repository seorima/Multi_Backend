package chap03;

import java.util.Scanner;

public class Exam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int money=0;
		
		System.out.println("����Ͻ� �ݾ��� �Է��ϼ��� : ");
		money=sc.nextInt();
		
		System.out.println("�����Ͻ� �ݾ��� �Է��ϼ��� : ");
		money-=sc.nextInt();
		
		System.out.println();
		
		System.out.println("�Ž����� : "+money);
		
		System.out.println("500�� ¥�� ����: "+money / 500);
		
		money %=500;
		System.out.println("100�� ¥�� ����: "+ money/100);
		
		money %=100;
		System.out.println("50�� ¥�� ����: "+ money/50);
		
		money %=50;
		System.out.println("10�� ¥�� ����: "+ money/10);
		
		money %=10;
		System.out.println("������ �Ž�����: "+ money);
		
		
		
	}

}
