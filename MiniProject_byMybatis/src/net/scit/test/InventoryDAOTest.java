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
		boolean isProduct = false; // product가 inventory 테이블에 존재하는지 확인 
		ProductVO pVO = pDao.selectOneProduct(productnum);
		System.out.println(pVO);
		
		if(pVO == null) {
			System.out.println("** pVO가 존재하지 않습니다.");
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
			System.out.println(result + "개 insertInventory() 완료");
		}
		*/
		
		// addStock() Test ok
		//int result = dao.addStock(1, 2);
		//System.out.println(result + "개 addStock() 완료");
		
		// subtractStock() Test ok
		//int result = dao.subtractStock(1, 3);
		//System.out.println(result + "개 subtractStock() 완료");
		
	}
}

/*
 	List<InventoryVO> selectAllInventory();
	void addStock(int productnum, int cnt); 
	void subtractStock(int productnum, int cnt); 
	int insertInventory(InventoryVO vo);
 
*/