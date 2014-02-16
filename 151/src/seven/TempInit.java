package seven;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TempInit {
	public static void main(String[] args) throws Exception {
		AbsPopulator ap = new UserPopulator();
		ap.dataInitialing();
	}
}


abstract class AbsPopulator{
	
	public final void dataInitialing() throws Exception{
		Method[] methods = getClass().getMethods();
		for(Method m : methods){
			if(isInitDataMethod(m))
				m.invoke(this);
		}
	}

	private boolean isInitDataMethod(Method m) {
		// TODO Auto-generated method stub
		return m.getName().startsWith("init")		//是否以init开头 类似junit 以test开头
			&& Modifier.isPublic(m.getModifiers())  //公开方法
			&& m.getReturnType().equals(Void.TYPE)  //返回值是void
			&& !m.isVarArgs()                        //输入参数为空  
			&& !Modifier.isAbstract(m.getModifiers());//不能是抽象方法
	}
}

class UserPopulator extends AbsPopulator{
	
	public void initUser(){
		System.out.println("11111111111111");
	}
	public void initPwd(){
		System.out.println("--------------");
	}
}