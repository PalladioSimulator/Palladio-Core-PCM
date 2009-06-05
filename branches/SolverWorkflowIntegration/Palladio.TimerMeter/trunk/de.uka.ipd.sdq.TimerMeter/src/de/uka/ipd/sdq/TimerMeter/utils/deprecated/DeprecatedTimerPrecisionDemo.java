package de.uka.ipd.sdq.TimerMeter.utils.deprecated;

import org.apache.log4j.Logger;

public class DeprecatedTimerPrecisionDemo {

	public static void main(String args[]){
		DeprecatedTimerPrecisionDemo tpc = new DeprecatedTimerPrecisionDemo();
		tpc.getDurationOfNothing();
		tpc.getDurationOf02();
		tpc.getDurationOf04();
		tpc.getDurationOf08();
		tpc.getDurationOf12();
		tpc.getDurationOf16();
	}
	
	private Logger log;
	
	public DeprecatedTimerPrecisionDemo(){
		log = Logger.getLogger(this.getClass().getCanonicalName());
	}
	
	public void getDurationOf02(){
		log.debug("getDurationOfNothing(int,boolean) started");
		long start;
		long finish;
		int i=0;
		start = System.nanoTime();
		i += 1;
		i -= 1;

		finish = System.nanoTime();
		log.debug(""+(finish-start));
	}	
	
	public void getDurationOf04(){
		log.debug("getDurationOfNothing(int,boolean) started");
		long start;
		long finish;
		int i=0;
		start = System.nanoTime();
		i += 1;
		i -= 1;
		i += 1;
		i -= 1;
		finish = System.nanoTime();
		log.debug(""+(finish-start));
	}	
	
	public void getDurationOf08(){
		log.debug("getDurationOfNothing(int,boolean) started");
		long start;
		long finish;
		int i=0;
		start = System.nanoTime();
		i += 1;
		i -= 1;
		i += 1;
		i -= 1;
		i += 1;
		i -= 1;
		i += 1;
		i -= 1;
		finish = System.nanoTime();
		log.debug(""+(finish-start));
	}	
	
	public void getDurationOf12(){
		log.debug("getDurationOfNothing(int,boolean) started");
		long start;
		long finish;
		int i=0;
		start = System.nanoTime();
		i += 1;
		i -= 1;
		i += 1;
		i -= 1;
		i += 1;
		i -= 1;
		i += 1;
		i -= 1;
		i += 1;
		i -= 1;
		i += 1;
		i -= 1;
		finish = System.nanoTime();
		log.debug(""+(finish-start));
	}	
	
	public void getDurationOf16(){
		log.debug("getDurationOfNothing(int,boolean) started");
		long start;
		long finish;
		int i=0;
		start = System.nanoTime();
		i += 1;
		i -= 1;
		i += 1;
		i -= 1;
		i += 1;
		i -= 1;
		i += 1;
		i -= 1;
		i += 1;
		i -= 1;
		i += 1;
		i -= 1;
		i += 1;
		i -= 1;
		i += 1;
		i -= 1;
		finish = System.nanoTime();
		log.debug(""+(finish-start));
	}
	
	public void getDurationOfNothing(){
		log.debug("getDurationOfNothing(int,boolean) started");
		long start;
		long finish;
		start = System.nanoTime();
		finish = System.nanoTime();
		log.debug(""+(finish-start));
	}
}
