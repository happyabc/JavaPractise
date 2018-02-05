package geym.conc.ch3.trace;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 通过TraceThreadPoolExecutor ，可以知道 在哪里提交的线程
 * @author Geym
 *
 */
public class TraceMain {

	public static void main(String[] args) {
		ThreadPoolExecutor pools=new TraceThreadPoolExecutor(0, Integer.MAX_VALUE,
                0L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
		
		/**
		 * 错误堆栈中可以看到是在哪里提交的任务
		 */
		for(int i=0;i<5;i++){
			pools.execute(new DivTask(100,i));
		}
	}

}
