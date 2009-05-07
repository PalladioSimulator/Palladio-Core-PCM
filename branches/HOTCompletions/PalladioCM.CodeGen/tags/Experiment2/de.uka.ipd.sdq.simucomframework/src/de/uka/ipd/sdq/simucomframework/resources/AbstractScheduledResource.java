package de.uka.ipd.sdq.simucomframework.resources;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorfactory.entities.State;
import de.uka.ipd.sdq.sensorfactory.entities.StateSensor;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorfactory.entities.dao.ISensorDAO;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IStateDAO;
import de.uka.ipd.sdq.simucomframework.exceptions.DemandTooLargeException;
import de.uka.ipd.sdq.simucomframework.exceptions.NegativeDemandIssuedException;
import de.uka.ipd.sdq.simucomframework.exceptions.SchedulerReturnedNegativeTimeException;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import desmoj.core.simulator.Entity;
import desmoj.core.simulator.Event;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public abstract class AbstractScheduledResource extends Entity {
	
	protected static Logger logger = 
		Logger.getLogger(AbstractScheduledResource.class.getName());
	
	private boolean idle; 
	private StateSensor stateSensor = null;
	private State idleState;
	private TimeSpanSensor waitTimeSensor = null;
	//private State busyState;
	private ExperimentRun experimentRun = null;
	protected ISchedulingStrategy myStrategy = null;

	private SimTime lastTimeOfAdjustingJobs;

	private int lastCount;
	
	public AbstractScheduledResource(SimuComModel myModel, String id, String description, SchedulingStrategy strategy)
	{
		super (myModel, id, false);
		this.idle = true;
		
		this.idleState = createOrReuseState(myModel.getDAOFactory().createStateDAO(), "Idle");
		//this.busyState = createOrReuseState(myModel.getDAOFactory().createStateDAO(), "Busy");

		this.stateSensor = createOrReuseStateSensor(myModel.getExperimentDatastore(),myModel.getExperimentDatastore().getExperimentName()+": Utilisation of "+description,this.idleState);
		if (!this.stateSensor.getSensorStates().contains(idleState)) 
			this.stateSensor.addSensorState(idleState);
		//this.stateSensor.addSensorState(busyState);
		this.waitTimeSensor = createOrReuseTimeSensor(myModel.getExperimentDatastore(),myModel.getExperimentDatastore().getExperimentName()+": Wait time at "+description);
		
		this.experimentRun = myModel.getCurrentExperimentRun();
		
		logger.info("Creating Simulated Active Resource: "+this.getName());
		
		myStrategy = getStrategy(strategy);
	}

	private TimeSpanSensor createOrReuseTimeSensor(
			Experiment experimentDatastore, String id) {
		ISensorDAO sensorDAO = ((SimuComModel)getModel()).getDAOFactory().createSensorDAO();
		if (sensorDAO.findBySensorName(id).size() > 0) {
			for (Sensor s : sensorDAO.findBySensorName(id)) {
				if (s instanceof TimeSpanSensor && experimentDatastore.getSensors().contains(s))
					return (TimeSpanSensor) s;
			}
		}
		return experimentDatastore.addTimeSpanSensor(id);
	}

	protected ISchedulingStrategy getStrategy(SchedulingStrategy strategy) {
		ISchedulingStrategy result = null;
		switch(strategy) {
		case PROCESSOR_SHARING:
			result = new RoundRobinStrategy();
			logger.info("Using RoundRobin Scheduler for Active Resource "+this.getName());
			break;
		case FCFS:
			result = new FCFSStrategy((SimuComModel)this.getModel());
			logger.info("Using FIFO Scheduler for Active Resource "+this.getName());
		case DELAY:
			result = new DelayStrategy();
			break;
		}
		return result;
	}

	private StateSensor createOrReuseStateSensor(Experiment experiment, String id, State initialState) {
		ISensorDAO sensorDAO = ((SimuComModel)getModel()).getDAOFactory().createSensorDAO();
		if (sensorDAO.findBySensorName(id).size() > 0) {
			for (Sensor s : sensorDAO.findBySensorName(id)) {
				if (s instanceof StateSensor && experiment.getSensors().contains(s))
					return (StateSensor) s;
			}
		}
		return experiment.addStateSensor(initialState,id);
	}

	private State createOrReuseState(IStateDAO stateDAO, String id) {
		if (stateDAO.findByStateLiteral(id).size() == 1) {
			return stateDAO.findByStateLiteral(id).iterator().next();
		}
		return stateDAO.addState(id);
	}

	public void addJob(JobAndDemandStruct demand) {
		myStrategy.addJob(demand);
	}

	public final static double EPSILON = Math.pow(10,-9);
	
	public double getTimeWhenNextJobIsDone() {
		double result = myStrategy.getTimeWhenNextJobIsDone();
		if (result < 0) {
			if (Math.abs(result)<EPSILON){
				result = 0.0;
			} else 
				new SchedulerReturnedNegativeTimeException();
		}
		return result;
	}
	
	public void consumeResource(SimProcess thread, double demand)
	{
		if (demand < 0)
			throw new NegativeDemandIssuedException("A negative demand occured. Demand was "+demand);
		JobAndDemandStruct job = new JobAndDemandStruct(thread,calculateDemand(demand),this,this.getModel().currentTime().getTimeValue());
		if (job.getDemand() > ((SimuComModel)this.getModel()).getConfig().getSimuTime())
			throw new DemandTooLargeException("A demand calculated from a processing rate and a demand in the design model ("+
					demand+") has been issued to resource "+
					this.getName()+" which is larger than the total simulation time ("+
					((SimuComModel)this.getModel()).getConfig().getSimuTime()+"). Check your models.");
		Event ev = new JobArrivalEvent(this.getModel(),
				job,"Arrival Event", true);
		ev.schedule(job, SimTime.NOW);
		logger.debug("Thread "+thread.getName()+" requested processing of demand "+demand);
		thread.passivate();
	}

	public JobAndDemandStruct removeFinishedJob() {
		JobAndDemandStruct job = myStrategy.removeFinshedJob();
		experimentRun.addTimeSpanMeasurement(waitTimeSensor, this.getModel().currentTime().getTimeValue(), 
				job.getWaitTime(this.getModel().currentTime().getTimeValue()));
		return job;
	}

	public boolean hasMoreJobs() {
		return myStrategy.hasMoreJobs();
	}
	
	public int getTotalJobCount()
	{
		return myStrategy.getTotalJobCount();
	}

	public void setIdle(boolean b) {
		if (this.idle != b || lastCount != myStrategy.getTotalJobCount()) {
			if (b) {
				experimentRun.addStateMeasurement(stateSensor, idleState, this.getModel().currentTime().getTimeValue());
			} else {
				String stateLiteral = "Busy "+Integer.toString(myStrategy.getTotalJobCount())+" Job(s)";
				lastCount = myStrategy.getTotalJobCount();
				State nrState = createOrReuseState(((SimuComModel)this.getModel()).getDAOFactory().createStateDAO(), stateLiteral);
				if (!stateSensor.getSensorStates().contains(nrState)) 
					stateSensor.addSensorState(nrState);
				experimentRun.addStateMeasurement(stateSensor, nrState, this.getModel().currentTime().getTimeValue());
			}
		}
		this.idle=b;
	}
	
	protected abstract double calculateDemand(double demand);
	
	public void activateResource()
	{
		logger.debug("Starting Resource "+this.getName());
		lastTimeOfAdjustingJobs = getModel().currentTime();
	}
	
	public void deactivateResource()
	{
		logger.debug("Stopping Resource "+this.getName());
		experimentRun.addStateMeasurement(stateSensor, idleState, getModel().currentTime().getTimeValue());
	}

	public void processPassedTime() {
		double timePassed = getModel().currentTime().getTimeValue() - lastTimeOfAdjustingJobs.getTimeValue();
		
		myStrategy.processPassedTime(timePassed);
		
		lastTimeOfAdjustingJobs = getModel().currentTime();
	}
	
}
