package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes;

import java.util.List;

import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.processes.PROCESS_STATE;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.IResourceInstance;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.events.IDelayedAction;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.IRunQueue;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.strategy.IScheduler;

/**
 * Not externally visible methods for running processes.
 * @author jens
 * 
 */
public interface IActiveProcess extends IRunningProcess {

	/**
	 * @return Returns the current runqueue of the process. NULL if the process
	 *         is in no runqueue.
	 */

	public abstract IRunQueue getRunQueue();

	/**
	 * Sets the current runqueue of the process.
	 * 
	 * @param runqueue
	 */
	public abstract void setRunQueue(IRunQueue runqueue);

	/**
	 * @return Returns the current state of the process.
	 */
	public abstract PROCESS_STATE getState();

	/**
	 * Change the current state of the process to running.
	 */
	public abstract void setRunning();

	/**
	 * Change the current state of the process to ready.
	 */
	public abstract void setReady();

	/**
	 * Change the current state of the process to waiting.
	 */
	public abstract void setWaiting();

	/**
	 * @return True, if the process is in the running state, otherwise false.
	 */
	public abstract boolean isRunning();

	/**
	 * @return True, if the process is in the ready state, otherwise false.
	 */
	public abstract boolean isReady();

	/**
	 * @return True, if the process is in the waiting state, otherwise false.
	 */
	public abstract boolean isWaiting();

	/**
	 * @return Returns the current demand of the process.
	 */
	public abstract double getCurrentDemand();

	/**
	 * Sets the new demand for a process. In order to do so, the current demand
	 * must be zero, i.e. has been completely processed.
	 * 
	 * @param new_demand
	 */
	public abstract void setCurrentDemand(double new_demand);

	/**
	 * Proceeds all timing variables to the current simulation time. The current
	 * demand is reduced only, if the process is in running state.
	 */
	public abstract void toNow();

	/**
	 * Sets the affine instances for the process. The process is only allowed to
	 * run on these instances. If the list is set to NULL the process can run on
	 * any instance.
	 * 
	 * @param instance_list
	 */
	public abstract void setAffineInstances(
			List<IResourceInstance> instance_list);

	/**
	 * @return True, if the process has a list of affinity instances, otherwise
	 *         false.
	 */
	public abstract boolean hasAffinityList();

	/**
	 * Checks if the given instance is in the set of affinity instances of the
	 * process.
	 * 
	 * @param instance
	 * @return
	 */
	public abstract boolean checkAffinity(IResourceInstance instance);

	/**
	 * Removes all instances the process is not allowed to run on from the given
	 * list.
	 * 
	 * @param instance_list
	 */
	public abstract void removeNonAffineInstances(
			List<IResourceInstance> instance_list);

	/**
	 * Sets the ideal instance of the process. That is the instance most
	 * preferred for the process.
	 * 
	 * @param instance
	 */
	public abstract void setIdealInstance(IResourceInstance instance);

	/**
	 * @return True, if the process has an ideal instance, otherwise false.
	 */
	public abstract boolean hasIdealInstance();

	/**
	 * Checks if the given instance is the ideal instance of the process.
	 * 
	 * @param instance
	 * @return True, if the instance is the process' ideal instance, otherwise
	 *         false.
	 */
	public abstract boolean isIdealInstance(IResourceInstance instance);

	/**
	 * @return Returns the ideal instance of the process.
	 */
	public abstract IResourceInstance getIdealInstance();

	/**
	 * Sets the instance the process is or just was running on.
	 * 
	 * @param instance
	 */
	public abstract void setLastInstance(IResourceInstance instance);

	/**
	 * @return True, if the last instance of the process is set.
	 */
	public abstract boolean hasLastInstance();

	/**
	 * @return If the process is in running state, the method returns the
	 *         instance the process is currently running on. Otherwise, the
	 *         instance the process was recently running on is returned.
	 */
	public abstract IResourceInstance getLastInstance();

	/**
	 * @param instance
	 * @return True, if the given instance is equal to the last instance of the
	 *         process.
	 */
	public abstract boolean isLastInstance(IResourceInstance instance);

	/**
	 * Schedules a proceed event for the process at the time the current demand
	 * is expired.
	 */
	public abstract void scheduleProceedEvent(IScheduler scheduler);


	/**
	 * Cancels an already scheduled ProceedEvent, e.g. if the process is
	 * interrupted.
	 */
	public abstract void cancelProceedEvent();

	/**
	 * @return Returns the time the process will be interrupted next.
	 */
	public abstract double getTimeUntilNextInterruption();

	/**
	 * Sets a delayed action for the process, that need to be executed as soon
	 * as the process is running. Only one delayed action at a time is allowed.
	 * 
	 * @param action
	 */
	public abstract void setDelayedAction(IDelayedAction action);
	
	/**
	 * Updates the process's timeslice and priority, if there is such.
	 */
	public abstract void update();

	public abstract IActiveProcess createNewInstance(ISchedulableProcess process);

	public abstract boolean isMovable(IResourceInstance targetInstance);

	public abstract void wasMovedTo(IResourceInstance dest);

}