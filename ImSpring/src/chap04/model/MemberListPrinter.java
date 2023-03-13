package chap04.model;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberListPrinter {

	private MemberDao memberDao;
	private MemberPrinter printer;
	
	
	public MemberListPrinter() {
		
	}
	
	/*public MemberListPrinter(MemberDao memberDao,MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
		
	}*/
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	@Autowired
	//=> 빈 이름으로 식별
	//public void setPrinter(MemberPrinter memberPrinter2) {
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m -> printer.print(m));  ///반복할때마다 m이 매개변수로 들어오고 그것들을 통해서 구현이가능..하다네요
	
	}
	
	
}
