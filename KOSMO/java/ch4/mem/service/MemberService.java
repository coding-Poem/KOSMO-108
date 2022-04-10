package a.b.c.ch4.mem.service;

import java.util.ArrayList;

import a.b.c.ch4.mem.vo.MemberVO;

public interface MemberService {

	// 회원 가입, 수정, 삭제, 조회
	public ArrayList<MemberVO> memSelect();
	public int memInsert(MemberVO mvo);
	public int memUpdate(MemberVO mvo);
	public int memDelete(MemberVO mvo);
}
