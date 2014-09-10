package org.palladiosimulator.protocom.framework.java.ee.experiment;

import java.util.Stack;

import org.palladiosimulator.protocom.framework.java.ee.common.ICallVisitor;

/**
 *
 * @author Christian Klaussner
 */
class StartTime {
	private String id;
	private long time;

	public StartTime(String id, long time) {
		this.id = id;
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public long getTime() {
		return time;
	}
}

/**
 *
 * @author Christian Klaussner
 */
public final class ExperimentVisitor implements ICallVisitor {

	// Singleton fields and methods.

	private static ExperimentVisitor instance;

	public static ExperimentVisitor getInstance() {
		if (instance == null) {
			instance = new ExperimentVisitor();
		}

		return instance;
	}

	private ExperimentVisitor() {
	}

	//

	private ExperimentManager manager = ExperimentManager.getInstance();
	private Stack<StartTime> startTimes = new Stack<StartTime>();

	@Override
	public void preCallVisit(String callId) {
		StartTime start = new StartTime(callId, System.nanoTime());
		startTimes.push(start);
	}

	@Override
	public void postCallVisit(String callId) {
		long now = System.nanoTime();
		StartTime start = startTimes.pop();

		manager.takeMeasurement(callId, start.getTime(), now);
	}
}
