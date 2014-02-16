package seven;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericT {

	public static void main(String[] args) {
	//List<Integer> ls = Arrays.<Integer>asList();
		//泛型数组初始化时不能声明泛型类型  ，执行了类型擦出操作
		//List<String>[] 跟List<Object>[] 相同
//		List<String>[] list = new List<String>[];
		//泛型类型的class对象是相同的。
//		List<String> list1 = new ArrayList<String>();
//		List<Integer> list2 = new ArrayList<Integer>();
//		System.out.println(list1.getClass() == list2.getClass());  //true
		
		//instanceof 不允许存在泛型参数
		//Cannot perform instanceof check against parameterized type List<String>.
		//Use the form List<?> instead since further generic type information will be erased at runtime
//		List<String> list = new ArrayList<String>();
//		System.out.println(list instanceof List<String>);
	}
	
//	public void dosomething(List<String> ls){}
//	public void dosomething(List<Integer> ls){}
	
}

/**
 * 编译器在编译时要获取T类型，泛型类型在编译期已经被擦除了
 *  所以 T(); new T[5];都会报错
 *  
 *  ArrayList表面上是泛型，在编译期已经转为Object了
 *  
 *  类的成员变量是在类初始化前初始化的，所以要求在初始化前它必须具有明确的类型，
 *  否则就只能声明，不能初始化。
 *  
 * @author Chain
 *
 * @param <T>
 */
class Foot<T>{
	//Cannot instantiate the type T
//	private T t = new T();
//	//Cannot create a generic array of T
//	private T[] tArray = new T[5];
//	private List<T> list = new ArrayList<T>();
	
	private T t;
	private T[] tArray;
	public Foot(){
		try {
			Class<?> tType = Class.forName("");
			// Type safety: Unchecked cast from Object to T[]  
			//类型安全：不能确定从objec到T[]的类型转化
			t = (T)tType.newInstance();
			tArray = (T[])Array.newInstance(tType, 5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		t = new T();
//		tArray = new T[10];
	}
}