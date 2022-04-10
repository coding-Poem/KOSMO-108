package a.b.c.ch2.aa;

public class Class_A  extends java.lang.Object{

	public Class_A() {
		System.out.println("Class_A() 생성자 >>> : ");
	}

	public Class_A(String s) {
		System.out.println("Class_A(String s 생성자 >>> : " + s);
	}


	public void class_a_1(){
		System.out.println("Class_A().class_a_1() 함수 >>> : ");
	}

	public String class_a_2(){
		System.out.println("Class_A().class_a_2() 함수 >>> : ");

		return "class_a_2() 함수 >>> : ";
	}

	/*
	java.lang.Object
	public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
	*/
	/*
	@Override
	public String toString(){
		return "Class_A().toString() 함수 >>> : ";
	}
	*/
}