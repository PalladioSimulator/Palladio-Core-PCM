package de.uka.ipd.sdq.dsolver;

import de.uka.ipd.sdq.context.allocation.ActualAllocationContext;
import de.uka.ipd.sdq.context.usage.UsageContext;
import de.uka.ipd.sdq.pcm.assembly.AssemblyContext;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;

public class Context {
	private de.uka.ipd.sdq.pcm.system.System mySystem;
	private AssemblyContext myAssemblyContext;
	
	private UsageContext usageContext;
	private ActualAllocationContext actualAllocationContext;
	
	/**
	 * @return the myAssemblyContext
	 */
	public AssemblyContext getDerivedAssemblyContext() {
		return myAssemblyContext;
	}
	/**
	 * @param myAssemblyContext the myAssemblyContext to set
	 */
	public void setDerivedAssemblyContext(AssemblyContext myAssemblyContext) {
		this.myAssemblyContext = myAssemblyContext;
	}
	/**
	 * @return the mySystem
	 */
	public de.uka.ipd.sdq.pcm.system.System getSystem() {
		return mySystem;
	}
	/**
	 * @param mySystem the mySystem to set
	 */
	public void setSystem(de.uka.ipd.sdq.pcm.system.System mySystem) {
		this.mySystem = mySystem;
	}
	public ActualAllocationContext getActualAllocationContext() {
		return actualAllocationContext;
	}
	public void setActualAllocationContext(
			ActualAllocationContext actualAllocationContext) {
		this.actualAllocationContext = actualAllocationContext;
	}
	public UsageContext getUsageContext() {
		return usageContext;
	}
	public void setUsageContext(UsageContext usageContext) {
		this.usageContext = usageContext;
	}

	
	
}
