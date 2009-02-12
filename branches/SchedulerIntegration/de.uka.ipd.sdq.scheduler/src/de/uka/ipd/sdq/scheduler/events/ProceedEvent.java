package de.uka.ipd.sdq.scheduler.events;

import javax.print.attribute.standard.Finishings;

import org.apache.log4j.Logger;

import umontreal.iro.lecuyer.simevents.Event;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.strategy.IScheduler;

/**
 * Event to proceed the activity of a process. This event requires, that at the
 * time it happens, the current demand of the process is zero, thus all former
 * actions of the process have been finished.
 * 
 * This event can either continue the process directly or execute a delayed
 * action of the process. Delayed actions are activities that are executed by
 * the scheduler (e.g. some housekeeping or asking for access to a passive
 * resource) but require the process to be running. DelayedActions have priority
 * of the proceeding of the process as they have to be finished in oder to
 * continue process execution.
 * 
 * @author jens
 * 
 */
public class ProceedEvent extends Event {

	protected IActiveProcess process;
	private IDelayedAction action;
	protected IScheduler scheduler;
	static Logger logger = Logger.getLogger(ProceedEvent.class);

	public ProceedEvent(IActiveProcess process) {
		super(SchedulingFactory.getUsedSimulator());
		this.process = process;
		this.action = null;
		
	}

	public void setDelayedAction(IDelayedAction action) {
		this.action = action;
	}

	@Override
	public void actions() {
		logger.debug("Proceed Event handler triggered");
		process.toNow();
		if (action != null) {
			// once the action has been successfully executed it is removed.
			if (action.perform())
				action = null;
		} else {
			process.getSchedulableProcess().activate();
		}
	}

	public void setScheduler(IScheduler scheduler) {
		this.scheduler = scheduler;
	}
}
