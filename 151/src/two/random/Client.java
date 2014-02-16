package two.random;

import java.util.Random;

/**
 * 不要设置随机种子。
 * //如果随机数的种子固定了，那么在同一台电脑上无论运行多少次，产生的随机数都是一样的。
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
