package chap11;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class InitialMember implements ServletContextListener {

   public void contextDestroyed(ServletContextEvent sce)  { 
	   ServletContext application = sce.getServletContext(); //내장객체에서 어플리케이션읆 ㅏㄴ든다.? 
	   ArrayList<Member> members = new ArrayList<Member>();
	   
	   for(int i=0;i<8;i++) {
		   members.add(new Member("박찬호" + i, "park" + i + "@daum.net"));
	   }
	   
	   members.add(new Member("김연아",null));
	   members.add(new Member("김연경",null)); //10개를 meembers에 넣음. 두개는 이름만있고 이메일 없음
	   
	   application.setAttribute("members", members);
	   application.setAttribute("member", new Member());//매개변수가없는 객체를 만들면 없는 생성자 호출되니까 손흥민,그 값이 됨
	   
        System.out.println("InitialMember Start");
    }
   
    public void contextInitialized(ServletContextEvent sce)  { 
    	 System.out.println("InitialMember Destroy!");
    }
	
}
