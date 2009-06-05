package de.uka.ipd.sdq.benchmarks.concurrency.client.webserver;

import simulation.WebserverModel;
import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.BehaviourWrapper;
import de.uka.ipd.sdq.benchmarks.concurrency.client.AbstractBenchmark;
import de.uka.ipd.sdq.benchmarks.concurrency.server.RmiHelper;
import de.uka.ipd.sdq.benchmarks.concurrency.workload.ILoadDriver;
import de.uka.ipd.sdq.benchmarks.concurrency.workload.OpenLoadDriverZeroThinkTime;

public class WebserverBenchmark extends AbstractBenchmark {

	public static void main(String[] args) {
		initialize(args);

		measureSimpleWsScenario();

		close();
	}


	protected static void measureSimpleWsScenario() {

		BehaviourWrapper ws_behaviour = RmiHelper.lookUpAndReset("WS");

		ws_behaviour.setDelay(delay);
		ws_behaviour.setDemand(demand);

		ILoadDriver driver = new OpenLoadDriverZeroThinkTime(directory, new WebserverModel());
		driver.addBehaviour(ws_behaviour);

		run(driver, "Webserver");
	}
}
