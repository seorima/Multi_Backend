package chap07;

public class Unit {
	int x,y;
	
	Unit(int x, int y){
		this.x = x;
		this.y = y;
		System.out.println("Unit �ν��Ͻ� ����");
	}
	
	abstract void move(int x,int y);
	
	void stop() {
		System.out.println("���� ��ġ���� ����");
	}

}
