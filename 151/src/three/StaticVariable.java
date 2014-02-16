package three;

/**
 * 静态变量一定要先申明后赋值
 * 变量要先申明后使用
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
	 * 静态变量是类加载时被分配到数据区（data area）的。它在内存中只有一个拷贝，
	 * 不会被分配多次，其后的所有赋值操作都是值在改变，地址则保持不变。
	 * 对应i  ，JVM的执行如下：
	 * int i; //分配地址空间
	 * i = 100;//赋值
	 * i = 99;//赋值
	 * 
	 */
	
	public static void main(String[] args) {
		System.out.println("i is --->>" + i);
		System.out.println("j is --->>" + j);
	}
}
