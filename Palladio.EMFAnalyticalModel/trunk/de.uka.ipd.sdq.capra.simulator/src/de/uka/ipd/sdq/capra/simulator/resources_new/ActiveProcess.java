package de.uka.ipd.sdq.capra.simulator.resources_new;

import java.util.List;

public class ActiveProcess extends AbstractDecoratedProcess {

	/**
	 * @uml.property name="state"
	 * @uml.associationEnd aggregation="composite"
	 *                     inverse="runningProcess:de.uka.ipd.sdq.capra.simulator.resources_new.PROCESS_STATE"
	 */
	private PROCESS_STATE state = PROCESS_STATE.READY;

	/**
	 * Getter of the property <tt>state</tt>
	 * 
	 * @return Returns the state.
	 * @uml.property name="state"
	 */
	public PROCESS_STATE getState() {
		return state;
	}

	/**
	 * Setter of the property <tt>state</tt>
	 * 
	 * @param state
	 *            The state to set.
	 * @uml.property name="state"
	 */
	public void setState(PROCESS_STATE state) {
		this.state = state;
	}

	/**
	 * @uml.property name="currentDemand"
	 */
	private double currentDemand;

	/**
	 * Getter of the property <tt>remainingDemand</tt>
	 * 
	 * @return Returns the remainingDemand.
	 * @uml.property name="currentDemand"
	 */
	public double getCurrentDemand() {
		return currentDemand;
	}

	/**
	 * Setter of the property <tt>remainingDemand</tt>
	 * 
	 * @param remainingDemand
	 *            The remainingDemand to set.
	 * @uml.property name="currentDemand"
	 */
	public void setCurrentDemand(double currentDemand) {
		this.currentDemand = currentDemand;
	}

	/** 
	 * @uml.property name="processorSelectionCriteriaList"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true" aggregation="composite" inverse="runningProcess:de.uka.ipd.sdq.capra.simulator.resources_new.IProcessorSelectionConstraint"
	 */
	private List<IProcessorSelectionConstraint> processorAffinity;

	public double getTimeUntilNextSchedulingEvent() {
		return 0;
	}

	/** 
	 * @uml.property name="processStateSensorList"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true" aggregation="shared" inverse="activeProcess:de.uka.ipd.sdq.capra.simulator.resources_new.IProcessStateSensor"
	 */
	private List<IProcessStateSensor> processStateSensorList;

	/** 
	 * Getter of the property <tt>processStateSensorList</tt>
	 * @return  Returns the processStateSensorList.
	 * @uml.property  name="processStateSensorList"
	 */
	public List<IProcessStateSensor> getProcessStateSensorList() {
		return processStateSensorList;
	}

	/** 
	 * Setter of the property <tt>processStateSensorList</tt>
	 * @param processStateSensorList  The processStateSensorList to set.
	 * @uml.property  name="processStateSensorList"
	 */
	public void setProcessStateSensorList(
			List<IProcessStateSensor> processStateSensorList) {
				this.processStateSensorList = processStateSensorList;
			}

	/**
	 * Getter of the property <tt>processorSelectionCriteriaList</tt>
	 * @return  Returns the processorAffinity.
	 * @uml.property  name="processorSelectionCriteriaList"
	 */
	public List<IProcessorSelectionConstraint> getProcessorSelectionCriteriaList() {
		return processorAffinity;
	}

	/**
	 * Setter of the property <tt>processorSelectionCriteriaList</tt>
	 * @param processorSelectionCriteriaList  The processorAffinity to set.
	 * @uml.property  name="processorSelectionCriteriaList"
	 */
	public void setProcessorSelectionCriteriaList(
			List<IProcessorSelectionConstraint> processorSelectionCriteriaList) {
		processorAffinity = processorSelectionCriteriaList;
	}

}
