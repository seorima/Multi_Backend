package chap06;

public class CircleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Circle c1,c2,c3;
		Circle.pi = 3.141592;
		
		c1 = new Circle();
		c1.radius = 5;
		
		System.out.println(c1.getCircleArea());
		
		c2 = new Circle();
		c2.radius = 5;
		
		System.out.println(c2.getCircleArea());

		
		c3 = new Circle();
		c3.radius = 5;
		
		System.out.println(c3.getCircleArea());
		
		
		
	}

}
