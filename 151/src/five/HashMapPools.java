package five;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapPools {

	public static void main(String[] args) {
//		Map<String,String> map = new HashMap<String,String>();
		List<String> list = new ArrayList<String>();
		final Runtime rt = Runtime.getRuntime();
		rt.addShutdownHook(new Thread(){
			@Override
			public void run() {
				StringBuffer sb = new StringBuffer();
				long heapMaxSize = rt.maxMemory() >> 20;
				sb.append("最大可用内存：" + heapMaxSize + "M\n");
				long totalMemory = rt.totalMemory() >> 20;
				sb.append("堆内存大小：" + totalMemory + "M\n");
				long free = rt.freeMemory() >> 20;
				sb.append("空闲内存大小：" + free + "M\n");
				System.out.println(sb);
			}
		});
		
		for(int i = 0; i < 1932170;i++){
//			map.put("key" + i, "value" + i);
			list.add("list" + i);
		}
		System.out.println(2 << 19);
	}
	
}
