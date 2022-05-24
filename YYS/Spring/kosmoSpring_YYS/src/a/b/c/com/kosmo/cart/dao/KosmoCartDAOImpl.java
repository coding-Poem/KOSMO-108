package a.b.c.com.kosmo.cart.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kosmo.cart.vo.KosmoCartVO;


@Repository
public class KosmoCartDAOImpl implements KosmoCartDAO {
	
	@Autowired(required=false)
	private SqlSession sqlSession;
	
	@Override
	public int kosmoCartInsert(KosmoCartVO cvo){
		return (Integer)sqlSession.insert("kosmoCartInsert", cvo);
	};
	
	@Override
	public List<KosmoCartVO> kosmoCartSelectAll(KosmoCartVO cvo){
		
		return sqlSession.selectList("kosmoCartSelectAll");
	}
	
	@Override
	public int kosmoCartDelete(KosmoCartVO cvo){
		return sqlSession.update("kosmoCartDelete");
	};
	
}
