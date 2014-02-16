package eight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 使用CountDownLatch协调子线程
 * 
 * @author Chain
 * 
 */
public class CountDownLatchTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 参加赛跑的人数
		int num = 10;
		// 发令枪只响一次
		CountDownLatch begin = new CountDownLatch(1);
		// 参与跑步者的人数
		CountDownLatch end = new CountDownLatch(num);
		// 每个跑步者有一个跑道
		ExecutorService es = Executors.newFixedThreadPool(num);
		// 记录跑步的成绩
		List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		//参赛者就位，所有线程处于等待状态
		for (int i = 0; i < num; i++) {
			list.add(es.submit(new Runner(begin, end)));
		}
		//发令枪响，参赛者开始跑，线程开始运行
		begin.countDown();
		end.await();
		int count = 0;
		for(Future<Integer> f : list){
			count += f.get();
		}
		System.out.println(count/num);
	}

	static class Runner implements Callable<Integer> {
		private CountDownLatch begin;
		private CountDownLatch end;

		public Runner(CountDownLatch begin, CountDownLatch end) {
			this.begin = begin;
			this.end = end;
		}

		@Override
		public Integer call() throws Exception {
			// 跑步的成绩
			int score = new Random().nextInt(25);
			// 等待发令枪响起
			begin.wait();
			TimeUnit.MILLISECONDS.sleep(score);
			end.countDown();
			return score;
		}

		public CountDownLatch getBegin() {
			return begin;
		}

		public void setBegin(CountDownLatch begin) {
			this.begin = begin;
		}

		public CountDownLatch getEnd() {
			return end;
		}

		public void setEnd(CountDownLatch end) {
			this.end = end;
		}
	}
}
