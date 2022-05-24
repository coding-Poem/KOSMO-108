package a.b.c.com.kosmo.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kosmo.board.vo.KosmoBoardVO;

@Repository
public class KosmoBoardDAOImpl implements KosmoBoardDAO {
	
	@Autowired(required=false)
	private SqlSession sqlSession;
	
	@Override
	public int kosmoBoardInsert(KosmoBoardVO bvo){
		return  (Integer)sqlSession.insert("kosmoBoardInsert", bvo);
	};
	
	@Override
	public List<KosmoBoardVO> kosmoBoardSelectAll(KosmoBoardVO bvo){
		return sqlSession.selectList("kosmoBoardSelectAll", bvo);
	}
	
	@Override
	public List<KosmoBoardVO> kosmoBoardSelect(KosmoBoardVO bvo){
		return sqlSession.selectList("kosmoBoardSelect", bvo);
	}
	
	@Override
	public List<KosmoBoardVO> kosmoBoardPwCheck(KosmoBoardVO bvo){
		return sqlSession.selectList("kosmoBoardPwCheck", bvo);
	};
}
