package geym.conc.ch2.group;

public class ThreadGroupName implements Runnable {
	public static void main(String[] args) {
		/*
		  1:
		 */
		//1：先声明一个线程组
		ThreadGroup tg = new ThreadGroup("PrintGroup");
		//2:线程加入到线程组中，并给某个线程起名称
		Thread t1 = new Thread(tg, new ThreadGroupName(), "T1");
		Thread t2 = new Thread(tg, new ThreadGroupName(), "T2");
		t1.start();
		t2.start();
		System.out.println(tg.activeCount());
		tg.list();
	}

	@Override
	public void run() {
		String groupAndName = Thread.currentThread().getThreadGroup().getName()
				+ "-" + Thread.currentThread().getName();
		while (true) {
			System.out.println("I am " + groupAndName);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
