package three;

/**
 * ��Ҫ��д(override)��̬����
 * 
 * ��̬�����ֳ�Ϊ�෽����������Ҫ��ʵ������ �Ϳ��Ե��õķ���
 * 
 * ֻ��ʵ���������ܱ�Override ֻ������ʵ�����ܵ��õķ���
 * @author Chain
 * 
 */
public class DontOverrideStaticMethod {

	public static void main(String[] args) {
		/**
		 *  ʵ����������������: �������ͺ�ʵ������
		 *  ����bse ��������ΪBase  ʵ������ΪSub
		 *  	ʵ��������ʵ������
		 *  	��̬�����ɱ�ʵ����������á�
		 *		���ھ�̬������JVM����ݶ���ı��������ҵ���̬���������  	
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
	//��������
	public static void doSomething() {
		System.out.println(" this is sub static method ");
	}
	//������д
	@Override
	public void doAnything(){
		System.out.println(" this is sub no static method");
	}
}