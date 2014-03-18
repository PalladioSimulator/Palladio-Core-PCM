package de.uka.ipd.sdq.simucomframework.usage;

import de.uka.ipd.sdq.probespec.framework.garbagecollection.IRegionBasedGarbageCollector;
import de.uka.ipd.sdq.probespec.framework.requestcontext.RequestContext;
import de.uka.ipd.sdq.reliability.core.FailureStatistics;
import de.uka.ipd.sdq.simucomframework.ReliabilitySensorHelper;
import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simucomframework.exceptions.FailureException;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * Base class for open workload users. Open workload users begin their life,
 * execute their behaviour once, and then they die
 * 
 * @author Steffen Becker
 * 
 */
public class OpenWorkloadUser extends SimuComSimProcess implements IUser {

	private IScenarioRunner scenarioRunner;
	private IRegionBasedGarbageCollector<RequestContext> blackboardGarbageCollector;
	private String usageScenarioId;

	public OpenWorkloadUser(final SimuComModel owner, final String name,
			final IScenarioRunner scenarioRunner, final String usageScenarioId) {
		super(owner, name);
		this.scenarioRunner = scenarioRunner;
        blackboardGarbageCollector = owner.getProbeSpecContext().getBlackboardGarbageCollector();
		this.usageScenarioId = usageScenarioId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see desmoj.core.simulator.SimProcess#lifeCycle()
	 */
	@Override
	protected void internalLifeCycle() {
		if(logger.isDebugEnabled())
			logger.debug(getName() + " started! I'm alive!!!");
		// update session id
		updateNewSessionID();
		try {
			blackboardGarbageCollector.enterRegion(getRequestContext()
					.rootContext());
			scenarioRunner(this);
			if (getModel().getConfiguration().getSimulateFailures()) {
				ReliabilitySensorHelper.recordScenarioRunResultSuccess(
						getModel(), getRequestContext(),
						usageScenarioId);
			}
		} catch (FailureException exception) {
			if (getModel().getConfiguration().getSimulateFailures()) {
				FailureStatistics.getInstance()
						.increaseUnhandledFailureCounter(
								exception.getFailureType(), currentSessionId);
				ReliabilitySensorHelper.recordScenarioRunResultFailure(
						getModel(), exception
								.getFailureType(), getRequestContext(),
						usageScenarioId);
			}
		} finally {
			// Increase measurements counter manually as usage scenario run is
			// not finished:
			getModel().increaseMainMeasurementsCount();

			blackboardGarbageCollector.leaveRegion(getRequestContext()
					.rootContext());
		}
		if(logger.isDebugEnabled())
			logger.debug(getName() + " done! I'm dying!!!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.simucomframework.usage.IScenarioRunner#scenarioRunner(
	 * desmoj.core.simulator.SimProcess)
	 */
	public void scenarioRunner(SimuComSimProcess thread) {
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

}
