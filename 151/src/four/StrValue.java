package four;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;


public class StrValue {
	public static void main(String[] args) {
		String str1 = "admin";
		String str2 = "admin";
		String str3 = new String("admin");
		String str4 = str3.intern();
//		System.out.println(str1 == str2);
//		System.out.println(str1 == str3);
//		System.out.println(str1 == str4);
//		doJoint();
		sortChinaSec();
	}

	
	void testReplace(String str){
		str.replaceAll("", "");//第一个参数是正则表达式
		str.replace("", "");//
	}
	/**
	 *拼接 
	 * 在 “+”运算中，string字符串具有最高优先权
	 */
	void joint(){
		System.out.println("admin" + 1 + 2);
		System.out.println(1 + 2 + "admin" );
	}
	
	/**
	 * += :  s = new StringBuffer(s).append("c").toString();
	 * concat : 每次都创建一个新的String,然后在执行数组拷贝
	 * append： 先执行数组拷贝，最后追加完成后 调用toString()方法，只创建了一次String
	 */
	public static void doJoint(){
//		String a = "c";
//		StringBuilder sb = new StringBuilder("c");
		StringBuffer buff = new StringBuffer("c");
		long startTime = System.currentTimeMillis();
		for(int i = 0;i < 50000;i++)
			//a += "c";  2872ms
//			a.concat("c");//4ms
//			sb.append("c");//2ms
			buff.append("c");// 4ms
		long endTime = System.currentTimeMillis() - startTime;
		String s = String.format("successful conversion: %s in %dms","+=",endTime);
		System.out.println(s);
	}
	
	public static void sortChinaSec(){
		String[] strArray = {"张三[z]","李四(L)","王五(W)"};
		/**
		   1.张三[z]
		   2.李四(L)
		   3.王五(W)
		 */
		//Arrays.sort(strArray);
		
		Comparator c = Collator.getInstance(Locale.CHINA);
		Arrays.sort(strArray, c);
		int i = 0;
		for(String s : strArray)
			System.out.println(++i +  "." + s);
	}
}
