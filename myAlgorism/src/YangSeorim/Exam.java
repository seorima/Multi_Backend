package YangSeorim;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam {
	
	ArrayList<StudentData> list = new ArrayList<StudentData>();
	Scanner scan = new Scanner(System.in);
	
	private int kor,eng,mat,sc;
	private String name,sex,id;
	boolean flag;

	
	
	void Examadd() {

		System.out.print("입력할 학생의 수 : ");	
		int num=scan.nextInt();
		for(int i=0;i<num;i++) {
			
			 System.out.println("학번을 입력하세요. :");	
		      id = scan.next();
		      System.out.println("이름을 입력하세요. :");
		      name = scan.next();
		      System.out.println("성별을 입력하세요. :");
		      sex = scan.next();
		      System.out.println("국어점수를 입력하세요. :");
		      kor = scan.nextInt();
		      System.out.println("영어점수를 입력하세요. :");
		      eng = scan.nextInt();
		      System.out.println("수학점수를 입력하세요. :");
		      mat = scan.nextInt();
		      System.out.println("과학점수를 입력하세요. :");
		      sc = scan.nextInt();
		      
		      for(int j=0;j<list.size();j++) {
		    	  if(list.get(j).getId().equals(id)) {
		      			System.out.println("학번이 이미 존재합니다. 다시 입력해주세요");
						 flag = false;
						 break;
		      		}
		      }
		      
		      if(flag==true) {
		    	  list.add(new StudentData(id,name,sex,kor,eng,mat,sc));
		      }
		      
		      
		      
			System.out.println();
		}
		
	}

	void Examcheck() {
		
		
		System.out.println("1. 학번을 이용한 개별 조회");	
		System.out.println("2. 전체 학생 정보 조회");	
		
		int check=scan.nextInt();
		
		if(check == 1) {
			System.out.print("조회하실 학번을 입력해주세요");	
			String realId = scan.next();
			
			for(int i=0;i<list.size();i++) {
				
				if(realId.equals(list.get(i).getId())) { 	
					System.out.println("학번\t이름\t성별\t국어\t영어\t수학\t과학");
		    		  System.out.println(list.get(i).getId()+"\t" +list.get(i).getName()+"\t"+"\t" +list.get(i).getSex()
		    				  +"\t"+list.get(i).getKor()+"\t"+list.get(i).getEng()+"\t"+list.get(i).getMat()+"\t"+list.get(i).getSci());
		    		  
				}
			}
			
			
			
			
		}else if(check ==2) {
			
				for(int i=0;i<list.size();i++) {	
					System.out.println("학번\t이름\t성별\t국어\t영어\t수학\t과학");
		    		  System.out.println(list.get(i).getId()+"\t" +list.get(i).getName()+"\t"+"\t" +list.get(i).getSex()
		    				  +"\t"+list.get(i).getKor()+"\t"+list.get(i).getEng()+"\t"+list.get(i).getMat()+"\t"+list.get(i).getSci());
		    		  
				
			}
			
		}else {
			System.out.println("숫자를 다시 입력해주세요");	
			
		}

	}


	void Examedit() {

		System.out.println("성적을 수정하실 학생의 [학번]을 입력해주세요");	
		String edit = scan.next();
		
		for(int i=0;i<list.size();i++) {
			if(edit.equals(list.get(i).getId())) { 	
				System.out.println("수정할 과목을 선택해주세요 1.과목 전체 수정 2.국어 3.영어 4.수학 5.과학");
				int select = scan.nextInt();
				
					if(select == 1) {
						System.out.println("변경할 국어점수 : ");
						list.get(i).setKor(scan.nextInt());
						
						System.out.println("변경할 영어점수 : ");
						list.get(i).setEng(scan.nextInt());
						
						System.out.println("변경할 수학점수 : ");
						list.get(i).setMat(scan.nextInt());
						
						System.out.println("변경할 과학점수 : ");
						list.get(i).setSci(scan.nextInt());
						
						System.out.println("수정이 완료되었습니다.");
						
						
					}else if(select == 2) {
						
						System.out.println("변경할 국어점수 : ");
						list.get(i).setKor(scan.nextInt());
						System.out.println("수정이 완료되었습니다.");
						
						
					}else if(select == 3) {
						
						System.out.println("변경할 영어점수 : ");
						list.get(i).setEng(scan.nextInt());
						System.out.println("수정이 완료되었습니다.");
						
					}else if(select == 4) {
						
						System.out.println("변경할 수학점수 : ");
						list.get(i).setMat(scan.nextInt());
						System.out.println("수정이 완료되었습니다.");
						
					}else if(select == 5) {
						
						System.out.println("변경할 과학점수 : ");
						list.get(i).setSci(scan.nextInt());
						System.out.println("수정이 완료되었습니다.");
						
					}
				
	    		  
	    		  
			}
		}
		
		
		
	}

	void Deletestudent() {
		
		System.out.println("성적을 삭제하실 학생의 [학번]을 입력해주세요");	
		String del = scan.next();
		
		for(int i=0;i<list.size();i++) {
			if(del.equals(list.get(i).getId())) { 	
				
				for (StudentData data : list) {
    				if(data.getId().equals(del)) {
    					list.remove(data);
    					break;
    				}  
				
			}

		}
			
	}
}
}

