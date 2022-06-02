package net.scit.dao;

import java.util.List;

import net.scit.vo.InventoryVO;

public interface InventoryMapper {
	List<InventoryVO> selectAllInventory();
	/* 재고 증가
	 * 
	 */
	void addStock(int productnum, int cnt); 
	/* 재고 감소
	 * 
	 */
	void subtractStock(int productnum, int cnt); 
}
