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
		return m.getName().startsWith("init")		//�Ƿ���init��ͷ ����junit ��test��ͷ
			&& Modifier.isPublic(m.getModifiers())  //��������
			&& m.getReturnType().equals(Void.TYPE)  //����ֵ��void
			&& !m.isVarArgs()                        //�������Ϊ��  
			&& !Modifier.isAbstract(m.getModifiers());//�����ǳ��󷽷�
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