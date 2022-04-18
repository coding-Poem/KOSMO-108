package a.b.c.common;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileUploadUtil {

	public static final String ENCODE_TYPE = "UTF-8";
	public static final  int SIZE_LIMIT = 5240880;	
	private MultipartRequest m;
	
	public FileUploadUtil(){
		
	}
	public boolean fileUpldad(HttpServletRequest hReq, String filePaths){
		System.out.println("FileUploadUtil :: fileUpldad 시작 >>> ");
		boolean fb = false;
		try{
			m = new MultipartRequest( hReq
                                     ,filePaths
                                     ,FileUploadUtil.SIZE_LIMIT
                                     ,FileUploadUtil.ENCODE_TYPE                                    
									 ,new DefaultFileRenamePolicy());		
			return fb = true;			
		}catch(Exception e){
			System.out.println("FileUploadUtil.fileUpldad() error >>> : " + e);
		}
		
		return fb;		
	}
	
	public boolean fileUpldad3(	HttpServletRequest hReq, 
								String filePaths, 
								int size_limit, 
								String encode_type){
		System.out.println("FileUploadUtil :: fileUpldad3 시작 >>> ");
		boolean fb = false;
		try{
			m = new MultipartRequest( hReq
                                     ,filePaths
                                     ,size_limit
                                     ,encode_type                                     
									 ,new DefaultFileRenamePolicy());
			return fb = true;			
		}catch(Exception e){
			System.out.println("FileUploadUtil.fileUpldad3() error >>> : " + e);
		}
		return fb;		
	}
	
	public String getParameter(String s){
		System.out.println("FileUploadUtil :: getParameter(String s) 시작 >>> ");
		return m.getParameter(s);
	}
	
	public String[] getParameterValues(String s){
		System.out.println("FileUploadUtil :: getParameterValues(String s) 시작 >>> ");
		return m.getParameterValues(s);		
	}
	
	public String getFileName(String f) {
		System.out.println("FileUploadUtil :: getFileName(String f) 시작 >>> ");
		return m.getFilesystemName(f);
	}	
	
	public ArrayList<String> getFileNames(){
		System.out.println("FileUploadUtil :: getFileNames() 시작 >>> ");
		@SuppressWarnings("unchecked")
		Enumeration<String> en = m.getFileNames();
		ArrayList<String> a = new ArrayList<String>();
		
		while (en.hasMoreElements()){
			String f = en.nextElement().toString();
			a.add(m.getFilesystemName(f));
		}		
		return a;
	}
}
