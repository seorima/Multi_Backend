package YangSeorim;

import java.util.Scanner;

public class ManageExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		Exam e = new Exam();
		
		System.out.println("### 학생 성적 관리 프로그램 ###");	
		System.out.println();
		int num=0;
		
		
		while (true) {
			
			System.out.println("1. 학생 정보 입력");
			System.out.println("2. 학생 정보 조회");
			System.out.println("3. 성적 변경");
			System.out.println("4. 학생 정보 삭제");
			System.out.println("5. 프로그램 종료");
			
			num=scan.nextInt();
			
			if(num==5) break;
			
			else if(num==1) {
				e.Examadd();
				
			}
			else if(num==2) {
				e.Examcheck();
				
			}
			else if(num==3) {
				e.Examedit();
				
			}
			else if(num==4) {
				
				e.Deletestudent();
			}


			

			
		}
	}	
}
