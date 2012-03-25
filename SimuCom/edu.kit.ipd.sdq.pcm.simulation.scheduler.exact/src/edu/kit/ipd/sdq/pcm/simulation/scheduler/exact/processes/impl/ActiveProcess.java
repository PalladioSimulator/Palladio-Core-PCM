package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.impl;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.entities.SchedulerEntity;
import de.uka.ipd.sdq.scheduler.processes.PROCESS_STATE;
import de.uka.ipd.sdq.scheduler.sensors.IProcessStateSensor;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.IResourceInstance;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.events.IDelayedAction;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.events.ProceedEvent;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.IResourceInstanceConstraint;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.constraints.MultipleResourceInstancesConstraint;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.constraints.SingleResourceInstanceConstraint;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.IRunQueue;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.strategy.IScheduler;

public class ActiveProcess extends SchedulerEntity implements IActiveProcess {
    
	/**
	 * Creates a new wrapper containing the running information of a process.
	 * 
	 * @param process
	 *            The process that should be executed.
	 * 
	 * @param id
	 *            A unique identifier of the process.
	 */
	public ActiveProcess(SchedulerModel model, ISchedulableProcess process) {
		super(model, ActiveProcess.class.getName());

		this.affinityConstraint = null;
		this.currentDemand = 0;
		this.idealInstanceConstraint = null;
		this.lastInstanceConstraint = null;
		this.lastUpdateTime = 0;
		this.proceedEvent = new ProceedEvent(model);
		this.process = process;
		this.processStateSensorList = new ArrayList<IProcessStateSensor>();
		this.runqueue = null;
		this.state = PROCESS_STATE.READY;
	}

	// /////////////////////////////////////////////////////////////////////
	// Basics
	// /////////////////////////////////////////////////////////////////////
	
	private ISchedulableProcess process;
	private IRunQueue runqueue;

	public void update() {
	}
	
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
		return process.getId();
	}
	
	public String getId(){
		return process.getId();
	}

	@Override
	public String toString() {
		return process.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ActiveProcess) {
			ActiveProcess process = (ActiveProcess) obj;
			return process.getId().equals(this.getId());
		}
		return false;
	}

	@Override
	public int hashCode() {
		String id = getId();
		int hashCode = id.hashCode();
		return hashCode;
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

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#setRunning()
	 */
	public void setRunning() {
		setState(PROCESS_STATE.RUNNING);
		just_blanced = false;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#setReady()
	 */
	public void setReady() {
		setState(PROCESS_STATE.READY);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#setWaiting()
	 */
	public void setWaiting() {
		setState(PROCESS_STATE.WAITING);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#isRunning()
	 */
	public boolean isRunning() {
		return getState() == PROCESS_STATE.RUNNING;
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#isReady()
	 */
	public boolean isReady() {
		return getState() == PROCESS_STATE.READY;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#isWaiting()
	 */
	public boolean isWaiting() {
		return getState() == PROCESS_STATE.WAITING;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#addStateSensor(de.uka.ipd.sdq.scheduler.processes.IProcessStateSensor)
	 */
	public void addStateSensor(IProcessStateSensor sensor) {
		processStateSensorList.add(sensor);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#removeStateSensor(de.uka.ipd.sdq.scheduler.processes.IProcessStateSensor)
	 */
	public void removeStateSensor(IProcessStateSensor sensor) {
		processStateSensorList.remove(sensor);
	}

	// /////////////////////////////////////////////////////////////////////
	// Timing
	// /////////////////////////////////////////////////////////////////////

	private double currentDemand = 0;
	private double lastUpdateTime = 0;

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#getCurrentDemand()
	 */
	public double getCurrentDemand() {
		return currentDemand;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#setCurrentDemand(double)
	 */
	public void setCurrentDemand(double currentDemand) {
		assert MathTools.equalsDouble(this.currentDemand, 0.0) : this.currentDemand;
		this.currentDemand = currentDemand;
	}

	public void toNow() {
		double currentTime = getModel().getSimulationControl().getCurrentSimulationTime();
		if (isRunning()) {
			double passedTime = currentTime - lastUpdateTime;
			if (passedTime > MathTools.EPSILON_ERROR) {
				passTimeProcessing(passedTime);
			}
		}
		lastUpdateTime = currentTime;
	}


	protected void passTimeProcessing(double passedTime) {
		currentDemand -= passedTime;
		if(MathTools.equalsDouble(currentDemand, 0))
			currentDemand = 0;
	}
	

	// /////////////////////////////////////////////////////////////////////
	// Resource Instance Constraints
	// /////////////////////////////////////////////////////////////////////

	private MultipleResourceInstancesConstraint affinityConstraint;
	private SingleResourceInstanceConstraint idealInstanceConstraint;
	private SingleResourceInstanceConstraint lastInstanceConstraint;
	private double movedAtTime = 0;
	private boolean just_blanced = false;

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#setAffineInstances(java.util.List)
	 */
	public void setAffineInstances(List<IResourceInstance> instanceList) {
		affinityConstraint = new MultipleResourceInstancesConstraint(
				instanceList);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#hasAffinityList()
	 */
	public boolean hasAffinityList() {
		return affinityConstraint != null;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#checkAffinity(de.uka.ipd.sdq.scheduler.resources.IResourceInstance)
	 */
	public boolean checkAffinity(IResourceInstance instance) {
		return checkInstanceConstraint(affinityConstraint, instance);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#removeNonAffineInstances(java.util.List)
	 */
	public void removeNonAffineInstances(List<IResourceInstance> instances) {
		if (hasAffinityList()) {
			for (IResourceInstance instance : instances) {
				if (!affinityConstraint.check(instance)) {
					instances.remove(instance);
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#setIdealInstance(de.uka.ipd.sdq.scheduler.resources.IResourceInstance)
	 */
	public void setIdealInstance(IResourceInstance instance) {
		if (instance != null) {
			idealInstanceConstraint = new SingleResourceInstanceConstraint(instance);
		} else {
			idealInstanceConstraint = null;
		}


	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#hasIdealInstance()
	 */
	public boolean hasIdealInstance() {
		return idealInstanceConstraint != null;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#isIdealInstance(de.uka.ipd.sdq.scheduler.resources.IResourceInstance)
	 */
	public boolean isIdealInstance(IResourceInstance instance) {
		return checkInstanceConstraint(idealInstanceConstraint, instance);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#getIdealInstance()
	 */
	public IResourceInstance getIdealInstance() {
		if (hasIdealInstance()) {
			return idealInstanceConstraint.getResourceInstance();
		}
		return null;
	}


	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#setLastInstance(de.uka.ipd.sdq.scheduler.resources.IResourceInstance)
	 */
	public void setLastInstance(IResourceInstance instance) {
		if (instance != null){
			lastInstanceConstraint = new SingleResourceInstanceConstraint(instance);
		} else {
			lastInstanceConstraint = null;
		}
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#hasLastInstance()
	 */
	public boolean hasLastInstance() {
		return lastInstanceConstraint != null;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#getLastInstance()
	 */
	public IResourceInstance getLastInstance() {
		if (hasLastInstance())
			return lastInstanceConstraint.getResourceInstance();
		return null;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#isLastInstance(de.uka.ipd.sdq.scheduler.resources.IResourceInstance)
	 */
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
	// Load Balancing
	// /////////////////////////////////////////////////////////////////////

	public boolean isMovable(IResourceInstance targetInstance) {
		return checkAffinity(targetInstance) && !just_blanced;
	}

	public void wasMovedTo(IResourceInstance dest) {
		this.setLastInstance(dest);
		this.setIdealInstance(dest);
		this.just_blanced = true;
	}
	

	// /////////////////////////////////////////////////////////////////////
	// Events
	// /////////////////////////////////////////////////////////////////////

	private ProceedEvent proceedEvent = null;

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#scheduleProceedEvent()
	 */
	public void scheduleProceedEvent(IScheduler scheduler) {
		cancelProceedEvent();
		proceedEvent.setScheduler(scheduler);
		proceedEvent.schedule(this, getCurrentDemand());
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#cancelProceedEvent()
	 */
	public void cancelProceedEvent() {
		proceedEvent.removeEvent();
	}


	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#getTimeUntilNextInterruption()
	 */
	public double getTimeUntilNextInterruption() {
		return currentDemand;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.processes.impl.IRunnableProcess#setDelayedAction(de.uka.ipd.sdq.scheduler.events.IDelayedAction)
	 */
	public void setDelayedAction(IDelayedAction action) {
		this.proceedEvent.setDelayedAction(action);
	}

	public IActiveProcess createNewInstance(SchedulerModel model, ISchedulableProcess process) {
		return new ActiveProcess(model, process);
	}

    @Override
    public IActiveProcess createNewInstance(ISchedulableProcess process) {
        // TODO Auto-generated method stub
        return null;
    }

}
