package seven;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

public class DecoratorPattern {
	public static void main(String[] args) {
		Animal jetty = new Rat();
		jetty = new DecorateAnimal(jetty, FlyFeature.class);
		jetty = new DecorateAnimal(jetty,DigFeature.class);
		jetty.doStuff();
	}
}

interface Animal{
	public void doStuff();
}

class Rat implements Animal{
	@Override
	public void doStuff() {
		System.out.println("this is the do stuff cm");
	}
}

interface Feature {
	public void load();
}

class FlyFeature implements Feature{
	@Override
	public void load() {
		System.out.println("it can fly....");
	}
}

class DigFeature implements Feature{

	@Override
	public void load() {
		System.out.println("it can dig ....");
	}
}


//定义包装类 为rat增加feature
class DecorateAnimal implements Animal{
	//被包装的动物
	private Animal animal;
	
	private Class<? extends Feature> clz;
	
	public DecorateAnimal(Animal animal,Class<? extends Feature> clz){
		this.animal = animal;
		this.clz = clz;
	}
	@Override
	public void doStuff() {
		InvocationHandler handler = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				Object obj = null;
				if(Modifier.isPublic(method.getModifiers())){
					obj = method.invoke(clz.newInstance(), args);
				}
				animal.doStuff();
				return obj;
			}
		};
		ClassLoader cl = getClass().getClassLoader();
		Feature proxy = (Feature) Proxy.newProxyInstance(cl, clz.getInterfaces(), handler);
		proxy.load();
	}
	
}

