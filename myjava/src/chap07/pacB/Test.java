package chap07.pacB;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child c = new Child();
		
		//System.out.println(c.num1);
		//System.out.println(c.num2); 
	//	System.out.println(c.methodA()); //Test는 pacA의 Parent의 자식이 아님 그래서 접근이 불가.
		System.out.println(c.methodB());
		System.out.println(c.methodC());
		
	}

}
