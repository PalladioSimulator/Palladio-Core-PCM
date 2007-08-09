package de.uka.ipd.sdq.capra.simulator.resources.scheduling.old;



public class ProcessorSharingStrategy extends AbstractSynchronousTimeProgressionStrategy {
	
	public ProcessorSharingStrategy() {
		super(new SynchronousTimeProgressionJobManager());
	}

	@Override
	protected double computeProcessedDemand(double passedTime) {
		return passedTime / jobList.size();
	}
}
