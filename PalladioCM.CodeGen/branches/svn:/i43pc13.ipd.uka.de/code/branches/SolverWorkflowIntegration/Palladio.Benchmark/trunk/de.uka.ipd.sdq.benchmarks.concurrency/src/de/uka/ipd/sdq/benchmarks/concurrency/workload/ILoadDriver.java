package de.uka.ipd.sdq.benchmarks.concurrency.workload;

import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.BehaviourWrapper;
import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.IBehaviourStrategy;
import de.uka.ipd.sdq.sensorframework.util.ExperimentManager;

public interface ILoadDriver {

	public abstract void addBehaviour(IBehaviourStrategy behaviour);
	
	public abstract void addBehaviour(BehaviourWrapper behaviourWrapper);

	public abstract void stop();

	public abstract void start();

	public abstract void store(ExperimentManager manager);

	public abstract void addBehaviour(BehaviourWrapper behaviour,
			int priority);

	void addBehaviour(IBehaviourStrategy behaviour, int priority);

}