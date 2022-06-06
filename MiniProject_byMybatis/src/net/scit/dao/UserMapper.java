package net.scit.dao;

import java.util.List;

import net.scit.vo.UserVO;

public interface UserMapper {
	
	// C
	public int insertUser(UserVO vo);
	
	// R
	public List<UserVO> selectAllUser();
	public UserVO selectOneUser(String usrid);
	
	// U
	public int updateUserInfo(UserVO vo);
	
	// D
	public int deleteUser(String usrid);
	
	public int changeAmount(UserVO vo);

	public UserVO loginUser(UserVO vo);

}
