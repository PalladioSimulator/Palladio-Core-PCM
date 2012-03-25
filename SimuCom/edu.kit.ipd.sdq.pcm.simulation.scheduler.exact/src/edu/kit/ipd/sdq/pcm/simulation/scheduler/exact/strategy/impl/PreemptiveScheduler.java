package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.strategy.impl;

import scheduler.configuration.StarvationBoost;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.IResourceInstance;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.SimActiveResource;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority.IPriority;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority.IPriorityUpdateStrategy;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority.update.SetToBaseUpdate;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.impl.ProcessWithPriority;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.IQueueingStrategy;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.resources.active.SimResourceInstance;

public class PreemptiveScheduler extends AbstractScheduler {
	
    private SchedulerModel model;
    
	public PreemptiveScheduler(SchedulerModel model, SimActiveResource resource,
			IQueueingStrategy queueingStrategy, boolean in_front_after_waiting,
			double scheduling_interval, StarvationBoost starvationBoost) {
		super(resource, queueingStrategy, in_front_after_waiting, starvationBoost);
		this.model = model;
		this.scheduling_interval = scheduling_interval;
	}

	
	public void schedule(IResourceInstance instance) {
		if (instance.isScheduling())
			return;
		
		// Balance the runqueue of this instance with the runqueues of other
		// instances. This might change the state of the instance's runqueue.
		// So, the next runnable process can only be determined after the
		// balancing was finished.
		queueing_strategy.activelyBalance(instance);
		
		// get the currently scheduled process for the instance.
		ProcessWithPriority running_process = (ProcessWithPriority) instance
				.getRunningProcess();

		// Update the timing variables and priority of the process. Possibly
		// pending events of the process are canceled.
		toNow(running_process);
		
		if (running_process == null){
		} else if ( running_process.getTimeslice().isFinished()) {
			unschedule(running_process, false, instance);
		} else {
			unschedule(running_process, true, instance);
		}
		scheduleNextProcess(instance);
		scheduleNextEvent(instance);
	}
	

	private void scheduleNextProcess(ProcessWithPriority next_process, IResourceInstance instance) {
		if (next_process != null) {
			next_process.toNow();
			next_process.update();
			fromReadyToRunningOn(next_process, instance);
		}
	}

	private void scheduleNextProcess(IResourceInstance instance) {
		lookForStarvingProcessesAndApplyStarvationBoost(instance);
		
		ProcessWithPriority next_process = (ProcessWithPriority) queueing_strategy.getNextProcessFor(instance);
		scheduleNextProcess(next_process, instance);
	}

	private void lookForStarvingProcessesAndApplyStarvationBoost(IResourceInstance instance) {
		if(starvationBoost != null){
			for (IActiveProcess p : queueing_strategy.getStarvingProcesses(instance, starvationBoost.getStarvationLimit())){
				applyStarvationBoost((ProcessWithPriority)p);
			}
				
		}
		
	}

	private void applyStarvationBoost(ProcessWithPriority p) {
		p.setToStaticPriorityWithBonus(starvationBoost.getBoost());
		IPriorityUpdateStrategy priorityUpdateStrategy = new SetToBaseUpdate(starvationBoost.getDurationInTimeslices());
		p.setPriorityUpdateStrategy(priorityUpdateStrategy);
	}


	private void toNow(ProcessWithPriority process) {
		if (process != null){
			process.toNow();
		}
	}

	private void unschedule(ProcessWithPriority running_process,
			boolean next_has_higher_priority, IResourceInstance current) {
		if (running_process != null) {
			if (running_process.getTimeslice().isFinished()){
				running_process.update(); 
				fromRunningToReady(running_process, current, false);
				running_process.getTimeslice().fullReset();
			} else {
				fromRunningToReady(running_process, current, next_has_higher_priority);
			}
			if (running_process.getRunQueue().getCurrentLoad() == 1){
					running_process.getRunQueue().resetStarvationInfo();
			}
		} 
	}

	/**
	 * pOne > pTwo ?
	 * 
	 * @param pTwo
	 * @return
	 */
	private boolean hasHigherPriority(ProcessWithPriority pOne,
			ProcessWithPriority pTwo) {
		if (pOne == null)
			return false;
		if (pTwo == null)
			return true;
		IPriority prio_one = pOne.getDynamicPriority();
		IPriority prio_two = pTwo.getDynamicPriority();
		return prio_one.greaterThan(prio_two);
	}

	public void scheduleNextEvent(IResourceInstance instance) {
		double time = model.getSimulationControl().getCurrentSimulationTime();
		ProcessWithPriority running = (ProcessWithPriority) instance
				.getRunningProcess();
		if (running != null) {
			running.toNow();
			double remainingTime = running.getTimeslice().getRemainingTime();
			double currentDemand = running.getCurrentDemand();
			if ( currentDemand < remainingTime )
				running.scheduleProceedEvent(this);
			else
				instance.scheduleSchedulingEvent(remainingTime);
		} else {
			if (!queueing_strategy.isIdle(instance))
				instance.scheduleSchedulingEvent(0);
			else
				instance.scheduleSchedulingEvent(scheduling_interval);
		}
	}

	
	public boolean isIdle(IResourceInstance instance) {
		return queueing_strategy.isIdle(instance);
	}

	
	public double getInterval() {
		return scheduling_interval;
	}
	
	@Override
	public void terminateProcess(IActiveProcess process, IResourceInstance current) {
		super.terminateProcess(process, current);
		ISchedulableProcess sProcess = process.getSchedulableProcess();
		if (sProcess.isFinished()
				// do NOT remove the originally defined processes as they
				// serve as prototypes for all spawned processes.
				&& sProcess.getRootProcess() != sProcess){
			this.resource.unregisterProcess(process);
		}
	}


	public int getQueueLengthFor(SimResourceInstance simResourceInstance) {
		return this.queueing_strategy.getQueueLengthFor(simResourceInstance);
	}


}
