package de.uka.ipd.sdq.simucom.resources;

import PalladioCM.ResourceEnvironmentPackage.ProcessingResourceSpecification;
import de.uka.ipd.sdq.simucom.SimuComModel;
import desmoj.core.simulator.ProcessQueue;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class SimulatedActiveResource extends SimProcess {

	protected ProcessQueue associatedQueue = null;
	
	public SimulatedActiveResource(SimuComModel myModel, ProcessingResourceSpecification spec)
	{
		super (myModel, spec.getActiveResourceType_ActiveResourceSpecification().getEntityName(), true);
		associatedQueue = new ProcessQueue(
				myModel, 
				spec.getActiveResourceType_ActiveResourceSpecification().getEntityName()+" WaitQueue",
				true,
				true);
	}
	
	public void consumeResource(SimProcess thread, int demand)
	{
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
				this.sendTraceNote("Resource passivated");
				passivate();
			}
			else
			{
				SimProcess waitingProcess = associatedQueue.first();
				associatedQueue.remove(waitingProcess);
				hold(new SimTime(100));
				waitingProcess.activateAfter(this);
			}
		}
	}
}
