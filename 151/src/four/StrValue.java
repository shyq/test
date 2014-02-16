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
		str.replaceAll("", "");//��һ��������������ʽ
		str.replace("", "");//
	}
	/**
	 *ƴ�� 
	 * �� ��+�������У�string�ַ��������������Ȩ
	 */
	void joint(){
		System.out.println("admin" + 1 + 2);
		System.out.println(1 + 2 + "admin" );
	}
	
	/**
	 * += :  s = new StringBuffer(s).append("c").toString();
	 * concat : ÿ�ζ�����һ���µ�String,Ȼ����ִ�����鿽��
	 * append�� ��ִ�����鿽�������׷����ɺ� ����toString()������ֻ������һ��String
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
		String[] strArray = {"����[z]","����(L)","����(W)"};
		/**
		   1.����[z]
		   2.����(L)
		   3.����(W)
		 */
		//Arrays.sort(strArray);
		
		Comparator c = Collator.getInstance(Locale.CHINA);
		Arrays.sort(strArray, c);
		int i = 0;
		for(String s : strArray)
			System.out.println(++i +  "." + s);
	}
}
