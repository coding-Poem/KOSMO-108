package a.b.c.ch4.mem.service;

import java.util.ArrayList;

import a.b.c.ch4.mem.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	@Override
	public ArrayList<MemberVO> memSelect() {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl.memSelect() 시작  >>> : ");
		return null;
	}

	@Override
	public int memInsert(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl.memInsert() 시작 >>> : ");
		return 0;
	}

	@Override
	public int memUpdate(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl.memUpdate() 시작  >>> : ");
		return 0;
	}

	@Override
	public int memDelete(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl.memDelete() 시작 >>> : ");
		return 0;
	}

}
