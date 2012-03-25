package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.impl;

import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority.IPriority;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority.IPriorityUpdateStrategy;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.IRunQueue;

public class ProcessWithPriority extends PreemptiveProcess {

	private IPriority staticPriority;
	private IPriority dynamicPriority;
	private IPriorityUpdateStrategy priorityUpdateStrategy;
	private static boolean in_front_if_priority_changed = false;

	public ProcessWithPriority(SchedulerModel model, ISchedulableProcess process,
			IPriority staticPriority) {
		super(model, process);
		this.staticPriority = staticPriority;
		this.dynamicPriority = staticPriority;
		this.priorityUpdateStrategy = null;
	}

	public IPriority getStaticPriority() {
		return staticPriority;
	}

	public IPriority getDynamicPriority() {
		return dynamicPriority;
	}

	public void setPriorityUpdateStrategy(
			IPriorityUpdateStrategy priorityUpdateStrategy) {
		this.priorityUpdateStrategy = priorityUpdateStrategy;
	}
	
	public void updatePriority(){
		if (this.priorityUpdateStrategy != null)
			this.priorityUpdateStrategy.update(this);
	}

	public boolean hasBonus() {
		return dynamicPriority.greaterThan(staticPriority);
	}

	/**
	 * Sets the dynamic priority back to the original, static priority.
	 */
	public void resetDynamicPriority() {
		changePriority(staticPriority);
	}

	public void decreasePriority() {
		changePriority(dynamicPriority.decrease());
	}

	public boolean setToStaticPriorityWithBonus(int bonus) {
		return changePriority(staticPriority.addBonus(bonus));
	}

	private boolean changePriority(IPriority new_priority) {
		if (!dynamicPriority.equals(new_priority)){
			IRunQueue q = null;
			if (isReady() && (q = getRunQueue()) != null){
				q.removeProcess(this);
				dynamicPriority = new_priority;
				q.addProcess(this,in_front_if_priority_changed);
			} else {
				dynamicPriority = new_priority;
			}
			return true;
		}
		return false;
	}

	@Override
	public void update() {
		super.update();
		updatePriority();
	}
	
	@Override
	public String toString() {
		return getName() + " (" + MathTools.round( getTimeslice().getRemainingTime(), 0.1) +", " + getDynamicPriority() + ")";
	}
	
	@Override
	public IActiveProcess createNewInstance(ISchedulableProcess process) {
        ProcessWithPriority p = new ProcessWithPriority(getModel(), process, staticPriority);
		p.dynamicPriority = staticPriority;
		if (this.priorityUpdateStrategy != null){
			p.priorityUpdateStrategy = this.priorityUpdateStrategy.cloneFor(p);
		}
		p.setTimeSlice(this.getTimeslice().clone());
		p.updatePriority();
		return p;
	}
}
