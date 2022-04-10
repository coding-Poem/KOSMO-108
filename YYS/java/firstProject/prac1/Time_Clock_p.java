package a.b.c.prac1;

import java.util.Calendar;
//import java.util.TimeZone;


//@SuppressWarnings("unused")
public class Time_Clock_p implements Runnable{
	
	private Thread thread;
	
	public Time_Clock_p(){
		if(thread==null){
			thread=new Thread(this);
			thread.start();
		}
	}
	
	@Override
	public void run(){
		while(true){
			Calendar cal=Calendar.getInstance();
			String now=cal.get(Calendar.YEAR)+"년"+(cal.get(Calendar.MONTH)+1)+"월"+cal.get(Calendar.DATE)+"일"+cal.get(Calendar.HOUR)+"시"+cal.get(Calendar.MINUTE)+"분"+cal.get(Calendar.SECOND)+"초";
			System.out.println(now);
			try{
				Thread.sleep(1000);
				// 1000은 1초라는 뜻
			}catch(InterruptedException e){
			}
		}
	}
	

	public static void main(String args[]){
		new Time_Clock_p();
	}
}


