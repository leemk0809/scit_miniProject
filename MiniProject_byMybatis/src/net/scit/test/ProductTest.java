package net.scit.test;

import net.scit.dao.ProductDAO;
import net.scit.vo.ProductVO;

public class ProductTest {

	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();

		// insertProduct
		int result = dao.insertProduct(new ProductVO(1, "Àè½¼ Ä«¸á·¹¿Â", 550000));
		System.out.println(result + "°³ insertProducty() ¼º°ø");
		
	

	}

}
