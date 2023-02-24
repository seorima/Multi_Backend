package chap07.polymorphism;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	/*	
		Parent p = new Child();  //이문장의 확실한 뜻이 뭐지? 
		//p는 Parent타입 parent에는 method b 없어...
		//자식의 child인스턴스를 생성했으니 methodB()를 사용하도록 할 수 없을까? == 네 안됩니다.
		p.methodA();
		// p.methodB(); //->왜 사용할 수 없을까?
		
		Child c = (Child)p; //명시적 형변환

*/
		
		//======
	/*			
				 
		Parent p = new Parent();
		Child c = (Child)p;
		c.methodA();
		
		
		
		//자식타입의 인스턴스가 부모타입의 레퍼런스를 가리키면 오류?
		//자식만의 멤버가 없는 부모인스턴스를 자식이 가리키게되면... 어 오류?
		
		// -. 자식클래스 타입의 레퍼런스는 부모클래스 타입의 인스턴스를 가리킬 수 없다
		 */
		
		
		//======
		
		/*
		  
		  Parent p = (Parent)o; // 상속 관계가 아닌 다른 클래스는 클래스 형변환의 대상이 아니다.
		 */
		
		//======
		/*
		  Parent p = new Parent();
		Child c = new Child();
		Other o = new Other();
		
		Object obj;
		obj = p;
		obj = c;
		obj = o;
		 */
		
		
		//Object클래스 타입의 레퍼런스는 모든 자바 클래스의 인스턴스를 가리킬 수 있다
		// 하지만 문제가 있다? 가리킬 수 만있지 써먹을수가 없다네요
		//어떻게 문제를 해결할 수 있을까?
		/*
		 
		 */
		
		Object obj;
		obj = new Parent();
		((Parent)obj).methodA();
		
		obj = new Child();
		((Child)obj).methodB();
		
		obj = new Other();
		((Other)obj).methodC();
		
		
		

	}

}
