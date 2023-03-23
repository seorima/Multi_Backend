package chap11.survey;

import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	
	private List<Question> questions;
	
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	/*
	@GetMapping				// http://localhost:8080/mySpringWeb/survey
	public String form(Model model) {
		List<Question> questions = this.questions;
		model.addAttribute("questions", questions);
		
		return "survey/surveyForm";
	}
	*/
	
	@GetMapping
	public ModelAndView form(Model model) {
		List<Question> questions = this.questions;
		ModelAndView mav = new ModelAndView();
		mav.addObject("questions", questions);
		mav.setViewName("survey/surveyForm");
		
		return mav;
	}
	
	@PostMapping
	public String submit(@ModelAttribute("ansData") AnsweredData data) {
		return "survey/submitted";
	}
}
