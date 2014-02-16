package eight;

public class ThreadException {
	public static void main(String[] args) {
		new TcpServer();
	}
}

class TcpServer implements Runnable {
	public TcpServer(){
		Thread t = new Thread(this);
		t.setUncaughtExceptionHandler(new TcpExceptionHandler());
		t.start();
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("系统正常运行: " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		throw new RuntimeException();
	}

	private static class TcpExceptionHandler implements
		Thread.UncaughtExceptionHandler{
		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println("线程" + t.getName() + "出现异常，程序自动重启" );
			e.printStackTrace();
			new TcpServer();
		}
	}
	
}