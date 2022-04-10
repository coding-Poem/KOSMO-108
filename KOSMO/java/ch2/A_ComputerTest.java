package a.b.c.ch2.abc;

import a.b.c.ch2.A_DeskTop;
import a.b.c.ch2.A_MyNoteBook;

public class A_ComputerTest {

	public static void main(String args[]) {
		
		A_DeskTop ad = new A_DeskTop();
		ad.display();
		ad.turnOn();
		ad.turnOff();

		A_MyNoteBook am = new A_MyNoteBook();
		am.display();
		am.typing();
		am.turnOn();
		am.turnOff();

	}
}
/*
C:\00.KOSMO108\10.JExam\ch2>javac -d . A*r.java A*p.java A*k.java A*M*k.java A*t.java

C:\00.KOSMO108\10.JExam\ch2>java a.b.c.ch2.abc.A_ComputerTest
DeskTop display()
전원을 켭니다.
전원을 끕니다.
NoteBook display()
MyNoteBook typing()
전원을 켭니다.
전원을 끕니다.

*/