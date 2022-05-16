package a.b.c.com.kosmo.common.service;

import a.b.c.com.kosmo.common.dao.ChabunDAO;

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
	private ChabunDAO chabunDAO;
	
	@Autowired(required=false)
	public ChabunServiceImpl(ChabunDAO chabunDAO) {
		this.chabunDAO = chabunDAO;
	}
	
	@Override
	public List getKosmoProductChabun(){
		logger.info("ChabunServiceImpl :: getKosmoProductChabun 함수 진입 >>> : ");
		return chabunDAO.getKosmoProductChabun();
	};
}
