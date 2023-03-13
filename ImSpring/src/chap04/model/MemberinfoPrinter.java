package chap04.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import chap03.exception.MemberNotFoundException;

public class MemberinfoPrinter {
	
	
	
	@Autowired
   private MemberDao memberDao;
	@Autowired
	//private MemberPrinter memberPrinter1;
	//@Qualifier("printerQ")
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