package chap06;

public class Exam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] lotto = new int[6];
		int number=0;
		int tmp,max=0;
		
		for(int i=0;i<6;i++) {
			number=(int)(Math.random()*45)+1;
			lotto[i] = number;
		}
		
		//중복제거가 없음
		
		for(int i=0; i<lotto.length; i++) {
			for(int j=i+1; j<lotto.length; j++) {
				if(lotto[i] > lotto[j]) { //오름차순
					tmp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = tmp;
				}
			}
		}
		
		for(int i=0;i<6;i++) {
			System.out.print("로또 번호:" + lotto[i] + " ");
		}
		
	}

}
