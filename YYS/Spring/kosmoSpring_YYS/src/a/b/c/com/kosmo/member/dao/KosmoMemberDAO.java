package a.b.c.com.kosmo.member.dao;

import java.util.List;

import a.b.c.com.kosmo.member.vo.KosmoMemberVO;

public interface KosmoMemberDAO {
	public int kosmoMemberInsert(KosmoMemberVO kmvo);
	public List<KosmoMemberVO> kosmoMemberSelectAll(KosmoMemberVO kmvo);
}
