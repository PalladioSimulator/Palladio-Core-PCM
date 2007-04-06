package de.uka.ipd.sdq.simucomframework.resources;

import java.util.HashMap;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import desmoj.core.simulator.Entity;
import desmoj.core.simulator.Event;
import desmoj.core.simulator.ProcessQueue;
import desmoj.core.simulator.Queue;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;


public class SimulatedActiveResource extends Entity {

	class JobAndDemandStruct extends Entity {
		private double demand;
		private SimProcess jobParent;
		private SimulatedActiveResource resource;
		
		public double getDemand() {
			return demand;
		}


		public SimProcess getJobParent() {
			return jobParent;
		}


		public JobAndDemandStruct(SimProcess jobParent, double demand, SimulatedActiveResource simulatedActiveResource){
			super(SimulatedActiveResource.this.getModel(),"JobAndDemand",true);
			this.demand = demand;
			this.jobParent = jobParent;
			this.resource = simulatedActiveResource;
		}

		public void reduceDemand(double timePassed) {
			demand -= timePassed;
		}


		public SimulatedActiveResource getResource() {
			return resource;
		}
	}
	
	protected ISchedulingStrategy myStrategy = null;
	private SimTime lastTimeOfAdjustingJobs;
	
	private double processingRate = 0;
	private String units = null; 
	
	public SimulatedActiveResource(SimuComModel myModel, String typeID, double d, String units)
	{
		super (myModel, typeID, true);
		// associatedQueue = new ProcessQueue(
		//		myModel, 
		//		typeID+" WaitQueue",
		//		true,
		//		true);
		this.processingRate = d;
		this.units = units;
		
		//myStrategy = new RoundRobinStrategy();
		myStrategy = new FIFOStrategy(myModel,typeID);
	}
		
	public void consumeResource(SimProcess thread, double demand)
	{
		JobAndDemandStruct job = new JobAndDemandStruct(thread,demand/processingRate,this);
		Event ev = new JobArrivalEvent(this.getModel(),
				job,"Arrival Event", true);
		ev.schedule(job, SimTime.NOW);
		// resourceDemands.put(thread,demand / processingRate);
		// associatedQueue.insert(thread);
		// activateAfter(thread);
		thread.passivate();
	}

	public void activateResource()
	{
		// activate(SimTime.NOW);
		lastTimeOfAdjustingJobs = getModel().currentTime();
	}
	
//	@Override
//	public void lifeCycle() {
//		while (true)
//		{
//			if (associatedQueue.isEmpty()) {
//				passivate();
//			}
//			else
//			{
//				SimProcess waitingProcess = associatedQueue.first();
//				associatedQueue.remove(waitingProcess);
//				Double demand = resourceDemands.get(waitingProcess);
//				resourceDemands.remove(waitingProcess);
//				hold(new SimTime(demand));
//				waitingProcess.activateAfter(this);
//			}
//		}
//	}

	public void processPassedTime() {
		double timePassed = getModel().currentTime().getTimeValue() - lastTimeOfAdjustingJobs.getTimeValue();
		
		myStrategy.processPassedTime(timePassed);
		
		lastTimeOfAdjustingJobs = getModel().currentTime();
	}

	public void addJob(JobAndDemandStruct demand) {
		myStrategy.addJob(demand);
	}
	
	public double getTimeWhenNextJobIsDone() {
		return myStrategy.getTimeWhenNextJobIsDone();
	}

	public JobAndDemandStruct removeFinishedJob() {
		return myStrategy.removeFinshedJob();
	}

	public boolean hasMoreJobs() {
		return myStrategy.hasMoreJobs();
	}
	
	public int getTotalJobCount()
	{
		return myStrategy.getTotalJobCount();
	}
}
