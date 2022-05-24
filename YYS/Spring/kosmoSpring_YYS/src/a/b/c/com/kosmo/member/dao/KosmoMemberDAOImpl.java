package a.b.c.com.kosmo.member.dao;

import a.b.c.com.kosmo.member.vo.KosmoMemberVO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class KosmoMemberDAOImpl implements KosmoMemberDAO {
	
	@Autowired(required=false)
	private SqlSession sqlSession;
	
	@Override
	public int kosmoMemberInsert(KosmoMemberVO kmvo){
		return (Integer)sqlSession.insert("kosmoMemberInsert", kmvo);
	};
	
	@Override
	public List<KosmoMemberVO> kosmoMemberSelectAll(KosmoMemberVO kmvo){
		return sqlSession.selectList("kosmoMemberSelectAll");
	};
	
	@Override
	public List<KosmoMemberVO> kosmoMemberSelect(KosmoMemberVO kmvo){
		return sqlSession.selectList("kosmoMemberSelect");
	};
	
	@Override
	public int kosmoMemberUpdate(KosmoMemberVO kmvo){
		return (Integer)sqlSession.update("kosmoMemberUpdate", kmvo);
	};
	
	@Override
	public int kosmoMemberDelete(KosmoMemberVO kmvo) {
		return (Integer)sqlSession.update("kosmoMemberDelete", kmvo);	
	};
	
	@Override
	public List<KosmoMemberVO> kosmoIdCheck(KosmoMemberVO kmvo){
		return sqlSession.selectList("kosmoIdCheck");
	};
}
