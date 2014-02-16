package three;

public class OverrideEqual {
	public static void main(String[] args) {
		ManObj mo = new ManObj("1111");
		ManObj mo1 = new ManObj("1111 ");
		System.out.println(mo.equals(mo1));
		
	}
}



class ManObj{
	private Long id ;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ManObj(String name) {
		super();
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ManObj){
			ManObj mo = (ManObj)obj;
			return name.equalsIgnoreCase(mo.getName().trim());
		}
		return false;
	}
	
}