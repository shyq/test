package five;

import java.util.ArrayList;
import java.util.List;

public class CollectionsOpt {

	public static void main(String[] args) {
		List<String> l1 = new ArrayList<String>();
		l1.add("A");
		l1.add("B");
		
		List<String> l2 = new ArrayList<String>();
		l2.add("C");
		l2.add("D");
		l2.add("A");
	//	l1.addAll(l2);//并集
		
	//	l1.retainAll(l2);//交集 删除l1中没有出现在l2中的元素
		
//		l1.removeAll(l2);//差集，删除l1中出现在l2中的元素
		
		/**
		 * 无重复的并集
		 * 先删除出现在l1中的元素
		 * 把剩余的l2中的元素加到l1
		 * 
		 */
//		l2.removeAll(l1);
//		l1.addAll(l2);
		
		System.out.println(l1.size());
		
	}
	
	
}
