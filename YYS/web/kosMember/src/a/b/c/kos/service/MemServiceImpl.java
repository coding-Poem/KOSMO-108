package a.b.c.kos.service;

import java.util.ArrayList;

import a.b.c.kos.dao.MemDAO;
import a.b.c.kos.dao.MemDAOImpl;
import a.b.c.kos.vo.MemVO;

public class MemServiceImpl implements MemService{
	// **DQL :: SELECT**
	@Override
	public ArrayList<MemVO> memSelectAll(){
		System.out.println("MemServiceImpl :: memSelectAll() :: Start");
		
		MemDAO mdao= new MemDAOImpl();
		return mdao.memSelectAll();
	};
	@Override
	public ArrayList<MemVO> memSelectNum(MemVO mvo){
		System.out.println("MemServiceImpl :: memSelectNum() :: Start");
		
		MemDAO mdao= new MemDAOImpl();	
		return mdao.memSelectNum(mvo);
	};
	@Override
	public ArrayList<MemVO> memSelectName(MemVO mvo){
		System.out.println("MemServiceImpl :: memSelectName() :: Start");
		
		MemDAO mdao= new MemDAOImpl();
		return mdao.memSelectName(mvo);
	};
	@Override
	public ArrayList<MemVO> memSelectDate(MemVO mvo){
		System.out.println("MemServiceImpl :: memSelectDate() :: Start");
		
		MemDAO mdao= new MemDAOImpl();
		return mdao.memSelectDate(mvo);
	};
	
	// **DML :: INSERT, UPDATE, DELETE**
	@Override
	public boolean memInsert(MemVO mvo){
		System.out.println("MemServiceImpl :: memInsert() :: Start");
		MemVO.printlnMemVO(mvo);
		
		MemDAO mdao= new MemDAOImpl();
		return mdao.memInsert(mvo);
	};
	@Override
	public boolean memUpdate(MemVO mvo){
		System.out.println("MemServiceImpl :: memUpdate() :: Start");
		MemVO.printlnMemVO(mvo);
		
		MemDAO mdao= new MemDAOImpl();
		return mdao.memUpdate(mvo);
	};
	@Override
	public boolean memDelete(MemVO mvo){
		System.out.println("MemServiceImpl :: memDelete() :: Start");
		System.out.println("\n MemServiceImpl :: 삭제할 회원 번호 >>> : "+mvo.getMnum());
		
		MemDAO mdao= new MemDAOImpl();
		return mdao.memDelete(mvo);
	};
} // end of class MemServiceImpl
