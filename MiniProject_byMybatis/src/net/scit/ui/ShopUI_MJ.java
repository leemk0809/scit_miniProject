package net.scit.ui;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import net.scit.dao.CategoryDAO;
import net.scit.dao.ProductDAO;
import net.scit.vo.CategoryVO;

public class ShopUI_MJ {
	Scanner scanner = new Scanner(System.in);
	CategoryDAO cdao = new CategoryDAO();
	ProductDAO pdao = new ProductDAO();

	public ShopUI_MJ() {
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
	}

	private void adminMenu() {
		String choice;
		while (true) {
			adminUI();
			choice = scanner.nextLine();

			switch (choice) {
			case "1":
				productManagement();
				break;
			case "2":
				categoryManagement();
				break;
			// case "3": brandManagement(); break;
			// case "4": allUserList(); break;
			// case "0":
			// System.out.println("** 프로그램을 종료합니다.");
			// System.exit(0);
			// default:
			// System.out.println("err) 메뉴를 다시 선택해 주세요");
			}
		}
	}

	private void productManagement() {
		String choice;

		while (true) {
			productUI();
			choice = scanner.nextLine();
			switch (choice) {
			case "1":
				registerProduct();
				break;
				// case "2":
				// productList();
				//break;
				// case "3":
				// deleteProduct();
				//break;
			//case "4":
				// updateProduct();
				//break;

			default:
				System.out.println("err) 메뉴를 다시 선택해 주세요");
			}
		}
	}

	private void registerProduct() {
		// TODO Auto-generated method stub

	}

	private void productUI() {
		System.out.println("=========[물건 관리]=========");
		System.out.println("      1. 추 가");
		System.out.println("      2. 전체 조회");
		System.out.println("      3. 조 회");
		System.out.println("      4. 삭 제");
		System.out.println("      5. 정보 수정");
		System.out.println("==========================");
		System.out.print("      선택>  ");
	}

	private void categoryManagement() {
		String choice;

		while (true) {
			categoryUI();

			choice = scanner.nextLine();
			switch (choice) {
			case "1":
				registerCategory();
				break;
			case "2":
				categoryList();
				break;
			case "3":
				deleteCategory();
				break;
			case "4":
				updateCategory();
				break;

			default:
				System.out.println("err) 메뉴를 다시 선택해 주세요");

			}
		}
	}

	private void updateCategory() {
		int categorynum;
		String categoryname;

		System.out.println("수정할 카테고리 번호 : ");
		categorynum = Integer.parseInt(scanner.nextLine());

		CategoryVO vo = cdao.selectOneCategory(categorynum);
		if (vo == null) {
			System.out.println("입력하신 카테고리 번호가 존재하지 않습니다.");
			return;

		} else {
			System.out.println("수정하실 카테고리 이름을 입력해주세요");
			categoryname = scanner.nextLine();
			if (categoryname == null) {
				System.out.println("카테고리 이름을 입력해주세요");
			}
			vo.setCategoryname(categoryname);
			System.out.println();

			int result = cdao.updateCategory(vo);
			System.out.println(result + "수정이 완료 되었습니다.");

		}

	}

	private void deleteCategory() {
		String answer;
		int num;

		System.out.println("> 삭제할 카테고리 번호 : ");
		num = Integer.parseInt(scanner.nextLine());

		CategoryVO vo = cdao.selectOneCategory(num);
		if (vo == null) {
			System.out.println("* 카테고리가 없습니다.");
			return;
		}

		System.out.println(vo);
		System.out.println("** 카테고리를 삭제하시겠습니까? (y/n)");
		answer = scanner.next();

		if (!answer.equals("y")) {
			System.out.println("** 삭제 작업이 취소되었습니다.");
			return;
		}

		int result = cdao.deleteCategory(num);
		if (result == 1) {
			System.out.println("** 카테고리 삭제가 완료되었습니다.");
		}
	}

	private void categoryList() {

		List<CategoryVO> clist = cdao.selectAllCategory();
		if (clist.isEmpty()) {
			System.out.println("카테고리가 없습니다.");
			return;
		}
		Iterator<CategoryVO> iter = clist.iterator();
		while (iter.hasNext())
			System.out.println(iter.next());
	}

	private void registerCategory() {
		String categoryname;

		System.out.println("> 카테고리 이름: ");
		categoryname = scanner.nextLine();

		CategoryVO vo = new CategoryVO(categoryname);
		int result = cdao.insertCategory(vo);
		System.out.println("카테고리 등록이 완료되었습니다.");

	}

	private void adminUI() {
		System.out.println("=========[관리자]=========");
		System.out.println(" 오늘도 노예처럼 일을 하자!! ");
		System.out.println("      1. 제품 관리");
		System.out.println("      2. 카테고리 관리");
		System.out.println("      3. 거래처 관리");
		System.out.println("      4. 전체 회원 조회");
		System.out.println("==========================");
		System.out.print("       선택>  ");

	}

	private void categoryUI() {
		System.out.println("=========[카테고리 관리]=========");
		System.out.println("1. 추가");
		System.out.println("2. 전체 조회");
		System.out.println("3. 삭제");
		System.out.println("4. 수정");
		System.out.println("=================================");
		System.out.print("   선택>   ");
	}

	private void userMenu() {

	}

}
