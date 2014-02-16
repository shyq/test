package one.instanceofc;

import java.util.Date;

/**
 * instanceof 非预期结果
 * @author Chain
 * 只要instanceof左右两端的操作数有继承或者实现关系，编译就能 通过
 */
public class Client {
	
	public static void main(String[] args) {
		//String对象是否是Object的实例
		boolean b1 = "String" instanceof Object;
		
		//
		boolean b2 = new String() instanceof Object;
		
		boolean b3 = new Object() instanceof String;
		
		//'A'是一个char类型，也就是一个基本类型，不是一个对象， instanceof只能用于对象的判断
//		boolean b4 = 'A' instanceof Character;
		
		//若左操作数为null 则直接返回false
		boolean b5 = null instanceof String;
		
		//null是一个万用类型，也可以说没有类型，即使做强制转换后还是null
		boolean b6 = (String)null instanceof String;
		
		//编译不能通过 Date和String没有继承或实现关系
//		boolean b7 = new Date() instanceof String;
		
		//false java中的泛型是为编码服务的，在编译成字节码时，T已经是个Object类型了。
		//T的表面上是Object类型，实际上是String类型 "t instanceof Date" 相当于"Object instanceof Date"
		boolean b8 =  new GenericClass<String>().isInstanceofDate("");
		
		System.out.println("b1:" + b1);
		System.out.println("b2:" + b2);
		System.out.println("b3:" + b3);
		System.out.println("b5:" + b5);
		System.out.println("b6:" + b6);
		System.out.println("b8:" + b8);
	}
	
}

class GenericClass<T>{
	public boolean isInstanceofDate(T t){
		return t instanceof Date;
	}
}

