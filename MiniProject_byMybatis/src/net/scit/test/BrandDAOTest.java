package net.scit.test;

import java.util.List;

import net.scit.dao.BrandDAO;
import net.scit.dao.ProductDAO;
import net.scit.vo.ProductVO;

public class BrandDAOTest {

	public static void main(String[] args) {
		BrandDAO dao = new BrandDAO();
		ProductDAO pdao = new ProductDAO();
			
		//selecAllBrand() Test ok
		//List<BrandVO> list =  dao.selectAllBrand();
		//list.forEach(x->System.out.println(x));
		
		//selecOneBrand() Test ok
		//BrandVO vo = dao.selectOneBrand(1);
		//System.out.println(vo);
		
		//updateBrand() Test ok
		/*
		int brandnum = 3;
		BrandVO vo = dao.selectOneBrand(brandnum);
		vo.setBrandname("��Ƽġ");
		vo.setEmail("abc");
		vo.setManagername("����");
		
		int result = dao.updateBrand(vo);
		System.out.println(result + "�� updateBrand ����!");
		*/
		
		
		
		//deleteBrand() Test ����
		/*
		int brandnum = 3;
		List<ProductVO> plist = pdao.selectAllProduct();
				
		for(ProductVO p : plist) {
			if(p.getBrandnum() == brandnum) 
				pdao.deleteProduct(p.getProductnum());
		}
		
		int result = dao.deleteBrand(brandnum);
		System.out.println(result + "�� deleteBrand ����!");
		*/
		
		
	}
}
