package chap03.assembler;

import chap03.model.*;

public class Assembler {
	
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler() { //도입이 끝났다는데.. 조립하고!! 만들어진 객체들을!!
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
		
	}

	public MemberDao getMemberDao() {  //이용할수있ㄱㅔ getter로..!! 제공@@
		return memberDao;
	}

	public MemberRegisterService getRegSvc() {
		return regSvc;
	}

	public ChangePasswordService getPwdSvc() {
		return pwdSvc;
	}
	
	
	
}
