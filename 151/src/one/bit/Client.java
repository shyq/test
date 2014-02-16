package one.bit;

import java.text.NumberFormat;
import java.util.Random;

import org.junit.Test;

/**
 *   ������
 * @author Chain
 *
 */
public class Client {
	
	/*
	 *  ע���׻�������ĸ������
	 *  ��ĸl������1
	 *  ��ĸo O ������0
	 *  ��ĸl��Ϊ��������ʱ��ش�д.
	 */
	@Test
	public void testObscure(){
		long i = 1l;
		System.out.println( i + i );
	}
	
	/*
	 * �������ڱ����ھ�Ӧ��ȷ����ֵ���������ڱ��ֲ���
	 */
	@Test
	public void testCanChangeConst(){
		System.out.println(Constant.RAND_CONST);
	}
	
	/*
	 * ��Ԫ���ʽ�����������������ͱ���һ�¡�
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

	/* �����ع�*********************************************/
	protected void calPrice(int price ,int discount){
		float knowDownPrice = price * discount / 100.0F;
		System.out.println("���ۿۺ�ļ۸���:" + formatCurrency(knowDownPrice));
	}
	protected void calPrice(int price,int... discounts){
		float knowDownPrice = price;
		for(int discount : discounts)
			knowDownPrice = knowDownPrice * discount/100;
		System.out.println("�����ۿۺ�ļ۸���:" + formatCurrency(knowDownPrice));
	}
	private String formatCurrency(float price) {
		return NumberFormat.getInstance().format(price);
	}
	@Test
	public void testReMethod(){
		calPrice(7500,40);
	}
	//��д�ķ��������븸����ͬ�������������͡����� ����������ʾ��ʽ
	/**
	 *  void fun(int i, int... j)
	 *  @overwrite
	 *  void fun(int i, int[] j)
	 */
	/* ****************************************************/
	
	/*
	 * count++ : 
		 1.jvm�Ȱ�count��ֵ��0����������ʱ������
		 2.count��ֵ��1����ʱ��countֵΪ1
		 3.������ʱ��������ֵ��0��
		 4. ����ʱ���������ص�ֵ��ֵ��count����ʱcount�ı�Ϊ��0
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
	
	//count++ ��ʵ��
	public int countAdd(int count){
		int temp = count;//�����ʼֵ
		count = count +1 ;//����������
		return temp;//����ԭʼֵ
	} 
	//++count ��ʵ��
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
 *  �����ӿ�
 * @author taosq
 *
 */
interface Constant{
	public final static int RAND_CONST = new Random().nextInt();//����  ??
}