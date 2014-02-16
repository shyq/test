package seven;

/**
 * ��̬����
 * 	ͨ�����������ɫ(Proxy) �;��������ɫ(real subject)��ͬʵ�ֳ��������ɫ(subject)���߼�
 * ���������ɫ����ص�ִ���߼�ί�и��˾��������ɫ
 * @author Chain
 */
public class StaticProxy {
	public static void main(String[] args) {
		Proxy p = new Proxy();
		p.request();
	}
}
/**
 * ���������ɫ
 * @author Chain
 *
 */
interface Subject{
	//����һ������
	public void request();
}

/**
 * ���������ɫ
 * @author Chain
 *
 */
class RealSubject implements Subject{
	@Override
	public void request() {
		System.out.println("��Ҫ�ⷿ(���������ɫ)");
	}
}

/**
 * ���������ɫ
 * @author Chain
 *
 */
class Proxy implements Subject{
	//Ҫ�����ĸ�ʵ����
	private Subject subject = null;
	//Ĭ�ϱ�������
	public Proxy(){
		subject = new RealSubject();
	}
	//���캯���д��ݱ�������
	public Proxy(Subject sub){
		this.subject = sub;
	}
	
	//ʵ�ֽӿ��ж���ķ���
	@Override
	public void request() {
		before();
		subject.request();
		after();
	}
	public void before(){
		System.out.println("�����ⷿ��Ϣ");
	}
	public void after(){
		System.out.println("�����ⷿ��Ϣ");
	}
}

