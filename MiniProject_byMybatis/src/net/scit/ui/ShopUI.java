package net.scit.ui;

import java.util.Scanner;

public class ShopUI {
	Scanner scanner = new Scanner(System.in);

	public ShopUI() {
		mainUI();
	}

	private void mainUI() {
		String choice;
		while (true) {
			mainMenu();
			choice = scanner.nextLine();

			switch (choice) {
			// case "1": registerUser(); break;
			case "2":
				login();
				break;
			// case "3": widthdrawUser(); break;
			case "0":
				System.out.println("** 프로그램을 종료합니다.");
				System.exit(0);
			default:
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
		System.out.print("  > 입력 : ");
		System.out.println();
	}

	private void login() {
		String choice;
		loginMenu();
		choice = scanner.nextLine();

		switch (choice) {
		case "1":
			userMenu();
			break;
		case "2":
			adminMenu();
			break;
		default:
			System.out.println("err) 메뉴를 다시 선택해 주세요");
		}
	}

	private void loginMenu() {
		System.out.println("=========[임시 로그인 화면]=========");
		System.out.println("1. 고객 화면으로");
		System.out.println("2. 관리자 화면으로");
		System.out.println("=================================");
		System.out.print("  > 입력 : ");
		System.out.println();
	}

	private void adminUI() {
		String choice;
		while (true) {
			adminMenu();
			choice = scanner.nextLine();

			switch (choice) {
			// case "1": productManagement(); break;
			case "2":
				categoryManagement();
				break;
			// case "3": brandManagement(); break;
			// case "4": allUserList(); break;
			//case "0":
				//System.out.println("** 프로그램을 종료합니다.");
				//System.exit(0);
			//default:
				//System.out.println("err) 메뉴를 다시 선택해 주세요");
			}
		}
	}

	private void categoryManagement() {
		String choice;

		System.out.println("=========[카테고리 관리]=========");
		System.out.println("1. 추가");
		System.out.println("2. 전체 조회");
		System.out.println("3. 삭제");
		System.out.print("4. 수정");
		System.out.println("------------------------------");
		System.out.print("  선택>    ");
		System.out.println();

		while (true) {

			choice = scanner.nextLine();

			switch (choice) {
			// case "1": registerCategory(); break;
			// case "2": categoryList; break;
			// case "3": deleteCategory(); break;
			// case "4": updateCategory(); break;
			case "0":
				System.out.println("** 프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("err) 메뉴를 다시 선택해 주세요");

			}
		}
	}

	private void adminMenu() {
		System.out.println("=========[관리자]=========");
		System.out.println(" 오늘도 노예처럼 일을 하자!! ");
		System.out.println("      1. 제품 관리");
		System.out.println("      2. 카테고리 관리");
		System.out.println("      3. 거래처 관리");
		System.out.println("      4. 전체 회원 조회");
		System.out.println("-----------------------");
		System.out.print("         선택>            ");
		System.out.println();

	}

	private void userMenu() {

	}

}
