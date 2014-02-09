package de.uka.ipd.sdq.simucomframework.resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.reliability.core.FailureStatistics;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.sensors.IActiveResourceStateSensor;
import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simucomframework.entities.SimuComEntity;
import de.uka.ipd.sdq.simucomframework.exceptions.FailureException;
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
public abstract class AbstractScheduledResource extends SimuComEntity implements IActiveResourceStateSensor {

	public final static double EPSILON = Math.pow(10, -9);

	protected static Logger logger = Logger
			.getLogger(AbstractScheduledResource.class.getName());

	// each instance maintains its own list of state listeners
	private Map<Integer, List<IStateListener>> stateListener;
	private List<IDemandListener> demandListener;
	private List<IOverallUtilizationListener> overallUtilizationListener;

	// For resources that can become unavailable (SimulatedActiveResources):
	protected double mttf = 0.0;
	protected double mttr = 0.0;
	protected boolean canBeUnavailable = false;
	protected boolean isAvailable = true;
	protected boolean requiredByContainer = false;

	protected ResourceFailedEvent failedEvent;
	protected ResourceRepairedEvent repairedEvent;

	// For resources that can fail (SimulatedLinkingResources):
	protected boolean canFail = false;
	protected double failureProbability = 0.0;

	private ActiveResouce myResourceStatus;

	protected IActiveResource aResource = null;

	protected String resourceTypeID;
	private String resourceContainerID;

	private boolean isStopped = false;

	protected String description;

	protected int numberOfInstances;

	protected String schedulingStrategyID;
	protected AbstractSimulatedResourceContainer resourceContainer = null;

	public AbstractScheduledResource(SimuComModel myModel, String typeID,
			String resourceContainerID, String resourceTypeID,
			String description, String schedulingStrategyID,
			int numberOfInstances, boolean requiredByContainer) {
		super(myModel, typeID);
		this.description = description;
		this.numberOfInstances = numberOfInstances;
		this.schedulingStrategyID = schedulingStrategyID;
		this.resourceTypeID = resourceTypeID;
		this.resourceContainerID = resourceContainerID;
		this.requiredByContainer = requiredByContainer;

		if(logger.isEnabledFor(Level.INFO))
			logger.info("Creating Simulated Active Resource: " + this.getName());

		myResourceStatus = SimucomstatusFactory.eINSTANCE.createActiveResouce();
		myResourceStatus.setId(this.getName());
		myModel.getSimulationStatus().getResourceStatus().getActiveResources()
				.add(myResourceStatus);
		resourceContainer = myModel.getResourceRegistry().getResourceContainer(resourceContainerID);
		if (resourceContainer == null) {
			if(logger.isEnabledFor(Level.WARN))
				logger.warn("Resource container " +resourceContainerID + " is not available!");
		}

		stateListener = new HashMap<Integer, List<IStateListener>>();
		for (int instance = 0; instance < numberOfInstances; instance++) {
			stateListener.put(instance, new ArrayList<IStateListener>());
		}
		overallUtilizationListener = new ArrayList<IOverallUtilizationListener>();
		demandListener = new ArrayList<IDemandListener>();

		this.aResource = createActiveResource(myModel);
		this.aResource.addObserver(this);
	}
	
	/**
	 * Returns the underlying resource 
	 * @return aResource
	 */
	public IActiveResource getUnderlyingResource() {
		return aResource;
	}

	/**
	 * Subclasses are responsible for creating the {@link IActiveResource} to
	 * use internally. Is called in the constructor.
	 * 
	 * @return the {@link IActiveResource} resource to use as determined by the
	 *         subclasses.
	 */
	protected abstract IActiveResource createActiveResource(
			SimuComModel simuComModel);

	   /**
     * Called by client of this resource to make the resource simulate resource processing. This is
     * the queueing network service center part of our simulation. Allows passing of additional
     * parameters.
     * 
     * @param thread
     *            The thread or job requesting the processing of its demand
     * @param resourceServiceID
     *            The id of the resource service to be called for resource consumption
     * @param parameterMap
     *            Additional parameters which can be used by the resource. Map can be empty.
     * @param demand
     *            The resource demand the client wishes to be processed by the resource
     */
    public abstract void consumeResource(SimuComSimProcess thread, int resourceServiceID,
            Map<String, Serializable> parameterMap, double demand);
    
	public abstract double getRemainingDemandForProcess(SimuComSimProcess thread);
	
	public abstract void updateDemand(SimuComSimProcess thread, double demand);

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
		if(logger.isDebugEnabled())
			logger.debug("Starting resource " + this.getName());
		if (canBeUnavailable) {
			double t = getFailureTime();
			failedEvent.schedule(this, t);
		}
	}

	/**
	 * Called by the framework to inform the resource that the simulation has
	 * been stopped. Fires a {@link IStateListener#stateChanged()} event.
	 */
	public void deactivateResource() {
		if (!this.isStopped) {
			if(logger.isDebugEnabled())
				logger.debug("Stopping resource " + this.getName());
			this.isStopped = true;
			for (int instance = 0; instance < numberOfInstances; instance++) {
				fireStateEvent(0, instance);
			}
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
		if(logger.isDebugEnabled())
			logger.debug("Resource " + this.getName() + " " + status
				+ " at sim time " + time);
	}

	/**
	 * Retrieves the current availability status of this resource.
	 * 
	 * @return TRUE if the resource is available; FALSE otherwise
	 */
	public boolean isAvailable() {
		return isAvailable;
	}

	/**
	 * Asks if a processing resource is required by its surrounding container.
	 * @return TRUE if resource is required; FALSE otherwise
	 */
	public boolean isRequiredByContainer() {
		return requiredByContainer;
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
		double failureTimeSample = (Double) Context.evaluateStatic("Exp(1 / "
				+ "(" + this.mttf + ")" + ")", Double.class);
		if(logger.isDebugEnabled())
			logger.debug("Resource " + this.getDescription()
				+ " will fail at sim time +" + failureTimeSample);
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
		if(logger.isDebugEnabled())
			logger.debug("Resource " + this.getDescription()
				+ " will be repaired at sim time +" + repairTimeSample);
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
			FailureException.raise(FailureStatistics.getInstance()
					.getInternalHardwareFailureType(resourceContainerID,
							resourceTypeID));
		}
	}

	public String getDescription() {
		return description;
	}

	public int getNumberOfInstances() {
		return numberOfInstances;
	}

	public void addStateListener(IStateListener listener, int instance) {
		stateListener.get(instance).add(listener);
	}

	public void addOverallUtilizationListener(
			IOverallUtilizationListener listener) {
		overallUtilizationListener.add(listener);
	}

	/**
	 * @see IStateListener
	 */
	protected void fireStateEvent(int queueLength, int instance) {
		for (IStateListener l : stateListener.get(instance)) {
			l.stateChanged(queueLength, instance);
		}
	}

	protected void fireOverallUtilization(double resourceDemand,
			double totalTime) {
		for (IOverallUtilizationListener l : overallUtilizationListener) {
			l.utilizationChanged(resourceDemand, totalTime);
		}
	}

	public void addDemandListener(IDemandListener listener) {
		demandListener.add(listener);
	}

	protected void fireDemand(double demand) {
		for (IDemandListener l : demandListener) {
			l.demand(demand);
		}
	}

	public void update(int state, int instanceId) {
		fireStateEvent(state, instanceId);
	}
	
	public void demandCompleted(ISchedulableProcess simProcess) {
		for (IDemandListener l : demandListener) {
			l.demandCompleted(simProcess);
		}
	}

    /**
     * Returns the id of the resource type (e.g. "_oro4gG3fEdy4YaaT-RYrLQ" for the "CPU" resource
     * type).
     * <p>
     * Be warned that this method's name may be confusing since it interprets the term
     * "resource type id" different to the rest of SimuCom! In SimuCom, the variable name "typeID"
     * is mostly used to refer to the name (!) of a resource type, i.e. "CPU", not "_oro4g...".
     * <p>
     * TODO: the {@code typeID} variables should be renamed to {@code typeName} or similar!
     */
    public String getResourceTypeId() {
        return resourceTypeID;
    }

	public String getSchedulingStrategyID() {
		return schedulingStrategyID;
	}
}
