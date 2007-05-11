package de.uka.ipd.sdq.simucomframework.fork;

import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor.SetterOnlyReflection;

import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStack;
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
	public SimulatedResourceContainer findResource(String assemblyContextID) {
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

	public ForkedBehaviourProcess(Context myContext, String assemblyContextID) {
		super(myContext.getModel(), "Forked Behaviour", true);
		this.ctx = new ForkContext(myContext,this);
		this.myParent = myContext.getThread();
		this.assemblyContextID = assemblyContextID;
	}

	@Override
	public void lifeCycle() {
		executeBehaviour();
		myParent.activateAfter(this);
	}

	protected abstract void executeBehaviour();

}
