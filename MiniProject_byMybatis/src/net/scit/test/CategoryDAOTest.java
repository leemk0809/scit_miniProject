package net.scit.test;

import java.util.List;

import net.scit.dao.CategoryDAO;
import net.scit.vo.CategoryVO;

public class CategoryDAOTest {

	public static void main(String[] args) {
		CategoryDAO dao = new CategoryDAO();    
		
		
		/*insertCategory()    Test ok
		int result = dao.insertCategory(new CategoryVO(3, "����"));
		System.out.println(result + "�� insertCategory() ����");
		*/


		//selectAllCategory()  Test ok
		//List<CategoryVO> list = dao.selectAllCategory();  
		//list.forEach(x->System.out.println(x));
		
		
		
		/*selctOneCategory()   Test ok
		CategoryVO vo = dao.selectOneCategory(1);
		System.out.println(vo);
		*/
		
		
		/*updateCategory()  Test ok
		int num = 1;  
		CategoryVO vo = dao.selectOneCategory(num);
		vo.setCategoryname("����");
		
		int result = dao.updateCategory(vo);
		System.out.println(result + "�� updateCategory ����");
		*/
	
	
		/*deleteCategory()  Test ok
		int result = dao.deleteCategory(1);
		System.out.println(result + "�� deleteCategory ����");
		*/
	}
}
