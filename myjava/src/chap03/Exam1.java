package chap03;

import java.util.Scanner;

public class Exam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�ϳ��� �Ǽ��� �Է��ϼ��� : ");
		System.out.println();
		
		double number = 0.0;
		number=sc.nextDouble();
		
		System.out.println("���� : %d"+(int)number);
		System.out.println("�ݿø� : %d"+(int)(number + 0.5));
	}

}
