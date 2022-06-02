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
				System.out.println("** ���α׷��� �����մϴ�.");
				System.exit(0);
			default:
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
		System.out.print("  > �Է� : ");
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
			System.out.println("err) �޴��� �ٽ� ������ �ּ���");
		}
	}

	private void loginMenu() {
		System.out.println("=========[�ӽ� �α��� ȭ��]=========");
		System.out.println("1. �� ȭ������");
		System.out.println("2. ������ ȭ������");
		System.out.println("=================================");
		System.out.print("  > �Է� : ");
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
			// System.out.println("** ���α׷��� �����մϴ�.");
			// System.exit(0);
			// default:
			// System.out.println("err) �޴��� �ٽ� ������ �ּ���");
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
				System.out.println("err) �޴��� �ٽ� ������ �ּ���");
			}
		}
	}

	private void registerProduct() {
		// TODO Auto-generated method stub

	}

	private void productUI() {
		System.out.println("=========[���� ����]=========");
		System.out.println("      1. �� ��");
		System.out.println("      2. ��ü ��ȸ");
		System.out.println("      3. �� ȸ");
		System.out.println("      4. �� ��");
		System.out.println("      5. ���� ����");
		System.out.println("==========================");
		System.out.print("      ����>  ");
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
				System.out.println("err) �޴��� �ٽ� ������ �ּ���");

			}
		}
	}

	private void updateCategory() {
		int categorynum;
		String categoryname;

		System.out.println("������ ī�װ� ��ȣ : ");
		categorynum = Integer.parseInt(scanner.nextLine());

		CategoryVO vo = cdao.selectOneCategory(categorynum);
		if (vo == null) {
			System.out.println("�Է��Ͻ� ī�װ� ��ȣ�� �������� �ʽ��ϴ�.");
			return;

		} else {
			System.out.println("�����Ͻ� ī�װ� �̸��� �Է����ּ���");
			categoryname = scanner.nextLine();
			if (categoryname == null) {
				System.out.println("ī�װ� �̸��� �Է����ּ���");
			}
			vo.setCategoryname(categoryname);
			System.out.println();

			int result = cdao.updateCategory(vo);
			System.out.println(result + "������ �Ϸ� �Ǿ����ϴ�.");

		}

	}

	private void deleteCategory() {
		String answer;
		int num;

		System.out.println("> ������ ī�װ� ��ȣ : ");
		num = Integer.parseInt(scanner.nextLine());

		CategoryVO vo = cdao.selectOneCategory(num);
		if (vo == null) {
			System.out.println("* ī�װ��� �����ϴ�.");
			return;
		}

		System.out.println(vo);
		System.out.println("** ī�װ��� �����Ͻðڽ��ϱ�? (y/n)");
		answer = scanner.next();

		if (!answer.equals("y")) {
			System.out.println("** ���� �۾��� ��ҵǾ����ϴ�.");
			return;
		}

		int result = cdao.deleteCategory(num);
		if (result == 1) {
			System.out.println("** ī�װ� ������ �Ϸ�Ǿ����ϴ�.");
		}
	}

	private void categoryList() {

		List<CategoryVO> clist = cdao.selectAllCategory();
		if (clist.isEmpty()) {
			System.out.println("ī�װ��� �����ϴ�.");
			return;
		}
		Iterator<CategoryVO> iter = clist.iterator();
		while (iter.hasNext())
			System.out.println(iter.next());
	}

	private void registerCategory() {
		String categoryname;

		System.out.println("> ī�װ� �̸�: ");
		categoryname = scanner.nextLine();

		CategoryVO vo = new CategoryVO(categoryname);
		int result = cdao.insertCategory(vo);
		System.out.println("ī�װ� ����� �Ϸ�Ǿ����ϴ�.");

	}

	private void adminUI() {
		System.out.println("=========[������]=========");
		System.out.println(" ���õ� �뿹ó�� ���� ����!! ");
		System.out.println("      1. ��ǰ ����");
		System.out.println("      2. ī�װ� ����");
		System.out.println("      3. �ŷ�ó ����");
		System.out.println("      4. ��ü ȸ�� ��ȸ");
		System.out.println("==========================");
		System.out.print("       ����>  ");

	}

	private void categoryUI() {
		System.out.println("=========[ī�װ� ����]=========");
		System.out.println("1. �߰�");
		System.out.println("2. ��ü ��ȸ");
		System.out.println("3. ����");
		System.out.println("4. ����");
		System.out.println("=================================");
		System.out.print("   ����>   ");
	}

	private void userMenu() {

	}

}
