package eight;

public class ThreadTest {
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			new TestThread().start(i % 10 + 1);
		}
	}
}

class TestThread implements Runnable {

	public void start(int priority) {
		Thread th = new Thread(this);
		th.setPriority(priority);
		th.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 100000; i++) {
			Math.hypot(Math.pow(95645431, i), Math.cos(i));
		}
		System.out.println("priority : " + Thread.currentThread().getPriority());
	}

}