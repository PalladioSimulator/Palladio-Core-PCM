package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.resources.passive;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.processes.IWaitingProcess;
import de.uka.ipd.sdq.scheduler.resources.AbstractSimResource;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.IResourceInstance;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.SimActiveResource;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority.IPriorityBoost;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.impl.ProcessWithPriority;

public abstract class SimAbstractPassiveResource extends AbstractSimResource
		implements IPassiveResource {

	private IPriorityBoost priority_boost;
	protected Deque<IWaitingProcess> waiting_queue;
	protected SimActiveResource main_resource;

	public SimAbstractPassiveResource(SchedulerModel model, int capacity, String name, String id,
			IPriorityBoost priority_boost, SimActiveResource managing_resource) {
		super(model, capacity, name, id);
		this.priority_boost = priority_boost;
		this.main_resource = managing_resource;
		this.waiting_queue = new ArrayDeque<IWaitingProcess>();
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
	
	public Queue<IWaitingProcess> getWaitingProcesses() {
		return waiting_queue;
	}

	@Override
	public String toString() {
		return super.getName()+"_"+super.getId();
	}
}
