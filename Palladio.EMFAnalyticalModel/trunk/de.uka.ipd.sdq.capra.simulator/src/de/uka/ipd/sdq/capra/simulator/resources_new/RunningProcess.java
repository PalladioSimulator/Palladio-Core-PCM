package de.uka.ipd.sdq.capra.simulator.resources_new;


public class RunningProcess extends AbstractDecoratedProcess {

	/**
	 * @uml.property   name="state"
	 * @uml.associationEnd   aggregation="composite" inverse="runningProcess:de.uka.ipd.sdq.capra.simulator.resources_new.PROCESS_STATE"
	 */
	private PROCESS_STATE state = PROCESS_STATE.READY;

	/**
	 * Getter of the property <tt>state</tt>
	 * @return  Returns the state.
	 * @uml.property  name="state"
	 */
	public PROCESS_STATE getState() {
		return state;
	}

	/**
	 * Setter of the property <tt>state</tt>
	 * @param state  The state to set.
	 * @uml.property  name="state"
	 */
	public void setState(PROCESS_STATE state) {
		this.state = state;
	}

	/**
	 * @uml.property  name="currentDemand"
	 */
	private double currentDemand;

	/** 
	 * Getter of the property <tt>remainingDemand</tt>
	 * @return  Returns the remainingDemand.
	 * @uml.property  name="currentDemand"
	 */
	public double getCurrentDemand() {
		return currentDemand;
	}

	/** 
	 * Setter of the property <tt>remainingDemand</tt>
	 * @param remainingDemand  The remainingDemand to set.
	 * @uml.property  name="currentDemand"
	 */
	public void setCurrentDemand(double currentDemand) {
		this.currentDemand = currentDemand;
	}

	/**
	 * @uml.property   name="processorSelectionCriteria"
	 * @uml.associationEnd   aggregation="composite" inverse="runningProcess:de.uka.ipd.sdq.capra.simulator.resources_new.IProcessorSelectionConstraints"
	 */
	private IProcessorSelectionConstraints processorAffinity;

	/**
	 * Getter of the property <tt>processorSelectionCriteria</tt>
	 * @return  Returns the processorAffinity.
	 * @uml.property  name="processorSelectionCriteria"
	 */
	public IProcessorSelectionConstraints getProcessorSelectionCriteria() {
		return processorAffinity;
	}

	/**
	 * Setter of the property <tt>processorSelectionCriteria</tt>
	 * @param processorSelectionCriteria  The processorAffinity to set.
	 * @uml.property  name="processorSelectionCriteria"
	 */
	public void setProcessorSelectionCriteria(
			IProcessorSelectionConstraints processorSelectionCriteria) {
				processorAffinity = processorSelectionCriteria;
			}

		
			
			
			public double getTimeUntilNextSchedulingEvent(){
				return 0;
			}

}
