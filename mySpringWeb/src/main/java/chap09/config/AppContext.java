package chap09.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import chap08.model.*;
@Configuration
public class AppContext {
	
	
	@Bean
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds = new DataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("scott");
		ds.setPassword("tiger");
		ds.setInitialSize(2);
		ds.setMinIdle(3);
		ds.setMaxIdle(3);
		ds.setMaxActive(5);
		ds.setMinEvictableIdleTimeMillis(60000);
		ds.setTimeBetweenEvictionRunsMillis(5000);
		
		return ds;
		
	}
	
	@Bean
	public MemberDaoSpring memberDao() {
		return new MemberDaoSpring(dataSource());
	}
	
	@Bean //이게 붙어있는 경우에는 작성한 코드 그대로 사용되는게아니라 코드변형이 일너마 . spring framework에 의해서 
	public MemberRegisterService memberRegSvc() { //생성자통해서 의존 주입
		return new MemberRegisterService(this.memberDao());
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() { //얘는 setter메소드를 통해서 의존주입을 하는것.
		ChangePasswordService pwdSvc =  new ChangePasswordService();
		pwdSvc.setMemberDao(this.memberDao());

	
	return pwdSvc;
			}
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao(),memberPrinter());
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

	
	
}
