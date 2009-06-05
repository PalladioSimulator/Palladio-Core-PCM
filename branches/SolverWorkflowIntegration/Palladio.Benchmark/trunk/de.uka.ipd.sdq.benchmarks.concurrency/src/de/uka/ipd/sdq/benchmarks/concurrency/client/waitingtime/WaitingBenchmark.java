package de.uka.ipd.sdq.benchmarks.concurrency.client.waitingtime;

import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.BehaviourThreadStub;
import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.BehaviourWrapper;
import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.IBehaviourStrategy;
import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.simple.SimpleBehaviour;
import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.waitingtime.WaitingTimeMeasuringBehaviour;
import de.uka.ipd.sdq.benchmarks.concurrency.client.AbstractBenchmark;
import de.uka.ipd.sdq.benchmarks.concurrency.server.RmiHelper;
import de.uka.ipd.sdq.benchmarks.concurrency.workload.ClosedLoadDriverZeroThinkTime;
import de.uka.ipd.sdq.benchmarks.concurrency.workload.ILoadDriver;

public class WaitingBenchmark extends AbstractBenchmark {

	public static void main(String[] args) {
		initialize(args);
//		measureEqualPrioScenario();
//		measureAcqiringScenario();
//		measureDistributedScenario();
//		measureNoBoostScenario();
		measureSemaphoreScenario();
		close();
	}

	protected static void measureEqualPrioScenario() {
		IBehaviourStrategy short_behaviour = new WaitingTimeMeasuringBehaviour("Short", 500, 0, 100, Thread.NORM_PRIORITY);
		IBehaviourStrategy long_behaviour = new WaitingTimeMeasuringBehaviour("Long", 600, 0, 500, Thread.NORM_PRIORITY);

		ILoadDriver driver = new ClosedLoadDriverZeroThinkTime();
		driver.addBehaviour(short_behaviour);
		driver.addBehaviour(long_behaviour);
		
		run(driver,"WaitingTime - Equal Priority");

	}

	protected static void measureNoBoostScenario() {
		IBehaviourStrategy short_behaviour = new WaitingTimeMeasuringBehaviour("Short", 500, 100, 100, Thread.NORM_PRIORITY);
		IBehaviourStrategy long_behaviour = new SimpleBehaviour("Long", 600, 100, 500, Thread.NORM_PRIORITY + 2,useMemory);

		ILoadDriver driver = new ClosedLoadDriverZeroThinkTime();
		driver.addBehaviour(short_behaviour);
		driver.addBehaviour(long_behaviour);
		
		run(driver,"WaitingTime - No Boost");

	}

	protected static void measureDistributedScenario() {
		
		// nice -n 0 /cygdrive/c/Programme/Java/jdk1.6.0_02/bin/java.exe -Djava.security.policy="wideopen.policy" -Djava.rmi.server.codebase="file:/D:/Benchmark/Windows/benchmark.jar" -cp benchmark.jar de.uka.ipd.sdq.benchmarks.concurrency.behaviours.simple.SimpleBehaviour -n Short -d 20 -i 500 -v 20
		BehaviourWrapper short_behaviour = RmiHelper.lookUpAndReset("Short");
		IBehaviourStrategy long_behaviour = new WaitingTimeMeasuringBehaviour("Long", 600, 100, 500, Thread.NORM_PRIORITY + 2 );

		ILoadDriver driver = new ClosedLoadDriverZeroThinkTime();
		driver.addBehaviour(short_behaviour, Thread.MAX_PRIORITY);
		driver.addBehaviour(long_behaviour);
		
		run(driver,"WaitingTime - Network");
	}
	
	protected static void measureAcqiringScenario() {
		IBehaviourStrategy short_behaviour = new WaitingTimeMeasuringBehaviour("Short", 500, 100, 100, Thread.NORM_PRIORITY);
		short_behaviour = new BehaviourThreadStub(short_behaviour);
		IBehaviourStrategy long_behaviour = new WaitingTimeMeasuringBehaviour("Long", 600, 100, 500, Thread.NORM_PRIORITY + 2);

		ILoadDriver driver = new ClosedLoadDriverZeroThinkTime();
		driver.addBehaviour(short_behaviour, Thread.MAX_PRIORITY);
		driver.addBehaviour(long_behaviour);
		
		run(driver,"WaitingTime - Semaphore");

	}
	
	protected static void measureSemaphoreScenario() {
		IBehaviourStrategy short_behaviour = new WaitingTimeMeasuringBehaviour("Short", 500, 20, 20, Thread.NORM_PRIORITY);
		short_behaviour = new BehaviourThreadStub(short_behaviour);
		IBehaviourStrategy long_behaviour = new WaitingTimeMeasuringBehaviour("Long", 600, 20, 500, Thread.NORM_PRIORITY + 2);

		ILoadDriver driver = new ClosedLoadDriverZeroThinkTime();
		driver.addBehaviour(short_behaviour, Thread.MAX_PRIORITY);
		driver.addBehaviour(long_behaviour);
		
		run(driver,"WaitingTime - Semaphore");

	}
}
