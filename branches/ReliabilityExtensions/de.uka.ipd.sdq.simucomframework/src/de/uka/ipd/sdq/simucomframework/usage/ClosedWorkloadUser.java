package de.uka.ipd.sdq.simucomframework.usage;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess;
import de.uka.ipd.sdq.simucomframework.exceptions.CommunicationLinkFailedException;
import de.uka.ipd.sdq.simucomframework.exceptions.InternalActionFailedException;
import de.uka.ipd.sdq.simucomframework.exceptions.ResourceNotAvailableException;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * A closed workload user is a user which performs the typical closed workload
 * clycle: execute, think, execute, ...
 * 
 * @author Steffen Becker
 * 
 */
public class ClosedWorkloadUser extends SimProcess implements IUser {

	private static Logger logger = Logger.getLogger(ClosedWorkloadUser.class
			.getName());

	private IScenarioRunner scenarioRunner;
	private String thinkTime;

	// Failure counters:
	private static int INTERNALACTIONFAILURECOUNT = 0;
	private static int COMMUNICATIONLINKFAILURECOUNT = 0;
	private static int RESOURCEUNAVAILABILITYCOUNT = 0;
	private static int USERCOUNT = 0;
	private static int RUNCOUNT = 0;

	/**
	 * Constructor of the closed workload user
	 * 
	 * @param owner
	 *            The model this user belongs to
	 * @param name
	 *            The users name
	 * @param scenarioRunner2
	 *            The scenario runner determining the users behaviour
	 * @param thinkTimeSpec
	 *            A stoex which deterimines the users think time
	 */
	public ClosedWorkloadUser(SimuComModel owner, String name,
			IScenarioRunner scenarioRunner2, String thinkTimeSpec) {
		super(owner, name);
		this.scenarioRunner = scenarioRunner2;
		this.thinkTime = thinkTimeSpec;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see desmoj.core.simulator.SimProcess#lifeCycle()
	 */
	@Override
	protected void internalLifeCycle() {

		// Repeat usage scenario runs as long as simulation is running:
		while (getModel().getSimulationControl().isRunning()) {
			try {
				RUNCOUNT++;
				scenarioRunner(this);
			} catch (InternalActionFailedException exception) {
				logger.debug(this.getName()
						+ " experienced InternalActionFailedException.");
				INTERNALACTIONFAILURECOUNT++;
			} catch (CommunicationLinkFailedException exception) {
				logger.debug(this.getName()
						+ " experienced CommunicationLinkFailedException.");
				COMMUNICATIONLINKFAILURECOUNT++;
			} catch (ResourceNotAvailableException exception) {
				logger.debug(this.getName()
						+ " experienced ResourceNotAvailableException.");
				RESOURCEUNAVAILABILITYCOUNT++;
			}
		}

		// Mark user as finished:
		USERCOUNT--;

		// Print failure statistics after last user is finished:
		if (USERCOUNT == 0) {
			logger.warn("Total usage scenario runs: " + RUNCOUNT);
			logger.warn("Internal action failures: "
					+ INTERNALACTIONFAILURECOUNT);
			logger.warn("Communication link failures: "
					+ COMMUNICATIONLINKFAILURECOUNT);
			logger.warn("Resource unavailability failures: "
					+ RESOURCEUNAVAILABILITYCOUNT);
			logger
					.warn("Total failure rate: "
							+ (double) (INTERNALACTIONFAILURECOUNT
									+ COMMUNICATIONLINKFAILURECOUNT + RESOURCEUNAVAILABILITYCOUNT)
							/ (double) RUNCOUNT);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.simucomframework.usage.IScenarioRunner#scenarioRunner(desmoj.core.simulator.SimProcess)
	 */
	public void scenarioRunner(SimProcess thread) {
		double thinkTime = (Double) Context.evaluateStatic(this.thinkTime,
				Double.class, null);
		this.hold(thinkTime);
		this.scenarioRunner.scenarioRunner(thread);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.simucomframework.usage.IUser#startUserLife()
	 */
	public void startUserLife() {
		logger.debug(this.getName() + " started! I'm alive!!!");
		USERCOUNT++;
		this.scheduleAt(0);
	}

	/**
	 * Resets the static failure counters of the user class.
	 */
	public static void resetFailureCounters() {
		INTERNALACTIONFAILURECOUNT = 0;
		COMMUNICATIONLINKFAILURECOUNT = 0;
		RESOURCEUNAVAILABILITYCOUNT = 0;
		USERCOUNT = 0;
		RUNCOUNT = 0;
	}
}
