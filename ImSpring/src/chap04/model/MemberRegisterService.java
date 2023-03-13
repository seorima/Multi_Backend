package chap04.model;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import chap03.exception.DuplicateMemberException;

public class MemberRegisterService {

	@Autowired
	private MemberDao memberDao;
	
	public MemberRegisterService() { //assembler통해서 객체만들어지고 의조 ㄴ주입까지 되었대요.
		
	}
	
	/*public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}*/
	
	public long regist(RegisterRequest req)
	{
		Member member = memberDao.selectByEmail(req.getEmail());
		
		if(member != null) {
			throw new DuplicateMemberException();
		}
		
		member = new Member(req.getEmail(),req.getPassword(),req.getName(),LocalDateTime.now());
		memberDao.insert(member);
		
		return member.getId();
		
	}
}
