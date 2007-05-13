package de.uka.ipd.sdq.simucomframework.resources;

import java.util.HashMap;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.AbstractMain;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import desmoj.core.simulator.Entity;
import desmoj.core.simulator.Event;
import desmoj.core.simulator.ProcessQueue;
import desmoj.core.simulator.Queue;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;


public class SimulatedActiveResource extends Entity {
	private static Logger logger = 
		Logger.getLogger(SimulatedActiveResource.class.getName());

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
		this.processingRate = d;
		this.units = units;
		
		logger.info("Creating Simulated Active Resource: "+this.getName());
		
		//myStrategy = new RoundRobinStrategy();
		//logger.info("Using RoundRobin Scheduler for Active Resource "+this.getName());
		myStrategy = new FIFOStrategy(myModel,typeID);
		logger.info("Using FIFO Scheduler for Active Resource "+this.getName());
	}
		
	public void consumeResource(SimProcess thread, double demand)
	{
		JobAndDemandStruct job = new JobAndDemandStruct(thread,demand/processingRate,this);
		Event ev = new JobArrivalEvent(this.getModel(),
				job,"Arrival Event", true);
		ev.schedule(job, SimTime.NOW);
		logger.debug("Thread "+thread.getName()+" requested processing of demand "+demand);
		thread.passivate();
	}

	public void activateResource()
	{
		logger.debug("Starting Resource "+this.getName());
		lastTimeOfAdjustingJobs = getModel().currentTime();
	}
	

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
