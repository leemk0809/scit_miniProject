package net.scit.test;

import java.util.List;

import net.scit.dao.InventoryDAO;
import net.scit.dao.ProductDAO;
import net.scit.vo.InventoryVO;
import net.scit.vo.ProductVO;

public class InventoryDAOTest {

	public static void main(String[] args) {
		InventoryDAO dao = new InventoryDAO();
		ProductDAO pDao = new ProductDAO();

		// selectAllInventory() Test ok
		//List<InventoryVO> list = dao.selectAllInventory();
		//list.forEach(x -> System.out.println(x));
		
		// insertInventory() Test ok
		/*
		int productnum = 1;
		boolean isProduct = false; // product�� inventory ���̺� �����ϴ��� Ȯ�� 
		ProductVO pVO = pDao.selectOneProduct(productnum);
		System.out.println(pVO);
		
		if(pVO == null) {
			System.out.println("** pVO�� �������� �ʽ��ϴ�.");
			return;
		}
		List<InventoryVO> list = dao.selectAllInventory();
		
		for(InventoryVO vo : list) {
			if(productnum == vo.getProductnum()) {
				isProduct = true;
			}
		}
		if(isProduct != true) {
			int stock = 2;
			int result = dao.insertInventory(productnum, stock);
			System.out.println(result + "�� insertInventory() �Ϸ�");
		}
		*/
		
		// addStock() Test ok
		//int result = dao.addStock(1, 2);
		//System.out.println(result + "�� addStock() �Ϸ�");
		
		// subtractStock() Test ok
		//int result = dao.subtractStock(1, 3);
		//System.out.println(result + "�� subtractStock() �Ϸ�");
		
	}
}

/*
 	List<InventoryVO> selectAllInventory();
	void addStock(int productnum, int cnt); 
	void subtractStock(int productnum, int cnt); 
	int insertInventory(InventoryVO vo);
 
*/