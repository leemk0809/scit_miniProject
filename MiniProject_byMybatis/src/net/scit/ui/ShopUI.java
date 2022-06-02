package net.scit.ui;

import java.util.Scanner;

public class ShopUI {
	Scanner scanner = new Scanner(System.in);
	
	public ShopUI(){
		mainUI();
	}
	
	private void mainUI() {
		String choice;
		while(true) {
			mainMenu();
			choice = scanner.nextLine();
			
			switch(choice) {
			//case "1": registerUser(); break;
			case "2": login(); break;
			//case "3": widthdrawUser(); break;
			case "0": 
				System.out.println("** 프로그램을 종료합니다.");
				System.exit(0);
			default : 
				System.out.println("err) 메뉴를 다시 선택해 주세요");
			}
		}
	}
	
	private void mainMenu() {
		System.out.println("=========[로그인]=========");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 탈퇴");
		System.out.println("==========================");
		System.out.print  ("  > 입력 : ");
	}
	
	private void login() {
		String choice;
		loginMenu();
		choice = scanner.nextLine();
		
		switch(choice) {
		case "1": userMenu(); break;
		case "2": adminMenu(); break;
		default : 
			System.out.println("err) 메뉴를 다시 선택해 주세요");
		}
	}
	
	private void loginMenu() {
		System.out.println("=========[임시 로그인 화면]=========");
		System.out.println("1. 고객 화면으로");
		System.out.println("2. 관리자 화면으로");
		System.out.println("====================================");
		System.out.print  ("  > 입력 : ");
	}
	
	private void adminMenu() {
		// TODO Auto-generated method stub
		
	}

	private void userMenu() {
		// TODO Auto-generated method stub
		
	}


	
	
	

}
