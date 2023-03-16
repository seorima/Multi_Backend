package chap09.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class HelloController {
	
	@GetMapping("/hello") // http://localhost:8080/mySpringWeb/hello?name=손흥민  
	public String hello(Model model, @RequestParam(value = "name",required = false) String name) {
		model.addAttribute("greeting", "안녕하세요 ..." + name);
		
		return "hello";
	}

}
