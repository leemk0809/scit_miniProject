package net.scit.dao;

import java.util.List;

import net.scit.vo.BrandVO;
import net.scit.vo.CategoryVO;

public interface CategoryMapper {

	// C
	public int insertCategory(CategoryVO vo);

	// R
	public List<CategoryVO> selectAllCategory();
	public CategoryVO selectOneCategory(int categorynum);
	
	// U
	public int updateCategory(CategoryVO vo);

	// D
	public int deleteCategory(int categorynum);

}
