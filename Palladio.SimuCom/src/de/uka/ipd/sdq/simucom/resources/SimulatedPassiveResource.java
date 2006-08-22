package de.uka.ipd.sdq.simucom.resources;

import de.uka.ipd.sdq.pcm.resourceenvironment.PassiveResourceSpecification;
import de.uka.ipd.sdq.simucom.SimuComModel;
import desmoj.core.simulator.ProcessQueue;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class SimulatedPassiveResource extends SimProcess {

	protected ProcessQueue associatedQueue = null;
	int available;
	
	public SimulatedPassiveResource(SimuComModel myModel, PassiveResourceSpecification spec)
	{
		super (myModel, spec.getPassiveResourceType_PassiveResourceSpecification().getEntityName(), true);
		associatedQueue = new ProcessQueue(
				myModel, 
				spec.getPassiveResourceType_PassiveResourceSpecification().getEntityName()+" WaitQueue",
				true,
				true);
		available = spec.getCapacity();
	}
	
	public void aquire(SimProcess thread)
	{
		associatedQueue.insert(thread);
		this.activateAfter(thread);
		thread.passivate();
	}

	public void release() throws Exception
	{
		available++;
		this.activateAfter(currentSimProcess());
	}

	@Override
	public void lifeCycle() {
		while(true)
		{
			if (associatedQueue.length()==0)
			{
				passivate();
			}
			else
			{
				if(available > 0)
				{
					available--;
					SimProcess next = associatedQueue.first();
					associatedQueue.remove(next);
					next.activateAfter(this);
				}
				else
				{
					passivate();
				}
			}
		}
	}

	public void activateResource() {
		this.activate(SimTime.NOW);
	}
}
