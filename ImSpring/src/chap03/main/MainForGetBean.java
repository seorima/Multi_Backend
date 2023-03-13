package chap03.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chap03.config.AppConf1;
import chap03.config.AppConf2;

public class MainForGetBean {

	
	private static AnnotationConfigApplicationContext context;
	
	static {
		context = new AnnotationConfigApplicationContext(AppConf1.class, AppConf2.class);
	}
	
	public static void main(String[] args) {
		AppConf1 conf1 = context.getBean(AppConf1.class);
		
		if(conf1 != null) {
			System.out.println("conf1 빈이 존재합니다");
			
		}
		else {
			System.out.println("conf1 빈이 존재하지 않습니다.");
		}
	}
}
