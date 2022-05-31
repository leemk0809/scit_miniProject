package net.scit.dao;

import java.util.List;

import net.scit.vo.ProductVO;

public interface ProductMapper {
		// C
		public int insertProduct(ProductVO vo);

		// R
		public List<ProductVO> selectAllProduct();
		public ProductVO selectOneProduct(int productnum);
		
		// U
		public int updateProduct(ProductVO vo);

		// D
		public int deleteProduct(int productnum);
	
	
}
