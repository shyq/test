package seven;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class RefractGeneric {
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		dao.get(12);
	}
}

class RefrectUtil {
	// 获得一个泛型类的实际类型
	public static <T> Class<T> getGenericClass(Class clz) {
		Type type = clz.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) type;
			Type[] types = pt.getActualTypeArguments();
			if (types.length > 0 && types[0] instanceof Class)
				return (Class) types[0];
		}
		return (Class) Object.class;
	}
}

abstract class BaseDao<T> {
	private Class<T> clz = RefrectUtil.getGenericClass(getClass());
	public void get(long id) {
		System.out.println("id : " + 12 + ";clz is :" + clz.getName());
		// session.get(clz,id);
	}
}

class UserDao extends BaseDao<User> {
}

class User {
	private long id;
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}