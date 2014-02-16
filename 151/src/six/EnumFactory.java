package six;

import java.rmi.AccessException;
import java.util.EnumMap;
import java.util.EnumSet;

/**
 * ʹ��ö�����͵Ĺ��������ĺô���
 *  *���������õĲ���  �߽����⡢nullֵ����
 *  *���ܺã�ʹ�ñ�ݡ���ö�����͵ļ�������int���͵ļ���Ϊ������
 *  *������֮������
 *     ������ԭ��law of Demeter >>����֪ʶԭ��һ������Ӧ�ö��������������ٵ��˽�
 * @author Chain
 *
 */
public class EnumFactory {

	public static void main(String[] args) throws AccessException {
//		Car fordCar = EnumStaticCarFactory.FordCar.create();
//		System.out.println(fordCar.getClass().getName());
		
		Car fordCar = ClassCarFactory.createCar(FordCar.class);
		System.out.println(fordCar.getClass().getName());
		
		/**
		 * ö�����������Ҫ����64����������
		 */
//		EnumSet<EnumStaticCarFactory> s = EnumSet.allOf(EnumStaticCarFactory.class);
		EnumMap<EnumStaticCarFactory, String> em = 
				new EnumMap<EnumStaticCarFactory, String>(EnumStaticCarFactory.class);
		em.put(EnumStaticCarFactory.BuickCar, "BuickCar");
	}
}

/**
 * ��̬����
 * @author Chain
 */
enum EnumStaticCarFactory{
	FordCar,BuickCar;
	public Car create() throws AccessException{
		switch (this) {
		case FordCar:
			return new FordCar();
		case BuickCar:
			return new BuickCar();
		default:
			throw new AccessException("��Ч����");
		}
	}
}

interface Car{}
class FordCar implements Car{}
class BuickCar implements Car{}

class ClassCarFactory{
	public static Car createCar(Class<? extends Car> c){
		try {
			return c.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(c + " create fail!");
		} 
	}
}

/**
 * ���󹤳�����
 */
enum AbsEnumCarFactory{
	FordCar {
		@Override
		public Car create() {
			return new FordCar();
		}
	},
	BuickCar {
		@Override
		public Car create() {
			return new  BuickCar();
		}
	};
	
	public abstract Car create();
}
