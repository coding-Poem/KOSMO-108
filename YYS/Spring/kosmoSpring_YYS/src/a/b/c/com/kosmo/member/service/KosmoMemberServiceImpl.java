package a.b.c.com.kosmo.member.service;

import a.b.c.com.kosmo.member.dao.KosmoMemberDAO;
import a.b.c.com.kosmo.member.vo.KosmoMemberVO;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KosmoMemberServiceImpl implements KosmoMemberService {
	Logger logger = LogManager.getLogger(KosmoMemberServiceImpl.class);
	
	// 필드위에서 DI
	@Autowired(required=false)
	private KosmoMemberDAO kosmoMemberDAO;
	
	@Override
	public int kosmoMemberInsert(KosmoMemberVO kmvo){
		logger.info("KosmoMemberServiceImpl :: kosmoMemberInsert 함수 진입 >>> : ");
		return kosmoMemberDAO.kosmoMemberInsert(kmvo);
	};
	
	@Override
	public List<KosmoMemberVO> kosmoMemberSelectAll(KosmoMemberVO kmvo){
		logger.info("KosmoMemberServiceImpl :: kosmoMemberSelectAll 함수 진입 >>> : ");
		return kosmoMemberDAO.kosmoMemberSelectAll(kmvo);
	};
	
	@Override
	public List<KosmoMemberVO> kosmoMemberSelect(KosmoMemberVO kmvo){
		logger.info("KosmoMemberServiceImpl :: kosmoMemberSelect 함수 진입 >>> :  ");
		return kosmoMemberDAO.kosmoMemberSelect(kmvo);
	};
	
	@Override
	public int kosmoMemberUpdate(KosmoMemberVO kmvo){
		logger.info("KosmoMemberServiceImpl :: kosmoMemberUpdate 함수 진입 >>> :  ");
		return kosmoMemberDAO.kosmoMemberUpdate(kmvo);
	};
	
	@Override
	public int kosmoMemberDelete(KosmoMemberVO kmvo){
		logger.info("KosmoMemberServiceImpl :: kosmoMemberDelete 함수 진입 >>> :  ");
		return kosmoMemberDAO.kosmoMemberDelete(kmvo);
	};
	
	@Override
	public List<KosmoMemberVO> kosmoIdCheck(KosmoMemberVO kmvo){
		logger.info("KosmoMemberServiceImpl :: kosmoIdCheck 함수 진입 >>> :  ");
		return kosmoMemberDAO.kosmoIdCheck(kmvo);
	};
}
