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
				System.out.println("** ���α׷��� �����մϴ�.");
				System.exit(0);
			default : 
				System.out.println("err) �޴��� �ٽ� ������ �ּ���");
			}
		}
	}
	
	private void mainMenu() {
		System.out.println("=========[�α���]=========");
		System.out.println("1. ȸ������");
		System.out.println("2. �α���");
		System.out.println("3. Ż��");
		System.out.println("==========================");
		System.out.print  ("  > �Է� : ");
	}
	
	private void login() {
		String choice;
		loginMenu();
		choice = scanner.nextLine();
		
		switch(choice) {
		case "1": userMenu(); break;
		case "2": adminMenu(); break;
		default : 
			System.out.println("err) �޴��� �ٽ� ������ �ּ���");
		}
	}
	
	private void loginMenu() {
		System.out.println("=========[�ӽ� �α��� ȭ��]=========");
		System.out.println("1. �� ȭ������");
		System.out.println("2. ������ ȭ������");
		System.out.println("====================================");
		System.out.print  ("  > �Է� : ");
	}
	
	private void adminMenu() {
		// TODO Auto-generated method stub
		
	}

	private void userMenu() {
		// TODO Auto-generated method stub
		
	}


	
	
	

}
