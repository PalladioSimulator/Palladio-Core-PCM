package de.uka.ipd.sdq.simucomframework.fork;

import org.apache.log4j.Logger;

import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor.SetterOnlyReflection;

import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.SimuComStatus;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.AbstractSimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStack;
import de.uka.ipd.sdq.simucomframework.variables.stoexvisitor.PCMStoExEvaluationVisitor;
import desmoj.core.exception.SimFinishedException;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;

class ForkContext extends Context {

	
	private Context parentContext;

	public ForkContext(Context parentContext, SimProcess parent) {
		super(parentContext.getModel());
		this.setSimProcess(parent);
		this.parentContext = parentContext;
		this.stack = new SimulatedStack<Object>();
		this.stack.pushStackFrame(parentContext.getStack().currentStackFrame().copyFrame());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6701742993106975705L;

	@Override
	public AbstractSimulatedResourceContainer findResource(String assemblyContextID) {
		return parentContext.findResource(assemblyContextID);
	}

	@Override
	protected void initialiseAssemblyContextLookup() {
	}
}

public abstract class ForkedBehaviourProcess extends SimProcess {

	protected Context ctx;
	private SimProcess myParent;
	protected String assemblyContextID;

	private static Logger logger = 
		Logger.getLogger(ForkedBehaviourProcess.class.getName());

	public ForkedBehaviourProcess(Context myContext, String assemblyContextID) {
		super(myContext.getModel(), "Forked Behaviour", true);
		this.ctx = new ForkContext(myContext,this);
		this.myParent = myContext.getThread();
		this.assemblyContextID = assemblyContextID;
	}

	@Override
	public void lifeCycle() {
		try {
			executeBehaviour();
		} catch(SimFinishedException ex) {
			return;
		} catch(Exception ex) {
			logger.error("Error in executing forked behaviour!",ex);
			((SimuComModel)this.getModel()).setStatus(SimuComStatus.ERROR, ex);
			this.getModel().getExperiment().stop();
		}
		myParent.activateAfter(this);
	}

	protected abstract void executeBehaviour();

}
