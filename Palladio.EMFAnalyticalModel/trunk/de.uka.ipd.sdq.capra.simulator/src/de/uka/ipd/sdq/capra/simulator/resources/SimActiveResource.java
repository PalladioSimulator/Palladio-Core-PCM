package de.uka.ipd.sdq.capra.simulator.resources;

import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraProcess;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.ISchedulingStrategy;


public class SimActiveResource extends AbstractSimResource {
	
	private ISchedulingStrategy strategy;
	
	private JobFinishedEvent jobFinished = new JobFinishedEvent(this);

		public SimActiveResource(ISchedulingStrategy strategy, String name) {
		super(name,1);
		this.strategy = strategy;
	}

	public void process(SimCapraProcess capraProcess, double demand) {
		strategy.progressInTime();
		strategy.addJob(new Job(capraProcess,demand));
		scheduleNextJob();		
	}

	public void jobFinishedCallback(Job job) {
		strategy.progressInTime();
		strategy.jobFinishedCallback(job);
		scheduleNextJob();
		job.capraProcess.proceed();
	}

	private void scheduleNextJob() {
		jobFinished.cancel();
		Job job = strategy.getNextJobToBeFinished();
		if (job != null) {
			jobFinished.setJob(job);
			jobFinished.schedule(job.getRemainingTime());
		} 
	}

	@Override
	public void init() {
	}
}
