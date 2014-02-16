package nine;

import java.util.ArrayList;
import java.util.List;

public class Efficiency {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int len = getCount();
		List<String> ls = new ArrayList<String>();
		for(int i = 0;i<len;i++){
			ls.add("zhangsan" + i);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
	
	public static int getCount(){
		return 100000*2*2*2;
	}
}
