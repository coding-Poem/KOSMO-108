package a.b.c.com.kosmo.common;

import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import com.oreilly.servlet.MultipartRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class FileUploadUtil {
	private String imgfilePaths;
	private int imgfileSize; 
	private String encodeType;	
	private MultipartRequest mr;
	
	Logger logger = LogManager.getLogger(FileUploadUtil.class);

	
	public FileUploadUtil(String imgfilePaths, int imgfileSize, String encodeType) {
		this.imgfilePaths = imgfilePaths;
		this.imgfileSize = imgfileSize;
		this.encodeType = encodeType;		
	}
	
	public boolean imgfileUpload(HttpServletRequest req) {		
		boolean bool = imgfileUpload(req, imgfilePaths);		
		return bool;
	}
	
	public boolean imgfileUploadSize(HttpServletRequest req) {		
		boolean bool = imgfileUploadSize(req, imgfilePaths);		
		return bool;
	}

	public boolean imgfileUpload(HttpServletRequest req, String filePath) {
		boolean bool = false;
		try {
			mr = new MultipartRequest(req, filePath, imgfileSize, encodeType, new FileRename());
			logger.info("FileUploadUtil :: imgfileUpload(HttpServletRequest req, String filePath) :: mr >>> : " + mr);
			bool=true;
		}catch(Exception e) {
			logger.info("FileUploadUtil :: imgfileUpload(HttpServletRequest req, String filePath) 함수 안에서 에러 발생 >>> : " + mr);			
		}		
		return bool;
	}
	
	public boolean imgfileUploadSize(HttpServletRequest req, String filePath) {
		boolean bool = false;
		try {
			mr = new MultipartRequest(req, filePath, imgfileSize, encodeType, new FileRename());
			logger.info("FileUploadUtil :: imgfileUploadSize(HttpServletRequest req, String filePath) :: mr >>> : " + mr);
			logger.info("FileUploadUtil :: imgfileUploadSize(HttpServletRequest req, String filePath) :: mr.getOriginalFileName(\"sbfile\") >>> : " + mr.getOriginalFileName("sbfile"));
			logger.info("FileUploadUtil :: imgfileUploadSize(HttpServletRequest req, String filePath) :: mr.getFilesystemName(\"sbfile\") >>> : " + mr.getFilesystemName("sbfile"));
			
			ThumnailImg.thumnailFun(filePath, mr.getFilesystemName("sbfile"));	
			bool=true;						
		}catch(Exception e) {
			logger.info("FileUploadUtil :: imgfileUploadSize(HttpServletRequest req, String filePath) 함수안에서 에러 발생 >>> : " + e);
			logger.info("mr >>> : "+mr);
		}		
		return bool;
	}
	
	public String getParameter(String s){
		logger.info("FileUploadUtil ::  getParameter(String s) :: s >>> : "+s);
		// FileUploadUtil ::  getParameter(String s) :: s >>> : mid
		logger.info("mr.getParameter(s) >>> : "+mr.getParameter(s));
		// 여기서 여러가 발생한다. :: NullPointerException
		return mr.getParameter(s);
	}
	
	public String[] getParameterValues(String s){
		return mr.getParameterValues(s);		
	}
	
	public String getFileName(String f){
		return mr.getFilesystemName(f);
	}
	
	public ArrayList<String> getFileNames(){
		@SuppressWarnings("unchecked")
		Enumeration<String> en = mr.getFileNames();
		ArrayList<String> a = new ArrayList<String>();
		
		while (en.hasMoreElements()){
			String f = en.nextElement().toString();
			a.add(mr.getFilesystemName(f));
		}		
		return a;
	}
}
