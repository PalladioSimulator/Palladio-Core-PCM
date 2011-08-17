package de.uka.ipd.sdq.simucomframework.fork;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.garbagecollection.IRegionBasedGarbageCollector;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess;


/**
 * Base class for ForkBehaviours. Generator creates a specialisation of this and
 * uses it to execute actions in parallel
 * @author Steffen Becker
 *
 */
public abstract class ForkedBehaviourProcess extends SimProcess {

	protected Context ctx;
	private ISimProcessDelegate myParent;
	protected String assemblyContextID;
	private boolean isAsync;
	private boolean isTerminated = false;
	private IRegionBasedGarbageCollector<RequestContext> blackboardGarbageCollector;

	private static Logger logger = 
		Logger.getLogger(ForkedBehaviourProcess.class.getName());

	public ForkedBehaviourProcess(Context myContext, String assemblyContextID, boolean isAsync) {
		super(myContext.getModel(), "Forked Behaviour", myContext.getThread().getRequestContext());
		this.ctx = new ForkContext(myContext,this);
		this.myParent = myContext.getThread();
		this.assemblyContextID = assemblyContextID;
		this.isAsync = isAsync;
		this.blackboardGarbageCollector = ProbeSpecContext.instance()
				.getBlackboardGarbageCollector();
	}

	@Override
	protected void internalLifeCycle() {
		blackboardGarbageCollector.enterRegion(getRequestContext()
				.rootContext());
		executeBehaviour();
		blackboardGarbageCollector.leaveRegion(getRequestContext()
				.rootContext());
		this.isTerminated  = true;
		if (!isAsync)
			myParent.scheduleAt(0);
		else
			logger.debug("Asynch behaviour finished at simtime "+getModel().getSimulationControl().getCurrentSimulationTime());
	}
	
	/**
	 * Template method filled by the generate with the parallel behaviour specified
	 * in the PCM's fork action
	 */
	protected abstract void executeBehaviour();

	public boolean isAsync() {
		return isAsync;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess#isTerminated()
	 */
	@Override
	public boolean isTerminated() {
		return this.isTerminated;
	}
	
}
