package three;


/**
 * 构造函数尽量简化
 * 
 * 
 * 
 * @author Chain
 * 
 */
public class SimplifyConstract {
	public static void main(String[] args) {
		Server server = new SimpleServer(500);
		server.init();
	}
}

abstract class Server {
	public static final int DEFAUT_PORT = 5000;

	public Server() {
//		int port = getPort();
//		System.out.println("端口号:" + port);
	}

	public void init(){
		int port = getPort();
		System.out.println("端口号:" + port);
	}
	
	protected abstract int getPort();
}

class SimpleServer extends Server {

	private int port = 100;

	public SimpleServer(int _port) {
		port = _port;
	}

	@Override
	protected int getPort() {
		return Math.random() > 0.5 ? port : DEFAUT_PORT;
	}

}