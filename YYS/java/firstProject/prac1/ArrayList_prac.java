package a.b.c.prac1;

import java.util.ArrayList;

public class ArrayList_prac {

	public static void main(String[] args) {
		ArrayList lArr=new ArrayList();
		lArr.add(1);
		lArr.add(2);
		lArr.add("»ï");
		lArr.add(1.0);
		lArr.add(false);
		lArr.add('c');
		lArr.add(1234l);
		lArr.add(1.000f);
		lArr.add(2.000d);
		
		for (int l=0; l<lArr.size(); l++) {
			System.out.print(lArr.get(l)+", ");
		}
	}
}
