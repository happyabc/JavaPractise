package geym.conc.ch6.stamped;

public class StampedLockDemo {
	static Point point=new Point();
	
	static class WritePoint implements Runnable{
		@Override
		public void run() {
			point.move(Math.random(), Math.random());
		}
	}	
	static class ReadPoint implements Runnable{
		@Override
		public void run() {
			point.distanceFromOrigin();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(new WritePoint());
		Thread t2=new Thread(new ReadPoint());
		t1.start();
		Thread.sleep(100);
		t2.start();
	}

}
