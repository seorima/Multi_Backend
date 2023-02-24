package chap07;

public final class Singleton {
	
	static private Singleton s = new Singleton();
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(s == null) {
			s = new Singleton();
		}
		//객체가 만들어지지 않았으면 객체를 만드는 거임
		return s;
	}
}
