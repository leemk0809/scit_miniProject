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
		vo.setBrandname("스티치");
		vo.setEmail("abc");
		vo.setManagername("기라쌤");
		
		int result = dao.updateBrand(vo);
		System.out.println(result + "개 updateBrand 성공!");
		*/
		
		
		
		//deleteBrand() Test 보류
		/*
		int brandnum = 3;
		List<ProductVO> plist = pdao.selectAllProduct();
				
		for(ProductVO p : plist) {
			if(p.getBrandnum() == brandnum) 
				pdao.deleteProduct(p.getProductnum());
		}
		
		int result = dao.deleteBrand(brandnum);
		System.out.println(result + "개 deleteBrand 성공!");
		*/
		
		
	}
}
