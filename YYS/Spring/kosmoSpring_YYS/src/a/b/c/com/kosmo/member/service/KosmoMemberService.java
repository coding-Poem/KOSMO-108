package a.b.c.com.kosmo.member.service;

import java.util.List;

import a.b.c.com.kosmo.member.vo.KosmoMemberVO;

public interface KosmoMemberService {
	public int kosmoMemberInsert(KosmoMemberVO kmvo);
	public List<KosmoMemberVO> kosmoMemberSelectAll(KosmoMemberVO kmvo);
}
