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
 * ʹ��CountDownLatchЭ�����߳�
 * 
 * @author Chain
 * 
 */
public class CountDownLatchTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// �μ����ܵ�����
		int num = 10;
		// ����ǹֻ��һ��
		CountDownLatch begin = new CountDownLatch(1);
		// �����ܲ��ߵ�����
		CountDownLatch end = new CountDownLatch(num);
		// ÿ���ܲ�����һ���ܵ�
		ExecutorService es = Executors.newFixedThreadPool(num);
		// ��¼�ܲ��ĳɼ�
		List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		//�����߾�λ�������̴߳��ڵȴ�״̬
		for (int i = 0; i < num; i++) {
			list.add(es.submit(new Runner(begin, end)));
		}
		//����ǹ�죬�����߿�ʼ�ܣ��߳̿�ʼ����
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
			// �ܲ��ĳɼ�
			int score = new Random().nextInt(25);
			// �ȴ�����ǹ����
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
