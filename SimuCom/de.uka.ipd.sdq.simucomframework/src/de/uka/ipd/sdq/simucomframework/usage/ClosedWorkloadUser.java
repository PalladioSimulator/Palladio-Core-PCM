package de.uka.ipd.sdq.simucomframework.usage;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.probespec.framework.BlackboardVote;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.garbagecollection.IRegionBasedGarbageCollector;
import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess;
import de.uka.ipd.sdq.simucomframework.exceptions.FailureException;
import de.uka.ipd.sdq.simucomframework.exceptions.FailureStatistics;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * A closed workload user is a user which performs the typical closed workload
 * cycle: execute, think, execute, ...
 * 
 * @author Steffen Becker
 * 
 */
public class ClosedWorkloadUser extends SimProcess implements IUser {

	private static Logger logger = Logger.getLogger(ClosedWorkloadUser.class
			.getName());

	private IScenarioRunner scenarioRunner;
	private String thinkTime;

	// private static int USERCOUNT = 0;
	private int runCount = 0;
	
	private IRegionBasedGarbageCollector<RequestContext> blackboardGarbageCollector;

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
	 *            A stoex which determines the users think time
	 */
	public ClosedWorkloadUser(SimuComModel owner, String name,
			IScenarioRunner scenarioRunner2, String thinkTimeSpec) {
		super(owner, name);
		this.scenarioRunner = scenarioRunner2;
		this.thinkTime = thinkTimeSpec;
		this.blackboardGarbageCollector = ProbeSpecContext.instance()
				.getBlackboardGarbageCollector();
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
				if (this.getModel().getConfig().getSimulateFailures()) {
					FailureStatistics.getInstance().increaseRunCount();
					// FailureStatistics.getInstance().printRunCount(logger);
				}
				blackboardGarbageCollector.enterRegion(getRequestContext()
						.rootContext());
				scenarioRunner(this);
			} catch (FailureException exception) {		
				if (this.getModel().getConfig().getSimulateFailures()) {
					FailureStatistics.getInstance().increaseSystemFailureCounter(exception.getFailureType());
				}
			} finally {
				// Increase measurements counter manually as usage scenario run
				// is not finished:
				this.getModel().increaseMainMeasurementsCount();
				
				blackboardGarbageCollector.leaveRegion(getRequestContext()
						.rootContext());
				runCount++;
			}
		}

		// Mark user as finished:
		// USERCOUNT--;

		// Print failure statistics after last user is finished:
		// if (USERCOUNT == 0) {
		// 	if (this.getModel().getConfig().getSimulateFailures()) {
		// 		FailureStatistics.getInstance().printFailureStatistics(logger);
		// 	}
		// }
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.simucomframework.usage.IScenarioRunner#scenarioRunner(
	 * desmoj.core.simulator.SimProcess)
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
		// USERCOUNT++;
		this.scheduleAt(0);
	}


	/**
	 * {@inheritDoc}
	 * <p>
	 * A closed workload user runs through his lifecycle several times in
	 * series. Each time the same {@link SimProcess} is used. In order to be
	 * able to distinguish between the different runs, the request context id
	 * gets concatenated with the run count. The run counts represents how often
	 * the lifecycle has been executed. Thus the returned ID is unique for each
	 * run through the lifecycle.
	 */
	@Override
	public RequestContext getRequestContext() {
		return super.getRequestContext().append("." + runCount);
	}

}
