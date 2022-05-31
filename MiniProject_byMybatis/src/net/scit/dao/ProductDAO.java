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
		return null;

	}

	public ProductVO selectOneProduct(int productnum) {
		return null;
	}

	// U
	public int updateProduct(ProductVO vo) {
		return 1;
	}

	// D
	public int deleteProduct(int productnum) {
		return 1;
	}

}
