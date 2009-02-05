package de.uka.ipd.sdq.scheduler.strategy.impl;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.priority.IPriority;
import de.uka.ipd.sdq.scheduler.priority.IPriorityUpdateStrategy;
import de.uka.ipd.sdq.scheduler.priority.update.SetToBaseUpdate;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.processes.impl.ProcessWithPriority;
import de.uka.ipd.sdq.scheduler.queueing.IQueueingStrategy;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;

public class PreemptiveScheduler extends AbstractScheduler {
	
	private double overhead;

	public PreemptiveScheduler(SimActiveResource resource,
			IQueueingStrategy queueingStrategy, boolean in_front_after_waiting,
			double scheduling_interval) {
		super(resource, queueingStrategy, in_front_after_waiting);
		this.scheduling_interval = scheduling_interval;
		this.overhead = 0.001;
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
		} else if ( running_process.getTimeslice().completelyFinished()) {
			unschedule(running_process, false, instance);
		} else if ( running_process.getTimeslice().partFinished()) {
			unschedule(running_process, false, instance);
		} else {
//			ProcessWithPriority next_process = (ProcessWithPriority) queueing_strategy.getNextProcessFor(instance);
//			if ( hasHigherPriority(next_process,running_process) ) {
				unschedule(running_process, true, instance);
//			}
		}
		schedulePostSchedulingEvent(instance);
	}
	
	
	private void schedulePostSchedulingEvent(IResourceInstance instance) {
		instance.setIsScheduling(true);
		instance.schedulePostSchedulingEvent(overhead);
	}


	public void postSchedule(IResourceInstance instance){
		assert instance.getRunningProcess() == null : instance.getRunningProcess();
		assert instance.isScheduling();
		instance.setIsScheduling(false);
		
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
		if(IS_WINDOWS ){
			for (IActiveProcess p : queueing_strategy.getStarvingProcesses(instance, WINDOWS_STARVATION_LIMIT)){
				applyStarvationBoost((ProcessWithPriority)p);
			}
				
		}
		ProcessWithPriority next_process = (ProcessWithPriority) queueing_strategy.getNextProcessFor(instance);
		scheduleNextProcess(next_process, instance);
	}

	private void applyStarvationBoost(ProcessWithPriority p) {
		p.setToStaticPriorityWithBonus(20);
		IPriorityUpdateStrategy priorityUpdateStrategy = new SetToBaseUpdate(2);
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
			if (running_process.getTimeslice().completelyFinished()){
				running_process.update(); 
				fromRunningToReady(running_process, current, next_has_higher_priority
						&& !running_process.getTimeslice().partFinished());
				running_process.getTimeslice().reset();
			} else {
				if (running_process.getTimeslice().partFinished()){
					running_process.getTimeslice().reset();
				}
				fromRunningToReady(running_process, current, next_has_higher_priority
						&& !running_process.getTimeslice().partFinished());
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
		ProcessWithPriority running = (ProcessWithPriority) instance
				.getRunningProcess();
		if (running != null) {
			running.toNow();
			double remainingTime = running.getTimeslice().getTimeUntilNextInterruption();
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


}
