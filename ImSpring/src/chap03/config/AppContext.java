package chap03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import chap03.model.*;
@Configuration
public class AppContext {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() { //생성자통해서 의존 주입
		return new MemberRegisterService(this.memberDao());
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() { //얘는 setter메소드를 통해서 의존주입을 하는것.
		ChangePasswordService pwdSvc =  new ChangePasswordService();
		pwdSvc.setMemberDao(this.memberDao());

	
	return pwdSvc;
			}

}
