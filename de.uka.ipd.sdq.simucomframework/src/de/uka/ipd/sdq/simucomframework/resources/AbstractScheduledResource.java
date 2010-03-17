package de.uka.ipd.sdq.simucomframework.resources;

import java.util.HashMap;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.Entity;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimEventDelegate;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess;
import de.uka.ipd.sdq.simucomframework.exceptions.CommunicationLinkFailedException;
import de.uka.ipd.sdq.simucomframework.exceptions.DemandTooLargeException;
import de.uka.ipd.sdq.simucomframework.exceptions.NegativeDemandIssuedException;
import de.uka.ipd.sdq.simucomframework.exceptions.ResourceNotAvailableException;
import de.uka.ipd.sdq.simucomframework.exceptions.SchedulerReturnedNegativeTimeException;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.sensors.SensorHelper;
import de.uka.ipd.sdq.simucomframework.simucomstatus.ActiveResouce;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusFactory;
import de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDemand;

/**
 * Base class of all resources which have their own scheduler, i.e., active
 * resources in the PCM. Contains generic code to instrument the resource to
 * report its results to the sensorframework
 * 
 * @author Steffen Becker
 * 
 */
public abstract class AbstractScheduledResource extends Entity {

	protected static Logger logger = Logger
			.getLogger(AbstractScheduledResource.class.getName());

	private boolean idle;
	private StateSensor stateSensor = null;
	private State idleState;
	private TimeSpanSensor waitTimeSensor = null;
	private TimeSpanSensor demandTimeSensor = null;
	// private State busyState;
	private ExperimentRun experimentRun = null;
//	protected ISchedulingStrategy myStrategy = null;

//	protected JobDoneEvent myJobDoneEvent = null;

	// For resources that can become unavailable (SimulatedActiveResources):
	protected double mttf = 0.0;
	protected double mttr = 0.0;
	protected boolean canBeUnavailable = false;
	protected boolean isAvailable = true;
	protected ResourceFailedEvent failedEvent;
	protected ResourceRepairedEvent repairedEvent;

	// For resources that can fail (SimulatedLinkingResources):
	protected boolean canFail = false;
	protected double failureProbability = 0.0;

	private HashMap<String, State> statesCache = new HashMap<String, State>();

	private double lastTimeOfAdjustingJobs;

	private int lastCount;

	private ActiveResouce myResourceStatus;

	private boolean isDebug;

	private boolean isStopped = false;

	public AbstractScheduledResource(SimuComModel myModel, String id,
			String description, SchedulingStrategy strategy) {
		super(myModel, id);
		this.idle = true;
		this.isDebug = myModel.getConfig().isDebug();

		this.idleState = SensorHelper.createOrReuseState(myModel
				.getDAOFactory(), "Idle");
		// this.busyState =
		// createOrReuseState(myModel.getDAOFactory().createStateDAO(), "Busy");

		this.stateSensor = SensorHelper.createOrReuseStateSensor(myModel
				.getDAOFactory(), myModel.getExperimentDatastore(), myModel
				.getExperimentDatastore().getExperimentName()
				+ ": Utilisation of " + description, this.idleState);
		if (!this.stateSensor.getSensorStates().contains(idleState))
			this.stateSensor.addSensorState(idleState);
		// this.stateSensor.addSensorState(busyState);
		this.waitTimeSensor = SensorHelper.createOrReuseTimeSensor(myModel
				.getDAOFactory(), myModel.getExperimentDatastore(), myModel
				.getExperimentDatastore().getExperimentName()
				+ ": Wait time at " + description);

		// used to log requested resource demands
		this.demandTimeSensor = SensorHelper.createOrReuseTimeSensor(myModel
				.getDAOFactory(), myModel.getExperimentDatastore(), myModel
				.getExperimentDatastore().getExperimentName()
				+ ": Demanded time at " + description);

		this.experimentRun = myModel.getCurrentExperimentRun();

		logger.info("Creating Simulated Active Resource: " + this.getName());

//		myStrategy = getStrategy(strategy);

		myResourceStatus = SimucomstatusFactory.eINSTANCE.createActiveResouce();
		myResourceStatus.setId(this.getName());
		myModel.getSimulationStatus().getResourceStatus().getActiveResources()
				.add(myResourceStatus);

//		this.myJobDoneEvent = new JobDoneEvent(getModel(), "JobDone");
	}

//	protected ISchedulingStrategy getStrategy(SchedulingStrategy strategy) {
//		ISchedulingStrategy result = null;
//		switch (strategy) {
//		case PROCESSOR_SHARING:
//			result = new RoundRobinStrategy();
//			logger.info("Using RoundRobin Scheduler for Active Resource "
//					+ this.getName());
//			break;
//		case FCFS:
//			result = new FCFSStrategy((SimuComModel) this.getModel());
//			logger.info("Using FIFO Scheduler for Active Resource "
//					+ this.getName());
//			break;
//		case DELAY:
//			result = new DelayStrategy();
//			logger.info("Using Delay Scheduler for Active Resource "
//					+ this.getName());
//			break;
//		}
//		return result;
//	}

//	/**
//	 * Add a job and its corresponding demand to the processing queue of this
//	 * resource. Delegates the task to its strategy
//	 * 
//	 * @param demand
//	 *            The job and its demand to add to our queue
//	 */
//	public void addJob(JobAndDemandStruct demand) {
//		myStrategy.addJob(demand);
//	}

	public final static double EPSILON = Math.pow(10, -9);

	/**
	 * @return The time in the future when the next job would be finished in
	 *         case no further interrupts occur
	 */
//	public double getTimeWhenNextJobIsDone() {
//		double result = myStrategy.getTimeWhenNextJobIsDone();
//		if (result < 0) {
//			if (Math.abs(result) < EPSILON) {
//				result = 0.0;
//			} else
//				new SchedulerReturnedNegativeTimeException();
//		}
//		return result;
//	}

	/**
	 * Called by client of this resource to make the resource simulate resource
	 * processing. This is the queueing network service center part of our
	 * simulation
	 * 
	 * @param thread
	 *            The thread or job requesting the processing of its demand
	 * @param demand
	 *            The resource demand the client wishes to be processed by the
	 *            resource
	 */
	public abstract void consumeResource(SimProcess thread, double demand);

//	public void consumeResource(SimProcess thread, double demand) {
//		if (this.getModel().getSimulationControl().isRunning()) {
//			double calculatedDemand = calculateDemand(demand);
//			logger.info("Resource " + this.getName() + " loaded with "
//					+ calculatedDemand);
//			if (calculatedDemand < 0)
//				throw new NegativeDemandIssuedException(
//						"A negative demand occured. Demand was " + demand);
//			experimentRun.addTimeSpanMeasurement(demandTimeSensor, this
//					.getModel().getSimulationControl()
//					.getCurrentSimulationTime(), demand);
//			JobAndDemandStruct job = new JobAndDemandStruct(thread,
//					calculatedDemand, this, this.getModel()
//							.getSimulationControl().getCurrentSimulationTime());
//			if (job.getDemand() > ((SimuComModel) this.getModel()).getConfig()
//					.getSimuTime()
//					&& (this.getModel().getConfig().getSimuTime() > 0))
//				throw new DemandTooLargeException(
//						"A demand calculated from a processing rate and a demand in the design model ("
//								+ demand
//								+ ") has been issued to resource "
//								+ this.getName()
//								+ " which is larger than the total simulation time ("
//								+ ((SimuComModel) this.getModel()).getConfig()
//										.getSimuTime()
//								+ "). Check your models.");
//			ISimEventDelegate ev = new JobArrivalEvent(this.getModel(), job,
//					"Arrival Event");
//			ev.schedule(job, 0);
//
//			updateSimProcessStatus(thread, calculatedDemand);
//
//			logger.debug("Thread " + thread.getName()
//					+ " requested processing of demand " + calculatedDemand);
//			thread.passivate();
//		}
//	}

	private void updateSimProcessStatus(SimProcess thread, double demand) {
		if (isDebug) {
			WaitForDemand action = SimucomstatusFactory.eINSTANCE
					.createWaitForDemand();
			action.setActionStartTime(this.getModel().getSimulationControl()
					.getCurrentSimulationTime());
			action.setDemand(demand);
			action.setResource(this.myResourceStatus);
			thread.getSimProcessStatus().setCurrentAction(action);
		}
	}

	/**
	 * Removes the job from the processing queue which signaled that it is
	 * finished via an event. Report the waiting time to a sensor
	 * 
	 * @return The job and its demand which just finished execution
	 */
//	public JobAndDemandStruct removeFinishedJob() {
//		JobAndDemandStruct job = myStrategy.removeFinishedJob();
//		if (this.getModel().getSimulationControl().isRunning()) {
//			experimentRun.addTimeSpanMeasurement(waitTimeSensor, this
//					.getModel().getSimulationControl()
//					.getCurrentSimulationTime(), job.getWaitTime(this
//					.getModel().getSimulationControl()
//					.getCurrentSimulationTime()));
//		}
//		return job;
//	}
//
//	/**
//	 * @return True if there are more jobs in the process queue of this resource
//	 */
//	public boolean hasMoreJobs() {
//		return myStrategy.hasMoreJobs();
//	}
//
//	/**
//	 * @return The number of jobs currently processed by this resource
//	 */
//	public int getTotalJobCount() {
//		return myStrategy.getTotalJobCount();
//	}
//
//	/**
//	 * Wake up or put this resource into sleep mode. Mainly used for reporting
//	 * reasons
//	 * 
//	 * @param b
//	 *            True if the resource gets idle, false if it has to execute
//	 *            jobs
//	 */
//	public void setIdle(boolean b) {
//		if (this.idle != b || lastCount != myStrategy.getTotalJobCount()) {
//			if (b) {
//				experimentRun.addStateMeasurement(stateSensor, idleState, this
//						.getModel().getSimulationControl()
//						.getCurrentSimulationTime());
//			} else {
//				String stateLiteral = "Busy "
//						+ Integer.toString(myStrategy.getTotalJobCount())
//						+ " Job(s)";
//				lastCount = myStrategy.getTotalJobCount();
//				if (!statesCache.containsKey(stateLiteral)) {
//					State newState = SensorHelper.createOrReuseState(
//							((SimuComModel) this.getModel()).getDAOFactory(),
//							stateLiteral);
//					statesCache.put(stateLiteral, newState);
//					if (!stateSensor.getSensorStates().contains(newState))
//						stateSensor.addSensorState(newState);
//				}
//				State nrState = statesCache.get(stateLiteral);
//				experimentRun.addStateMeasurement(stateSensor, nrState, this
//						.getModel().getSimulationControl()
//						.getCurrentSimulationTime());
//			}
//		}
//		this.idle = b;
//	}

	/**
	 * Template method. Implementers have to use the given demand and return the
	 * time span needed to process the demand on this resource.
	 * 
	 * @param demand
	 *            The demand issued to this resource in units understood by the
	 *            resource
	 * @return The service time, given in seconds
	 */
	protected abstract double calculateDemand(double demand);

	/**
	 * Called by the framework to inform that the resource should start its
	 * lifecycle
	 */
	public void activateResource() {
		logger.debug("Starting resource " + this.getName());
		lastTimeOfAdjustingJobs = getModel().getSimulationControl()
				.getCurrentSimulationTime();
		if (canBeUnavailable) {
			double t = getFailureTime();
			failedEvent.schedule(this, t);
		}
	}

	/**
	 * Called by the framework to inform the resource that the simulation has
	 * been stopped
	 */
	public void deactivateResource() {
		if (!this.isStopped) {
			logger.debug("Stopping resource " + this.getName());
			this.isStopped = true;
			experimentRun.addStateMeasurement(stateSensor, idleState,
					getModel().getSimulationControl()
							.getCurrentSimulationTime());
			this.getModel().getSimulationStatus().getResourceStatus()
					.getActiveResources().remove(myResourceStatus);
			if (this.canBeUnavailable) {
				this.failedEvent.removeEvent();
				this.repairedEvent.removeEvent();
			}
		}
	}

//	/**
//	 * Called by JobArriaval or JobDoneEvents to update the process queue and
//	 * their remaining demands
//	 */
//	public void processPassedTime() {
//		double timePassed = getModel().getSimulationControl()
//				.getCurrentSimulationTime()
//				- lastTimeOfAdjustingJobs;
//
//		myStrategy.processPassedTime(timePassed);
//
//		lastTimeOfAdjustingJobs = getModel().getSimulationControl()
//				.getCurrentSimulationTime();
//	}

	public abstract IActiveResource getScheduledResource();
	/**
	 * Marks the resource as being available or unavailable.
	 * 
	 * @param isAvailable
	 *            the target state to set
	 */
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
		double time = this.getModel().getSimulationControl()
				.getCurrentSimulationTime();
		String status = (this.isAvailable) ? "available" : "unavailable";
		logger.debug("Resource " + this.getName() + " " + status
				+ " at sim time " + time);
	}

	/**
	 * Returns the failure time for this resource (or -1.0 if the resource
	 * cannot fail).
	 * 
	 * @return the failure time for the resource
	 */
	public double getFailureTime() {
		if (!canBeUnavailable) {
			throw new RuntimeException(
					"getFailureTime() should not be invoked as resource cannot fail");
		}
		double failureTimeSample = (Double) Context.evaluateStatic("Exp(1/"
				+ this.mttf + ")", Double.class);
		logger.debug("Resource will fail at sim time +" + failureTimeSample);
		return failureTimeSample;
	}

	/**
	 * Returns the repair time for this resource (or -1.0 if the resource cannot
	 * fail).
	 * 
	 * @return the repair time for the resource
	 */
	public double getRepairTime() {
		if (!canBeUnavailable) {
			throw new RuntimeException(
					"getRepairTime() should not be invoked as resource cannot fail");
		}
		double repairTimeSample = (Double) Context.evaluateStatic("Exp(1/"
				+ this.mttr + ")", Double.class);
		logger.debug("Resource will be repaired at sim time +"
				+ repairTimeSample);
		return repairTimeSample;
	}

//	public ISimEventDelegate getJobDoneEvent() {
//		return myJobDoneEvent;
//	}

	public double getFailureProbability() {
		return (canFail) ? failureProbability : 0.0;
	}
}
