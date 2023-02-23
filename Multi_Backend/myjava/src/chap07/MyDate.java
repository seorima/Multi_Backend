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
		return this.isLeapYear(this.year); // �ٸ� �޼��� ȣ��.. ��? �����ε��� �ٸ� isleapyear��..ȣ��...?��..�� �ڵ� �ߺ��� �����ϱ����� ��� .... �� ���� ����ϴ°� �� �ݺ����Ϸ���
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
		//���⿡ 2�� ...29���϶� ���� �־����....�ؿ�
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
		String[] arr = {"��","��","ȭ","��","��","��","��"};
		return arr[this.getTotalDays() % 7];
	}
}
