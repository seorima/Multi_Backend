package chap08;

public class ExceptionTest {

	public void methodA() throws Exception{
		Exception e = new Exception("methodA ���ܹ߻�!");
		
		throw e; // ���� ȣ���� �������� �̷��̷��ؼ� ���ܰ� �߻��߾�~ ��� �˷��ֱ����ؼ�
	}
	
	public void methodB() {
		
		try {
			methodA();
		}
		catch(Exception e) {
			System.out.println("methodB()���� ��� ����ó��");
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		ExceptionTest test = new ExceptionTest();
		test.methodB();
		
	}
	
}
