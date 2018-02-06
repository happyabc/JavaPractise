package geym.conc.ch2.inter;

/**
 * 中断状态可以检测，并在应用上作出相应
 * 如果应用不相应中断，则T1永远不会退出
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
