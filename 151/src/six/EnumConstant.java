package six;

/**
 * 推荐使用枚举定义常量
 * 
 *  枚举的优势：
 *   *　 枚举常量更简单	
 * 	        枚举常量只需要定义每个枚举项。而接口(类)常量必须定义值。
 * 	 
 * 	 * 　枚举常量属于稳态型
 *	   //接口(类)常量需要校验边界   
 *	   //枚举常量在switch的时候已经限定了其类型	
 * 
 * 	 *　枚举具有內置方法
 * 		for(Season s : Season.values()){
			System.out.println(s);
		}
 * 	
 * 	 * 枚举可以自定义方法
	   public static Season getComfortableSeason(){
			return Spring;
		}
 * 
 * 	 缺点：
 *    枚举不能被继续，即一个枚举常量一旦被定义，除非修改重构，否则无法做扩展
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
			System.out.println("未知");
			break;
		}
	}
	
}

enum Season{
	Spring("春"),Summer("夏"),Autumn("秋"),Winter("冬");
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
	 * 使用枚举类的valueOf()方法前必须进行校验
	 */
	
	/**
	 * 扩展枚举类
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