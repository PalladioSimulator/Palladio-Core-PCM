package de.uka.ipd.sdq.ByCounterV2;

public class Counter {
	public static long counter_001 = 0;
	public long counter_002 = 0;
	
	public synchronized void increment_002(){
		counter_002++;
	}
	
	public synchronized long increment_002_get(){
		counter_002++;
		return counter_002;
	}
	
	public synchronized void increment_002(long amount){//amount not checked!
		counter_002+=amount;
	}
	
	public synchronized long increment_002_get(long amount){
		counter_002+=amount;
		return counter_002;
	}
	
	public synchronized void increment_002_check() throws ByCounterOverFlowException{
		counter_002++;
	}
	
	public synchronized long increment_002_get_check() throws ByCounterOverFlowException{
		counter_002++;
		return counter_002;
	}
	
	public synchronized void increment_002_check(long amount) throws ByCounterOverFlowException{ 
		counter_002+=amount;
	}
	
	public synchronized long increment_002_get_check(long amount) throws ByCounterOverFlowException{
		counter_002+=amount;
		return counter_002;
	}
}
