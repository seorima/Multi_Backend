package ojdbc;

import java.util.ArrayList;

public class ArrayListTest {
	//arraylist�̿��ؼ� ����ϴ� ���α׷�

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<jdbcTest> rows = new ArrayList<jdbcTest>();
		
		rows.add(new jdbcTest("�̼���","longlee@daum.net"));
		rows.add(new jdbcTest("ȫ�浿","hong@naver.com"));
		rows.add(new jdbcTest("����ȣ","hong@naver.com"));
		
		
		//���� row�� ����� ��� ȸ�������� ����ϴ��ڵ带 �ۼ��ϼ���
		for(jdbcTest jdbcTest : rows) {
			System.out.println(jdbcTest.getUsername() + "\t" + jdbcTest.getEmail());
		}

	}

}
