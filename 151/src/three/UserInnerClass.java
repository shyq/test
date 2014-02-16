package three;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用匿名内部类
 * @author Chain
 *
 */
public class UserInnerClass {

	public static void main(String[] args) {
		List l1 =new ArrayList();
		List l2 = new ArrayList(){};
		List l3 = new ArrayList(){{}{}{}};
		
		System.out.println(l1.getClass() ==  l2.getClass());
		System.out.println(l2.getClass() ==  l3.getClass());
		System.out.println(l3.getClass() ==  l1.getClass());
	}
}
