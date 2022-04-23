package a.b.c.test.xml_p;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.util.ArrayList;

public class TestClass {
	public void test(){
		Logger logger = LogManager.getLogger(TestClass.class);
		logger.info("a.b.c.test.xml.TestClass 클래스에 있는 test() 메소드 입니다.");
		logger.info("Hello >>>>>>>>>> : ");
		
		ArrayList<String> aList=new ArrayList<String>();
		aList.add("윤요섭");
		aList.add("강민");
		aList.add("김별");
		aList.add("박건원");
		aList.add("박성훈");
		aList.add("성연제");
				
		for (int i=0; i<aList.size(); i++){
			logger.info(" >>> : "+aList.get(i));
		}
		
	}
	public static void main(String args[]){
		TestClass tc= new TestClass();
		tc.test();
	}
}
