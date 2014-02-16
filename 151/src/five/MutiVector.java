package five;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class MutiVector {

	public static void main(String[] args) {
//		vectorThread();
		mutiThread();
	}

	static void listThread() {
		final List<String> tickets = new ArrayList<String>();
		for (int i = 0; i < 100000; i++) {
			tickets.add("Train tickets " + i);
		}
		Thread returnThread = new Thread() {
			@Override
			public void run() {
				while (true) {
					tickets.add(" Train tickets " + new Random().nextInt());
				}
			}
		};
		Thread saleThread = new Thread() {
			@Override
			public void run() {
				for (String s : tickets) {
					tickets.remove(s);
				}
			}
		};
		returnThread.start();
		saleThread.start();
	}

	static void vectorThread() {//
		final Vector<String> tickets = new Vector<String>();
		for (int i = 0; i < 100000; i++) {
			tickets.add("Train tickets " + i);
		}
		Thread returnThread = new Thread() {
			@Override
			public void run() {
				while (true) {
					tickets.add(" Train tickets " + new Random().nextInt());
				}
			}
		};
		Thread saleThread = new Thread() {
			@Override
			public void run() {
				for (String s : tickets) {
					tickets.remove(s);
				}
			}
		};
		returnThread.start();
		saleThread.start();
	}

	static void mutiThread() {
		final Vector<String> tickets = new Vector<String>();
		for (int i = 0; i < 100000; i++) {
			tickets.add("Train tickets " + i);
		}

		for (int i = 0; i < 10; i++) {
			new Thread(){
				public void run() {
					while(true){
						if(tickets.size()>0){
							System.out.println(Thread.currentThread().getId()
									+ "---" + tickets.remove(0));
						}
					}
				};
			}.start();
		}
	}

}
