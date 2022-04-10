package a.b.c.test;

import java.net.URL;
import java.net.MalformedURLException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;

public class URLTest{

	public static void main(String args[]){
	
//		String url = "https://www.naver.com";
		String url = "http://localhost:8088/kosMember/kos_css/css_02_boxmodel.html";

		try
		{
			URL u = new URL(url);
			System.out.println("u >>> : " + u);			
			System.out.println("u >>> : " + u.openStream());
			BufferedReader br = new BufferedReader(
				new InputStreamReader(u.openStream(), "UTF-8")); 
			// UTF-8, EUC-KR, ISO-8859-1
			System.out.println("br >>> : " + br);
			String inLine = "";

			BufferedWriter bw = new BufferedWriter(new FileWriter("css_02_boxmodel.html")); 
			while ((inLine=br.readLine()) !=null)
			{
				System.out.println(inLine);
				bw.write(inLine);
			}
			bw.flush();
			br.close();
			bw.close();
		}
		catch (Exception m)
		{
			System.out.println("m >>> : " + m);
		}	
	}
}