package chap07;

import java.util.Scanner;

public class Exam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int year,month,day=0;
		MyDate myDate;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("��¥�� �Է��ϼ���: ");
		
		year=sc.nextInt();
		month=sc.nextInt();
		day=sc.nextInt();
		
		myDate= new MyDate(year,month,day);
		
		System.out.println("�Է��Ͻ� " + year + "�� " + month + "�� " + day + "���� " + myDate.getWeekdays() + "���� �Դϴ�.");
	}

}
