package geym.conc.ch2.group;

public class ThreadGroupStop implements Runnable {
    /**
     * 可能的一种结果：
     * ------------------------------
     * begin 2
     * I am PrintGroup-T1
     * I am PrintGroup-T2
     * stop end 0
     * ------------------------------
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup tg = new ThreadGroup("PrintGroup");
        Thread t1 = new Thread(tg, new ThreadGroupStop(), "T1");
        Thread t2 = new Thread(tg, new ThreadGroupStop(), "T2");
        t1.start();
        t2.start();
        System.out.println("begin " + tg.activeCount());
        Thread.sleep(3000);
        tg.stop();
        Thread.sleep(9000);
        System.out.println("stop end " + tg.activeCount());
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
