package net.scit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.scit.vo.BrandVO;
import net.scit.vo.InventoryVO;

public class InventoryDAO {
	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	List<InventoryVO> selectAllInventory(){
		SqlSession session = null;
		session = factory.openSession();
		
		InventoryMapper mapper = session.getMapper(InventoryMapper.class);
		
		return mapper.selectAllInventory();
	}

	void addStock(int productnum, int cnt) {
		SqlSession session = null;
		session = factory.openSession();
		
		InventoryMapper mapper = session.getMapper(InventoryMapper.class);
		
		mapper.addStock(productnum, cnt);
	}
	void subtractStock(int productnum, int cnt) {
		SqlSession session = null;
		session = factory.openSession();
		
		InventoryMapper mapper = session.getMapper(InventoryMapper.class);
		
		mapper.subtractStock(productnum, cnt);
	}

}
