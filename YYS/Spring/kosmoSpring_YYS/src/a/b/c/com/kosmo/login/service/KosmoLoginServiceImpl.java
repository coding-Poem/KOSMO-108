package a.b.c.com.kosmo.login.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kosmo.login.dao.KosmoLoginDAO;
import a.b.c.com.kosmo.member.vo.KosmoMemberVO;

@Service
@Transactional
public class KosmoLoginServiceImpl implements KosmoLoginService {
	Logger logger = LogManager.getLogger(KosmoLoginServiceImpl.class);
	
	@Autowired(required=false)
	private KosmoLoginDAO kosmoLoginDAO;
	
	@Override
	public List<KosmoMemberVO> kosmoLoginCheck(KosmoMemberVO mvo){
		logger.info("KosmoLoginServiceImpl :: kosmoLoginCheck 함수 진입 >>> :  ");
		return kosmoLoginDAO.kosmoLoginCheck(mvo);
	};
}
