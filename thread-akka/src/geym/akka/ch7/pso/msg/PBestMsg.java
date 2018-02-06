package geym.akka.ch7.pso.msg;

import geym.akka.ch7.pso.PsoValue;


public final class PBestMsg {
	final PsoValue value;
	public PBestMsg(PsoValue v){
		value=v;
	}

	public PsoValue getValue() {
		return value;
	}
	 
	public String toString(){
		return value.toString();
	}
}
