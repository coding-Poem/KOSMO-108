package a.b.c.ch3;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello JAVA ");
		 
		HelloInterface hif = new HelloInterfaceImpl();
		hif.InterfaceFunc();
		
		HelloVO hvo = new HelloVO();
		hvo.setMid("SMJ");
		hvo.setMpw("SMJ000");
		hvo.setMname("º≠πŒ¡§");
		
		System.out.print(hvo.getMid() + "	");
		System.out.print(hvo.getMpw() + "	");
		System.out.println(hvo.getMname());
		
	}
}
