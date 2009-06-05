package de.uka.ipd.sdq.measurement.strategies.activeresource.cpu;

import de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum;

public class WaitDemand extends AbstractDemandStrategy {

	public WaitDemand() {
		
		/** define the calibration accuracy parameter */
		high = 3; 
		medium = 0;
		low = -2;

		/** which amount of time is waited for the test */
		defaultIterationCount = 10;
		
		/** number of warm up cycles before calibrating */
		warmUpCycles = 50;
	}

	private void waitFor(long waitingTime) {
		try {
			Thread.sleep(waitingTime);
		} catch (InterruptedException e) {
		}
	}

	@Override
	public void run(long initial) {
		waitFor(initial);
	}

	@Override
	public ResourceTypeEnum getStrategysResource() {
		return ResourceTypeEnum.CPU;
	}

	@Override
	public String getName() {
		return "Wait";
	}

}
