package net.scit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.scit.vo.UserVO;

public class UserDAO {
	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	public int insertUser(UserVO vo) {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);

		int result = mapper.insertUser(vo);
		if (result != -1)
			session.commit();

		return result;
	}

	public List<UserVO> selectAllUser() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);

		return mapper.selectAllUser();
	}

	public UserVO selectOneUser(String usrid) {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);

		return mapper.selectOneUser(usrid);
	}

	public int updateUserInfo(UserVO vo) {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);

		int result = mapper.updateUserInfo(vo);
		if (result != -1)
			session.commit();

		return result;
	}

	public int deleteUser(String usrid) {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);

		int result = mapper.deleteUser(usrid);
		if (result != -1)
			session.commit();

		return result;
	}

	public int changeAmount(UserVO vo) {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);

		int result = mapper.changeAmount(vo);

		if (result != -1) {
			session.commit();
		}

		return result;
	}

	public UserVO loginUser(UserVO vo) {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		UserVO loginvo =  mapper.loginUser(vo);
		return loginvo;
		
	}
}
