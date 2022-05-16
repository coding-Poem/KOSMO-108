package a.b.c.com.kosmo.common.dao;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import a.b.c.com.kosmo.product.vo.KosmoProductVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChabunDAOImpl implements ChabunDAO {
	
	private Logger logger = Logger.getLogger(ChabunDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List getKosmoProductChabun(){
		logger.info("ChabunDAOImpl :: getKosmoProductChabun 함수 진입 >>> : ");
		return sqlSession.selectList("getKosmoProductChabun");
	};
}
