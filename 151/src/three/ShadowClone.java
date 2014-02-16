package three;

/**
 * �����ǳ����
 * ����Ŀ��������ڴ��в�����
 * ǳ����(Ӱ�ӿ���) ���� ���Կ��������ص�����
 * 
 * super.clone():������Ѷ�����������Կ���һ�ݣ���������Ϊ��
 * 	1.�������ͣ���������ǻ������ͣ��򿽱���ֵ����int,float,boolean
 *  2.�������������һ��ʵ�������򿽱���ַ���ã���ʱ�¿����Ķ����ԭ�еĶ������ʵ������
 *  ���շ���Ȩ�����ƣ�Ҳ���Ǽ�ʹ��private���εı���Ҳ���Ա�����ʵ������
 *  3.String�ַ����� ���String�ַ����������������ַ�����ԭ�ַ������䣬�����ڻ�������
 * @author Chain
 *
 */
public class ShadowClone {
	public static void main(String[] args) {
//		Annimal father = new Annimal("Զ������");
//		Annimal east = new Annimal("��������",father);
//		Annimal west = east.clone();
//		west.setName("��������");
//		System.out.println("����������������--->>" + east.getFather().getName());
//		System.out.println("����������������--->>" + west.getFather().getName());
		
		Annimal father = new Annimal("Զ������");
		Annimal east = new Annimal("��������",father);
		Annimal west = east.clone();
		west.setName("��������");
		east.getFather().setName("�Ϲ�����");
		System.out.println("����������������--->>" + east.getFather().getName());
		System.out.println("����������������--->>" + west.getFather().getName());
	}
}


class Annimal implements Cloneable{
	private String name;
	private Annimal father;
	
	public Annimal(String name) {
		super();
		this.name = name;
	}
	
	public Annimal(String name, Annimal father) {
		super();
		this.name = name;
		this.father = father;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Annimal getFather() {
		return father;
	}

	public void setFather(Annimal father) {
		this.father = father;
	}

	@Override
	protected Annimal clone() {
		Annimal a = null;
		try {
			a = (Annimal)super.clone();//ǳ����
			
			//��������Ա�֤���������Ķ����Գ�һ�壬������new
			a.setFather(new Annimal(a.getFather().getName()));
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
		}
		return a;
	}

	
	
}