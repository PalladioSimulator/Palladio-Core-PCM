package org.palladiosimulator.protocom.framework.java.ee.experiment;

import java.util.Stack;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.palladiosimulator.protocom.framework.java.ee.prototype.ICallVisitor;

/**
 * The StartTime class stores the start time of a method call.
 * @author Christian Klaussner
 */
class StartTime {
	private String id;
	private long time;

	/**
	 * Constructs a new StartTime object.
	 * @param id the call ID
	 * @param time the start time in nanoseconds
	 */
	public StartTime(String id, long time) {
		this.id = id;
		this.time = time;
	}

	/**
	 * Gets the call ID.
	 * @return the call ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the start time.
	 * @return the start time in nanoseconds
	 */
	public long getTime() {
		return time;
	}
}

/**
 * The ExperimentVisitor class is used to measure the duration of method calls during an experiment.
 * @author Christian Klaussner
 */
@Singleton
public final class ExperimentVisitor implements ICallVisitor {
	/**
	 * Constructs a new ExperimentVisitor object.
	 */
	public ExperimentVisitor() {
	}
	
	@Inject
	private IExperiment experiment;

	private final Stack<StartTime> startTimes = new Stack<StartTime>();

	@Override
	public void preCallVisit(String callId) {
		StartTime start = new StartTime(callId, System.nanoTime());
		startTimes.push(start);
	}

	@Override
	public void postCallVisit(String callId) {
		long now = System.nanoTime();
		StartTime start = startTimes.pop();

		experiment.takeMeasurement(callId, start.getTime(), now);
	}
}
