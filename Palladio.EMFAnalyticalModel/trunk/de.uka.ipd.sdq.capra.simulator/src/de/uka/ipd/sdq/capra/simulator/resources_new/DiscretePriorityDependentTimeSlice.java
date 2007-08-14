package de.uka.ipd.sdq.capra.simulator.resources_new;


public class DiscretePriorityDependentTimeSlice extends AbstractDiscreteTimeSlice {

	/**
	 * @uml.property   name="processPriority"
	 * @uml.associationEnd   aggregation="shared" inverse="priorityDependentTimeSlice:de.uka.ipd.sdq.capra.simulator.resources_new.ProcessWithPriority"
	 */
	private ProcessWithPriority processPriority;

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Getter of the property <tt>processPriority</tt>
	 * @return  Returns the priorityProcess.
	 * @uml.property  name="processPriority"
	 */
	public ProcessWithPriority getProcessPriority() {
		return processPriority;
	}

	/**
	 * Setter of the property <tt>processPriority</tt>
	 * @param processPriority  The priorityProcess to set.
	 * @uml.property  name="processPriority"
	 */
	public void setProcessPriority(ProcessWithPriority processPriority) {
		this.processPriority = processPriority;
	}

}
