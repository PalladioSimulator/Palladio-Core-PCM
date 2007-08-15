package de.uka.ipd.sdq.pcmsolver.models;

import java.util.ArrayList;

import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext;
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;

/**
 * @author Koziolek
 *
 */
public class Context {
	private de.uka.ipd.sdq.pcm.system.System mySystem;
	private AssemblyContext myAssemblyContext;
	private Allocation myAllocation;
	
	private ComputedUsageContext usageContext;
	private ComputedAllocationContext actualAllocationContext;
	
	private ArrayList currentLoopIterationNumber;
	private ArrayList currentEvaluatedBranchConditions;
		
	public Context(){
		this.currentEvaluatedBranchConditions = new ArrayList();
		this.currentLoopIterationNumber = new ArrayList();
	}
	
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
	public ComputedAllocationContext getActualAllocationContext() {
		return actualAllocationContext;
	}
	public void setActualAllocationContext(
			ComputedAllocationContext actualAllocationContext) {
		this.actualAllocationContext = actualAllocationContext;
	}
	public ComputedUsageContext getUsageContext() {
		return usageContext;
	}
	public void setUsageContext(ComputedUsageContext usageContext) {
		this.usageContext = usageContext;
	}
	public ArrayList getCurrentEvaluatedBranchConditions() {
		return currentEvaluatedBranchConditions;
	}
	public void setCurrentEvaluatedBranchConditions(
			ArrayList currentEvaluatedBranchConditions) {
		this.currentEvaluatedBranchConditions = currentEvaluatedBranchConditions;
	}
	public ArrayList getCurrentLoopIterationNumber() {
		return currentLoopIterationNumber;
	}
	public void setCurrentLoopIterationNumber(ArrayList currentLoopIterationNumber) {
		this.currentLoopIterationNumber = currentLoopIterationNumber;
	}

	public Allocation getAllocation() {
		return myAllocation;
	}

	public void setAllocation(Allocation myAllocation) {
		this.myAllocation = myAllocation;
	}
	
}
