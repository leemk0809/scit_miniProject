package net.scit.test;

import java.util.List;

import net.scit.dao.InventoryDAO;
import net.scit.dao.ProductDAO;
import net.scit.vo.InventoryVO;

public class InventoryDAOTest {

	public static void main(String[] args) {
		InventoryDAO dao = new InventoryDAO();
		ProductDAO pDao = new ProductDAO();

		// selectAllInventory() Test ok
		//System.out.println("=========[ ����ũ���̺� �ŷ�ó ���� ]=========");
		//System.out.printf(" ���� | \t ��ǰ�� \t\t | \t ���� \t\t | \t����\n");
		//List<InventoryVO> list = dao.selectAllInventory(5);
		//list.forEach(x -> System.out.println(x.printList()));
		
		// selectAllInventoryByMap() Test 
		//dao.selectAllInventorybyMap(1);
		//System.out.println(map);
		
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
		
		//selectOneInventory() Test ok
		//System.out.println(dao.selectOneInventory(2));
		
	}
}

/*
 	List<InventoryVO> selectAllInventory();
	void addStock(int productnum, int cnt); 
	void subtractStock(int productnum, int cnt); 
	int insertInventory(InventoryVO vo);
 
*/