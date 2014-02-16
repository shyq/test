package six;

import java.rmi.AccessException;
import java.util.EnumMap;
import java.util.EnumSet;

/**
 * 使用枚举类型的工厂方法的好处：
 *  *避免错误调用的产生  边界问题、null值问题
 *  *性能好，使用便捷　　枚举类型的计算是以int类型的计算为基础的
 *  *降低类之间的耦合
 *     迪米特原则：law of Demeter >>最少知识原则：一个对象应该对其他对象有最少的了解
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
		 * 枚举项的数量不要超过64，否则建议拆分
		 */
//		EnumSet<EnumStaticCarFactory> s = EnumSet.allOf(EnumStaticCarFactory.class);
		EnumMap<EnumStaticCarFactory, String> em = 
				new EnumMap<EnumStaticCarFactory, String>(EnumStaticCarFactory.class);
		em.put(EnumStaticCarFactory.BuickCar, "BuickCar");
	}
}

/**
 * 静态方法
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
			throw new AccessException("无效参数");
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
 * 抽象工厂方法
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
