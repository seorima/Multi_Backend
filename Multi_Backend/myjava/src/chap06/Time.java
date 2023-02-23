package chap06;

public class Time {

	int hour;
	int min;
	int sec;
	
	public void setTime(int h, int m, int s) {
		hour=h;
		min=m;
		sec=s;
	}
	
	public String toString() {
		String reStr = hour + "Ω√ " + min + "∫– " + sec + "√ ";
		
		return reStr;
	}
	
	
}
