package a.b.c.ch2;

public class Ex_MessageEngImpl implements Ex_MessageInterface {

	@Override
	public void sayHello(String name){
		System.out.println("Hello, " + name + "!!");
	}
}