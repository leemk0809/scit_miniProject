package net.scit.test;

import net.scit.dao.UserDAO;
import net.scit.vo.UserVO;

public class UserDAOTest {

	public static void main(String[] args) {
		UserDAO dao = new UserDAO();

		// insertUser() Test ok
		/*
		 * int result = dao.insertUser(new UserVO("dao", "dao", "testname", "testAdd",
		 * 10000)); System.out.println(result + "개 insertUsert() 성공");
		 */

		// selectAllUser() Test ok
		/*
		 * List<UserVO> list = dao.selectAllUser(); list.forEach(x ->
		 * System.out.println(x));
		 */

		// selectOneUser() Test ok
		// System.out.println(dao.selectOneUser("mk"));

		// updateUserInfo() Test ok
		/*
		 * UserVO vo = dao.selectOneUser("dao"); vo.setUsrname("good!");
		 * vo.setAddress("adddddd"); int result = dao.updateUserInfo(vo);
		 * System.out.println(result + "개 updateUserInfo() 성공");
		 */

		// deleteUser() Test ok
		// int result = dao.deleteUser("dao");
		// System.out.println(result + "개 deleteUser() 성공");

		// changeAmount() Test ok
		/*
		 * UserVO vo = dao.selectOneUser("mk2"); vo.setAmount(vo.getAmount() + 2000);
		 * 
		 * int result = dao.chargeAmount(vo); System.out.println(result +
		 * "개 chargeAmount() 성공");
		 */

		// loginUser Test ok
		/*
		 * UserVO vo = new UserVO();
		 * 
		 * 올바른 입력 //vo.setUsrid("harry"); //vo.setPasswd("123");
		 * 
		 * /* 올바르지 않은 입력 vo.setUsrid("111"); vo.setPasswd("111");
		 * 
		 * dao.loginUser(vo); System.out.println("결과 값 : " + dao.loginUser(vo));
		 */

	}
}
