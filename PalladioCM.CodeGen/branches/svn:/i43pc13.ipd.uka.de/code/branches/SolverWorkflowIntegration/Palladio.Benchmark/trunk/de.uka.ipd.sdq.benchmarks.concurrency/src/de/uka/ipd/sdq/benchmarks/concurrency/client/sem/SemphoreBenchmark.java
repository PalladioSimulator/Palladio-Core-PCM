package de.uka.ipd.sdq.benchmarks.concurrency.client.sem;

import java.util.concurrent.Semaphore;

import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.IBehaviourStrategy;
import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.sem.SemaphoreBehaviour;
import de.uka.ipd.sdq.benchmarks.concurrency.client.AbstractBenchmark;
import de.uka.ipd.sdq.benchmarks.concurrency.workload.ClosedLoadDriverZeroThinkTime;
import de.uka.ipd.sdq.benchmarks.concurrency.workload.ILoadDriver;

public class SemphoreBenchmark extends AbstractBenchmark {

	public static void main(String[] args) {
		initialize(args);
		measureSemaphoreScenario();
		close();
	}

	protected static void measureSemaphoreScenario() {
		Semaphore semaphore = new Semaphore(1, true);
		ILoadDriver driver = new ClosedLoadDriverZeroThinkTime();
		int size = 3;

		IBehaviourStrategy[] task = new IBehaviourStrategy[size];
		for (int i = 0; i < size; i++) {
			task[i] = new SemaphoreBehaviour("Task " + (i + 1), 100, delay,
					demand, Thread.NORM_PRIORITY, useMemory, semaphore);
			driver.addBehaviour(task[i]);
		}

		run(driver, (semaphore.isFair() ? "Fair " : "Unfair ") + " Demand: "
				+ demand + " Delay: " + delay);
	}

}
