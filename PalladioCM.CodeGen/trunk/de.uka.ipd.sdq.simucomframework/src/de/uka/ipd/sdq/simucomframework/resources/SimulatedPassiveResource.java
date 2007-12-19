package de.uka.ipd.sdq.simucomframework.resources;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import desmoj.core.simulator.ProcessQueue;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class SimulatedPassiveResource extends SimProcess {

	protected static Logger logger = 
		Logger.getLogger(SimulatedPassiveResource.class.getName());
	
	protected ProcessQueue associatedQueue = null;
	int available;

	private String resourceID;
	
	public SimulatedPassiveResource(SimuComModel myModel, String resourceID, int capacity)
	{
		super (myModel, resourceID, false);
		associatedQueue = new ProcessQueue(
				myModel, 
				resourceID+" WaitQueue",
				true,
				true);
		available = capacity;
		this.resourceID = resourceID;
		logger.debug("Simulated Passive Resource "+resourceID+" created.");
	}
	
	public void acquire(SimProcess thread)
	{
		logger.debug("Simulated thread "+thread.getName()+" requests Passive Resource "+this.resourceID);
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
				logger.debug("Queue of Passive Resource "+resourceID+" is empty. Resource going to sleep...");
				passivate();
			}
			else
			{
				if(available > 0)
				{
					available--;
					SimProcess next = associatedQueue.first();
					associatedQueue.remove(next);
					logger.debug("Simulated Process "+next.getName()+" acquired Passive Resource "+resourceID+". It continues execution now...");
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
