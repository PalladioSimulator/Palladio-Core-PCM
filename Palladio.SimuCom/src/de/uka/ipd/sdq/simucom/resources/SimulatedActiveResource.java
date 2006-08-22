package de.uka.ipd.sdq.simucom.resources;

import java.util.HashMap;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.simucom.SimuComModel;
import desmoj.core.simulator.ProcessQueue;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class SimulatedActiveResource extends SimProcess {

	protected ProcessQueue associatedQueue = null;
	protected HashMap<SimProcess,Double> resourceDemands = null;
	
	public SimulatedActiveResource(SimuComModel myModel, ProcessingResourceSpecification spec)
	{
		super (myModel, spec.getActiveResourceType_ActiveResourceSpecification().getEntityName(), true);
		associatedQueue = new ProcessQueue(
				myModel, 
				spec.getActiveResourceType_ActiveResourceSpecification().getEntityName()+" WaitQueue",
				true,
				true);
		resourceDemands = new HashMap<SimProcess, Double>();
	}
	
	public void consumeResource(SimProcess thread, double demand)
	{
		resourceDemands.put(thread,demand);
		associatedQueue.insert(thread);
		activateAfter(thread);
		thread.passivate();
	}

	public void activateResource()
	{
		activate(SimTime.NOW);
	}
	
	@Override
	public void lifeCycle() {
		while (true)
		{
			if (associatedQueue.isEmpty()) {
				passivate();
			}
			else
			{
				SimProcess waitingProcess = associatedQueue.first();
				associatedQueue.remove(waitingProcess);
				Double demand = resourceDemands.get(waitingProcess);
				resourceDemands.remove(waitingProcess);
				hold(new SimTime(demand));
				waitingProcess.activateAfter(this);
			}
		}
	}
}
