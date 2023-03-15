package chap08.model;

import org.springframework.beans.factory.annotation.Autowired;

import chap08.exception.MemberNotFoundException;

public class MemberinfoPrinter {
	
	
	
	@Autowired
   private MemberDao memberDao;
	@Autowired
   private MemberPrinter memberPrinter;
   
   public MemberinfoPrinter() {
   }
 
   /*
   public void setMemberDao(MemberDao memberDao) {
      this.memberDao = memberDao;
   }
   
   public void setMemberPrinter(MemberPrinter printer) {
      this.memberPrinter = printer;
   }
   */
   
   public void printInfo(String email) {
      Member member = memberDao.selectByEmail(email);
      
      if(member == null) {
         throw new MemberNotFoundException();
      }
      else {
    	  memberPrinter.print(member);
      }
   }
   
}