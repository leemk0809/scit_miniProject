package net.scit.test;

import java.util.List;

import net.scit.dao.ProductDAO;
import net.scit.vo.ProductVO;

public class ProductDAOTest {

	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();

		 // insertProduct Test ok
		 //int result = dao.insertProduct(new ProductVO(7, 7, 5, "�轼 ī�᷹��", 550000));
		 //System.out.println(result + "�� insertProducty() ����");
		 

		// selectAllProduct() Test ok
		 List<ProductVO> list = dao.selectAllProduct();
		 list.forEach(x->System.out.println(x));

		// selectOneProduct() Test ok
		// ProductVO vo = dao.selectOneProduct(1);
		// System.out.println(vo);

		// updateProduct() Test ok
		/*
		 * int num = 1; ProductVO vo = dao.selectOneProduct(num);
		 * vo.setProductname("�������"); vo.setPrice(350000);
		 * 
		 * int result = dao.updateProduct(vo); System.out.println(result +
		 * "�� updateProduct ����");
		 */

		// deleteProduct() Test ok
		// int result = dao.deleteProduct(1);
		// System.out.println(result + "�� deleteProduct ����");

	}
}
