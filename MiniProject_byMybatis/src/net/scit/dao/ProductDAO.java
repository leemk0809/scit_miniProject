package net.scit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.scit.vo.ProductVO;

public class ProductDAO {
	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	// C
	public int insertProduct(ProductVO vo) {
		SqlSession session = null;
		session = factory.openSession();
		ProductMapper mapper = session.getMapper(ProductMapper.class);

		int result = mapper.insertProduct(vo);
		session.commit();

		return result;
	}

	public List<ProductVO> selectAllProduct() {

		SqlSession session = null;
		session = factory.openSession();
		ProductMapper mapper = session.getMapper(ProductMapper.class);

		List<ProductVO> list = mapper.selectAllProduct();
		return list;

	}

	public ProductVO selectOneProduct(int productnum) {
		SqlSession session = null;
		session = factory.openSession();
		ProductMapper mapper = session.getMapper(ProductMapper.class);

		ProductVO vo = mapper.selectOneProduct(productnum);
		return vo;
	}

	// U
	public int updateProduct(ProductVO vo) {
		SqlSession session = null;
		session = factory.openSession();
		ProductMapper mapper = session.getMapper(ProductMapper.class);

		int result = mapper.updateProduct(vo);
		if (result == 1) {
			return 1;
		}
		session.commit();
		return 0;
	}

	// D
	public int deleteProduct(int productnum) {
		SqlSession session = null;
		session = factory.openSession();
		ProductMapper mapper = session.getMapper(ProductMapper.class);

		int result = mapper.deleteProduct(productnum);
		if (result == 1) {
			session.commit();
			return 1;
		}
		return 0;
	}
}
