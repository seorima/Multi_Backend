package chap11.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chap11.controller.MemberController;
import chap11.controller.RegisterController;
import chap11.model.MemberRegisterService;
import chap11.survey.Question;
import chap11.survey.SurveyController;

@Configuration
public class ControllerConfig {

	@Autowired
	private MemberRegisterService memberRegisterService;
	
	@Bean
	public RegisterController registerController() {
		RegisterController rc = new RegisterController();
		rc.setMemberRegisterService(memberRegisterService);
		
		return rc;
	}
	
	@Bean
	public MemberController memberController() {
		return new MemberController();
	}
	
	@Bean
	public SurveyController surveyController() {
		SurveyController survey = new SurveyController();
		survey.setQuestions(this.createQuestions());
		
		return survey;
	}
	
	private List<Question> createQuestions() {
		Question q1 = new Question("당신의 역할은 무엇입니까?",
				Arrays.asList("서버 개발자", "프론트 개발자", "풀스택 개발자"));
		Question q2 = new Question("많이 사용하는 개발도구는 무엇입니까?",
				Arrays.asList("Eclipse", "IntelliJ", "Sublime"));
		Question q3 = new Question("하고 싶은 말을 적어주세요.");
		
		return Arrays.asList(q1, q2, q3);
	}
}
