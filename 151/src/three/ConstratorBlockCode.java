package three;

/**
 * ��������
 * 
 * @author Chain
 * 
 */
public class ConstratorBlockCode {
	{
		System.out.println("��������");
	}

	ConstratorBlockCode() {
		System.out.println("���캯������");
	}

	ConstratorBlockCode(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		// System.out.println(new ConstratorBlockCode());
//		new ConstratorBlockCode("a");
		new ConsBase();
		new ConsBase(1);
		new ConsBase("");
		System.out.println(ConsBase.getNumberOfObject());
	}
}

class ConsBase {
	private static int numOfObject = 0;
	{
		numOfObject++;
	}

	public ConsBase() {
		//numOfObject++;
		System.out.println("C:" + numOfObject);
	}

	public ConsBase(String s) {
		this();//this����ִ�й��캯������顣
//		numOfObject++;
		System.out.println("C1:" +numOfObject);
	}

	public ConsBase(int i) {
	//	numOfObject++;
		System.out.println("C2:" +numOfObject);
	}

	public static int getNumberOfObject() {
		return numOfObject;
	}

}
