package three;

/**
 * 对象的浅拷贝
 * 对象的拷贝是在内存中操作的
 * 浅拷贝(影子拷贝) 存在 属性拷贝不彻地的问题
 * 
 * super.clone():并不会把对象的所有属性拷贝一份，拷贝规则为：
 * 	1.基本类型：如果变量是基本类型，则拷贝其值，如int,float,boolean
 *  2.对象：如果变量是一个实例对象，则拷贝地址引用，此时新拷贝的对象和原有的对象共享改实例变量
 *  不收访问权限限制，也就是即使是private修饰的变量也可以被两个实例访问
 *  3.String字符串： 会从String字符串池中重新生成字符串，原字符串不变，类似于基本类型
 * @author Chain
 *
 */
public class ShadowClone {
	public static void main(String[] args) {
//		Annimal father = new Annimal("远古神龙");
//		Annimal east = new Annimal("东方巨龙",father);
//		Annimal west = east.clone();
//		west.setName("西方巨龙");
//		System.out.println("东方巨龙的祖先是--->>" + east.getFather().getName());
//		System.out.println("西方巨龙的祖先是--->>" + west.getFather().getName());
		
		Annimal father = new Annimal("远古神龙");
		Annimal east = new Annimal("东方巨龙",father);
		Annimal west = east.clone();
		west.setName("西方巨龙");
		east.getFather().setName("上古神龙");
		System.out.println("东方巨龙的祖先是--->>" + east.getFather().getName());
		System.out.println("西方巨龙的祖先是--->>" + west.getFather().getName());
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
			a = (Annimal)super.clone();//浅拷贝
			
			//深拷贝，可以保证拷贝出来的对象自成一体，类似于new
			a.setFather(new Annimal(a.getFather().getName()));
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
		}
		return a;
	}

	
	
}