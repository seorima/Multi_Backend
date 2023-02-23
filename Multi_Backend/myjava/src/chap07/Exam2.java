package chap07;

import java.util.Scanner;

public class Exam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int year,month,day=0;
		MyDate myDate;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("날짜를 입력하세요: ");
		
		year=sc.nextInt();
		month=sc.nextInt();
		day=sc.nextInt();
		
		myDate= new MyDate(year,month,day);
		
		System.out.println("입력하신 " + year + "년 " + month + "월 " + day + "일은 " + myDate.getWeekdays() + "요일 입니다.");
	}

}
