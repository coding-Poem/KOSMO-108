package a.b.c.com.kosmo.product.dao;

import a.b.c.com.kosmo.product.vo.KosmoProductVO;
import java.util.List;

public interface KosmoProductDAO {
	public int kosmoProductInsert(KosmoProductVO kvo);	
	public List<KosmoProductVO> kosmoProductSelectAll(KosmoProductVO kvo);
	public List<KosmoProductVO> kosmoProductSelect(KosmoProductVO kvo);
	// 상품조회
	public List<KosmoProductVO> kosmoProductMSelect(KosmoProductVO kvo);
	public int kosmoProductUpdate(KosmoProductVO kvo);
	public int kosmoProductDelete(KosmoProductVO kvo);
}
