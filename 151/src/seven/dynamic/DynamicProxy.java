package seven.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
	public static void main(String[] args) {
		Subject subject = new RealSubject();
		InvocationHandler handler = new SubjectHandler(subject);
		ClassLoader loader = subject.getClass().getClassLoader();
		Subject proxy = (Subject) Proxy.newProxyInstance(loader, subject.getClass().getInterfaces(), handler);
		proxy.request();
	}
}
interface Subject{
	public void request();
}

class RealSubject implements Subject{
	@Override
	public void request() {
		System.out.println("dynamic proxy !!");
	}
}


class SubjectHandler implements InvocationHandler{
	private Subject subject;
	public SubjectHandler(Subject subject){
		this.subject = subject;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("预处理");
		Object obj = method.invoke(subject, args);
		System.out.println("处理结束");
		return obj;
	}
	
	
	
}