package three;

/**
 * ��̬����һ��Ҫ��������ֵ
 * ����Ҫ��������ʹ��
 * @author Chain
 */
public class StaticVariable {

	public static int i = 100;
	static{
		i = 99;
		j = 99;
	}
	
	public static int j  = 100;
	
	/**
	 * 
	 * ��̬�����������ʱ�����䵽��������data area���ġ������ڴ���ֻ��һ��������
	 * ���ᱻ�����Σ��������и�ֵ��������ֵ�ڸı䣬��ַ�򱣳ֲ��䡣
	 * ��Ӧi  ��JVM��ִ�����£�
	 * int i; //�����ַ�ռ�
	 * i = 100;//��ֵ
	 * i = 99;//��ֵ
	 * 
	 */
	
	public static void main(String[] args) {
		System.out.println("i is --->>" + i);
		System.out.println("j is --->>" + j);
	}
}
