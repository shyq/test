package six;

/**
 * �Ƽ�ʹ��ö�ٶ��峣��
 * 
 *  ö�ٵ����ƣ�
 *   *�� ö�ٳ�������	
 * 	        ö�ٳ���ֻ��Ҫ����ÿ��ö������ӿ�(��)�������붨��ֵ��
 * 	 
 * 	 * ��ö�ٳ���������̬��
 *	   //�ӿ�(��)������ҪУ��߽�   
 *	   //ö�ٳ�����switch��ʱ���Ѿ��޶���������	
 * 
 * 	 *��ö�پ��Ѓ��÷���
 * 		for(Season s : Season.values()){
			System.out.println(s);
		}
 * 	
 * 	 * ö�ٿ����Զ��巽��
	   public static Season getComfortableSeason(){
			return Spring;
		}
 * 
 * 	 ȱ�㣺
 *    ö�ٲ��ܱ���������һ��ö�ٳ���һ�������壬�����޸��ع��������޷�����չ
 * 
 * @author Chain
 */
public class EnumConstant {
	public static void main(String[] args) {
//		for(Season s : Season.values()){
//			System.out.println(s);
//		}
//		System.out.println(Season.getComfortableSeason());
		/**
		 * 
		 */
		doForEach(Season.Summer);
		Season.valueOf("");
	}
	
	static void doForEach(Season s){
		if(s==null) {
			System.out.println("s is null");
			return;
		}
		switch (s) {
		case Spring:
			System.out.println(s.getVal() + s.ordinal());
			break;
		case Summer:
			System.out.println(s.getVal() + s.ordinal());
			break;
		case Autumn:
			System.out.println(s.getVal() + s.ordinal());
			break;
		case Winter:
			System.out.println(s.getVal() + s.ordinal());
			break;
		default:
			System.out.println("δ֪");
			break;
		}
	}
	
}

enum Season{
	Spring("��"),Summer("��"),Autumn("��"),Winter("��");
	private String val;
	Season(String val){
		this.val = val;
	}
	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public static Season getComfortableSeason(){
		return Spring;
	}
	
	
	/**
	 * ʹ��ö�����valueOf()����ǰ�������У��
	 */
	
	/**
	 * ��չö����
	 * @param val
	 * @return
	 */
	public static boolean contains(String val){
		Season[] ses = values();
		for(Season s : ses){
			if(s.name().equals(val))
				return true;
		}
		return false;
	}
	
}