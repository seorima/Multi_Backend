package chap07;

public class SingletonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton s1,s2,s3;
		//s1 = new SingletonTest(); Singleton 생성자가 private로 선언되어 있어서 외부에서 만들수없어요
		
		s1 = Singleton.getInstance();
		s2 = Singleton.getInstance();
		s3 = Singleton.getInstance();
		
		if(s1 == s2) { //하나의 레퍼런스를 두개의 인스턴스가 가리킬때
			System.out.println("s1과 s2는 하나의 인스턴스를 가리키고 있습니다");
			
		}
		if(s2 == s3) { //하나의 레퍼런스를 두개의 인스턴스가 가리킬때
			System.out.println("s3과 s2는 하나의 인스턴스를 가리키고 있습니다");
			
		}
		
		
	}

}

//인스턴스는 하나만 만들고 필요한 놈한테 주소값을 다 준다. 그래서 여러놈들이 필요할때 주소값을 나누어준다네요
//데이터는 고정되어 있고 