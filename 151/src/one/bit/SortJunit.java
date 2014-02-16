package one.bit;

import java.util.HashSet;
import java.util.Set;

public class SortJunit {
	public static final Set<String>  KEY = new HashSet<String>(){{
		add("ole");
		add("eve");
		add("sss");
	}};
	

	public static void doSort(int[] data, int max) {
		int[] temp = new int[max];
		for (int i = 0, len = data.length; i < len; i++) {
			if (temp[data[i]] != 1) {
				temp[data[i]] = 1;
			} else {
				System.out.println(data[i] + " 是重复的数字");
			}
		}

		System.out.println("排序结果为:");

		for (int i = 0; i < max; i++) {
			if (temp[i] == 1) {
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) {
		int[] data = { 4, 10, 19, 1, 9, 6, 4, 9 };
		int[] array = bitMap(data);
		for (int i : array) {
			System.out.println(i);
		}
	}

	public static int[] bitMap(int[] data) {
		// 计算出数组中的最大值和最小值
		int max = data[0];
		int min = max;
		for (int i : data) {
			if (max < i)
				max = i;
			if (min > i)
				min = i;
		}
		System.out.println("max=" + max + ",min=" + 0);

		// 根据数组中的最值得到位图数组的长度max-min+1
		int[] bitArray = new int[max - min + 1];
		for (int i : data) {
			int index = i - min;
			bitArray[index]++;
		}
		// 重整数组顺序
		int index = 0;
		for (int i = 0, len = bitArray.length; i < len; i++) {
			while (bitArray[i] > 0) {
				data[index] = i + min;
				index++;
				bitArray[i]--;
			}
		}
		return data;
	}

}
