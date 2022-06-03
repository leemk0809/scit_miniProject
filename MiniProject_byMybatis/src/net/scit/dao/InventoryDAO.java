package net.scit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.scit.vo.BrandVO;
import net.scit.vo.InventoryVO;

public class InventoryDAO {
	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	public List<InventoryVO> selectAllInventory(int brandnum){
		SqlSession session = null;
		session = factory.openSession();
		
		InventoryMapper mapper = session.getMapper(InventoryMapper.class);
		
		return mapper.selectAllInventory(brandnum);
	}
	
	public int insertInventory(int productnum, int stock) {
		SqlSession session = null;
		session = factory.openSession();
		
		InventoryMapper mapper = session.getMapper(InventoryMapper.class);
		
		int result = mapper.insertInventory(productnum, stock);
		
		if(result != -1) {
			session.commit();
		}
		
		return result;
	}

	public int addStock(int productnum, int stockCnt) {
		SqlSession session = null;
		session = factory.openSession();
		
		InventoryMapper mapper = session.getMapper(InventoryMapper.class);
		
		int result = mapper.addStock(productnum, stockCnt);
		if(result != -1)
			session.commit();
		
		return result;
	}
	public int subtractStock(int productnum, int stockCnt) {
		SqlSession session = null;
		session = factory.openSession();
		
		InventoryMapper mapper = session.getMapper(InventoryMapper.class);
		
		int result = mapper.subtractStock(productnum, stockCnt);
		if(result != -1)
			session.commit();
		
		return result;
	}
}
