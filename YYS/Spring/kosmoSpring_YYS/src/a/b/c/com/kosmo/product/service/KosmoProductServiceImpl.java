package a.b.c.com.kosmo.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import a.b.c.com.kosmo.product.dao.KosmoProductDAO;
import a.b.c.com.kosmo.product.vo.KosmoProductVO;

@Service
@Transactional
public class KosmoProductServiceImpl implements KosmoProductService {
	Logger logger = Logger.getLogger(KosmoProductServiceImpl.class);
	
	// 서비스에서 DAO 연결하기
	// 필드에 @Autowired 어노테이션으로 DI(의존성 주입하기)
	@Autowired(required=false)
	private KosmoProductDAO kosmoProductDAO;
	
	@Override
	public int kosmoProductInsert(KosmoProductVO kvo){
		logger.info("KosmoProductServiceImpl :: kosmoProductInsert 함수 진입 >>> : ");
		return kosmoProductDAO.kosmoProductInsert(kvo);
	}
	
	@Override
	public List kosmoProductSelectAll(){
		logger.info("KosmoProductServiceImpl :: kosmoProductSelectAll 함수 진입 >>> : ");
		return kosmoProductDAO.kosmoProductSelectAll();
	};
	
	
	@Override
	public List kosmoProductSelect(KosmoProductVO kvo){
		logger.info("KosmoProductServiceImpl :: kosmoProductSelect 함수 진입 >>> : ");
		return kosmoProductDAO.kosmoProductSelect(kvo);
	};
	
}
