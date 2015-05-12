package de.uka.ipd.sdq.simucomframework.resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.resources.active.AbstractActiveResource;
import de.uka.ipd.sdq.scheduler.sensors.IActiveResourceStateSensor;
import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simucomframework.entities.SimuComEntity;
import de.uka.ipd.sdq.simucomframework.exceptions.FailureException;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.simucomstatus.ActiveResouce;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusFactory;

/**
 * Base class of all resources which have their own scheduler, i.e., active resources in the PCM.
 * Contains generic code to instrument the resource to report its results to the sensorframework
 * 
 * @author Steffen Becker, Sebastian Lehrig
 */
public abstract class AbstractScheduledResource extends SimuComEntity implements IActiveResourceStateSensor {
    private static final Logger LOGGER = Logger.getLogger(AbstractScheduledResource.class.getName());

    // each instance maintains its own list of state listeners
    private final Map<Integer, List<IStateListener>> stateListener;
    private final List<IDemandListener> demandListener;
    private final List<IOverallUtilizationListener> overallUtilizationListener;

    private final boolean requiredByContainer;

    private final ActiveResouce myResourceStatus;
    private final IActiveResource aResource;

    private final String resourceTypeID;
    private final String resourceContainerID;

    private final String description;
    private final int numberOfInstances;
    private final String schedulingStrategyID;
    private final AbstractSimulatedResourceContainer resourceContainer;

    // non-final members
    // //////////////////
    private boolean isStopped = false;
    private boolean isAvailable = true;

    public AbstractScheduledResource(final SimuComModel myModel, final String typeID, final String resourceContainerID,
            final String resourceTypeID, final String description, final String schedulingStrategyID,
            final int numberOfInstances, final boolean requiredByContainer) {
        super(myModel, typeID);

        this.description = description;
        this.numberOfInstances = numberOfInstances;
        this.schedulingStrategyID = schedulingStrategyID;
        this.resourceTypeID = resourceTypeID;
        this.resourceContainerID = resourceContainerID;
        this.requiredByContainer = requiredByContainer;

        if (LOGGER.isEnabledFor(Level.DEBUG)) {
            LOGGER.debug("Creating Simulated Active Resource: " + this.getName());
        }

        myResourceStatus = SimucomstatusFactory.eINSTANCE.createActiveResouce();
        myResourceStatus.setId(this.getName());
        myModel.getSimulationStatus().getResourceStatus().getActiveResources().add(myResourceStatus);
        resourceContainer = myModel.getResourceRegistry().getResourceContainer(resourceContainerID);
        if (resourceContainer == null) {
            if (LOGGER.isEnabledFor(Level.WARN)) {
                LOGGER.warn("Resource container " + resourceContainerID + " is not available!");
            }
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
     * 
     * @return aResource
     */
    public IActiveResource getUnderlyingResource() {
        return aResource;
    }

    /**
     * Subclasses are responsible for creating the {@link IActiveResource} to use internally. Is
     * called in the constructor.
     * 
     * @return the {@link IActiveResource} resource to use as determined by the subclasses.
     */
    protected abstract IActiveResource createActiveResource(SimuComModel simuComModel);

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
     * Template method. Implementers have to use the given demand and return the time span needed to
     * process the demand on this resource.
     * 
     * @param demand
     *            The demand issued to this resource in units understood by the resource
     * @return The service time, given in seconds
     */
    protected abstract double calculateDemand(double demand);

    /**
     * Called by the framework to inform that the resource should start its lifecycle
     */
    public void activateResource() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Starting resource " + this.getName());
        }
    }

    /**
     * Called by the framework to inform the resource that the simulation has been stopped. Fires a
     * {@link IStateListener#stateChanged()} event.
     */
    public void deactivateResource() {
        if (!this.isStopped) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Stopping resource " + this.getName());
            }
            this.isStopped = true;
            for (int instance = 0; instance < numberOfInstances; instance++) {
                fireStateEvent(0l, instance);
            }
            this.getModel().getSimulationStatus().getResourceStatus().getActiveResources().remove(myResourceStatus);
        }
    }

    public abstract IActiveResource getScheduledResource();

    /**
     * Marks the resource as being available or unavailable.
     * 
     * @param isAvailable
     *            the target state to set
     */
    public void setAvailable(final boolean isAvailable) {
        this.isAvailable = isAvailable;
        final double time = this.getModel().getSimulationControl().getCurrentSimulationTime();
        final String status = (this.isAvailable) ? "available" : "unavailable";
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Resource " + this.getName() + " " + status + " at sim time " + time);
        }
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
     * 
     * @return TRUE if resource is required; FALSE otherwise
     */
    public boolean isRequiredByContainer() {
        return requiredByContainer;
    }

    /**
     * Asserts that the resource is currently available; if not, an EnvironmentFailureException is
     * thrown.
     */
    protected void assertAvailability() {
        if (!isAvailable) {
            FailureException.raise(this.getModel(), this.getModel().getFailureStatistics()
                    .getInternalHardwareFailureType(resourceContainerID, resourceTypeID));
        }
    }

    public String getDescription() {
        return description;
    }

    public int getNumberOfInstances() {
        return numberOfInstances;
    }

    public void addStateListener(final IStateListener listener, final int instance) {
        stateListener.get(instance).add(listener);
    }

    public void addOverallUtilizationListener(final IOverallUtilizationListener listener) {
        overallUtilizationListener.add(listener);
    }

    /**
     * @see IStateListener
     */
    protected void fireStateEvent(final long queueLength, final int instance) {
        for (final IStateListener l : stateListener.get(instance)) {
            l.stateChanged(queueLength, instance);
        }
    }

    protected void fireOverallUtilization(final double resourceDemand, final double totalTime) {
        for (final IOverallUtilizationListener l : overallUtilizationListener) {
            l.utilizationChanged(resourceDemand, totalTime);
        }
    }

    public void addDemandListener(final IDemandListener listener) {
        demandListener.add(listener);
    }

    protected void fireDemand(final double demand) {
        for (final IDemandListener l : demandListener) {
            l.demand(demand);
        }
    }

    @Override
    public void update(final long state, final int instanceId) {
        fireStateEvent(state, instanceId);
    }

    @Override
    public void demandCompleted(final ISchedulableProcess simProcess) {
        for (final IDemandListener l : demandListener) {
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

    public long getQueueLength(final int coreID) {
        return aResource.getQueueLengthFor((AbstractActiveResource) getScheduledResource(), coreID);
    }
}
