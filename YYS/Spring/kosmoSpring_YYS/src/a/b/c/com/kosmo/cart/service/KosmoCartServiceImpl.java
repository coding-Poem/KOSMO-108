package a.b.c.com.kosmo.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kosmo.cart.dao.KosmoCartDAO;
import a.b.c.com.kosmo.cart.vo.KosmoCartVO;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@Service
@Transactional
public class KosmoCartServiceImpl implements KosmoCartService {
	Logger logger = LogManager.getLogger(KosmoCartServiceImpl.class);
	
	// 필드위에서 DI
	@Autowired(required=false)
	private KosmoCartDAO kosmoCartDAO;
	
	@Override
	public int kosmoCartInsert(KosmoCartVO cvo){
		logger.info("KosmoCartServiceImpl :: kosmoCartInsert 함수 진입 >>> : ");
		return kosmoCartDAO.kosmoCartInsert(cvo);
	};
	
	@Override
	public List<KosmoCartVO> kosmoCartSelectAll(KosmoCartVO cvo){
		logger.info("KosmoCartServiceImpl :: kosmoCartSelectAll 함수 진입 >>> : ");
		return kosmoCartDAO.kosmoCartSelectAll(cvo);
	};
	
	@Override
	public int kosmoCartDelete(KosmoCartVO cvo){
		logger.info("KosmoCartServiceImpl :: kosmoCartDelete 함수 진입 >>> : ");
		return kosmoCartDAO.kosmoCartDelete(cvo);
	};

}
