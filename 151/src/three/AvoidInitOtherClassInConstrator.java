package three;

/**
 * 避免在构造函数中初始化其他类
 * @author Chain
 */
public class AvoidInitOtherClassInConstrator {
	public static void main(String[] args) {
//		new Father();
		new Other();
	}
}



class Father{
	Father(){
		new Other();
	}
}

class Son extends Father{
	Son(){
		System.out.println("Hay,this is son constrator.");
	}
	
	void doSomething(){
		System.out.println("Hay,doSomething.");
	}
}

class Other{
	Other(){
		new Son();
	}
}