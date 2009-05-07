package de.uka.ipd.sdq.benchmarks.concurrency.workload;

import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.BehaviourWrapper;
import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.IBehaviourStrategy;


public class OpenLoadDriver extends AbstractLoadDriver {
	
	public OpenLoadDriver(int poolsize) {
		super(poolsize);
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addBehaviour(BehaviourWrapper behaviourWrapper) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addBehaviour(BehaviourWrapper behaviour, int priority) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addBehaviour(IBehaviourStrategy behaviour, int priority) {
		// TODO Auto-generated method stub
		
	}

//	public void start(){
//			executor.scheduleWithFixedDelay(this, initial_delay, delay, TimeUnit.MILLISECONDS);
//	}
}
