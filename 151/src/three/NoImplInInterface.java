package three;

/**
 * �ӿ��в�Ӧ�ô���ʵ����,�ӿ���һ����Լ
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
			System.out.println("��B�ӿ���ʵ����C!!");
		}
	};
}

interface C{
	void doSomething();
}
