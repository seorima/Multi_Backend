package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
		
		Greeter g1 = context.getBean("greeter",Greeter.class);
		Greeter g2 = context.getBean("greeter",Greeter.class);
		
		System.out.println("g1 == g2 : " + (g1 == g2));
		
		/*Greeter g = context.getBean("greeter",Greeter.class);
		
		String msg = g.greet("스프링");
		System.out.println(msg);*/
		
		context.close();
		
	}

}
