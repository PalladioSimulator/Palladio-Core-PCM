package de.uka.ipd.sdq.benchmarks.concurrency.client.penalty;

import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.BehaviourThreadStub;
import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.IBehaviourStrategy;
import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.penalty.MultiAcquisitionBehaviour;
import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.simple.SimpleBehaviour;
import de.uka.ipd.sdq.benchmarks.concurrency.client.AbstractBenchmark;
import de.uka.ipd.sdq.benchmarks.concurrency.workload.ClosedLoadDriverZeroThinkTime;
import de.uka.ipd.sdq.benchmarks.concurrency.workload.ILoadDriver;

public class PenaltyBenchmark extends AbstractBenchmark {

	public static void main(String[] args) {
		initialize(args);
		measureAcqiringScenario(1);
		measureAcqiringScenario(10);
		measureAcqiringScenario(100);
		close();
	}

	protected static void measureAcqiringScenario(int num_aq) {
		IBehaviourStrategy short_behaviour = new MultiAcquisitionBehaviour("Short", 500, 100, 100, Thread.NORM_PRIORITY,num_aq);
		short_behaviour = new BehaviourThreadStub(short_behaviour);
		IBehaviourStrategy long_behaviour = new SimpleBehaviour("Long", 600, 100, 500, Thread.NORM_PRIORITY + 2, useMemory);

		ILoadDriver driver = new ClosedLoadDriverZeroThinkTime();
		driver.addBehaviour(short_behaviour, Thread.MAX_PRIORITY);
		driver.addBehaviour(long_behaviour);
		
		run(driver,"Penalty - Aquisitions: " + num_aq);
	}
}
