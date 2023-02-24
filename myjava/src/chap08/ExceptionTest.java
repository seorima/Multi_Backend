package chap08;

public class ExceptionTest {

	public void methodA() throws Exception{
		Exception e = new Exception("methodA 예외발생!");
		
		throw e; // 나를 호출한 아이한테 이러이러해서 예외가 발생했어~ 라고 알려주기위해서
	}
	
	public void methodB() {
		
		try {
			methodA();
		}
		catch(Exception e) {
			System.out.println("methodB()에서 대신 예외처리");
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		ExceptionTest test = new ExceptionTest();
		test.methodB();
		
	}
	
}
