package de.uka.ipd.sdq.measurement.strategies.activeresource.cpu;

import de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum;


public class CountNumbersDemand extends AbstractDemandStrategy {
	
	// needed to stop the JIT compiler from removing the code in execute
	private long k;
	
	public CountNumbersDemand() {
		
		/** define the calibration accuracy parameter */
		high = 2; 
		medium = -1;
		low = -3;
		
		/** how many numbers are counted for the test */
		defaultIterationCount = 10000;
		
		/** number of warm up cycles before calibrating */ 
		warmUpCycles = 5000;
	}
	
	private void countNumbers(double countTo) {
		for (long j=0; j<countTo; j++){
			if (k>100000){
				k=0;
			}
			k+=j;
		}
	}

	@Override
	public void run(long initial) {
		countNumbers(initial);
	}


	//@Override
	@Override
	public ResourceTypeEnum getStrategysResource() {
		return ResourceTypeEnum.CPU;
	}

	//@Override
	@Override
	public String getName() {
		return "CountNumbers";
	}

}
