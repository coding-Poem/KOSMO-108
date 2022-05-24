package a.b.c.com.kosmo.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kosmo.board.dao.KosmoBoardDAO;
import a.b.c.com.kosmo.board.vo.KosmoBoardVO;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@Service
@Transactional
public class KosmoBoardServiceImpl implements KosmoBoardService {
	Logger logger = LogManager.getLogger(KosmoBoardServiceImpl.class);
	
	@Autowired(required=false)
	private KosmoBoardDAO kosmoBoardDAO;
	
	@Override
	public int kosmoBoardInsert(KosmoBoardVO bvo){
		logger.info("KosmoBoardServiceImpl :: kosmoBoardInsert 함수 진입 >>> : ");
		return kosmoBoardDAO.kosmoBoardInsert(bvo);
	};
	
	@Override
	public List<KosmoBoardVO> kosmoBoardSelectAll(KosmoBoardVO bvo){
		logger.info("KosmoBoardServiceImpl :: kosmoBoardSelectAll 함수 진입 >>> : ");
		return kosmoBoardDAO.kosmoBoardSelectAll(bvo);
	};
	
	@Override
	public List<KosmoBoardVO> kosmoBoardSelect(KosmoBoardVO bvo){
		logger.info("KosmoBoardServiceImpl :: kosmoBoardSelect 함수 진입 >>> : ");
		return kosmoBoardDAO.kosmoBoardSelect(bvo);
	};
	
	@Override
	public List<KosmoBoardVO> kosmoBoardPwCheck(KosmoBoardVO bvo){
		logger.info("KosmoBoardServiceImpl :: kosmoBoardPwCheck 함수 진입 >>> : ");
		return kosmoBoardDAO.kosmoBoardPwCheck(bvo);
	};
}
