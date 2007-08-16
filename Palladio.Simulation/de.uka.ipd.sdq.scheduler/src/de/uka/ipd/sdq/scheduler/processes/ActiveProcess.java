package de.uka.ipd.sdq.scheduler.processes;

import java.util.List;

import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraProcess;
import de.uka.ipd.sdq.scheduler.resources.balancing.MultipleResourceInstancesConstraint;
import de.uka.ipd.sdq.scheduler.resources.balancing.SingleResourceInstanceConstraint;

public class ActiveProcess {

	/**
	 * @uml.property   name="state"
	 * @uml.associationEnd   aggregation="composite" inverse="runningProcess:de.uka.ipd.sdq.scheduler.processes.PROCESS_STATE"
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
	 * @uml.property   name="currentDemand"
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

	public double getRemainingTimeSlice() {
		return 0;
	}

	/**
	 * @uml.property   name="processStateSensorList"
	 * @uml.associationEnd   multiplicity="(0 -1)" ordering="true" aggregation="shared" inverse="activeProcess:de.uka.ipd.sdq.scheduler.processes.IProcessStateSensor"
	 */
	private List<IProcessStateSensor> processStateSensorList;

	/**
	 * Getter of the property <tt>processStateSensorList</tt>
	 * 
	 * @return Returns the processStateSensorList.
	 * @uml.property name="processStateSensorList"
	 */
	public List<IProcessStateSensor> getProcessStateSensorList() {
		return processStateSensorList;
	}

	/**
	 * Setter of the property <tt>processStateSensorList</tt>
	 * 
	 * @param processStateSensorList
	 *            The processStateSensorList to set.
	 * @uml.property name="processStateSensorList"
	 */
	public void setProcessStateSensorList(
			List<IProcessStateSensor> processStateSensorList) {
				this.processStateSensorList = processStateSensorList;
			}

	/**
	 * @uml.property   name="capraProcess"
	 * @uml.associationEnd   aggregation="shared" inverse="abstractDecoratedProcess:de.uka.ipd.sdq.capra.simulator.expressions.SimCapraProcess"
	 */
	private SimCapraProcess capraProcess;

	/**
	 * Getter of the property <tt>capraProcess</tt>
	 * 
	 * @return Returns the capraProcess.
	 * @uml.property name="capraProcess"
	 */
	public SimCapraProcess getCapraProcess() {
		return capraProcess;
	}

	/**
	 * Setter of the property <tt>capraProcess</tt>
	 * 
	 * @param capraProcess
	 *            The capraProcess to set.
	 * @uml.property name="capraProcess"
	 */
	public void setCapraProcess(SimCapraProcess capraProcess) {
		this.capraProcess = capraProcess;
	}

	/**
	 */
	public void getRemainingDemand() {
	}

	/**
	 * Proceeds all timeing variables to the current simulation time.
	 */
	public void toNow() {
	}

	public void setStandby() {
		// TODO Auto-generated method stub
		
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setRunning() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @uml.property   name="affinityConstraint"
	 * @uml.associationEnd   aggregation="composite" inverse="activeProcess:de.uka.ipd.sdq.capra.simulator.resources.MultipleResourceInstancesConstraint"
	 */
	private MultipleResourceInstancesConstraint affinityConstraint;

	/**
	 * Getter of the property <tt>affinityConstraint</tt>
	 * @return  Returns the affinityConstraint.
	 * @uml.property  name="affinityConstraint"
	 */
	public MultipleResourceInstancesConstraint getAffinityConstraint() {
		return affinityConstraint;
	}

	/**
	 * Setter of the property <tt>affinityConstraint</tt>
	 * @param affinityConstraint  The affinityConstraint to set.
	 * @uml.property  name="affinityConstraint"
	 */
	public void setAffinityConstraint(
			MultipleResourceInstancesConstraint affinityConstraint) {
				this.affinityConstraint = affinityConstraint;
			}

	/**
	 * @uml.property   name="idealInstanceConstraint"
	 * @uml.associationEnd   aggregation="composite" inverse="activeProcess:de.uka.ipd.sdq.capra.simulator.resources.SingleResourceInstanceConstraint"
	 */
	private SingleResourceInstanceConstraint idealInstanceConstraint;

	/** 
	 * Getter of the property <tt>idealInstanceConstraint</tt>
	 * @return  Returns the idealInstanceConstraint.
	 * @uml.property  name="idealInstanceConstraint"
	 */
	public SingleResourceInstanceConstraint getIdealInstanceConstraint() {
		return idealInstanceConstraint;
	}

	/** 
	 * Setter of the property <tt>idealInstanceConstraint</tt>
	 * @param idealInstanceConstraint  The idealInstanceConstraint to set.
	 * @uml.property  name="idealInstanceConstraint"
	 */
	public void setIdealInstanceConstraint(
			SingleResourceInstanceConstraint idealInstanceConstraint) {
				this.idealInstanceConstraint = idealInstanceConstraint;
			}

	/**
	 * @uml.property   name="lastInstanceConstraint"
	 * @uml.associationEnd   aggregation="composite" inverse="activeProcess:de.uka.ipd.sdq.capra.simulator.resources.SingleResourceInstanceConstraint"
	 */
	private SingleResourceInstanceConstraint lastInstanceConstraint;

	/**
	 * Getter of the property <tt>lastInstanceConstraint</tt>
	 * @return  Returns the lastInstanceConstraint.
	 * @uml.property  name="lastInstanceConstraint"
	 */
	public SingleResourceInstanceConstraint getLastInstanceConstraint() {
		return lastInstanceConstraint;
	}

	/**
	 * Setter of the property <tt>lastInstanceConstraint</tt>
	 * @param lastInstanceConstraint  The lastInstanceConstraint to set.
	 * @uml.property  name="lastInstanceConstraint"
	 */
	public void setLastInstanceConstraint(
			SingleResourceInstanceConstraint lastInstanceConstraint) {
				this.lastInstanceConstraint = lastInstanceConstraint;
			}

}
