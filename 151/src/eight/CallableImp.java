package eight;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableImp {

	public static void main(String[] args) throws Exception{
		// 生成一个单线程的异步执行器
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<Integer> future = es.submit(new TaxCalCulation(10000));
		while(!future.isDone()){
			TimeUnit.MILLISECONDS.sleep(200);
			System.out.print("#");
		}
		System.out.println("\n计算完成: " + future.get() + "元");
		es.shutdown();
	}
}

class TaxCalCulation implements Callable<Integer>{
	
	private Integer seedMoney;//本金
	
	public TaxCalCulation(Integer _seedMoney){
		this.seedMoney = _seedMoney;
	}
	
	@Override
	public Integer call() throws Exception {
		//复杂计算，运行一次需要10秒
		TimeUnit.MILLISECONDS.sleep(10000);
		return seedMoney/10;
	}
	
}
