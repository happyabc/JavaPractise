package geym.conc.ch2.inter;

/**
 * �ж�״̬���Լ�⣬����Ӧ����������Ӧ
 * ���Ӧ�ò���Ӧ�жϣ���T1��Զ�����˳�
 * @author Administrator
 *
 */
public class InterruputThread2 {
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(){
			@Override
			public void run(){
				while(true){
					System.out.println(Thread.currentThread().getName()+" is "+Thread.currentThread().isInterrupted());
					Thread.yield();
				}
			}

		};
		t1.start();
		System.out.println(Thread.currentThread().getName()+" is "+Thread.currentThread().isInterrupted());
		Thread.sleep(2000);
		t1.interrupt();
	}
}
