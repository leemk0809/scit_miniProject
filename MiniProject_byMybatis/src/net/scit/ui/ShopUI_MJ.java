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

public class ShopUI_MJ {
	Scanner scanner = new Scanner(System.in);
	CategoryDAO cdao = new CategoryDAO();
	ProductDAO pdao = new ProductDAO();
	BrandDAO bdao = new BrandDAO();
	UserDAO udao = new UserDAO();
	InventoryDAO idao = new InventoryDAO();
	String user = "해리스타일스";

	public ShopUI_MJ() {
		mainUI();
	}

	private void mainUI() {
		String choice;
		while (true) {
			mainMenu();
			choice = scanner.nextLine();

			switch (choice) {
			case "1":
				registerUser();
				break;
			case "2":
				login();
				break;
			case "0":
				System.out.println("** 프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("err) 메뉴를 다시 선택해 주세요");
			}
		}
	}

	private void registerUser() {
		String usrid, passwd, usrname, address;
		int amount;
		System.out.print("*  아이디   :  ");
		usrid = scanner.nextLine();

		if (idCheck(usrid)) {
			System.out.println("** 이미 존재하는 아이디입니다. 다른 아이디를 입력해주세요");
			System.out.println();
			return;
		}

		System.out.print("*  비밀번호 :  ");
		passwd = scanner.nextLine();
		if (passwd.trim().equals("")) {
			System.out.println("err) 비밀번호를 입력해 주세요");
			return;
		}

		System.out.print("*  이름    :  ");
		usrname = scanner.nextLine();
		if (usrname.trim().equals("")) {
			System.out.println("err) 이름을 입력해 주세요");
			return;
		}

		System.out.print("*  주소    :  ");
		address = scanner.nextLine();
		if (address.trim().equals("")) {
			System.out.println("err) 주소를 입력해 주세요");
			return;
		}
		System.out.print("*  충전금액 :  ");
		amount = Integer.parseInt(scanner.nextLine());
		if (amount == 0) {
			System.out.println("** 충전금액을 입력해 주세요 : ");
		}

		UserVO vo = new UserVO(usrid, passwd, usrname, address, amount);
		udao.insertUser(vo);
		System.out.printf("회원가입이 완료되었습니다. 즐거운 쇼핑되세요 ^-^ %n");

	}

	private boolean idCheck(String usrid) {
		UserVO vo = udao.selectOneUser(usrid);
		if (vo != null)
			return true;
		return false;
	}

	private void mainMenu() {
		System.out.println("=========[ 로그인 ]==========");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("===========================");
		System.out.print  ("   입력>   ");
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

	public UserVO loginMenu() {
		String usrid, passwd;
		UserVO avo = udao.selectOneUser("admin");
		UserVO vo = new UserVO();
		System.out.println("=========[ 로그인 ]=========");
		System.out.print("* 아이디   : ");
		usrid = scanner.nextLine();

		System.out.print("* 비밀번호  : ");
		passwd = scanner.nextLine();

		vo.setUsrid(usrid);
		vo.setPasswd(passwd);
		UserVO loginVo = udao.loginUser(vo);

		if (loginVo == null) {
			System.out.println("아이디 비밀번호가 일치하지 않습니다. 다시 입력해주세요");
			loginMenu();
			return null;
		}
		if (usrid.equals(avo.getUsrid())) {
			adminMenu();
		}
		userMenu();
		return loginVo;
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
			case "5" :
				 loginMenu();
				 return;
			case "0":
				System.out.println("** 프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("err) 메뉴4를 다시 선택해 주세요");
			}
		}
	}

	private void allUserList() {
		UserVO uvo = new UserVO();
		System.out.println("                   << 전체 회원 조회 >> ");
		System.out.println("------------------------------------------------------");
		System.out.println("   아이디	         이름	      주소	      충전금액  ");
		System.out.println("------------------------------------------------------");
		List<UserVO> vo = udao.selectAllUser();
		vo.forEach(x -> System.out.println(x));
		
	}

	private void brandManagement() {
		System.out.println("                   << 거래처 목록 >> ");
		System.out.println("------------------------------------------------------");
		System.out.println("          거래처명	      담당자	        담당자 메일  ");
		System.out.println("------------------------------------------------------");
		List<BrandVO> bvo = bdao.selectAllBrand();
		bvo.forEach(x -> System.out.println(x));


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
		// System.out.printf("%d개의 제품 등록이 완료되었습니다.%n", result);

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
				System.out.println("err) 메뉴6를 다시 선택해 주세요");
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
			System.out.println("** 등록된 제품이 없습니다.");
			return;
		}
		System.out.println("Brand    Category  Product     Product Name     Price");
		System.out.println("Number   Number    Number");
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
		System.out.println("=========[제품 관리]=========");
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
				System.out.println("err) 메뉴1를 다시 선택해 주세요");

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
		System.out.println("      5. 뒤로 가기");
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
				System.out.println("err) 메뉴2를 다시 선택해 주세요");
			}
		}

	}

	private void goShopping() {
		System.out.println("=========[ 카테고리 ]========");
		System.out.println("1. 가구");
		System.out.println("2. 패브릭");
		System.out.println("===========================");
		System.out.print  ("   선택>   ");

		String choice = scanner.nextLine();

		switch (choice) {
		case "1":
			furniture();
			break;
		case "2":
			fabric();
			break;

		}

	}

	private void fabric() {
		int productnum, lastnum;

		System.out.println("=========================[ 패브릭 ]=========================");
		System.out.println();
		System.out.println("                           상품명                     판매가");
		System.out.println();
		System.out.println("==========================================================");

		List<ProductVO> proList = pdao.selectAllProduct();

		for (int i = 0; i < proList.size(); i++) {
			if (proList.get(i).getCategorynum() == 2) {
				System.out.println(proList.get(i).printList());
			}
		}
		System.out.println("==========================================================");
		System.out.print("> 제품 번호 선택 :  ");
		productnum = Integer.parseInt(scanner.nextLine());

		ProductVO vo = pdao.selectOneProduct(productnum);

		if (vo == null) {
			System.out.println("** 없는 제품 입니다. 다시 입력해 주세요");
			return;
		}

		System.out.println("=====================[" + vo.getProductname() + "]=====================");
		System.out.println(" 브랜드 " + bdao.selectOneBrand(vo.getBrandnum()).getBrandname());
		System.out.println(" 상품명 " + vo.getProductname());
		System.out.println(" 판매가 " + vo.getPrice());
		System.out.println(" 배송방법 : 자체배송");
		System.out.println("===============================================================");
		System.out.println("1. 구입하기");
		System.out.println("2. 돌아가기");
		System.out.println("===============================================================");
		System.out.print  ("   선택>  ");
		lastnum = Integer.parseInt(scanner.nextLine());

		switch (lastnum) {
		case 1:
			buyItem(productnum);
			break;
		case 2:
			return;
		default:
			System.out.println("** 존재하지 않는 제품입니다. 다시 입력해주세요.");
		}
	}

	private void furniture() {
		int productnum, lastnum;

		System.out.println("========================[ 의  자 ]========================");
		System.out.println();
		System.out.println("                         상품명                 판매가 ");
		System.out.println();
		System.out.println("=========================================================");

		List<ProductVO> proList = pdao.selectAllProduct();

		for (int i = 0; i < proList.size(); i++) {
			if (proList.get(i).getCategorynum() == 1) {
				System.out.println(proList.get(i).printList());
			}
		}

		System.out.println("=========================================================");
		System.out.print("> 제품 번호 선택 :  ");
		productnum = Integer.parseInt(scanner.nextLine());

		ProductVO vo = pdao.selectOneProduct(productnum);

		if (vo == null) {
			System.out.println("** 존재하지 않는 제품입니다. 다시 입력해 주세요");
			return;
		}

		System.out.println("===============[" + vo.getProductname() + "]===============");
		System.out.println(" 브랜드 " + bdao.selectOneBrand(vo.getBrandnum()).getBrandname());
		System.out.println(" 상품명 " + vo.getProductname());
		System.out.println(" 판매가 " + vo.getPrice());
		System.out.println(" 배송방법 : 자체배송");
		System.out.println("==============================================");
		System.out.println("1. 구입하기");
		System.out.println("2. 돌아가기");
		System.out.println("==============================================");
		System.out.println("선택>  ");
		lastnum = Integer.parseInt(scanner.nextLine());

		switch (lastnum) {
		case 1:
			buyItem(productnum);
			break;
		case 2:
			return;
		default:
			System.out.println("** 다시 입력해주세요.");
		}
	}

	private void buyItem(int productnum) {
		// 재료부터 모은다
		UserVO user = udao.selectOneUser("harry");
		ProductVO product = pdao.selectOneProduct(productnum);
		InventoryVO ivo = idao.selectOneInventory(productnum);

		// stock이 0일때 판매금지(RETURN) // 추가 예정
		if (idao.selectOneInventory(productnum).getStock() <= 0) {
			System.out.println("** 죄송합니다. 이 상품은 현재 품절입니다. 다른 상품으로 다시 선택해주세요.");
			return;
		}

		// 유저가 살 돈이 있는지 확인
		if (user.getAmount() < product.getPrice()) {
			System.out.println("** 잔고가 모자랍니다. 충전부탁드려요.");
			return;
		}

		// 유저 돈을 빼가자. ( 잔고 - 물건 값)
		int amount = user.getAmount() - product.getPrice();
		user.setAmount(amount);
		// db반영
		int result = udao.changeAmount(user);
		if (result != -1) {
			System.out.println(" * 구매해주셔서 감사합니다 최대한 빠르게 배송해드릴게요 ^-^ *");
			System.out.println(user.getUsrname() + "님의 충전금액에서 " + product.getPrice() + "원이 차감되었습니다. 현재 잔액은 "
					+ user.getAmount() + "원 입니다.");
		}

		// 재고를 줄이자. (재고, -1)
		int result2 = idao.subtractStock(productnum, 1);

		if (result2 != -1) {
			System.out.println("구매가 완료 되었습니다. ");
		}
	}

	private void userUI() {
		System.out.println("========[ 고객 화면 ]========");
		System.out.println("1. 쇼핑하기");
		System.out.println("2. 내 정보 확인");
		System.out.println("3. 내 정보 수정");
		System.out.println("4. 탈퇴하기");
		System.out.println("5. 캐쉬 충전");
		System.out.println("===========================");
		System.out.print  ("   선택>   ");
	}

}
