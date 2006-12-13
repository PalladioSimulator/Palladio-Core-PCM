package de.uka.ipd.sdq.simucomframework.resources;

import java.util.HashMap;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import desmoj.core.simulator.ProcessQueue;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class SimulatedActiveResource extends SimProcess {

	protected ProcessQueue associatedQueue = null;
	protected HashMap<SimProcess,Double> resourceDemands = null;
	
	private double processingRate = 0;
	private String units = null; 
	
	public SimulatedActiveResource(SimuComModel myModel, String typeID, double d, String units)
	{
		super (myModel, typeID, true);
		associatedQueue = new ProcessQueue(
				myModel, 
				typeID+" WaitQueue",
				true,
				true);
		resourceDemands = new HashMap<SimProcess, Double>();
		this.processingRate = d;
		this.units = units;
	}
	
	public void consumeResource(SimProcess thread, double demand)
	{
		resourceDemands.put(thread,demand / processingRate);
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
