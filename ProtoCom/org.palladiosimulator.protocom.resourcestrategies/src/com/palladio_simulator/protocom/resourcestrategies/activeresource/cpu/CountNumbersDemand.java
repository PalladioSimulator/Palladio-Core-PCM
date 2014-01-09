package com.palladio_simulator.protocom.resourcestrategies.activeresource.cpu;

import com.palladio_simulator.protocom.resourcestrategies.activeresource.AbstractDemandStrategy;
import com.palladio_simulator.protocom.resourcestrategies.activeresource.ResourceTypeEnum;


public class CountNumbersDemand extends AbstractDemandStrategy {
	
	// needed to stop the JIT compiler from removing the code in execute
	private long k;
	
	public CountNumbersDemand() {
		super(-3,-1,2,10000,5000);
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

	@Override
	public ResourceTypeEnum getStrategysResource() {
		return ResourceTypeEnum.CPU;
	}

	@Override
	public String getName() {
		return "CountNumbers";
	}
	
	@Override
	public void cleanup() {
		// Do nothing.
	}
}
