package eight;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableImp {

	public static void main(String[] args) throws Exception{
		// ����һ�����̵߳��첽ִ����
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<Integer> future = es.submit(new TaxCalCulation(10000));
		while(!future.isDone()){
			TimeUnit.MILLISECONDS.sleep(200);
			System.out.print("#");
		}
		System.out.println("\n�������: " + future.get() + "Ԫ");
		es.shutdown();
	}
}

class TaxCalCulation implements Callable<Integer>{
	
	private Integer seedMoney;//����
	
	public TaxCalCulation(Integer _seedMoney){
		this.seedMoney = _seedMoney;
	}
	
	@Override
	public Integer call() throws Exception {
		//���Ӽ��㣬����һ����Ҫ10��
		TimeUnit.MILLISECONDS.sleep(10000);
		return seedMoney/10;
	}
	
}
