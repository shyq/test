package seven;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericT {

	public static void main(String[] args) {
	//List<Integer> ls = Arrays.<Integer>asList();
		//���������ʼ��ʱ����������������  ��ִ�������Ͳ�������
		//List<String>[] ��List<Object>[] ��ͬ
//		List<String>[] list = new List<String>[];
		//�������͵�class��������ͬ�ġ�
//		List<String> list1 = new ArrayList<String>();
//		List<Integer> list2 = new ArrayList<Integer>();
//		System.out.println(list1.getClass() == list2.getClass());  //true
		
		//instanceof ��������ڷ��Ͳ���
		//Cannot perform instanceof check against parameterized type List<String>.
		//Use the form List<?> instead since further generic type information will be erased at runtime
//		List<String> list = new ArrayList<String>();
//		System.out.println(list instanceof List<String>);
	}
	
//	public void dosomething(List<String> ls){}
//	public void dosomething(List<Integer> ls){}
	
}

/**
 * �������ڱ���ʱҪ��ȡT���ͣ����������ڱ������Ѿ���������
 *  ���� T(); new T[5];���ᱨ��
 *  
 *  ArrayList�������Ƿ��ͣ��ڱ������Ѿ�תΪObject��
 *  
 *  ��ĳ�Ա�����������ʼ��ǰ��ʼ���ģ�����Ҫ���ڳ�ʼ��ǰ�����������ȷ�����ͣ�
 *  �����ֻ�����������ܳ�ʼ����
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
			//���Ͱ�ȫ������ȷ����objec��T[]������ת��
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