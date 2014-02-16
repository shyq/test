package seven;

public class GenericLimit {

	public static void main(String[] args) {
		discount(new Me());
	}
	/**
	 * &设定多重边界 multi bounds
	 * @param <T>
	 * @param t
	 */
	public static <T extends Staff & Passenger> void discount(T t){
		if(t.getSalary()<8000 && t.isStanding()){
			System.out.println("0.8!!!!!!!!!");
		}
	}
}


interface Staff{
	public int getSalary();
}
interface Passenger{
	public boolean isStanding();
}

class Me implements Staff,Passenger{

	@Override
	public int getSalary() {
		return 5000;
	}

	@Override
	public boolean isStanding() {
		return true;
	}
	
}