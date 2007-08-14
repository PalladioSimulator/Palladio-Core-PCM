package de.uka.ipd.sdq.capra.simulator.resources_new;


public class DiscretePriorityDependentTimeSlice extends AbstractDiscreteTimeSlice {

	/** 
	 * @uml.property name="processPriority"
	 * @uml.associationEnd aggregation="shared" inverse="priorityDependentTimeSlice:de.uka.ipd.sOdq.capra.simulator.resources_new.ProcessPriority"
	 */
	private ProcessPriority processPriority;

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Getter of the property <tt>processPriority</tt>
	 * @return  Returns the priorityProcess.
	 * @uml.property  name="processPriority"
	 */
	public ProcessPriority getProcessPriority() {
		return processPriority;
	}

	/**
	 * Setter of the property <tt>processPriority</tt>
	 * @param processPriority  The priorityProcess to set.
	 * @uml.property  name="processPriority"
	 */
	public void setProcessPriority(ProcessPriority processPriority) {
		this.processPriority = processPriority;
	}

}
