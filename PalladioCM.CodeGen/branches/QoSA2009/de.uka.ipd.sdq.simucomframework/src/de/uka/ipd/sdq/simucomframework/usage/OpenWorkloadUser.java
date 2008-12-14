package de.uka.ipd.sdq.simucomframework.usage;

import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.sensors.SensorHelper;

/**
 * Base class for open workload users. Open workload users begin their life,
 * execute their behaviour once, and then they die
 * 
 * @author Steffen Becker
 * 
 */
public class OpenWorkloadUser extends SimProcess implements IUser {

	private IScenarioRunner scenarioRunner;

	private SimuComModel model;
	private ExperimentRun experimentRun;
	private StateSensor stateSensor;
	private State stateSuccess;
	private State stateFailure;

	private static int runCount = 0;
	private static int failureCount = 0;

	public OpenWorkloadUser(SimuComModel owner, String name,
			IScenarioRunner scenarioRunner) {

		// Call the SimProcess constructor:
		super(owner, name);

		// Add a state sensor for capturing success or failure
		// of the usage scenario:
		this.model = owner;
		this.experimentRun = model.getCurrentExperimentRun();
		this.stateSuccess = SensorHelper.createOrReuseState(model
				.getDAOFactory(), "Success");
		this.stateFailure = SensorHelper.createOrReuseState(model
				.getDAOFactory(), "Failure");
		this.stateSensor = SensorHelper.createOrReuseStateSensor(model
				.getDAOFactory(), model.getExperimentDatastore(), model
				.getExperimentDatastore().getExperimentName()
				+ ": Success of " + name, this.stateSuccess);

		// Set the ScenarioRunner:
		this.scenarioRunner = scenarioRunner;
	}

	/**
	 * Performs a single scenario run and increases the failure counter if a
	 * failure occurs.
	 */
	@Override
	protected void internalLifeCycle() {

		// Inform the user in the case of verbose logging:
		logger.debug(this.getName() + " started! I'm alive!!!");

		// Try to run the scenario. Catch RuntimeException with
		// message "Internal Action Failed":
		try {

			// Run the scenario:
			scenarioRunner(this);

			// Indicate scenario success:
			experimentRun.addStateMeasurement(stateSensor, stateSuccess, model
					.getSimulationControl().getCurrentSimulationTime());

		} catch (RuntimeException exception) {

			// A runtime exception has occurred:
			if (exception.getMessage() == "Internal Action Failed") {

				// Increase the failure counter:
				failureCount++;

				// Indicate scenario failure:
				experimentRun
						.addStateMeasurement(stateSensor, stateFailure, model
								.getSimulationControl()
								.getCurrentSimulationTime());
			} else {
				
				// The exception is unknown. Escalate it:
				throw exception;
			}
		} finally {
			
			// Increase the run counter:
			runCount++;
		}

		// Inform the user in the case of verbose logging:
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
	 * Returns the number of failures occurred during a usage scenario run of an
	 * open workload user
	 * 
	 * @return the number of failures occurred
	 */
	public static int getFailureCount() {
		return failureCount;
	}
}
