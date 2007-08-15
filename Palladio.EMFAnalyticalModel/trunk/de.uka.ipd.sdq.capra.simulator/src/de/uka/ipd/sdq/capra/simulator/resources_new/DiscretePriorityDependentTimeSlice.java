package de.uka.ipd.sdq.capra.simulator.resources_new;


public class DiscretePriorityDependentTimeSlice extends AbstractDiscreteTimeSlice {

	/** 
	 * @uml.property name="processWithPriority"
	 * @uml.associationEnd aggregation="shared" inverse="priorityDependentTimeSlice:de.uka.ipd.sdq.capra.simulator.resources_new.ProcessWithPriority"
	 */
	private ProcessWithPriority processWithPriority;

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	/** 
	 * Getter of the property <tt>processPriority</tt>
	 * @return  Returns the priorityProcess.
	 * @uml.property  name="processWithPriority"
	 */
	public ProcessWithPriority getProcessWithPriority() {
		return processWithPriority;
	}

	/** 
	 * Setter of the property <tt>processPriority</tt>
	 * @param processPriority  The priorityProcess to set.
	 * @uml.property  name="processWithPriority"
	 */
	public void setProcessWithPriority(ProcessWithPriority processWithPriority) {
		this.processWithPriority = processWithPriority;
	}

}
