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
				sb.append("�������ڴ棺" + heapMaxSize + "M\n");
				long totalMemory = rt.totalMemory() >> 20;
				sb.append("���ڴ��С��" + totalMemory + "M\n");
				long free = rt.freeMemory() >> 20;
				sb.append("�����ڴ��С��" + free + "M\n");
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
