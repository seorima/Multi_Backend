package chap04.model;

import org.springframework.beans.factory.annotation.Autowired;

import chap03.exception.MemberNotFoundException;
import chap03.exception.WrongIdPasswordException;

public class ChangePasswordService {
	
	@Autowired //필드방식
	private MemberDao memberDao;
	
	public ChangePasswordService() {
		
	}
	
//	@Autowired //메소드에도 의존자동주입을 수행할 수 있군요~
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void changePassword(String email, String oldPassword, String newPassword) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		
		if(oldPassword.equals(newPassword)) {
			throw new WrongIdPasswordException();
		}
		
		member.changePassword(oldPassword, newPassword);
		memberDao.update(member);
		
	}
	
}
