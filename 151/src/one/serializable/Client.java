package one.serializable;

public class Client {
	 public static void main(String[] args) {
//		Person p = new Person("zhangsan");
		
//		SerializableUtils.writeObject(p);
		
		Person person = (Person)SerializableUtils.readObject();
		System.out.println(person.getName());
	}
}
