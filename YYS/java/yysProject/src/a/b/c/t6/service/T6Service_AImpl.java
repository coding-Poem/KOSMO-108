package a.b.c.t6.service;

import java.util.ArrayList;

import a.b.c.t6.dao.T6DAO_A;
import a.b.c.t6.dao.T6DAO_AImpl;
import a.b.c.t6.vo.T6VO;

public class T6Service_AImpl implements T6Service_A{
	@Override
	public ArrayList<T6VO> t6SelectAll(){
		System.out.println("T6Service_AImpl :: t6SelectAll() 시작");
		
		T6DAO_A tdao= new T6DAO_AImpl();
		return tdao.t6SelectAll();
	};
	
	@Override
	public ArrayList<T6VO> t6SelectName(T6VO tvo){
		System.out.println("T6Service_AImpl :: t6SelectName(T6VO tvo) 시작");
		T6DAO_A tdao=new T6DAO_AImpl();
		return tdao.t6SelectName(tvo);
	};
	
	@Override
	public ArrayList<T6VO> t6SelectDate(T6VO tvo){
		System.out.println("T6Service_AImpl :: t6SelectDate(T6VO tvo) 시작");
		T6DAO_A tdao=new T6DAO_AImpl();
		return tdao.t6SelectDate(tvo);
	};
	
	public boolean t6Insert(T6VO tvo) {};
	public boolean t6Update(T6VO tvo) {};
	public boolean t6Delete(T6VO tvo) {};
}
