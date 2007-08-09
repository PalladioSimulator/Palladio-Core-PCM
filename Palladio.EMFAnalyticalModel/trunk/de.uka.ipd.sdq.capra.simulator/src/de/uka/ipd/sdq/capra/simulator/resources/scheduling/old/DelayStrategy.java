package de.uka.ipd.sdq.capra.simulator.resources.scheduling.old;



public class DelayStrategy extends AbstractSynchronousTimeProgressionStrategy {

	public DelayStrategy() {
		super(new SynchronousTimeProgressionJobManager());
	}

	@Override
	protected double computeProcessedDemand(double passedTime) {
		return passedTime;
	}

}
