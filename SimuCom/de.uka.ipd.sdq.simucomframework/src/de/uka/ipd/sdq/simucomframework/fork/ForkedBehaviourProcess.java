package de.uka.ipd.sdq.simucomframework.fork;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess;
import de.uka.ipd.sdq.simucomframework.resources.AbstractSimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStack;

/**
 * Context for forked behaviours
 * @author Steffen Becker
 *
 */
class ForkContext extends Context {
	
	private Context parentContext;

	/**
	 * Constructor of the parallel process
	 * @param parentContext The current context of the parent thread.
	 * Used to evaluate variables in the parallel process 
	 * @param parent The parent process
	 */
	public ForkContext(Context parentContext, SimProcess parent) {
		super(parentContext.getModel());
		this.setSimProcess(parent);
		this.parentContext = parentContext;
		this.stack = new SimulatedStack<Object>();

		// Run this thread with a copy of the parents stackframe
		// Likely subject to change in later PCM versions
		this.stack.pushStackFrame(parentContext.getStack().currentStackFrame().copyFrame());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6701742993106975705L;

	@Override
	public AbstractSimulatedResourceContainer findResource(String assemblyContextID) {
		// Use my parents allocation information to do my look ups
		return parentContext.findResource(assemblyContextID);
	}

	@Override
	protected void initialiseAssemblyContextLookup() {
		// Emtpy as we use our parents allocation lookup
	}
	
	@Override
	protected void initialiseAllocationConnectors() {
		// TODO:
		// Probably empty. Check!
	}
}

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

	private static Logger logger = 
		Logger.getLogger(ForkedBehaviourProcess.class.getName());

	public ForkedBehaviourProcess(Context myContext, String assemblyContextID, boolean isAsync) {
		super(myContext.getModel(), "Forked Behaviour");
		this.ctx = new ForkContext(myContext,this);
		this.myParent = myContext.getThread();
		this.assemblyContextID = assemblyContextID;
		this.isAsync = isAsync;
	}

	@Override
	protected void internalLifeCycle() {
		executeBehaviour();
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
