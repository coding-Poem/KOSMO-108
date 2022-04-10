package a.b.c.prac1;

/*
 * // 메모리 올리는 방법
 * 1. static
 * 2. new
 * 3. 상속
 * 4. getInstance
 * 5. newInstance
 * 
 * 이제까지 1~3번은 많이 사용했지만,
 * 4~5번은 거의 쓰지 않았음.
 * */

import java.lang.reflect.Method;

/*
 * ClassNotFoundException
 * 
 * public class ClassNotFoundException
 * extends ReflectiveOperationException
 * Thrown when an application tries to load in a class through its string name using:
 * The forName method in class Class.
 * The findSystemClass method in class ClassLoader .
 * The loadClass method in class ClassLoader.
 * 
 * As of release 1.4~~~ getException() method is
 * now known as the cause, and may be accessed via the
 * Throwable.getCause()
 * 
 * InstantiationException
 * 
 * public InstantiationException()
 * Thrown when an application tries to create 
 * an instance of a class using the newInstance method 
 * in class Class, but the specified class object cannot 
 * be instantiated.
 * 
 * IllegalAccessException
 * 
 * public class IllegalAccessException
 * 
 * An IllegalAccessException is thrown 
 * when an application tries to reflectively create 
 * an instance (other than an array), set or get a field, 
 * or invoke a method, but the currently executing method 
 * does not have access to the definition of the specified 
 * class, field, method or constructor.
 * */

public class ForName_p {
	public void classForName() throws ClassNotFoundException,
									  InstantiationException,
									  IllegalAccessException{
		// public static Class<?> forName(String className) 
		// throws ClassNotFoundException
		Class cl=Class.forName("a.b.c.prac1.ForNameSample");
		// 해당 명령을 실행하기 위해, ClassNotFoundException,
		// throws 함.
		// Why?????
		// static Class<?> forName(String className)
		// public static Class<?> forName(String className)
        // throws **ClassNotFoundException**
		
		System.out.println("\n 1. Class cl >>> : "+cl);
		// public T newInstance() throws InstantiationException,
		// IllegalAccessException
		ForNameSample fs=(ForNameSample)cl.newInstance();
		// a.b.c.prac1.ForNameSample@15db9742
		// ForNameSample 생성자가 생성됨.
		// 해당 명령어를 실행하기 위해, InstantiationException을 throws 해야 함.
		// Why?
		// public T newInstance()
        // throws **InstantiationException, IllegalAccessException**
		System.out.println("\n 2. ForNameSample fs >>> : "+fs);
		System.out.println("\n 3. fs.aM()");
		fs.aM();
		// ForNameSample 클래스에서 생성자를 만들었으므로, 클래스의 자원을 사용할 수 있다.
		System.out.println("\n 4. fs.bM()");
		fs.bM();
		System.out.println("\n 5. fs.cM()");
		fs.cM();
		// 클래스에 선언된 메소드 찾기
		Method m[]=cl.getDeclaredMethods();
		// Method[] : getDeclared Methods()
		/*public Method[] getDeclaredMethods()
          throws SecurityException
          
          Returns an array containing Method objects
          reflecting all the declared methods of the class
          or interface represented by this Class object,
          including public, protected, default (package) access,
          and private methods, but excluding inherited methods
        */
		for (int i=0; i<m.length; i++){
			String findM=m[i].getName();
			// java.lang.reflect.Method.getName()
			// public String getName()
			// Returns the name of the method represented by this Method object, 
			// as a String.
			System.out.println("m["+i+"].getName() >>> :: "+findM);	
		}
	} // classForName() method

	public static void main(String[] args) throws ClassNotFoundException,
												  InstantiationException,
												  IllegalAccessException{
		new ForName_p().classForName();
		// ForName_p를 인스턴스하고, classForName 메서드 실행
	} // main method
} // ForName_p class
