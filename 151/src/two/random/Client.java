package two.random;

import java.util.Random;

/**
 * ��Ҫ����������ӡ�
 * //�������������ӹ̶��ˣ���ô��ͬһ̨�������������ж��ٴΣ����������������һ���ġ�
 * @author Chain
 *
 */
public class Client {
	public static void main(String[] args) {
		noSeed();
		withSeed();
	}
	
	static void noSeed(){
		Random random = new Random();
		for(int i = 0 ; i < 4; i++ ){
			System.out.println("no seed --->>:" + random.nextInt());
		}
	}
	static void withSeed(){
		Random random = new Random(1000);
		for(int i = 0 ; i < 4; i++ ){
			System.out.println(" seed --->>:" + random.nextInt());
		}
	}
}
