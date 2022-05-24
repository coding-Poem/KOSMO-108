package a.b.c.com.kosmo.common.service;

import a.b.c.com.kosmo.board.vo.KosmoBoardVO;
import a.b.c.com.kosmo.cart.vo.KosmoCartVO;
import a.b.c.com.kosmo.common.dao.ChabunDAO;
import a.b.c.com.kosmo.member.vo.KosmoMemberVO;
import a.b.c.com.kosmo.product.vo.KosmoProductVO;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ChabunServiceImpl implements ChabunService {
	private Logger logger = Logger.getLogger(ChabunServiceImpl.class);
	
	@Autowired(required=false)
	private ChabunDAO chabunDAO;
	
	/*
	public ChabunServiceImpl(ChabunDAO chabunDAO) {
		this.chabunDAO = chabunDAO;
	}
	*/
	
	@Override
	public List<KosmoProductVO> getKosmoProductChabun(){
		logger.info("ChabunServiceImpl :: getKosmoProductChabun 함수 진입 >>> : ");
		return chabunDAO.getKosmoProductChabun();
	};
	
	@Override
	public List<KosmoMemberVO> getKosmoMemberChabun(){
		logger.info("ChabunServiceImpl :: getKosmoMemberChabun 함수 진입 >>> : ");
		return chabunDAO.getKosmoMemberChabun();
	};
	
	@Override
	public List<KosmoCartVO> getKosmoCartChabun(){
		logger.info("ChabunServiceImpl :: getKosmoCartChabun 함수 진입 >>> : ");
		return chabunDAO.getKosmoCartChabun();
	};
	
	@Override
	public List<KosmoBoardVO> getKosmoBoardChabun(){
		logger.info("ChabunServiceImpl :: getKosmoBoardChabun 함수 진입 >>> : ");
		return chabunDAO.getKosmoBoardChabun();
	};
}
