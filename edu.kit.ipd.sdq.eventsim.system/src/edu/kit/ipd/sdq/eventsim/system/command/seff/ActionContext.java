package edu.kit.ipd.sdq.eventsim.system.command.seff;

import org.palladiosimulator.pcm.allocation.AllocationContext;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.seff.AbstractAction;

public class ActionContext<A extends AbstractAction> {
	
	private AllocationContext allocationContext;
	
	private AssemblyContext assemblyContext;
	
	private A action;
	
	public ActionContext(AllocationContext allocationContext, AssemblyContext assemblyContext, A action) {
		this.allocationContext = allocationContext;
		this.assemblyContext = assemblyContext;
		this.action = action;
	}
	
	public AllocationContext getAllocationContext() {
		return allocationContext;
	}
	
	public AssemblyContext getAssemblyContext() {
		return assemblyContext;
	}
	
	public A getAction() {
		return action;
	}
	
}
