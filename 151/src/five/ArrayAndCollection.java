package five;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Chain
 *
 *����Ҫ��ϸߵĳ���ʹ��������漯��
 *
 */
public class ArrayAndCollection {

	public static void main(String[] args) {
		List<String> s = new ArrayList<String>();
		
		for(int i = 0 ; i < 100; i++){
			s.add("s");
		}
		
		List<String> sub = s.subList(10, 20);
		sub.clear();
		System.out.println(s.size());
	}
	
}



