package de.uka.ipd.sdq.ByCounterV2;

public class Countee {
	
	public Counter counteeMeth_noOverflowCheck(int input){
		Counter counter = new Counter();
		for(int i=0; i<input; i++){
			Counter.counter_001++;
		}
		return counter;
	}
	
	public static void main(String[] args){
		Countee countee = new Countee();
		int nrIterations = 100000;
		int percent = nrIterations/100;
		for(int i=0; i<nrIterations; i++){
			if(i%percent==0){
				System.out.println(i/percent+"%: "+
						System.currentTimeMillis()+" ms timestamp; "+
						System.nanoTime()+" ns relative time");
			}
			countee.counteeMeth_noOverflowCheck(100);
		}
		System.out.println("Counter.counter_001 value: "+Counter.counter_001);
	}
			
}
