package net.scit.test;

import java.util.List;

import net.scit.dao.BrandDAO;
import net.scit.vo.BrandVO;

public class BrandDAOTest {

	public static void main(String[] args) {
		BrandDAO dao = new BrandDAO();
			
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
		
		
		
		//deleteBrand() Test 
		/*
		int result = dao.deleteBrand(3);
		System.out.println(result + "�� deleteBrand ����!");
		*/
		
		
	}
}
