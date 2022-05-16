package a.b.c.com.kosmo.product.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.apache.ibatis.session.SqlSession;

import a.b.c.com.kosmo.product.vo.KosmoProductVO;
import java.util.List;

@Repository
public class KosmoProductDAOImpl implements KosmoProductDAO {
	
	@Autowired(required=false)
	private SqlSession sqlSession;
				
	@Override
	public int kosmoProductInsert(KosmoProductVO kvo) {
			
			return (Integer)sqlSession.insert("kosmoProductInsert", kvo);
		}
	
	@Override
	public List kosmoProductSelectAll(){
		
		return sqlSession.selectList("kosmoProductSelectAll");
	};
	
	
	@Override
	public List kosmoProductSelect(KosmoProductVO kvo){
		
		return sqlSession.selectList("kosmoProductSelect", kvo);
	};
	
}
