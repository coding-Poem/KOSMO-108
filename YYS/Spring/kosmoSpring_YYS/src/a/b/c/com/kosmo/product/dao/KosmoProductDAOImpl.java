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
	public List<KosmoProductVO> kosmoProductSelectAll(KosmoProductVO kvo){
		
		return sqlSession.selectList("kosmoProductSelectAll");
	};
	
	
	@Override
	public List<KosmoProductVO> kosmoProductSelect(KosmoProductVO kvo){
		
		return sqlSession.selectList("kosmoProductSelect", kvo);
	};
	
	@Override
	public List<KosmoProductVO> kosmoProductMSelect(KosmoProductVO kvo){
		return sqlSession.selectList("kosmoProductMSelect", kvo);
	};
	
	@Override
	public int kosmoProductUpdate(KosmoProductVO kvo){
		
		return (Integer)sqlSession.update("kosmoProductUpdate", kvo);
	};
	
	@Override
	public int kosmoProductDelete(KosmoProductVO kvo){
		
		return (Integer)sqlSession.update("kosmoProductDelete", kvo);
	};
	
}
