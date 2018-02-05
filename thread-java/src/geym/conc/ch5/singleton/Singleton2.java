package geym.conc.ch5.singleton;

public class Singleton2 {
	public static int STATUS=1;
	private Singleton2() {
		System.out.println("Singleton is create");			//创建单例的过程可能会比较慢
	}
	private static Singleton2 instance = new Singleton2();
	public static Singleton2 getInstance() {
		return instance;
	}
}
