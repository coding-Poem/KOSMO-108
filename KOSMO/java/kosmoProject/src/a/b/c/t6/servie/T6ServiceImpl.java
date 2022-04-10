package a.b.c.t6.servie;

import java.util.ArrayList;

import a.b.c.t6.dao.T6DAO;
import a.b.c.t6.dao.T6DAOImpl;
import a.b.c.t6.vo.T6VO;

public class T6ServiceImpl implements T6Service {

	@Override
	public ArrayList<T6VO> t6SelectAll() {
		// TODO Auto-generated method stub
		System.out.println("T6ServiceImpl.t6SelectAll >>> :");
		
		T6DAO tdao = new T6DAOImpl();
		return tdao.t6SelectAll();
	}

	@Override
	public ArrayList<T6VO> t6SelectName(T6VO tvo) {
		// TODO Auto-generated method stub
		System.out.println("T6ServiceImpl.t6SelectAll >>> :");
		
		T6DAO tdao = new T6DAOImpl();
		return tdao.t6SelectName(tvo);
	}

	@Override
	public ArrayList<T6VO> t6SelectDate(T6VO tvo) {
		// TODO Auto-generated method stub
		System.out.println("T6ServiceImpl.t6SelectAll >>> :");
		
		T6DAO tdao = new T6DAOImpl();
		return tdao.t6SelectDate(tvo);
	}

	// 입력하기 
	@Override
	public boolean t6Insert(T6VO tvo) {
		// TODO Auto-generated method stub
		System.out.println("T6ServiceImpl.t6Insert >>> : tvo " + tvo);
		T6VO.printlnT6VO(tvo);
		
		T6DAO tdao = new T6DAOImpl();
		return tdao.t6Insert(tvo);
	}

	// 수정하기 
	@Override
	public boolean t6Update(T6VO tvo) {
		// TODO Auto-generated method stub
		System.out.println("T6ServiceImpl.t6Update >>> : tvo " + tvo);
		T6VO.printlnT6VO(tvo);
		
		T6DAO tdao = new T6DAOImpl();
		return tdao.t6Update(tvo);
	}

	// 삭제하기 
	@Override
	public boolean t6Delete(T6VO tvo) {
		// TODO Auto-generated method stub
		System.out.println("T6ServiceImpl.t6Delete >>> : tvo " + tvo);
		T6VO.printlnT6VO(tvo);
		
		T6DAO tdao = new T6DAOImpl();
		return tdao.t6Delete(tvo);
	}
}
