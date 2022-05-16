package a.b.c.com.kosmo.product.dao;

import a.b.c.com.kosmo.product.vo.KosmoProductVO;
import java.util.List;

public interface KosmoProductDAO {
	public int kosmoProductInsert(KosmoProductVO kvo);	
	public List kosmoProductSelectAll();
	public List kosmoProductSelect(KosmoProductVO kvo);
}
