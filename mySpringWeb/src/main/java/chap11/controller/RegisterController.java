package chap11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
	
	@RequestMapping("/register/step1") //   http://localhost:8080/mySpringWeb/register/step1
	public String handleStep1() {
		return "register/step1";
	}
	
	
	@PostMapping("/register/step2") //   http://localhost:8080/mySpringWeb/register/step1
	public String handleStep2(@RequestParam(value = "agree", defaultValue="false") boolean agree) {
		String view = "";
		
		if(agree) {
			view = "register/step2";
		}
		else {
			view = "register/step1";
		}
		
		return view;
	}
	

}
