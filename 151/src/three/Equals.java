package three;

/**
 * ��дequals����ʱ����Ҫע�⣺
 *  >>.��Ҫʶ�𲻳��Լ���ע�� �ַ����Ƚ�ʱ��Ҫ��trim()
 *  	equals�������Է���ԭ�򣺶����κηǿ�����x,x.eqauls(x)Ӧ�÷���true
 *  >>.equalsӦ�ÿ���null������
 *  	 equals�����ĶԳ���ԭ�򣺶����κ�����x��y�����Σ����x.equals(y)����true
 *  							����ôy.equals(x)Ҳ���뷵��true
 * >>.��equals��ʹ��getClass()���������ж�
 *		equals�����Ĵ�����ԭ�򣺶���x,y,z �����x.equals(y)Ϊtrue��y.equals(z)Ϊtrue
 *								����x.equals(z)Ҳ����Ϊtrue 
 * 
 * >>.��дequals����ʱ����븲д hashCode();
 * 
 * ��ø�дtoString() ����
 * 
 * @author Chain
 *
 */
public class Equals {

	public static void main(String[] args) {
//		People p1 = new People("zhangsan");
//		People p2 = new People(null);
//		System.out.println(p1.equals(p2));
		Employee e1 = new Employee("zhangsan", 1000);
		Employee e2 = new Employee("zhangsan", 1001);
		People p1 = new People("zhangsan");
//		System.out.println(e1.equals(p1) & e2.equals(p1));
//		System.out.println(e2.equals(p1));
//		System.out.println(e1.equals(e2));
		
		System.out.println(100000001 & 1);
	}
}

class People{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public People(String name) {
		super();
		this.name = name;
	}

	
	@Override
	public boolean equals(Object obj) {
//		if(obj instanceof People){
//			if(((People) obj).getName()!=null && name!=null){
//				return name.equalsIgnoreCase(((People) obj).getName());
//			}
//		}
		if(obj != null && obj.getClass() == this.getClass()){
			Person p = (Person)obj;
			if(name!=null && p.getName()!=null){
				return name.equalsIgnoreCase(p.getName());
			}
		}
		return false;
	}

}
class Employee extends People{
	private int id;
	public Employee(String name) {
		super(name);
	}
	
	public Employee(String name,int id){
		super(name);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
//		if(obj instanceof Employee){
//			Employee e = (Employee) obj;
//			return super.equals(e) && e.getId() == id;
//		}
		if(obj != null && obj.getClass()==this.getClass()){
			Employee e = (Employee) obj;
			return super.equals(e) && e.getId() == id;
		}
		return super.equals(obj);
	}
	
	
	
}