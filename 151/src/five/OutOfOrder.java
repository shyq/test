package five;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class OutOfOrder {

	public static void main(String[] args) {
		int tagCloudNum = 10;
		List<String> tagClouds = new ArrayList<String>(tagCloudNum);
		for(int i = 0; i < tagCloudNum ; i ++ ){
			tagClouds.add("cloud >> " + i);
		}
//		tempSort(tagCloudNum,tagClouds);
//		swapSort(tagCloudNum,tagClouds);
		shutffleSort(tagCloudNum,tagClouds);
	}
	
	public static void tempSort(int tagCloudNum,List<String> tagClouds){
		Random ran = new Random();
		for(int i = 0; i < tagCloudNum ; i ++ ){
			//取得随机位置
			int randomPostion = ran.nextInt(tagCloudNum);
			String temp = tagClouds.get(i);
			tagClouds.set(i, tagClouds.get(randomPostion));
			tagClouds.set(randomPostion, temp);
			System.out.println(tagClouds.get(i));
		}
	}
	
	public static void swapSort(int tagCloudNum,List<String> tagClouds){
		Random ran = new Random();
		for(int i = 0; i < tagCloudNum ; i ++ ){
			//取得随机位置
			int randomPostion = ran.nextInt(tagCloudNum);
			Collections.swap(tagClouds, i, randomPostion);
			System.out.println(tagClouds.get(i));
		}
	}
	
	public static void shutffleSort(int tagCloudNum,List<String> tagClouds){
		for(int i = 0;i < tagCloudNum;i++){
			Collections.shuffle(tagClouds);
			System.out.println(tagClouds.get(i));
		}
	}
}
