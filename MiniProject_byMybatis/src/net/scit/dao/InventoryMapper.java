package net.scit.dao;

import java.util.List;

import net.scit.vo.InventoryVO;

public interface InventoryMapper {
	List<InventoryVO> selectAllInventory();
	/* ��� ����
	 * 
	 */
	void addStock(int productnum, int cnt); 
	/* ��� ����
	 * 
	 */
	void subtractStock(int productnum, int cnt); 
}
