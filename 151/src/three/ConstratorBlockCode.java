package three;

/**
 * 构造代码块
 * 
 * @author Chain
 * 
 */
public class ConstratorBlockCode {
	{
		System.out.println("构造块代码");
	}

	ConstratorBlockCode() {
		System.out.println("构造函数代码");
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
		this();//this不会执行构造函数代码块。
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
