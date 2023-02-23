package chap06;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Time [] timeArr;
		timeArr = new Time[3];
		
		timeArr[0] = new Time();
		timeArr[1] = new Time();
		timeArr[2] = new Time();
		
		timeArr[0].setTime(11, 25, 37);
		timeArr[1].setTime(15, 40, 37);
		timeArr[2].setTime(21, 35, 37);
		
		for(Time n : timeArr) {
			System.out.println(n);
		}
		
	}

}
