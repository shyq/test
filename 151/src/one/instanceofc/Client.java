package one.instanceofc;

import java.util.Date;

/**
 * instanceof ��Ԥ�ڽ��
 * @author Chain
 * ֻҪinstanceof�������˵Ĳ������м̳л���ʵ�ֹ�ϵ��������� ͨ��
 */
public class Client {
	
	public static void main(String[] args) {
		//String�����Ƿ���Object��ʵ��
		boolean b1 = "String" instanceof Object;
		
		//
		boolean b2 = new String() instanceof Object;
		
		boolean b3 = new Object() instanceof String;
		
		//'A'��һ��char���ͣ�Ҳ����һ���������ͣ�����һ������ instanceofֻ�����ڶ�����ж�
//		boolean b4 = 'A' instanceof Character;
		
		//���������Ϊnull ��ֱ�ӷ���false
		boolean b5 = null instanceof String;
		
		//null��һ���������ͣ�Ҳ����˵û�����ͣ���ʹ��ǿ��ת������null
		boolean b6 = (String)null instanceof String;
		
		//���벻��ͨ�� Date��Stringû�м̳л�ʵ�ֹ�ϵ
//		boolean b7 = new Date() instanceof String;
		
		//false java�еķ�����Ϊ�������ģ��ڱ�����ֽ���ʱ��T�Ѿ��Ǹ�Object�����ˡ�
		//T�ı�������Object���ͣ�ʵ������String���� "t instanceof Date" �൱��"Object instanceof Date"
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

