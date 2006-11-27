package de.uka.ipd.sdq.qnm.simulator.resources;

import de.uka.ipd.sdq.qnm.simulator.SimuQNModel;
import de.uka.ipd.sdq.qnm.simulator.tasks.SimulatedTask;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.ProcessQueue;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class SimulatedProcessingResourceReplica extends SimProcess{

	protected SimulatedProcessingResource master;
	
	public SimulatedProcessingResourceReplica(Model owner, String name,
			boolean showInTrace, SimulatedProcessingResource master) {
		super(owner, name, showInTrace);
		this.master = (SimulatedProcessingResource) master;
	}

	@Override
	public void lifeCycle() {
		
		while (true)
		{
			ProcessQueue waitingTasks = this.master.getWaitingTasks();
			
			if (waitingTasks.isEmpty()) {
				// no tasks waiting to be served -> enter queue of processors...
				master.getWaitingProcessingResources().insert(this);
				// ... and wait:
				passivate();
			} else {
				// some task wants to be served -> get it from queue of tasks
				SimProcess waitingTask = waitingTasks.first();
				waitingTasks.remove(waitingTask);
				SimulatedTask simTask = (SimulatedTask)waitingTask;
				
				Double demand = simTask.getCurrentDemand();
				
				if (this.getName().startsWith("HD")){
					SimuQNModel qnModel = (SimuQNModel)this.currentModel();
					qnModel.monitoredSingleFunction.addValue(demand);
					System.out.println(demand);
				}

				
				hold(new SimTime(demand));
				
				simTask.activateAfter(this);
			}
		}
	}

}
