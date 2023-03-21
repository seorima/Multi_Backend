package chap11.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// http://localhost:8080/mySpringWeb/register/main
		registry.addViewController("/register/main").setViewName("register/main");
		
		// http://localhost:8080/mySpringWeb/register/step1
		registry.addViewController("/register/step1").setViewName("register/step1");
		
		// http://localhost:8080/mySpringWeb/member/login
		registry.addViewController("/member/login").setViewName("member/login");
		
		// http://localhost:8080/mySpringWeb/member/findMember
		registry.addViewController("/member/findMember").setViewName("member/findMember");
		
		// http://localhost:8080/mySpringWeb/member/changePasswd
		registry.addViewController("/member/changePasswd").setViewName("member/changePasswd");
		
	}
}
