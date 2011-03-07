package de.uka.ipd.sdq.scheduler.resources.passive;

import java.util.ArrayDeque;
import java.util.Deque;

import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.priority.IPriorityBoost;
import de.uka.ipd.sdq.scheduler.processes.impl.ProcessWithPriority;
import de.uka.ipd.sdq.scheduler.resources.AbstractSimResource;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;

public abstract class SimAbstractPassiveResource extends AbstractSimResource
		implements IPassiveResource {

	private IPriorityBoost priority_boost;
	protected Deque<WaitingProcess> waiting_queue;
	protected SimActiveResource main_resource;

	public SimAbstractPassiveResource(int capacity, String name, String id,
			IPriorityBoost priority_boost, SimActiveResource managing_resource) {
		super(capacity, name, id);
		this.priority_boost = priority_boost;
		this.main_resource = managing_resource;
		this.waiting_queue = new ArrayDeque<WaitingProcess>();
	}

	protected void fromWaitingToReady(WaitingProcess waiting_process,
			IResourceInstance current) {
		if (main_resource != null){
			main_resource.getScheduler().fromWaitingToReady(waiting_process,
					waiting_queue, current);
		}
	}

	protected void fromRunningToWaiting(WaitingProcess waiting_process,
			boolean inFront) {
		if (main_resource != null) {
			main_resource.getScheduler().fromRunningToWaiting(waiting_process,
					waiting_queue, inFront);
		}
	}

	protected void boostPriority(IRunningProcess process) {
		if (priority_boost != null) {
			assert process instanceof ProcessWithPriority : "If priority boosts are used only ProcessWithPriorities can be used!";
			priority_boost.boost((ProcessWithPriority) process);
		}
	}

	protected void punish(IRunningProcess process) {
		if (priority_boost != null) {
			assert process instanceof ProcessWithPriority : "If priority boosts are used only ProcessWithPriorities can be used!";
			priority_boost.punish((ProcessWithPriority) process);
		}
	}

	@Override
	public String toString() {
		return super.getName()+"_"+super.getId();
	}
}
