package chap03.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chap03.model.ChangePasswordService;
import chap03.model.MemberDao;
import chap03.model.MemberListPrinter;
import chap03.model.MemberPrinter;
import chap03.model.MemberRegisterService;
import chap03.model.MemberinfoPrinter;
import chap03.model.VersionPrinter;

@Configuration
public class AppConf2 {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberPrinter memberPrinter;
	
	//bean들을 autowired어토네이션삿용
	
	@Bean //이게 붙어있는 경우에는 작성한 코드 그대로 사용되는게아니라 코드변형이 일너마 . spring framework에 의해서 
	public MemberRegisterService memberRegSvc() { //생성자통해서 의존 주입
		return new MemberRegisterService(this.memberDao);
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() { //얘는 setter메소드를 통해서 의존주입을 하는것.
		ChangePasswordService pwdSvc =  new ChangePasswordService();
		pwdSvc.setMemberDao(this.memberDao);

	
	return pwdSvc;
			}
	
	//사이에 안들어가나?
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao,memberPrinter);
	}
	
	@Bean MemberinfoPrinter infoPrinter() {
		MemberinfoPrinter infoPritner = new MemberinfoPrinter();
		//infoPritner.setMemberDao(memberDao);
		//infoPritner.setMemberPrinter(memberPrinter);    //그 autowired해서 주석처리한거임
		
		return infoPritner;
	}
	
	@Bean VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);;
		
		return versionPrinter;
	}
	
	
	
	
	
}
