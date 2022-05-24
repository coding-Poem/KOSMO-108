package a.b.c.com.kosmo.common.dao;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import a.b.c.com.kosmo.board.vo.KosmoBoardVO;
import a.b.c.com.kosmo.cart.vo.KosmoCartVO;
import a.b.c.com.kosmo.member.vo.KosmoMemberVO;
import a.b.c.com.kosmo.product.vo.KosmoProductVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChabunDAOImpl implements ChabunDAO {
	
	private Logger logger = Logger.getLogger(ChabunDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<KosmoProductVO> getKosmoProductChabun(){
		logger.info("ChabunDAOImpl :: getKosmoProductChabun 함수 진입 >>> : ");
		return sqlSession.selectList("getKosmoProductChabun");
	};
	
	@Override
	public List<KosmoMemberVO> getKosmoMemberChabun(){
		logger.info("ChabunDAOImpl :: getKosmoProductChabun 함수 진입 >>> : ");
		return sqlSession.selectList("getKosmoMemberChabun");
	};
	
	@Override
	public List<KosmoCartVO> getKosmoCartChabun(){
		logger.info("ChabunDAOImpl :: getKosmoCartChabun 함수 진입 >>> : ");
		return sqlSession.selectList("getKosmoCartChabun");
	};
	
	@Override
	public List<KosmoBoardVO> getKosmoBoardChabun(){
		logger.info("ChabunDAOImpl :: getKosmoBoardChabun 함수 진입 >>> : ");
		return sqlSession.selectList("getKosmoBoardChabun");
	};
}
