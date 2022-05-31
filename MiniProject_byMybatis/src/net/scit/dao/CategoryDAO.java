package net.scit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.scit.vo.CategoryVO;

public class CategoryDAO {
	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	// C
	public int insertCategory(CategoryVO vo) {
		SqlSession session = null;
		session = factory.openSession();
		CategoryMapper mapper = session.getMapper(CategoryMapper.class);

		int result = mapper.insertCategory(vo);
		session.commit();

		return result;
	}

	// R
	public List<CategoryVO> selectAllCategory() {
		SqlSession session = null;
		session = factory.openSession();
		CategoryMapper mapper = session.getMapper(CategoryMapper.class);

		List<CategoryVO> list = mapper.selectAllCategory();
		return list;
	}

	public CategoryVO selectOneCategory(int categorynum) {
		SqlSession session = null;
		session = factory.openSession();
		CategoryMapper mapper = session.getMapper(CategoryMapper.class);

		CategoryVO vo = mapper.selectOneCategory(categorynum);
		return vo;
	}

	// U
	public int updateCategory(CategoryVO vo) {
		SqlSession session = null;
		session = factory.openSession();
		CategoryMapper mapper = session.getMapper(CategoryMapper.class);

		int result = mapper.updateCategory(vo);
		if (result == 1) {
			session.commit();
			return 1;
		}
		session.rollback();
		return 0;
	}

	// D
	public int deleteCategory(int categorynum) {
		SqlSession session = null;
		session = factory.openSession();
		CategoryMapper mapper = session.getMapper(CategoryMapper.class);

		int result = mapper.deleteCategory(categorynum);
		if (result == 1) {
			session.commit();
			return 1;
		}
		return 0;
	}
}
