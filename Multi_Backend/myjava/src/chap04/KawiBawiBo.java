package chap04;

import java.util.Scanner;

public class KawiBawiBo { //�̱涧���� ����������

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int user,com;
		boolean isWin = false;
		String[] kbb = {"����","����","��"};
		String result = "";
		Scanner scanner = new Scanner(System.in);
		
		String intro="\n\t [ ���������� ���� ] \n\n" +
				"\t 1. ���� \n" +
				"\t 2. ���� \n" +
				"\t 3. �� \n" +
				"\t >>> ";
		do {
		System.out.println(intro);
		user = scanner.nextInt()-1;
		com=(int)(Math.random()*3);
		
		System.out.printf("\n\t ����� %s, ��ǻ�� %s %n",kbb[user],kbb[com]);
		
		switch(user - com) {
			case 2: case -1:
				result = "�����ϴ�";
				break;
			case 1: case -2:
				result = "�̰���ϴ�";
				isWin = true;
				break;
			case 0:
				result = "�����ϴ�";
				break;
		}
		System.out.printf("\t ���������� ���  ==> %s %n",result);
	} while(!isWin);
		
		scanner.close();
		
	}

}
