package de.uka.ipd.sdq.benchmarks.concurrency.client.simple;

import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.BehaviourThreadStub;
import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.BehaviourWrapper;
import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.IBehaviourStrategy;
import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.simple.SimpleBehaviour;
import de.uka.ipd.sdq.benchmarks.concurrency.client.AbstractBenchmark;
import de.uka.ipd.sdq.benchmarks.concurrency.server.RmiHelper;
import de.uka.ipd.sdq.benchmarks.concurrency.workload.ClosedLoadDriverZeroThinkTime;
import de.uka.ipd.sdq.benchmarks.concurrency.workload.ILoadDriver;

public class SimpleBenchmark extends AbstractBenchmark {

	public static void main(String[] args) {
		initialize(args);

		for (Scenarios s : scenarioList) {
			switch (s) {
			case scaled:
				measureScaledHeavyLoadScenario();
				break;
			case heavy:
				measureHeavyLoadScenario();
				break;
			case heavyLinux:
				measureLinuxHeavyLoadScenario();
				break;
			case noboost:
				measureNoBoostScenario();
				break;
			case semaphore:
				measureSemaphoreScenario();
				break;
			case network:
				measureNetworkScenario();
				break;
			case linux:
				measureLinuxScenario();
				break;
			default:
				break;
			}
		}

		close();
	}

	protected static void measureScaledHeavyLoadScenario() {
		ILoadDriver driver = new ClosedLoadDriverZeroThinkTime();

		for (int j = 0; j < number_of_tasks; j++) {
			for (int i = 0; i < number_of_processors; i++) {
				long __delay = delay;
				int __demand = demand;
				String name = "Task " + (j + 1);
				if (i + 1 < number_of_processors) {
					__delay = duration + 1000;
					__demand = 1000;
					name = "Dummy";
				}
				if (max_repetitions > 0) {
					IBehaviourStrategy behaviour = new SimpleBehaviour(name,
							1000, __delay, __demand, Thread.NORM_PRIORITY,
							max_repetitions, useMemory);
					driver.addBehaviour(behaviour);
				} else {
					IBehaviourStrategy behaviour = new SimpleBehaviour(name,
							1000, __delay, __demand, Thread.NORM_PRIORITY, useMemory);
					driver.addBehaviour(behaviour);
				}
			}
		}
		run(driver, "LB - "
				+ number_of_tasks
				+ " Tasks, "
				+ number_of_processors
				+ "CPUs, "
				+ demand
				+ " ms Demand, "
				+ delay
				+ " ms Delay, "
				+ (max_repetitions > 0 ? (max_repetitions + " Repetitions")
						: ""));
	}

	protected static void measureLinuxHeavyLoadScenario() {
		ILoadDriver driver = new ClosedLoadDriverZeroThinkTime();

		for (int j = 0; j < number_of_tasks; j++) {
			String name = "Task " + (j + 1);
			if (max_repetitions > 0) {
				IBehaviourStrategy behaviour = new SimpleBehaviour(name, 1000,
						delay, demand, Thread.NORM_PRIORITY, max_repetitions, useMemory);
				driver.addBehaviour(behaviour);
			} else {
				IBehaviourStrategy behaviour = new SimpleBehaviour(name, 1000,
						delay, demand, Thread.NORM_PRIORITY, useMemory);
				driver.addBehaviour(behaviour);
			}
		}
		run(driver, "LB - "
				+ number_of_tasks
				+ " Tasks, "
				+ number_of_processors
				+ "CPUs, "
				+ demand
				+ " ms Demand, "
				+ delay
				+ " ms Delay, "
				+ (max_repetitions > 0 ? (max_repetitions + " Repetitions")
						: ""));
	}

	protected static void measureHeavyLoadScenario() {
		IBehaviourStrategy[][] behaviours = new IBehaviourStrategy[number_of_processors][number_of_processors];
		ILoadDriver driver = new ClosedLoadDriverZeroThinkTime();

		for (int j = 0; j < number_of_processors; j++) {
			for (int i = 0; i < number_of_processors; i++) {
				long delay = j <= i ? 0 : duration + 1000;
				int demand = j <= i ? 250 : 1000;
				behaviours[i][j] = new SimpleBehaviour(
						"(" + i + ", " + j + ")", 1000, delay, demand,
						Thread.NORM_PRIORITY, useMemory);
				driver.addBehaviour(behaviours[i][j]);
			}
		}
		run(driver, "SimpleBenchmark - Heavy Load");
	}

	protected static void measureNoBoostScenario() {
		IBehaviourStrategy short_behaviour = new SimpleBehaviour("Short", 500,
				20, 20, Thread.NORM_PRIORITY, useMemory);
		IBehaviourStrategy long_behaviour = new SimpleBehaviour("Long", 600,
				20, 500, Thread.NORM_PRIORITY + 2, useMemory);

		ILoadDriver driver = new ClosedLoadDriverZeroThinkTime();
		driver.addBehaviour(short_behaviour);
		driver.addBehaviour(long_behaviour);

		run(driver, "SimpleBenchmark - No Boost");

	}

	protected static void measureNetworkScenario() {

		// nice -n 0 /cygdrive/c/Programme/Java/jdk1.6.0_02/bin/java.exe
		// -Djava.security.policy="wideopen.policy"
		// -Djava.rmi.server.codebase="file:/D:/Benchmark/Windows/benchmark.jar"
		// -cp benchmark.jar
		// de.uka.ipd.sdq.benchmarks.concurrency.behaviours.simple.SimpleBehaviour
		// -n Short -d 20 -i 500 -v 20
		BehaviourWrapper short_behaviour = RmiHelper.lookUpAndReset("Short");
		IBehaviourStrategy long_behaviour = new SimpleBehaviour("Long", 600,
				20, 500, Thread.NORM_PRIORITY, useMemory);

		ILoadDriver driver = new ClosedLoadDriverZeroThinkTime();
		driver.addBehaviour(short_behaviour, Thread.MAX_PRIORITY);
		driver.addBehaviour(long_behaviour);

		run(driver, "SimpleBenchmark - Network");
	}

	protected static void measureSemaphoreScenario() {
		IBehaviourStrategy short_behaviour = new SimpleBehaviour("Short", 500,
				20, 20, Thread.NORM_PRIORITY, useMemory);
		IBehaviourStrategy long_behaviour = new SimpleBehaviour("Long", 600,
				20, 500, Thread.NORM_PRIORITY + 2, useMemory);
		short_behaviour = new BehaviourThreadStub(short_behaviour);

		ILoadDriver driver = new ClosedLoadDriverZeroThinkTime();
		driver.addBehaviour(short_behaviour, Thread.MAX_PRIORITY);
		driver.addBehaviour(long_behaviour);

		run(driver, "SimpleBenchmark - Semaphore");

	}

//	protected static void measureLinuxScenario() {
//
//		// nice -n 0 /cygdrive/c/Programme/Java/jdk1.6.0_02/bin/java.exe
//		// -Djava.security.policy="wideopen.policy"
//		// -Djava.rmi.server.codebase="file:/D:/Benchmark/Windows/benchmark.jar"
//		// -cp benchmark.jar
//		// de.uka.ipd.sdq.benchmarks.concurrency.behaviours.simple.SimpleBehaviour
//		// -n Short -d 20 -i 500 -v 20
//		BehaviourWrapper short_behaviour = RmiHelper.lookUpAndReset("Short");
//		BehaviourWrapper long_behaviour = RmiHelper.lookUpAndReset("Long");
//		ILoadDriver driver = new ClosedLoadDriverZeroThinkTime();
//		driver.addBehaviour(short_behaviour);
//		driver.addBehaviour(long_behaviour);
//		run(driver, short_behaviour.getDescription());
//	}

	protected static void measureLinuxScenario() {

		BehaviourWrapper short_behaviour = RmiHelper.lookUpAndReset("Short");
		BehaviourWrapper long_behaviour = RmiHelper.lookUpAndReset("Long");

		short_behaviour.setDelay(delay);
		short_behaviour.setDemand(demand);
		
		long_behaviour.setDelay(0);
		long_behaviour.setDemand(demand);
		
		ILoadDriver driver = new ClosedLoadDriverZeroThinkTime();
		driver.addBehaviour(short_behaviour);
		driver.addBehaviour(long_behaviour);
		
		run(driver, "D" + numberToString(demand) + " V" + numberToString(delay));
	}
	
	protected static String numberToString(long number){
		String str = " ";
		if (number < 100)
			str += "0";
		if (number < 10)
			str += "0";
		str += number;
		return str;
	}
}
