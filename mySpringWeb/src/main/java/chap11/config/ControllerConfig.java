package chap11.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//controller설정

import chap11.controller.RegisterController;

@Configuration
public class ControllerConfig {
	
	@Bean
	public RegisterController registerController() {
		return new RegisterController();
	}

}
