package geym.conc.ch6.pstream;

import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class PrimeMain {

	public static void main(String[] args) {
		long b=System.currentTimeMillis();
//		IntStream.range(1, 1000000).parallel().filter(PrimeUtil::isPrime).count();
		IntStream.range(1, 1000000).filter(PrimeUtil::isPrime).count();
		long e=System.currentTimeMillis();
		System.out.println("spend:"+(e-b)+"ms");
	}

}
