package net.scit.ui;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import net.scit.dao.BrandDAO;
import net.scit.dao.CategoryDAO;
import net.scit.dao.ProductDAO;
import net.scit.dao.UserDAO;
import net.scit.vo.BrandVO;
import net.scit.vo.CategoryVO;
import net.scit.vo.ProductVO;
import net.scit.vo.UserVO;

public class ShopUI_MJ {
	Scanner scanner = new Scanner(System.in);
	CategoryDAO cdao = new CategoryDAO();
	ProductDAO pdao = new ProductDAO();
	BrandDAO bdao = new BrandDAO();
	UserDAO udao = new UserDAO();

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
			case "3":
				brandManagement();
				break;
			case "4":
				allUserList();
				break;
			case "0":
				System.out.println("** ���α׷��� �����մϴ�.");
				System.exit(0);
			default:
				System.out.println("err) �޴��� �ٽ� ������ �ּ���");
			}
		}
	}

	private void allUserList() {
		System.out.println("                      << ��ü ȸ�� ��ȸ >> ");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("   ȸ����ȣ	     �̸�	          ���̵�	          �ּ�	       �����ݾ�  ");
		System.out.println("-------------------------------------------------------------------");
		List<UserVO> vo = udao.selectAllUser();
		System.out.println(vo);
	}

	private void brandManagement() {
		BrandVO vo = new BrandVO();
		System.out.println("=========[�ŷ�ó ���]=========");

		System.out.println(vo);

		String choice;

		System.out.println();

		while (true) {
			BrandUI();
			choice = scanner.nextLine();
			switch (choice) {
			// case "1":
			// registerBrand(); break;
			case "2":
				brandDetailed();
				break;
			case "3":
				deleteBrand();
				break;
			case "4":
				updateBrand();
				break;
			default:
				System.out.println("err) �޴��� �ٽ� ������ �ּ���");
			}
		}
	}

	private void updateBrand() {
		int brandnum;
		String brandname, managername, email;

		System.out.println("> �ŷ�ó ��ȣ: ");
		brandnum = Integer.parseInt(scanner.nextLine());

		if (productnumCheck(brandnum)) {
			System.out.println("** �ߺ��� �ŷ�ó�� �����մϴ�.");
			return;
		}
		System.out.println("> �ŷ�ó �̸�: ");
		brandname = scanner.nextLine();
		System.out.println("> �ŷ�ó ����� �̸�: ");
		managername = scanner.nextLine();
		System.out.println("> �ŷ�ó ����: ");
		email = scanner.nextLine();

		BrandVO vo = new BrandVO(brandnum, brandname, managername, email);
		// int result = bdao.(vo); ���⼭�����ϱ�
		// System.out.printf("%d���� ��ǰ ����� �Ϸ�Ǿ����ϴ�.%n", result);

	}

	private void deleteBrand() {
		String answer;
		int num;

		System.out.println("> ������ �ŷ�ó ��ȣ : ");
		num = Integer.parseInt(scanner.nextLine());

		BrandVO vo = bdao.selectOneBrand(num);
		if (vo == null) {
			System.out.println("* �ش��ϴ� �ŷ�ó�� �����ϴ�.");
			return;
		}

		System.out.println(vo);
		System.out.println("** �ŷ�ó�� �����Ͻðڽ��ϱ�? (y/n)");
		answer = scanner.nextLine();

		if (!answer.equals("y")) {
			System.out.println("** ���� �۾��� ��ҵǾ����ϴ�.");
			return;
		}

		int result = pdao.deleteProduct(num);
		if (result == 1) {
			System.out.println("** �ŷ�ó ������ �Ϸ�Ǿ����ϴ�.");
		}

	}

	private void brandDetailed() {

	}

	private void BrandUI() {
		System.out.println("=========[�ŷ�ó ����]=========");
		System.out.println("      1. �� ��");
		System.out.println("      2. �� ��ȸ");
		System.out.println("      3. �� ��");
		System.out.println("      4. �� ��");
		System.out.println("============================");
		System.out.print("      ����>  ");
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
			case "2":
				productList();
				break;
			case "3":
				selectOneProduct();
				break;
			case "4":
				deleteProduct();
				break;
			case "5":
				updateProduct();
				break;
			default:
				System.out.println("err) �޴��� �ٽ� ������ �ּ���");
			}
		}
	}

	private void updateProduct() {
		int productnum, price;
		String productname;

		System.out.println("�����ϰ� ���� ��ǰ��ȣ�� �Է��ϼ��� : ");
		productnum = Integer.parseInt(scanner.nextLine());

		ProductVO vo = pdao.selectOneProduct(productnum);
		if (vo == null) {
			System.out.println("�Է��Ͻ� ��ǰ ��ȣ�� �������� �ʽ��ϴ�.");
			return;

		} else {

			System.out.println("�����Ͻ� ��ǰ���� �Է����ּ���");
			productname = scanner.nextLine();

			System.out.println("�����Ͻ� ��ǰ�� ������ �Է����ּ���");
			price = Integer.parseInt(scanner.nextLine());

			vo.setProductname(productname);
			vo.setPrice(price);
			System.out.println();

			int result = pdao.updateProduct(vo);
			System.out.println(result + "���� ��ǰ ������ �Ϸ� �Ǿ����ϴ�.");

		}

	}

	private void deleteProduct() {
		String answer;
		int num;

		System.out.println("> ������ ��ǰ ��ȣ : ");
		num = Integer.parseInt(scanner.nextLine());

		ProductVO vo = pdao.selectOneProduct(num);
		if (vo == null) {
			System.out.println("* �ش��ϴ� ��ǰ��ȣ�� �����ϴ�.");
			return;
		}

		System.out.println(vo);
		System.out.println("** ��ǰ�� �����Ͻðڽ��ϱ�? (y/n)");
		answer = scanner.nextLine();

		if (!answer.equals("y")) {
			System.out.println("** ���� �۾��� ��ҵǾ����ϴ�.");
			return;
		}

		int result = pdao.deleteProduct(num);
		if (result == 1) {
			System.out.println("** ��ǰ ������ �Ϸ�Ǿ����ϴ�.");
		}
	}

	private void selectOneProduct() {
		int productnum;
		System.out.println("��ȸ�� ��ǰ ��ȣ�� �Է��ϼ��� : ");
		productnum = Integer.parseInt(scanner.nextLine());

		ProductVO vo = pdao.selectOneProduct(productnum);
		System.out.println(vo);

	}

	private void productList() {
		List<ProductVO> plist = pdao.selectAllProduct();
		if (plist.isEmpty()) {
			System.out.println("** ������ ȸ���� �����ϴ�.");
			return;
		}

		Iterator<ProductVO> iter = plist.iterator();
		while (iter.hasNext())
			System.out.println(iter.next());
	}

	private void registerProduct() {
		int brandnum, categorynum, productnum, price;
		String productname;

		System.out.println("> ��ǰ ��ȣ: ");
		productnum = Integer.parseInt(scanner.nextLine());

		if (productnumCheck(productnum)) {
			System.out.println("** �ߺ��� ��ǰ��ȣ�� �����մϴ�.");
			return;
		}

		System.out.println("> �ŷ�ó ��ȣ: ");
		brandnum = Integer.parseInt(scanner.nextLine());
		System.out.println("> ī�װ� ��ȣ: ");
		categorynum = Integer.parseInt(scanner.nextLine());
		System.out.println("> ��ǰ �̸�: ");
		productname = scanner.nextLine();
		System.out.println("> ��ǰ ����: ");
		price = Integer.parseInt(scanner.nextLine());

		ProductVO vo = new ProductVO(brandnum, categorynum, productnum, productname, price);
		int result = pdao.insertProduct(vo);
		System.out.printf("%d���� ��ǰ ����� �Ϸ�Ǿ����ϴ�.%n", result);

	}

	private boolean productnumCheck(int productnum) {
		ProductVO vo = pdao.selectOneProduct(productnum);
		// sql = select..from fitness where usrid = 'adc'; pk�� �ϳ����̶� ������ 1 ������ 0��
		// �׷��� ����Ʈ�� �� �ް� ��ü�� �޴´�
		if (vo != null)
			return true;
		return false;
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
		String choice;

		while (true) {
			userUI();
			choice = scanner.nextLine();

			switch (choice) {
			case "1":
				goShopping();
				break;
			/*
			 * case "2": selectOneUser(); break; case "3": updateUser(); break; case "4":
			 * deleteUser(); break; case "5": charge(); break;
			 */
			default:
				System.out.println("err) �޴��� �ٽ� ������ �ּ���");
			}
		}

	}

	private void goShopping() {
		System.out.println("==========[ ī�װ� ]==========");
		System.out.println("1. ����");
		System.out.println("2. �к긯");
		System.out.print("   ����>   ");

		String choice = scanner.nextLine();

		switch (choice) {
		case "1":
			furniture();
			break;
		// case "2" :
		// fabric(); break;

		}

	}

	private void furniture() {
		int choice;
		System.out.println("==========[ ���� ]==========");
		List<ProductVO> proList = pdao.selectAllProduct();
		proList.forEach(x -> System.out.println(x.printList()));

		System.out.println("> ��ǰ ��ȣ ���� :  ");
		choice = Integer.parseInt(scanner.nextLine());
		
		ProductVO vo = pdao.selectOneProduct(choice);

		if (choice == vo.getProductnum()) {
			System.out.println(vo);
			//System.out.println("brandnum : " + brandnum);
			System.out.println("                       ����                         ");
			System.out.println("---------------------------------------------------");
			System.out.println("   �ŷ�ó �̸�	         �����̸�	          �ǸŰ�	       ");
			System.out.println("---------------------------------------------------");
			System.out.printf("%15s %20 %,10d��", 
							   bdao.selectOneBrand(vo.getBrandnum()).getBrandname(), 
							   
							   pdao.selectOneProduct(choice).getProductname(),
							   pdao.selectOneProduct(choice).getPrice());
			
		}
	}//"%3d %15s %,9d��

	private void userUI() {
		System.out.println("==========[ �� ȭ�� ]==========");
		System.out.println("1. �����ϱ�");
		System.out.println("2. �� ���� Ȯ��");
		System.out.println("3. �� ���� ����");
		System.out.println("4. Ż���ϱ�");
		System.out.println("5. ĳ�� ����");
		System.out.println("=================================");
		System.out.print("   ����>   ");
	}

}
