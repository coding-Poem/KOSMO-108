package a.b.c.kos.mem.service;

import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import a.b.c.kos.mem.dao.MemDAO;
import a.b.c.kos.mem.dao.MemDAOImpl;
import a.b.c.kos.mem.vo.MemVO;


public class MemServiceImpl implements MemService{
	Logger logger=LogManager.getLogger(MemServiceImpl.class);
	
	// **DQL :: SELECT**
	@Override
    public ArrayList<MemVO> memSelectAll(MemVO mvo){
    	logger.info("MemServiceImpl :: memSelectAll(MemVO mvo) 함수 진입 >>> : ");
		
    	MemDAO mdao=new MemDAOImpl();
    	return mdao.memSelectAll(mvo);
    };
    @Override
    public ArrayList<MemVO> memSelect(MemVO mvo){
    	logger.info("MemServiceImpl :: memSelect(MemVO mvo) 함수 진입 >>> : ");
    	
    	MemDAO mdao=new MemDAOImpl();
    	return mdao.memSelect(mvo);
    };
    
    // **DML :: INSERT, UPDATE, DELETE**
    @Override
    public boolean memInsert(MemVO mvo){
    	logger.info("MemServiceImpl :: memInsert(MemVO mvo) 함수 진입 >>> : ");
    	
    	MemDAO mdao=new MemDAOImpl();
    	return mdao.memInsert(mvo);
    };
    
    @Override
    public boolean memUpdate(MemVO mvo){
    	logger.info("MemServiceImpl :: memSelectAll() 함수 진입 >>> : ");
    	
    	MemDAO mdao=new MemDAOImpl();
    	return mdao.memUpdate(mvo);
    };
    
    @Override
    public boolean memDelete(MemVO mvo){
    	logger.info("MemServiceImpl :: memDelete(MemVO mvo) 함수 진입 >>> : ");
    	
    	MemDAO mdao=new MemDAOImpl();
    	return mdao.memDelete(mvo);
    };
}
