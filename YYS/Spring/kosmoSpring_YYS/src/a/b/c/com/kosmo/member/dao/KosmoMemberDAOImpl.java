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
	
	public int kosmoMemberInsert(KosmoMemberVO kmvo){
		return (Integer)sqlSession.insert("kosmoMemberInsert", kmvo);
	};
	
	public List<KosmoMemberVO> kosmoMemberSelectAll(KosmoMemberVO kmvo){
		return sqlSession.selectList("kosmoMemberSelectAll");
	};
}
