package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import desmoj.core.simulator.ProcessQueue;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class SimulatedPassiveResource extends SimProcess {

	protected ProcessQueue associatedQueue = null;
	int available;
	
	public SimulatedPassiveResource(SimuComModel myModel, String typeID, int capacity)
	{
		super (myModel, typeID, true);
		associatedQueue = new ProcessQueue(
				myModel, 
				typeID+" WaitQueue",
				true,
				true);
		available = capacity;
	}
	
	public void aquire(SimProcess thread)
	{
		associatedQueue.insert(thread);
		this.activateAfter(thread);
		thread.passivate();
	}

	public void release()
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
