package net.scit.test;

import java.util.List;

import net.scit.dao.UserDAO;
import net.scit.vo.UserVO;

public class UserDAOTest {

	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		
		// insertUser() Test ok
		/*
		int result = dao.insertUser(new UserVO("dao", "dao", "testname", "testAdd", 10000));
		System.out.println(result + "�� insertUsert() ����");
		*/
		
		// selectAllUser() Test ok
		/*
		List<UserVO> list = dao.selectAllUser();
		list.forEach(x -> System.out.println(x));
		*/
		
		// selectOneUser() Test ok
		//System.out.println(dao.selectOneUser("mk"));
		
		// updateUserInfo() Test ok
		/*
		UserVO vo = dao.selectOneUser("dao");
		vo.setUsrname("good!");
		vo.setAddress("adddddd");
		int result = dao.updateUserInfo(vo);
		System.out.println(result + "�� updateUserInfo() ����");
		*/
		
		// deleteUser() Test ok
		//int result = dao.deleteUser("dao");
		//System.out.println(result + "�� deleteUser() ����");
		
		// changeAmount() Test ok
		/*
		UserVO vo = dao.selectOneUser("mk2");
		vo.setAmount(vo.getAmount() + 2000);
		
		int result = dao.chargeAmount(vo);
		System.out.println(result + "�� chargeAmount() ����");
		*/
	}
}
