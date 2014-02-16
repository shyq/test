package three;

/**
 * 接口中不应该存在实现类,接口是一个契约
 * @author Chain
 */
public class NoImplInInterface {
	public static void main(String[] args) {
		B.c.doSomething();
	}
}

interface B{
	static C c = new C() {
		@Override
		public void doSomething() {
			System.out.println("在B接口中实现了C!!");
		}
	};
}

interface C{
	void doSomething();
}
