package net.scit.dao;

import java.util.List;

import net.scit.vo.UserVO;

public interface UserMapper {
	
	// C
	int insertUser(UserVO vo);
	
	// R
	List<UserVO> selectAllUser();
	UserVO selectOneUser(String usrid);
	
	// U
	int updateUserInfo(UserVO vo);
	
	// D
	int deleteUser(String usrid);
}
