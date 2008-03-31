package de.uka.ipd.sdq.capra.simulator.expressions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import de.uka.ipd.sdq.capra.simulator.actions.WaitAction;
import de.uka.ipd.sdq.capra.simulator.processes.SimCapraProcess;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;
import de.uka.ipd.sdq.scheduler.resources.passive.WaitingProcess;

public class SimParallelComposition implements SimCapraExpression,
		IFinishingListener {

	List<SimCapraExpression> behaviourList = new ArrayList<SimCapraExpression>();
	private int next;
	private int processesReturned;
	private boolean synchronised;
	private SimCapraExpression targetProcess;

	private Deque<WaitingProcess> waiting_queue;
	private WaitingProcess waiting_process;

	public SimParallelComposition(List<SimCapraExpression> behaviourList,
			SimCapraExpression targetProcess, boolean synchronised) {
		super();
		this.behaviourList = behaviourList;
		this.next = 0;
		this.processesReturned = 0;
		this.synchronised = synchronised;
		this.targetProcess = targetProcess;
		this.waiting_queue = new ArrayDeque<WaitingProcess>();
		this.waiting_process = null;
	}

	@Override
	public SimCapraExpression getNext(SimCapraProcess process) {
		SimActiveResource last_resource = process.getMainResource();
		assert last_resource != null;
		switch (next) {
		case 0:
			processesReturned = 0;
			next++;
			for (SimCapraExpression expr : behaviourList) {
				SimCapraProcess p = new SimCapraProcess(expr.clone(), process
						.getPlainName(), process.getPlainId(), process
						.getAncestor());
				if (synchronised) {
					p.setParent(process);
					p.addFinishingListener(this);
				}
				p.start(0);
			}
			if (synchronised) {
				assert waiting_process == null;
				IActiveProcess ap = (IActiveProcess) last_resource
						.lookUp(process);
				waiting_process = new WaitingProcess(ap, 1);
				last_resource.getScheduler().fromRunningToWaiting(
						waiting_process, waiting_queue, false);
				return new WaitAction();
			} else {
				next++;
				return targetProcess;
			}

		case 1:
			if (!synchronised) {
				next++;
				return targetProcess;
			} else {
				if ((processesReturned == behaviourList.size())) {
					last_resource.getScheduler().fromWaitingToReady(
							waiting_process, waiting_queue,
							waiting_process.getProcess().getLastInstance());
					waiting_process = null;
					next++;
					return targetProcess;
				} else {
					return new WaitAction();
				}
			}

		default:
			return null;
		}
	}

	public void notifyFinished() {
		processesReturned++;
	}

	@Override
	public boolean isAction() {
		return false;
	}

	@Override
	public void reset() {
		next = 0;
	}

	@Override
	public SimParallelComposition clone() {
//		List<SimCapraExpression> newBehaviourList = new ArrayList<SimCapraExpression>();
//		for (SimCapraExpression e : behaviourList) {
//			newBehaviourList.add(e.clone());
//		}
		return new SimParallelComposition(behaviourList, targetProcess.clone(),
				synchronised);
	}

	@Override
	public void setVarUsages(String name, SimCapraExpression behaviour) {
		for (SimCapraExpression expr : behaviourList) {
			expr.setVarUsages(name, behaviour);
		}
		targetProcess.setVarUsages(name, behaviour);
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public void addFinishingListener(IFinishingListener listener) {
		targetProcess.addFinishingListener(listener);

	}
}
