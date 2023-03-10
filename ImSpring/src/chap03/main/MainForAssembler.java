package chap03.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import chap03.model.*;
import chap03.exception.*;
import chap03.assembler.Assembler;

public class MainForAssembler {
	
	private static Assembler assembler = new Assembler();
	
	private void printHelp() {
		System.out.println("\n잘못된 명령입니다. 아래 사용법을 확인하세요.");
		System.out.println("\n ### 명령어 사용법 ###");
		System.out.println("\n 명령어를 입력하세요: new 이메일 이름 암호 암호확인 ###");
		System.out.println("\n 명령어를 입력하세요: change 이메일 현재암호 변경암호 ###\n");
		System.out.println("\n 명령어를 입력하세요: exit\n");
	}
	
	private void processNewCommand(String [] args) {
		if(args.length != 5) {
			this.printHelp();
			return;
		}
		
		MemberRegisterService regSvc = assembler.getRegSvc();
		RegisterRequest req = new RegisterRequest();
		
		req.setEmail(args[1]);
		req.setName(args[2]);
		req.setPassword(args[3]);
		req.setConfirmPassword(args[4]); 
		
		//비밀번호를 가지고 왓으면 확인을 해야함
		if(!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호와 암호 확인이 일치하지 않습니다.");
			return;
		}
		
		try {
			regSvc.regist(req); //regist가 memberrigisterservice에서 예외를 발생시킬 ㅅ 있거든여.. 그래서 예외처리
		}
		catch(DuplicateMemberException e) {
			System.out.println("이미 존재하는 이메일입니다\n");
		}
		
		
		
		
	}
	private void processChangeCommand(String [] args) {
		if(args.length != 4) {
			this.printHelp();
			return;
		}
		ChangePasswordService pwdSvc = assembler.getPwdSvc();
		
		try{
			pwdSvc.changePassword(args[1], args[2], args[3]);
		}
		catch(MemberNotFoundException e) {
			System.out.println("이미 존재하지 않는 이메일입니다\n");
		}
		catch(WrongIdPasswordException e) {
			System.out.println("잘못된 아이디 또는 패스워드 입니다.\n");
		}
		
	}

	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));// reader통해서 사용자입력을 처리가능
		MainForAssembler main = new MainForAssembler();
		String command = "";
		
		System.out.println("\\n ### 회원 관리 프로그램 ###");
		
		while(true) {
			System.out.print("명령어를 입력하세요: ");
			command = reader.readLine();
			
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("\n 프로그램을 종료합니다");
				break;
			}
			else if(command.startsWith("new ")) {
				main.processNewCommand(command.split(" "));
				continue;
				
			}
			else if(command.startsWith("change ")) {
				main.processNewCommand(command.split(" "));
				continue;
				
			}
			main.printHelp();
			
			
		}
		
		
	}

}
