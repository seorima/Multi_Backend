package chap07;

import java.util.Scanner;

public class Exam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int year,month,day=0;
		String[] arr = {"일","월","화","수","목","금","토"};
		int[] mon = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		
		int result=0;
		
		String fin;
		int totalmonth = 0;
		int totalyear=0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("날짜를 입력하세요: ");
		
		year=sc.nextInt();
		month=sc.nextInt();
		day=sc.nextInt();
		
		for(int i=1;i<year;i++) {
			if(i%4==0 && i % 100 !=0 || i%400==0) {
				totalyear+=366;
			}
			else {
				totalyear+=365;
			}
		}
		
		
			if(year%4==0 && year % 100 !=0 || year%400==0) {
				mon[2]=29;
			}
			else {
				
			}
		for(int i=1;i<month;i++) {
			totalmonth+=mon[i];
		}
		
		result =  totalmonth + totalyear + day;
		
		fin= arr[result%7];
		
		System.out.println("입력하신 " + year + "년 " + month + "월 " + day + "일은 " + fin + "요일 입니다.");
		
		
	}

}
