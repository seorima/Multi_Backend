package ojdbc;

import java.util.ArrayList;

public class ArrayListTest {
	//arraylist이용해서 출력하는 프로그램

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<jdbcTest> rows = new ArrayList<jdbcTest>();
		
		rows.add(new jdbcTest("이성구","longlee@daum.net"));
		rows.add(new jdbcTest("홍길동","hong@naver.com"));
		rows.add(new jdbcTest("박찬호","hong@naver.com"));
		
		
		//문제 row에 저장된 모든 회원정보를 출력하는코드를 작성하세요
		for(jdbcTest jdbcTest : rows) {
			System.out.println(jdbcTest.getUsername() + "\t" + jdbcTest.getEmail());
		}

	}

}
