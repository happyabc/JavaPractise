package geym.conc.ch1;

public class Long2Binary {
	
	
	public static void main(String[] args) {
		System.out.println("+111="+String.format("%64s", Long.toBinaryString(111)).replaceAll(" ", "0"));
		System.out.println("-999="+String.format("%64s", Long.toBinaryString(-999)).replaceAll(" ", "0"));
		System.out.println("+333="+String.format("%64s", Long.toBinaryString(333)).replaceAll(" ", "0"));
		System.out.println("-444="+String.format("%64s", Long.toBinaryString(-444)).replaceAll(" ", "0"));
		
		System.out.println("+4294966852="+String.format("%64s", Long.toBinaryString(4294966852L)).replaceAll(" ", "0"));
		System.out.println("-4294967185="+Long.toBinaryString(-4294967185L));
	}

}
