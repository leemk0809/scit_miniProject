package net.scit.ui;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import net.scit.dao.BrandDAO;
import net.scit.dao.CategoryDAO;
import net.scit.dao.InventoryDAO;
import net.scit.dao.ProductDAO;
import net.scit.dao.UserDAO;
import net.scit.vo.BrandVO;
import net.scit.vo.CategoryVO;
import net.scit.vo.InventoryVO;
import net.scit.vo.ProductVO;
import net.scit.vo.UserVO;

public class ShopUI_MK {
	Scanner scanner = new Scanner(System.in);
	CategoryDAO cdao = new CategoryDAO();
	ProductDAO pdao = new ProductDAO();
	BrandDAO bdao = new BrandDAO();
	UserDAO udao = new UserDAO();
	InventoryDAO idao = new InventoryDAO();
	String tempUsrid = "mk"; // 로그인 생기기전 까지 쓸 임시 아이디

	public ShopUI_MK() {
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
			case "3":
				brandManagement();
				break;
			// case "4": allUserList(); break;
			// case "0":
			// System.out.println("** 프로그램을 종료합니다.");
			// System.exit(0);
			// default:
			// System.out.println("err) 메뉴를 다시 선택해 주세요");
			}
		}
	}

	private void brandManagement() {
		BrandVO vo = new BrandVO();
		List<BrandVO> list = bdao.selectAllBrand();
		System.out.println("=========[거래처 목록]=========");
		list.forEach(x -> System.out.println(x));

		String choice;

		System.out.println();

		while (true) {
			BrandUI();
			choice = scanner.nextLine();
			switch (choice) {
			case "1":
				 break;
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
				System.out.println("err) 메뉴를 다시 선택해 주세요");
			}
		}

	}

	private void updateBrand() {
		int brandnum;
		String brandname, managername, email;

		System.out.println("> 거래처 번호: ");
		brandnum = Integer.parseInt(scanner.nextLine());

		if (productnumCheck(brandnum)) {
			System.out.println("** 중복된 거래처가 존재합니다.");
			return;
		}
		System.out.println("> 거래처 이름: ");
		brandname = scanner.nextLine();
		System.out.println("> 거래처 담당자 이름: ");
		managername = scanner.nextLine();
		System.out.println("> 거래처 메일: ");
		email = scanner.nextLine();

		BrandVO vo = new BrandVO(brandnum, brandname, managername, email);
		// int result = bdao.(vo); 여기서부터하기
		//System.out.printf("%d개의 제품 등록이 완료되었습니다.%n", result);

	}

	private void deleteBrand() {
		String answer;
		int num;

		System.out.println("> 삭제할 거래처 번호 : ");
		num = Integer.parseInt(scanner.nextLine());

		BrandVO vo = bdao.selectOneBrand(num);
		if (vo == null) {
			System.out.println("* 해당하는 거래처가 없습니다.");
			return;
		}

		System.out.println(vo);
		System.out.println("** 거래처를 삭제하시겠습니까? (y/n)");
		answer = scanner.nextLine();

		if (!answer.equals("y")) {
			System.out.println("** 삭제 작업이 취소되었습니다.");
			return;
		}

		int result = pdao.deleteProduct(num);
		if (result == 1) {
			System.out.println("** 거래처 삭제가 완료되었습니다.");
		}

	}

	private void brandDetailed() {
		System.out.println("");
		System.out.print("** 조회하려는 거래처 번호를 입력해 주세요. : ");
		int brandnum = Integer.parseInt(scanner.nextLine());
		
		BrandVO vo = bdao.selectOneBrand(brandnum);
		
		if(vo == null) {
			System.out.println("** 존재 하지 않는 번호입니다. 다시 입력해주세요.");
			return;
		}
		
		System.out.printf("=========[ %s 거래처 물건 ]=========\n", vo.getBrandname());
		System.out.printf(" 순번 | \t 제품명 \t\t | \t 가격 \t\t | \t수량\n");
		List<InventoryVO> list = idao.selectAllInventory(brandnum);
		list.forEach(x -> System.out.println(x));
		System.out.println("====================================");
		InventoryMenu();
	}
	
	private void InventoryMenu() {
		String choice;
		while(true) {
			System.out.println("==========[재고 관리]==========");
			System.out.println("1. 재고 추가");
			System.out.println("2. 재고 빼기");
			System.out.println("0. 돌아가기");
			System.out.println("===============================");
			System.out.print  ("   선택 >  ");	
			choice = scanner.nextLine();
			switch (choice) {
			case "1": addStock(); break;
			case "2": subtractStock(); break;
			case "0": return;
			default: System.out.println("** 메뉴를 다시 선택해 주세요.");
			}
		}
	}
	
	private void addStock() {
		System.out.print("  추가할 제품 번호 > ");
		int productnum = Integer.parseInt(scanner.nextLine());
		
		if(pdao.selectOneProduct(productnum) == null) {
			System.out.println("** 제품이 없습니다. 다시 입력해 주세요.");
			return;
		}
		
		System.out.print("  추가 할 수량 > ");
		int stockCnt = Integer.parseInt(scanner.nextLine());
		
		int result = idao.addStock(productnum, stockCnt);
		
		if(result != -1) {
			System.out.println(stockCnt + "개 추가 완료.");
		}
	}
	
	private void subtractStock() {
		System.out.print("뺄 제품 번호 : ");
		int productnum = Integer.parseInt(scanner.nextLine());
		
		if(pdao.selectOneProduct(productnum) == null) {
			System.out.println("** 제품이 없습니다. 다시 입력해 주세요.");
			return;
		}
		
		System.out.print("뺄 수량 : ");
		int stockCnt = Integer.parseInt(scanner.nextLine());
		
		int result = idao.addStock(productnum, -stockCnt);
		
		if(result != -1) {
			System.out.println(stockCnt + "개 추가 완료.");
		}
	}

	private void BrandUI() {
		System.out.println("=========[거래처 관리]=========");
		System.out.println("      1. 추 가");
		System.out.println("      2. 상세 조회");
		System.out.println("      3. 삭 제");
		System.out.println("      4. 수 정");
		System.out.println("============================");
		System.out.print("      선택>  ");
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
				System.out.println("err) 메뉴를 다시 선택해 주세요");
			}
		}
	}

	private void updateProduct() {
		int productnum, price;
		String productname;

		System.out.println("수정하고 싶은 제품번호를 입력하세요 : ");
		productnum = Integer.parseInt(scanner.nextLine());

		ProductVO vo = pdao.selectOneProduct(productnum);
		if (vo == null) {
			System.out.println("입력하신 제품 번호가 존재하지 않습니다.");
			return;

		} else {

			System.out.println("수정하실 제품명을 입력해주세요");
			productname = scanner.nextLine();

			System.out.println("수정하실 제품의 가격을 입력해주세요");
			price = Integer.parseInt(scanner.nextLine());

			vo.setProductname(productname);
			vo.setPrice(price);
			System.out.println();

			int result = pdao.updateProduct(vo);
			System.out.println(result + "개의 제품 수정이 완료 되었습니다.");

		}

	}

	private void deleteProduct() {
		String answer;
		int num;

		System.out.println("> 삭제할 제품 번호 : ");
		num = Integer.parseInt(scanner.nextLine());

		ProductVO vo = pdao.selectOneProduct(num);
		if (vo == null) {
			System.out.println("* 해당하는 제품번호가 없습니다.");
			return;
		}

		System.out.println(vo);
		System.out.println("** 제품을 삭제하시겠습니까? (y/n)");
		answer = scanner.nextLine();

		if (!answer.equals("y")) {
			System.out.println("** 삭제 작업이 취소되었습니다.");
			return;
		}

		int result = pdao.deleteProduct(num);
		if (result == 1) {
			System.out.println("** 제품 삭제가 완료되었습니다.");
		}
	}

	private void selectOneProduct() {
		int productnum;
		System.out.println("조회할 제품 번호를 입력하세요 : ");
		productnum = Integer.parseInt(scanner.nextLine());

		ProductVO vo = pdao.selectOneProduct(productnum);
		System.out.println(vo);

	}

	private void productList() {
		List<ProductVO> plist = pdao.selectAllProduct();
		if (plist.isEmpty()) {
			System.out.println("** 가입한 회원이 없습니다.");
			return;
		}

		Iterator<ProductVO> iter = plist.iterator();
		while (iter.hasNext())
			System.out.println(iter.next());
	}

	private void registerProduct() {
		int brandnum, categorynum, productnum, price;
		String productname;

		System.out.println("> 제품 번호: ");
		productnum = Integer.parseInt(scanner.nextLine());

		if (productnumCheck(productnum)) {
			System.out.println("** 중복된 제품번호가 존재합니다.");
			return;
		}

		System.out.println("> 거래처 번호: ");
		brandnum = Integer.parseInt(scanner.nextLine());
		System.out.println("> 카테고리 번호: ");
		categorynum = Integer.parseInt(scanner.nextLine());
		System.out.println("> 제품 이름: ");
		productname = scanner.nextLine();
		System.out.println("> 제품 가격: ");
		price = Integer.parseInt(scanner.nextLine());

		ProductVO vo = new ProductVO(brandnum, categorynum, productnum, productname, price);
		int result = pdao.insertProduct(vo);
		System.out.printf("%d개의 제품 등록이 완료되었습니다.%n", result);

	}

	private boolean productnumCheck(int productnum) {
		ProductVO vo = pdao.selectOneProduct(productnum);
		// sql = select..from fitness where usrid = 'adc'; pk라 하나뿐이라 있으면 1 없으면 0뿐
		// 그래서 리스트로 안 받고 객체로 받는다
		if (vo != null)
			return true;
		return false;
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
		System.out.println();
		List<CategoryVO> clist = cdao.selectAllCategory();
		if (clist.isEmpty()) {
			System.out.println("카테고리가 없습니다.");
			return;
		}
		System.out.println("========[ 카테고리 목록] =========");
		System.out.println("번호 | 카테고리명 ");
		clist.forEach(x -> System.out.println(x.printList()));
		System.out.println();
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
		String choice;
		
		while(true) {
			userUI();
			choice = scanner.nextLine();
			
			switch(choice) {
			case "1": goShopping(); break;
			case "2": selectOneUser(); break;
			case "3": updateUser(); break;
			case "4": deleteUser(); break;
			case "5": charge(); break;
			default:
				System.out.println("err) 메뉴를 다시 선택해 주세요");	
			}
		}
	}
	
	private void userUI() {
		System.out.println("==========[ 고객 화면 ]==========");
		System.out.println("1. 쇼핑하기");
		System.out.println("2. 내 정보 확인");
		System.out.println("3. 내 정보 수정");
		System.out.println("4. 탈퇴하기");
		System.out.println("5. 캐쉬 충전");
		System.out.println("=================================");
		System.out.print  ("   선택>   ");
	}
	
	private void goShopping() {
		// TODO Auto-generated method stub
		
	}

	private void selectOneUser() {
		UserVO vo = udao.selectOneUser(tempUsrid); // 임시로 mk
		
		System.out.println("==========[ 내 정보 ]==========");
		System.out.println("아이디 : " + vo.getUsrid());
		System.out.println("이름 : " + vo.getUsrname());
		System.out.println("주소 : " + vo.getAddress());
		System.out.println("충전 금액 : " + vo.getAmount());
		System.out.println("===============================");
		System.out.print  ("** 돌아가려면 아무키나 입력 해주세요. > ");
		String command = scanner.nextLine();
		
		// 당장은 의미 없는 코드
		if(command != null) {
			return;
		}
	}

	private void updateUser() {
		UserVO vo = udao.selectOneUser(tempUsrid);
		
		System.out.println("==========[ 내 정보 수정 ]==========");
		System.out.println("아이디 : " + vo.getUsrid());
		System.out.println("이름 : " + vo.getUsrname());
		System.out.println("주소 : " + vo.getAddress());
		System.out.println("충전 금액 : " + vo.getAmount());
		System.out.println("===================================");
		System.out.print  ("** 수정 하시겠습니까?(y/n) ");
		String choice = scanner.nextLine();
		
		if(!choice.equals("y")) {
			return;
		}
		
		System.out.print("수정 할 이름 입력 : ");
		vo.setUsrname(scanner.nextLine()); 
		
		System.out.print("수정 할 주소 입력 : ");
		vo.setAddress(scanner.nextLine());
		
		int result = udao.updateUserInfo(vo);
		
		if(result != -1)
			System.out.println("** 수정 완료!");
		System.out.println();
	}

	private void deleteUser() {
		UserVO vo = udao.selectOneUser(tempUsrid);
		
		System.out.println("==========[ 회원 탈퇴 ]==========");
		System.out.println("아이디 : " + vo.getUsrid());
		System.out.println("이름 : " + vo.getUsrname());
		System.out.println("주소 : " + vo.getAddress());
		System.out.println("충전 금액 : " + vo.getAmount());
		System.out.println("===================================");
		System.out.print  ("** 진짜로 탈퇴 하시겠습니까?(y/n) ");
		String choice = scanner.nextLine();
		
		if(!choice.equals("y")) {
			return;
		}
		
		int result = udao.deleteUser(vo.getUsrid());
		if(result != -1) {
			System.out.println("** 탈퇴 완료!, 세션만료로 프로그램을 종료합니다.");
			System.exit(0);
		}
	}

	private void charge() {
		UserVO vo = udao.selectOneUser(tempUsrid);
		
		System.out.println("==========[ 충전 하기 ]==========");
		System.out.println("잔액 : " + vo.getAmount());
		System.out.print  ("** 충전 하시겠습니까?(y/n)");
		String choice = scanner.nextLine();
		
		if(!choice.equals("y")) {
			return;
		}
		System.out.print("충전 금액 : ");
		int amount = Integer.parseInt(scanner.nextLine());
		
		vo.setAmount(vo.getAmount() + amount);
		int result = udao.changeAmount(vo);
		
		if(result != -1) {
			System.out.println(amount +"원 충전완료!");
		}
	}
}
