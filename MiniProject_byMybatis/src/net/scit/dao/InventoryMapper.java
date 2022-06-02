package net.scit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.scit.vo.InventoryVO;

public interface InventoryMapper {
	public List<InventoryVO> selectAllInventory();
	public int insertInventory(@Param("productnum") int productnum, @Param("stock") int stock);
	public int addStock(@Param("productnum") int productnum, @Param("stockCnt") int stockCnt); 
	public int subtractStock(@Param("productnum") int productnum, @Param("stockCnt") int stockCnt); 
}
