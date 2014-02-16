package one.bit;

import java.text.NumberFormat;
import java.util.Random;

import org.junit.Test;

/**
 *   测试类
 * @author Chain
 *
 */
public class Client {
	
	/*
	 *  注意易混淆的字母和数字
	 *  字母l和数字1
	 *  字母o O 和数字0
	 *  字母l作为长整数型时务必大写.
	 */
	@Test
	public void testObscure(){
		long i = 1l;
		System.out.println( i + i );
	}
	
	/*
	 * 常量：在编译期就应该确定其值，在运行期保持不变
	 */
	@Test
	public void testCanChangeConst(){
		System.out.println(Constant.RAND_CONST);
	}
	
	/*
	 * 三元表达式的两个操作数的类型必须一致。
	 */
	@Test
	public void testTernary(){
		int num = 50;
		String s1 = String.valueOf(num < 100 ? num : 100);
		String s2 = String.valueOf(num < 100 ? num : 100.0);
		System.out.println("s1= " + s1 +  " , s2= " + s2);
		
		String s3 = "";
		String s4 = "";
		if(num < 100) 
			s3 = String.valueOf(num);
		else 
			s3 = String.valueOf(100);
		
		if(num < 100) 
			s4 = String.valueOf(num);
		else 
			s4 = String.valueOf(100.0);
		System.out.println(s3.equals(s4));
		
	}

	/* 方法重构*********************************************/
	protected void calPrice(int price ,int discount){
		float knowDownPrice = price * discount / 100.0F;
		System.out.println("简单折扣后的价格是:" + formatCurrency(knowDownPrice));
	}
	protected void calPrice(int price,int... discounts){
		float knowDownPrice = price;
		for(int discount : discounts)
			knowDownPrice = knowDownPrice * discount/100;
		System.out.println("复杂折扣后的价格是:" + formatCurrency(knowDownPrice));
	}
	private String formatCurrency(float price) {
		return NumberFormat.getInstance().format(price);
	}
	@Test
	public void testReMethod(){
		calPrice(7500,40);
	}
	//复写的方法参数与父类相同，不仅仅是类型、数量 ，还包括显示形式
	/**
	 *  void fun(int i, int... j)
	 *  @overwrite
	 *  void fun(int i, int[] j)
	 */
	/* ****************************************************/
	
	/*
	 * count++ : 
		 1.jvm先把count的值（0）拷贝到临时变量区
		 2.count的值加1，此时的count值为1
		 3.返回临时变量区的值（0）
		 4. 把临时变量区返回的值赋值给count，此时count的变为了0
	 */
	@Test
	public void testAddPlus(){
		int count = 0;
		int count1 = 0;
		int count2 = 0;
		for(int i = 0 ; i < 10 ; i++){
			count = count ++ ;
		}
		for(int i = 0 ; i < 10 ; i++){
			count1 = ++count1 ;
		}
		for(int i = 0 ; i < 10 ; i++){
			count2++;
		}
		System.out.println("count=" + count + ",count1=" + count1 +",count2="+count2);
		System.out.println("countAdd=" + countAdd(0) + ",addCount=" + addCount(0));
	}
	
	//count++ 的实现
	public int countAdd(int count){
		int temp = count;//保存初始值
		count = count +1 ;//做自增操作
		return temp;//返回原始值
	} 
	//++count 的实现
	public int addCount(int count){
		count = count + 1;
		int temp = count;
		return temp;
	}
	
	@Test
	public void oldGrammar(){
		int fee = 200;
		saveDefault:save(fee);
	}
	
	protected void saveDefault(){}

	protected void save(int fee){
		System.out.println(fee);
	}
	
	
}













/**
 *  常量接口
 * @author taosq
 *
 */
interface Constant{
	public final static int RAND_CONST = new Random().nextInt();//常量  ??
}