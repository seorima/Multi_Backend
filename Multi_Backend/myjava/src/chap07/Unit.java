package chap07;

public class Unit {
	int x,y;
	
	Unit(int x, int y){
		this.x = x;
		this.y = y;
		System.out.println("Unit 인스턴스 생성");
	}
	
	abstract void move(int x,int y);
	
	void stop() {
		System.out.println("현재 위치에서 정지");
	}

}
