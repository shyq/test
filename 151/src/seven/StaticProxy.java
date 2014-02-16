package seven;

/**
 * 静态代理：
 * 	通过代理主题角色(Proxy) 和具体主题角色(real subject)共同实现抽象主题角色(subject)的逻辑
 * 代理主题角色把相关的执行逻辑委托给了具体主题角色
 * @author Chain
 */
public class StaticProxy {
	public static void main(String[] args) {
		Proxy p = new Proxy();
		p.request();
	}
}
/**
 * 抽象主题角色
 * @author Chain
 *
 */
interface Subject{
	//定义一个方法
	public void request();
}

/**
 * 具体主题角色
 * @author Chain
 *
 */
class RealSubject implements Subject{
	@Override
	public void request() {
		System.out.println("我要租房(具体主题角色)");
	}
}

/**
 * 代理主题角色
 * @author Chain
 *
 */
class Proxy implements Subject{
	//要代理哪个实现类
	private Subject subject = null;
	//默认被代理者
	public Proxy(){
		subject = new RealSubject();
	}
	//构造函数中传递被代理者
	public Proxy(Subject sub){
		this.subject = sub;
	}
	
	//实现接口中定义的方法
	@Override
	public void request() {
		before();
		subject.request();
		after();
	}
	public void before(){
		System.out.println("发布租房信息");
	}
	public void after(){
		System.out.println("反馈租房信息");
	}
}

