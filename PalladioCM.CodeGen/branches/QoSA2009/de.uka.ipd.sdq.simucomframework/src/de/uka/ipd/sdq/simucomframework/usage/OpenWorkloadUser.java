package de.uka.ipd.sdq.simucomframework.usage;

import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * Base class for open workload users. Open workload users begin their life,
 * execute their behaviour once, and then they die
 * 
 * @author Steffen Becker
 * 
 */
public class OpenWorkloadUser extends SimProcess implements IUser {

	private IScenarioRunner scenarioRunner;

	private static int runCount = 0;
	private static int failureCount = 0;

	public OpenWorkloadUser(SimuComModel owner, String name,
			IScenarioRunner scenarioRunner) {
		super(owner, name);
		this.scenarioRunner = scenarioRunner;
	}

	/**
	 * Performs a single scenario run and increases the failure counter if a
	 * failure occurs.
	 */
	@Override
	protected void internalLifeCycle() {
		logger.debug(this.getName() + " started! I'm alive!!!");
		try {
			scenarioRunner(this);
		} catch (RuntimeException exception) {
			if (exception.getMessage() == "Internal Action Failed") {
				failureCount++;
			} else {
				throw exception;
			}
		} finally {
			runCount++;
		}
		logger.debug(this.getName() + " done! I'm dying!!!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.simucomframework.usage.IScenarioRunner#scenarioRunner(desmoj.core.simulator.SimProcess)
	 */
	public void scenarioRunner(SimProcess thread) {
		this.scenarioRunner.scenarioRunner(thread);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.simucomframework.usage.IUser#startUserLife()
	 */
	public void startUserLife() {
		this.scheduleAt(0);
	}

	/**
	 * Resets the run and failure counters.
	 */
	public static void resetCounters() {
		runCount = 0;
		failureCount = 0;
	}

	/**
	 * Returns the number of usage scenario runs of all open workload users.
	 * 
	 * @return the number of usage scenario runs
	 */
	public static int getRunCount() {
		return runCount;
	}

	/**
	 * Returns the number of failures occurred during a usage scenario run of
	 * an open workload user
	 * 
	 * @return the number of failures occurred
	 */
	public static int getFailureCount() {
		return failureCount;
	}
}
