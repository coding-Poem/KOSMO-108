package a.b.c.com.kosmo.common;

public abstract class CommonUtils {
	
	// 이미지 넣는 경로
	// 상품 이미지 넣는 경로
	public static final String BOARD_IMG_UPLOAD_PATH="C:\\00.KOSMO108\\30.Web\\eclipse_kosmo_spring_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\kosmoSpring_YYS\\fileupload\\board";
	public static final int BOARD_IMG_FILE_SIZE = 2*1024*1024; // 2MB
	public static final String BOARD_EN_CODE = "UTF-8";
	
	// 회원 이미지 넣는 경로
	public static final String MEMBER_IMG_UPLOAD_PATH="C:\\00.KOSMO108\\30.Web\\eclipse_kosmo_spring_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\kosmoSpring_YYS\\fileupload\\member";
	
	// 상품 페이징  
	public static final int PRODUCT_PAGE_SIZE = 3;
	public static final int PRODUCT_GROUP_SIZE = 3;
	public static final int PRODUCT_CUR_PAGE = 1;
	public static final int PRODUCT_TOTAL_COUNT = 0;
	
	// 게시판 이미지 경로
	public static final String BOARD2_IMG_UPLOAD_PATH="C:\\00.KOSMO108\\30.Web\\eclipse_kosmo_spring_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\kosmoSpring_YYS\\fileupload\\board2";
	public static final int BOARD2_IMG_FILE_SIZE = 2*1024*1024; // 2MB
	public static final String BOARD2_EN_CODE = "UTF-8";
}
