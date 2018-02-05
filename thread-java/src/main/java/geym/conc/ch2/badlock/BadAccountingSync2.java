package geym.conc.ch2.badlock;

public class BadAccountingSync2 implements Runnable{
	static int i=0;
	public synchronized void increase(){
		i++;
	}
	@Override
	public void run() {
		for(int j=0;j<10000;j++){
			increase();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(new BadAccountingSync2());
		Thread t2=new Thread(new BadAccountingSync2());
		t1.start();t2.start();
		t1.join();t2.join();
		System.out.println(i);
	}
}
