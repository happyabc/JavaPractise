package geym.akka.ch7.pso.msg;

import geym.akka.ch7.pso.PsoValue;


public final class GBestMsg  {
	final PsoValue value;
	public GBestMsg(PsoValue v){
		value=v;
	}
	public PsoValue getValue() {
		return value;
	}
}
