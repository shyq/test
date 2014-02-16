package three;

/**
 * 不要复写(override)静态方法
 * 
 * 静态方法又称为类方法，即不需要的实例化类 就可以调用的方法
 * 
 * 只有实例方法才能被Override 只有生成实例才能调用的方法
 * @author Chain
 * 
 */
public class DontOverrideStaticMethod {

	public static void main(String[] args) {
		/**
		 *  实例对象有两种类型: 表面类型和实际类型
		 *  对于bse 表面类型为Base  实际类型为Sub
		 *  	实例方法被实例调用
		 *  	静态方法可被实例或者类调用。
		 *		对于静态方法，JVM会根据对象的表面类型找到静态方法的入口  	
		 */
		Base bse = new Sub();
		bse.doSomething();
		bse.doAnything();
	}
}

class Base {

	public static void doSomething() {
		System.out.println(" this is base static method ");
	}
	
	public void doAnything(){
		System.out.println(" this is base no static method");
	}
}

class Sub extends Base{
	//方法隐藏
	public static void doSomething() {
		System.out.println(" this is sub static method ");
	}
	//方法复写
	@Override
	public void doAnything(){
		System.out.println(" this is sub no static method");
	}
}