package chap07;

public class MyDate {

	private int year;
	private int month;
	private int day;
	
	MyDate(int year, int month, int day){
		this.year = year;
		this.month= month;
		this.day = day;
		
	}
	
	boolean isLeapYear() {
		return this.isLeapYear(this.year); // 다른 메서드 호출.. 왜? 오버로딩된 다른 isleapyear를..호출...?음..아 코드 중복을 제거하기위해 사용 .... 그 윤년 계산하는거 를 반복안하려구
	}
	
	boolean isLeapYear(int year) {
		boolean result = false;
		
		if(this.year % 4==0 && this.year % 100 !=0 || this.year % 400==0) {
			result = true;
		}
		
		return result;
	}
	
	int getMonthLastDdays(int month) {
		int[] mon = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		//여기에 2월 ...29일일때 조건 넣어야함....밑에
		if(this.isLeapYear()) {
			mon[2]=29;
		}
		return mon[month];
	}
	
	int getTotalDays() {
		int totalDays=0;
		
		for(int i=1;i<this.year;i++) {
			if(this.isLeapYear(i)) {
				totalDays+=366;
			}
			else {
				totalDays+=365;
			}
		}
		
		for(int i=1;i<month;i++) {
			totalDays+=this.getMonthLastDdays(i);
		}
		
		return totalDays + this.day;
	}
	
	String getWeekdays() {
		String[] arr = {"일","월","화","수","목","금","토"};
		return arr[this.getTotalDays() % 7];
	}
}
