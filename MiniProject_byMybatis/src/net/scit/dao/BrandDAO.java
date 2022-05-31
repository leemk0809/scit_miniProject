package net.scit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.scit.vo.BrandVO;

public class BrandDAO {
	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	// R
	public List<BrandVO> selectAllBrand() {
		SqlSession session = null;
		session = factory.openSession();
		BrandMapper mapper = session.getMapper(BrandMapper.class);

		List<BrandVO> list = mapper.selectAllBrand();
		return list;
	}

	// U
	public int updateBrand(BrandVO brand) {
		SqlSession session = null;
		session = factory.openSession();
		BrandMapper mapper = session.getMapper(BrandMapper.class);

		int result = mapper.updateBrand(brand);
		if (result == 1) {
			session.commit();
			return 1;
		}
		session.rollback();
		return 0;
	}

	// D
	public int deleteBrand(int brandnum) {
		SqlSession session = null;
		session = factory.openSession();
		BrandMapper mapper = session.getMapper(BrandMapper.class);

		int result = mapper.deleteBrand(brandnum);
		if (result == 1) {
			session.commit();
			return 1;
		}
		return 0;
	}

	public BrandVO selectOneBrand(int brandnum) {
		SqlSession session = null;
		session = factory.openSession();
		BrandMapper mapper = session.getMapper(BrandMapper.class);

		BrandVO vo = mapper.selectOneBrand(brandnum);
		return vo;
	}

}
