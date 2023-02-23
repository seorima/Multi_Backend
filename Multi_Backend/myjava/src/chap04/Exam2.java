package chap04;

import java.util.Scanner;

public class Exam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("년도와 월을 입력하세요 : ");
		int year=sc.nextInt();
		int month=sc.nextInt();
		int day=0;
		
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
			day=31;
		}
		else if(month==4||month==6||month==9||month==11){
			day=30;
		}
		else if(month==2) {
			if(year%100==0) {
				day=28;
			}else if(year%4==0 || year%400==0) {
				day=29;
			}else {
				day=28;
			}
		}
		System.out.println(year + "년 "+month+"월의 마지막 일자는 "+day+"일입니다");
		
		
		
		
	}

}
