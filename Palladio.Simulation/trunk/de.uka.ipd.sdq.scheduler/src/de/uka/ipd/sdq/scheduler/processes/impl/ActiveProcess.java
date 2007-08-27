package de.uka.ipd.sdq.scheduler.processes.impl;

import java.util.ArrayList;
import java.util.List;

import umontreal.iro.lecuyer.simevents.Sim;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.scheduler.IResourceInstance;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.events.ProceedEvent;
import de.uka.ipd.sdq.scheduler.loaddistribution.IResourceInstanceConstraint;
import de.uka.ipd.sdq.scheduler.loaddistribution.constraints.MultipleResourceInstancesConstraint;
import de.uka.ipd.sdq.scheduler.loaddistribution.constraints.SingleResourceInstanceConstraint;
import de.uka.ipd.sdq.scheduler.processes.IProcessStateSensor;
import de.uka.ipd.sdq.scheduler.processes.states.PROCESS_STATE;
import de.uka.ipd.sdq.scheduler.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.resources.passive.IDelayedAction;

public class ActiveProcess {
	
	
	/**
	 * Creates a new wrapper containing the running information of a process.
	 * 
	 * @param process
	 *            The process that should be executed.
	 * 
	 * @param name
	 *            A UNIQUE name of the process.
	 */
	protected ActiveProcess(ISchedulableProcess process, String name) {
		super();

		this.affinityConstraint = null;
		this.currentDemand = 0;
		this.idealInstanceConstraint = null;
		this.lastInstanceConstraint = null;
		this.lastUpdateTime = 0;
		this.name = name;
		this.proceedEvent = new ProceedEvent(this);
		this.process = process;
		this.processStateSensorList = new ArrayList<IProcessStateSensor>();
		this.runqueue = null;
		this.state = PROCESS_STATE.READY;
	}

	// /////////////////////////////////////////////////////////////////////
	// Basics
	// /////////////////////////////////////////////////////////////////////

	private ISchedulableProcess process;
	private String name;
	private IRunQueue runqueue;

	public IRunQueue getRunQueue() {
		return runqueue;
	}
	
	public void setRunQueue(IRunQueue runqueue){
		this.runqueue = runqueue;
	}


	public ISchedulableProcess getSchedulableProcess() {
		return process;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ActiveProcess) {
			ActiveProcess process = (ActiveProcess) obj;
			return this.name.equals(process.name);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	// /////////////////////////////////////////////////////////////////////
	// Process State
	// /////////////////////////////////////////////////////////////////////

	private PROCESS_STATE state = PROCESS_STATE.READY;
	private List<IProcessStateSensor> processStateSensorList;

	public PROCESS_STATE getState() {
		return state;
	}

	public void setState(PROCESS_STATE new_state) {
		state = new_state;
		for (IProcessStateSensor sensor : processStateSensorList) {
			sensor.update(new_state);
		}
	}

	public void setRunning() {
		setState(PROCESS_STATE.RUNNING);
	}

	public void setReady() {
		setState(PROCESS_STATE.READY);
	}

	public void setWaiting() {
		setState(PROCESS_STATE.WAITING);
	}

	public boolean isRunning() {
		return getState() == PROCESS_STATE.RUNNING;
	}
	
	public boolean isReady() {
		return getState() == PROCESS_STATE.READY;
	}

	public boolean isWaiting() {
		return getState() == PROCESS_STATE.WAITING;
	}

	public void addStateSensor(IProcessStateSensor sensor) {
		processStateSensorList.add(sensor);
	}

	public void removeStateSensor(IProcessStateSensor sensor) {
		processStateSensorList.remove(sensor);
	}

	// /////////////////////////////////////////////////////////////////////
	// Timing
	// /////////////////////////////////////////////////////////////////////

	private double currentDemand = 0;
	private double lastUpdateTime = 0;

	public double getCurrentDemand() {
		return currentDemand;
	}

	public void setCurrentDemand(double currentDemand) {
		this.currentDemand = currentDemand;
	}

	/**
	 * Proceeds all timing variables to the current simulation time.
	 */
	public void toNow() {
		double currentTime = Sim.time();
		if (isRunning()) {
			double passedTime = currentTime - lastUpdateTime;
			if (passedTime > MathTools.EPSILON_ERROR) {
				passTime(passedTime);
			}
		}
		lastUpdateTime = currentTime;
	}

	protected void passTime(double passedTime) {
		currentDemand -= passedTime;
	}

	// /////////////////////////////////////////////////////////////////////
	// Resource Instance Constraints
	// /////////////////////////////////////////////////////////////////////

	private MultipleResourceInstancesConstraint affinityConstraint;
	private SingleResourceInstanceConstraint idealInstanceConstraint;
	private SingleResourceInstanceConstraint lastInstanceConstraint;

	public void setAffineInstances(List<IResourceInstance> instanceList) {
		affinityConstraint = new MultipleResourceInstancesConstraint(
				instanceList);
	}

	public boolean hasAffinityList() {
		return affinityConstraint != null;
	}

	public boolean checkAffinity(IResourceInstance instance) {
		return checkInstanceConstraint(affinityConstraint, instance);
	}

	public void removeNonAffineInstances(List<IResourceInstance> instances) {
		if (hasAffinityList()) {
			for (IResourceInstance instance : instances) {
				if (!affinityConstraint.check(instance)) {
					instances.remove(instance);
				}
			}
		}
	}

	public void setIdealInstance(IResourceInstance instance) {
		idealInstanceConstraint = new SingleResourceInstanceConstraint(instance);

	}

	public boolean hasIdealInstance() {
		return idealInstanceConstraint != null;
	}

	public boolean isIdealInstance(IResourceInstance instance) {
		return checkInstanceConstraint(idealInstanceConstraint, instance);
	}

	public IResourceInstance getIdealInstance() {
		if (hasIdealInstance()) {
			return idealInstanceConstraint.getResourceInstance();
		}
		return null;
	}


	public void setLastInstance(IResourceInstance instance) {
		lastInstanceConstraint = new SingleResourceInstanceConstraint(instance);
	}
	
	public boolean hasLastInstance() {
		return lastInstanceConstraint != null;
	}

	public IResourceInstance getLastInstance() {
		if (hasLastInstance())
			return lastInstanceConstraint.getResourceInstance();
		return null;
	}

	public boolean isLastInstance(IResourceInstance instance) {
		return checkInstanceConstraint(lastInstanceConstraint, instance);
	}

	private boolean checkInstanceConstraint(
			IResourceInstanceConstraint constraint, IResourceInstance instance) {
		if (constraint != null) {
			return constraint.check(instance);
		}
		// if no constraint is defined, every instance is accepted.
		return true;
	}

	// /////////////////////////////////////////////////////////////////////
	// Resource Instance Constraints
	// /////////////////////////////////////////////////////////////////////

	private ProceedEvent proceedEvent = null;

	public void scheduleProceedEvent() {
		proceedEvent.schedule(getCurrentDemand());
	}
	
	public void cancelProceedEvent() {
		proceedEvent.cancel();
	}


	public double getTimeUntilNextInterruption() {
		return currentDemand;
	}

	public void setDelayedAction(IDelayedAction action) {
		this.proceedEvent.setDelayedAction(action);
	}
}
