package geym.conc.ch2.inter;

/**
 * �ж�״̬���Լ�⣬����Ӧ����������Ӧ
 * ���Ӧ�ò���Ӧ�жϣ���T1��Զ�����˳�
 *
 * @author Administrator
 */
public class InterruputThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main is running");
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Interruted!");
                        break;
                    }
                    Thread.yield();
                }
                System.out.println(Thread.currentThread().getName() + " is " + Thread.currentThread().isInterrupted());
            }
        };
        t1.start();
        System.out.println(" begin interrupt");
        Thread.sleep(2000);
        t1.interrupt();
        System.out.println(Thread.currentThread().getName() + " is " + Thread.currentThread().isInterrupted());
    }
}
