package chap07;

public class InterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InterfaceB b = new InterfaceImpl();
		System.out.println(InterfaceB.num);
		System.out.println(b.num);
		
		// InterfaceB.methodB();
		b.methodB();
		// InterfaceB.dafaultMethod();
		b.dafaultMethod();
		
	}

}
