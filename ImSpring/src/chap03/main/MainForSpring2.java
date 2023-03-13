package chap03.main;

import java.io.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chap03.model.*;
import chap03.exception.*;
import chap03.config.*;

public class MainForSpring2 {

	private static AnnotationConfigApplicationContext context;
	
	static {
		context = new AnnotationConfigApplicationContext(AppConf1.class,AppConf2.class); //설정클래스를 하나가아니라 여러개지정
	}
	
	private void printHelp() {
		System.out.println("\n 잘못된 명령입니다. 아래 사용법을 확인하세요");
		System.out.println("\n ### 명령어 사용법 ###");
		System.out.println(" 명령어를 입력하세요: new 이메일 이름 암호 암호확인");
		System.out.println(" 명령어를 입력하세요: change 이메일 현재암호 변경암호");
		System.out.println(" 명령어를 입력하세요: list");
		System.out.println(" 명령어를 입력하세요: info 이메일");
		System.out.println(" 명령어를 입력하세요: version");
		System.out.println(" 명령어를 입력하세요: exit\n");
	}
	
	private void processNewCommand(String [] args) {
		if(args.length != 5) {
			this.printHelp();
			return;
		}
		
		MemberRegisterService regSvc = context.getBean("memberRegSvc", MemberRegisterService.class);
		RegisterRequest req = new RegisterRequest();
		req.setEmail(args[1]);
		req.setName(args[2]);
		req.setPassword(args[3]);
		req.setConfirmPassword(args[4]);
		
		if(!req.isPasswordEqualToConfirmPassword()) {
			System.out.println(" 암호와 암호 확인이 일치하지 않습니다.\n");
			return;
		}
		
		try {
			regSvc.regist(req);
			System.out.println(" 회원 정보를 등록했습니다.\n");
		}
		catch(DuplicateMemberException e) {
			System.out.println(" 이미 존재하는 이메일입니다.\n");
		}
	}
	
	private void processChangeCommand(String [] args) {
		if(args.length != 4) {
			this.printHelp();
			return;
		}
		
		ChangePasswordService pwdSvc = context.getBean("changePwdSvc", ChangePasswordService.class);
		
		try {
			pwdSvc.changePassword(args[1], args[2], args[3]);
			System.out.println(" 비밀번호를 잘 변경했습니다!\n");
		}
		catch (MemberNotFoundException e) {
			System.out.println(" 존재하지 않는 이메일입니다.\n");
		}
		catch (WrongIdPasswordException e) {
			System.out.println(" 잘못된 아이디 또는 패스워드 입니다.\n");
		}
	}
	
	private void processListCommand() {
		MemberListPrinter listPrinter = context.getBean("listPrinter",MemberListPrinter.class);
		listPrinter.printAll();
	}
	
	private void processInfoCommand(String [] args) {
		if(args.length != 2) {
			this.printHelp();
			return;
		}
		MemberinfoPrinter infoPrinter = context.getBean("infoPrinter", MemberinfoPrinter.class);
				
		try {
			infoPrinter.printInfo(args[1]);   //오류나면 이거 printinfo맞는지
		}
		catch(MemberNotFoundException exception ) {
			System.out.println("존재하지 않는 이메일입니다.");
		}
	}
	
	private void processVersionCommand() {
		VersionPrinter versionPrinter = context.getBean("versionPrinter",VersionPrinter.class);
		versionPrinter.print();
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		MainForSpring2 main = new MainForSpring2();
		String command = "";
		
		System.out.println("\n ### 회원 관리 프로그램 ###\n");
		
		while(true) {
			System.out.print(" 명령어를 입력하세요: ");
			command = reader.readLine();
			
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("\n 프로그램을 종료합니다.");
				break;
			}
			else if(command.startsWith("new ")) {
				main.processNewCommand(command.split(" "));
			}
			else if(command.startsWith("change ")) {
				main.processChangeCommand(command.split(" "));
			}
			else if(command.startsWith("list")) {
				main.processListCommand();
			}
			else if(command.startsWith("info ")) {
				main.processInfoCommand(command.split(" "));
			}
			else if(command.startsWith("version ")) {
				main.processVersionCommand();
			}
			else {
				main.printHelp();
			}
		}
	}
}
