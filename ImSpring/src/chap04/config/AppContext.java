package chap04.config;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Qualifier;
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
	public MemberRegisterService memberRegSvc() { 
		//return new MemberRegisterService(this.memberDao());
		return new MemberRegisterService(); // 매개변수업슨 생성자통해서 객체만들고 끝냄
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() { 
		ChangePasswordService pwdSvc =  new ChangePasswordService();
		// pwdSvc.setMemberDao(this.memberDao());          이게 chap04 처음 수정한건데... mainforspring 뭐가 바뀌었지..

	
	return pwdSvc;
			}
	
/*	기본
 * 	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	*/
	/*
	@Bean
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	
	@Bean //memberprinter 사용하는 객체 memberinfoprinter,
	public MemberPrinter memberPrinter2() {
		return new MemberPrinter();
	}*/
	
	@Bean
	@Qualifier("printerQ")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	
	@Bean //memberprinter 사용하는 객체 memberinfoprinter,
	public MemberPrinter memberPrinter2() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		// return new MemberListPrinter(this.memberDao(),this.memberPrinter());

		return new MemberListPrinter(); //이거 왜 오류가...
	}
	
	@Bean MemberinfoPrinter infoPrinter() {
		MemberinfoPrinter infoPritner = new MemberinfoPrinter();
		//infoPritner.setMemberDao(memberDao());
		//infoPritner.setMemberPrinter(memberPrinter());
		
		return infoPritner;
	}
	
	@Bean VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);;
		
		return versionPrinter;
	}
	
	@Bean DateTimeFormatter dateTimeFormatter() {
		return DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	}

}
