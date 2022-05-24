package a.b.c.com.kosmo.cart.dao;


import java.util.List;

import a.b.c.com.kosmo.cart.vo.KosmoCartVO;

public interface KosmoCartDAO {
	public int kosmoCartInsert(KosmoCartVO cvo);
	public List<KosmoCartVO> kosmoCartSelectAll(KosmoCartVO cvo);
	public int kosmoCartDelete(KosmoCartVO cvo);
}
