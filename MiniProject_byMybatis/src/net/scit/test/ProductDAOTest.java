package net.scit.test;

import java.util.List;

import net.scit.dao.ProductDAO;
import net.scit.vo.ProductVO;

public class ProductDAOTest {

	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();

		 // insertProduct Test ok
		 //int result = dao.insertProduct(new ProductVO(7, 7, 5, "잭슨 카멜레온", 550000));
		 //System.out.println(result + "개 insertProducty() 성공");
		 

		// selectAllProduct() Test ok
		 List<ProductVO> list = dao.selectAllProduct();
		 list.forEach(x->System.out.println(x));

		// selectOneProduct() Test ok
		// ProductVO vo = dao.selectOneProduct(1);
		// System.out.println(vo);

		// updateProduct() Test ok
		/*
		 * int num = 1; ProductVO vo = dao.selectOneProduct(num);
		 * vo.setProductname("기라의자"); vo.setPrice(350000);
		 * 
		 * int result = dao.updateProduct(vo); System.out.println(result +
		 * "개 updateProduct 성공");
		 */

		// deleteProduct() Test ok
		// int result = dao.deleteProduct(1);
		// System.out.println(result + "개 deleteProduct 성공");

	}
}
