package net.scit.dao;

import java.util.List;

import net.scit.vo.BrandVO;

public interface BrandMapper {
	// R
	public List<BrandVO> selectAllBrand();
	public BrandVO selectOneBrand(int brandnum);

	// U
	public int updateBrand(BrandVO brand);

	// D
	public int deleteBrand(int brandnum);
	
	
}
