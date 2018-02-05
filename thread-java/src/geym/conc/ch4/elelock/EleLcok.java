package geym.conc.ch4.elelock;

import java.util.Vector;

public class EleLcok {

	public String[] createStrings(){
		Vector<String> v=new Vector<String>();
		for(int i=0;i<100;i++){
			v.add(Integer.toString(i));
		}
		return v.toArray(new String[]{});
	}
	
	public static void main(String[] args) {
		

	}

}
