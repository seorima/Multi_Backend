package chap03.model;

import java.util.Collection;

public class MemberListPrinter {

	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public MemberListPrinter(MemberDao memberDao,MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
		
	}
	
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m -> printer.print(m));  ///반복할때마다 m이 매개변수로 들어오고 그것들을 통해서 구현이가능..하다네요
	
	}
	
	
}
