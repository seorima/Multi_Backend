package chap11.survey;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/survey")
public class SurveyController {

	@GetMapping				// http://localhost:8080/mySpringWeb/survey
	public String form() {
		return "survey/surveyForm";
	}
	
	@PostMapping
	public String submit(@ModelAttribute("ansData")AnsweredData data) {
		return "survey/submitted";
	}
}
