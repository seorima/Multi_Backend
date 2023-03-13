import chap03.model.Member;
import chap03.model.MemberPrinter;

public class MemberSummaryPrinter extends MemberPrinter {
	
	public void print(Member member) {
		System.out.printf("회원정보: 이메일=%s,이름 =%s\n", member.getEmail(),member.getName());
	}

}
