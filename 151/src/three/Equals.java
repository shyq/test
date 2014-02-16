package three;

/**
 * 覆写equals方法时候需要注意：
 *  >>.不要识别不出自己。注意 字符串比较时不要用trim()
 *  	equals方法的自反性原则：对于任何非空引用x,x.eqauls(x)应该返回true
 *  >>.equals应该考虑null的情形
 *  	 equals方法的对称性原则：对于任何引用x和y的情形，如果x.equals(y)返回true
 *  							，那么y.equals(x)也必须返回true
 * >>.在equals中使用getClass()进行类型判断
 *		equals方法的传递性原则：对于x,y,z ，如果x.equals(y)为true，y.equals(z)为true
 *								，则x.equals(z)也必须为true 
 * 
 * >>.覆写equals方法时候必须覆写 hashCode();
 * 
 * 最好覆写toString() 方法
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