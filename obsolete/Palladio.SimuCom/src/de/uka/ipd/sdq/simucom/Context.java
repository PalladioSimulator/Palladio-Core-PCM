package de.uka.ipd.sdq.simucom;

import de.uka.ipd.sdq.pcm.assembly.AssemblyContext;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;

public class Context {
	private de.uka.ipd.sdq.pcm.system.System mySystem;
	private AssemblyContext myAssemblyContext;
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
}
