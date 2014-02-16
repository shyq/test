package seven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayUtils {

	public static <T> List<T> asList(T ...t){
		List<T> list = new ArrayList<T>();
		Collections.addAll(list, t);
		return list;
	}
	
	/**
	 * 无法从代码中推断出泛型类型的情况下，即可强制声明泛型类型
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> strList = ArrayUtils.asList("A","B");
		List list2 = ArrayUtils.asList();
		List<Integer> list3 = ArrayUtils.<Integer>asList();
//		List<Object> list2 = ArrayUtils.asList();
		List intList = ArrayUtils.asList(1,12,3,3.1);
	}
}
