package a.b.c.com.kosmo.login.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import a.b.c.com.kosmo.member.vo.KosmoMemberVO;

@Repository
public class KosmoLoginDAOImpl implements KosmoLoginDAO {
	Logger logger = LogManager.getLogger(KosmoLoginDAOImpl.class);
	
	@Autowired(required=false) 
	private SqlSession sqlSession;
	
	@Override
	public List<KosmoMemberVO> kosmoLoginCheck(KosmoMemberVO mvo){
		logger.info("KosmoLoginDAOImpl :: kosmoLoginCheck 함수 진입 >>> : ");
		 return sqlSession.selectList("kosmoLoginCheck", mvo);
	};
}
