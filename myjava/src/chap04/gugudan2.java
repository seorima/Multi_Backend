package chap04;

import java.util.Scanner;

public class gugudan2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int dan=2,num=1;
		
		for(int i=1;i<=72;i++) {
			System.out.printf("%d * %d = %d", dan,num,dan*num);
			num++;
			
			if(num==10) {
				num = 1;
				dan++;
				
			}
			
		}
	
	
	}

}
