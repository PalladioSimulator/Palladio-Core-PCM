package de.uka.ipd.sdq.simucomframework.resources;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;
import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.Entity;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess;
import de.uka.ipd.sdq.simucomframework.exceptions.DemandTooLargeException;
import de.uka.ipd.sdq.simucomframework.exceptions.EnvironmentFailureException;
import de.uka.ipd.sdq.simucomframework.exceptions.NegativeDemandIssuedException;
import de.uka.ipd.sdq.simucomframework.exceptions.SchedulerReturnedNegativeTimeException;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.simucomstatus.ActiveResouce;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusFactory;

/**
 * Base class of all resources which have their own scheduler, i.e., active
 * resources in the PCM. Contains generic code to instrument the resource to
 * report its results to the sensorframework
 * 
 * @author Steffen Becker
 * 
 */
public abstract class AbstractScheduledResource extends Entity {
	public final static double EPSILON = Math.pow(10, -9);

	protected static Logger logger = Logger
			.getLogger(AbstractScheduledResource.class.getName());

	private StateSensor stateSensor = null;
	private State idleState;
	private ExperimentRun experimentRun = null;

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

	private ActiveResouce myResourceStatus;

	private boolean isStopped = false;

	public AbstractScheduledResource(SimuComModel myModel, String id,
			String description, SchedulingStrategy strategy) {
		super(myModel, id);

		this.experimentRun = myModel.getCurrentExperimentRun();

		logger.info("Creating Simulated Active Resource: " + this.getName());

		myResourceStatus = SimucomstatusFactory.eINSTANCE.createActiveResouce();
		myResourceStatus.setId(this.getName());
		myModel.getSimulationStatus().getResourceStatus().getActiveResources()
				.add(myResourceStatus);
	}

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

	// Check first if the resource is currently available.
	// This works for the standard resource types (CPU, HDD, DELAY).
	/*
	 * if (!isAvailable) { EnvironmentFailureException.raise(this.getName()); }
	 */

	// If the resource can fail, simulate a failure with the given probability.
	// This works for communication link resources (LAN), but only if the
	// "simulate linking resources" option is activated. Otherwise, the
	// commlink failure is triggered out of the OAW generated code.
	/*
	 * if (canFail) { if (Math.random() < failureProbability) {
	 * EnvironmentFailureException.raise(this.getName()); } }
	 */
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

	/**
	 * Retrieves the failure probability of the resource (if it can fail).
	 * 
	 * @return the failure probability
	 */
	public double getFailureProbability() {
		return (canFail) ? failureProbability : 0.0;
	}

	/**
	 * Creates the events that let the resource fail and be repaired.
	 * 
	 * @param model
	 *            the SimuComModel
	 */
	protected void createAvailabilityEvents(final SimuComModel model) {
		this.failedEvent = new ResourceFailedEvent(model, "ResourceFailed");
		this.repairedEvent = new ResourceRepairedEvent(model,
				"ResourceRepaired");
		this.failedEvent.setResource(this);
		this.failedEvent.setRepairedEvent(repairedEvent);
		this.repairedEvent.setResource(this);
		this.repairedEvent.setFailedEvent(failedEvent);
	}

	/**
	 * Asserts that the resource is currently available; if not, an
	 * EnvironmentFailureException is thrown.
	 */
	protected void assertAvailability() {
		if (!isAvailable) {
			EnvironmentFailureException.raise(this.getName());
		}
	}
}
