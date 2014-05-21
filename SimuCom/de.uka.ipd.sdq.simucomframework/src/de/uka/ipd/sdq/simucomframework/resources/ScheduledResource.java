package de.uka.ipd.sdq.simucomframework.resources;

import java.io.Serializable;
import java.util.Map;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * @author Steffen Becker, Sebastian Lehrig
 */
public class ScheduledResource extends AbstractScheduledResource {

    private static Logger LOGGER = Logger.getLogger(ScheduledResource.class.getName());

    private final ProcessingResourceSpecification activeResource;

    private static long resourceId = 1;
    private String processingRate;
    private double totalDemandedTime;

    // For resources that can become unavailable (SimulatedActiveResources):
    private final double mttf;
    private final double mttr;
    protected final boolean canBeUnavailable;

    private ResourceFailedEvent failedEvent;
    private ResourceRepairedEvent repairedEvent;

    public ScheduledResource(final ProcessingResourceSpecification activeResource, SimuComModel myModel,
            String resourceContainerID, String schedulingStrategyID) {
        super(myModel, // myModel
                activeResource.getId(), // typeID
                resourceContainerID, // resourceContainerID
                activeResource.getActiveResourceType_ActiveResourceSpecification().getId(), // resourceTypeID
                activeResource.getResourceContainer_ProcessingResourceSpecification().getEntityName() + " ["
                        + activeResource.getActiveResourceType_ActiveResourceSpecification().getEntityName() + "] <"
                        + activeResource.getResourceContainer_ProcessingResourceSpecification().getId() + ">", // description
                schedulingStrategyID, // schedulingStrategyID
                activeResource.getNumberOfReplicas(), // numberOfInstances
                activeResource.isRequiredByContainer() // requiredByContainer
        );
        this.activeResource = activeResource;
        this.processingRate = activeResource.getProcessingRate_ProcessingResourceSpecification().getSpecification();

        this.mttf = activeResource.getMTTF();
        this.mttr = activeResource.getMTTR();
        this.canBeUnavailable = myModel.getConfiguration().getSimulateFailures() && (this.mttf > 0.0)
                && (this.mttr > 0.0);

        // used to let resource fail and be repaired again:
        if (this.canBeUnavailable) {
            createAvailabilityEvents(myModel);
        }
    }

    /**
     * Creates the events that let the resource fail and be repaired.
     * 
     * @param model
     *            the SimuComModel
     */
    private void createAvailabilityEvents(final SimuComModel model) {
        this.failedEvent = new ResourceFailedEvent(model, "ResourceFailed");
        this.repairedEvent = new ResourceRepairedEvent(model, "ResourceRepaired");
        this.failedEvent.setResource(this);
        this.failedEvent.setRepairedEvent(repairedEvent);
        this.repairedEvent.setResource(this);
        this.repairedEvent.setFailedEvent(failedEvent);
    }

    @Override
    protected IActiveResource createActiveResource(SimuComModel myModel) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Creating scheduled resource with strategy " + getSchedulingStrategyID() + " and "
                    + getNumberOfInstances() + " replicas!");
        }
        IActiveResource aResource = getScheduledResource(myModel, "Utilisation of " + this.getName() + " "
                + getDescription());
        return aResource;
    }

    private IActiveResource getScheduledResource(SimuComModel simuComModel, String sensorDescription) {
        IActiveResource scheduledResource = null;
        // active resources scheduled by standard scheduling techniques
        if (getSchedulingStrategyID().equals(SchedulingStrategy.FCFS)) {
            scheduledResource = getModel().getSchedulingFactory().createSimFCFSResource(SchedulingStrategy.FCFS,
                    getNextResourceId());
        } else if (getSchedulingStrategyID().equals(SchedulingStrategy.PROCESSOR_SHARING)) {
            scheduledResource = getModel().getSchedulingFactory().createSimProcessorSharingResource(
                    SchedulingStrategy.PROCESSOR_SHARING, getNextResourceId(), getNumberOfInstances());
        } else if (getSchedulingStrategyID().equals(SchedulingStrategy.DELAY)) {
            scheduledResource = getModel().getSchedulingFactory().createSimDelayResource(SchedulingStrategy.DELAY,
                    getNextResourceId());
        } else {
            scheduledResource = getModel().getSchedulingFactory().createResourceFromExtension(
                    getSchedulingStrategyID(), getNextResourceId(), getNumberOfInstances());
            // scheduledResource = ISchedulingFactory.eINSTANCE
            // .createSimGinpexDiskResource(
            // SchedulingStrategy.GINPEX_DISK.toString(),
            // getNextResourceId(), getModel().getConfig().getHddParameterConfig());
        }

        if (scheduledResource instanceof SimuComExtensionResource) {
            // The resource takes additional configuration that is available in the SimuComModel
            // object
            // As the scheduler project is currently SimuCom-agnostic, we use the
            // SimuComExtensionResource class
            // to initialize the resource wit a SimuCom-related object.
            ((SimuComExtensionResource) scheduledResource).initialize(simuComModel);
        }

        return scheduledResource;
    }

    @Override
    protected double calculateDemand(double demand) {
        return demand / Context.evaluateStatic(processingRate, Double.class);
    }

    @Override
    public void activateResource() {
        getUnderlyingResource().start();
        super.activateResource();
        if (canBeUnavailable) {
            final double t = getFailureTime();
            failedEvent.schedule(this, t);
        }
    }

    @Override
    public void consumeResource(SimuComSimProcess process, int resourceServiceID,
            Map<String, Serializable> parameterMap, double abstractDemand) {
        // Check first if the resource is currently available.
        // This works for the standard resource types (CPU, HDD, DELAY).
        assertAvailability();

        getUnderlyingResource().registerProcess(process);
        // registerProcessWindows(process, aResource);
        double concreteDemand = calculateDemand(abstractDemand);
        fireDemand(concreteDemand);
        this.totalDemandedTime += concreteDemand;
        getUnderlyingResource().process(process, resourceServiceID, parameterMap, concreteDemand);
    }

    @Override
    public double getRemainingDemandForProcess(SimuComSimProcess thread) {
        return getUnderlyingResource().getRemainingDemand(thread);
    }

    @Override
    public void updateDemand(SimuComSimProcess thread, double demand) {
        getUnderlyingResource().updateDemand(thread, demand);
    }

    @Override
    public void deactivateResource() {
        super.deactivateResource();
        if (this.canBeUnavailable) {
            this.failedEvent.removeEvent();
            this.repairedEvent.removeEvent();
        }

        // calculate overall utilization and inform listeners
        double totalTime = getModel().getSimulationControl().getCurrentSimulationTime() * getNumberOfInstances();
        if (totalDemandedTime > totalTime) {
            totalDemandedTime = totalTime;
        }
        fireOverallUtilization(totalDemandedTime, totalTime);

        getUnderlyingResource().stop();
    }

    public static String getNextResourceId() {
        return Long.toString(resourceId++);
    }

    @Override
    public IActiveResource getScheduledResource() {
        return getUnderlyingResource();
    }

    /**
     * Method to alter processing rate at runtime, e.g., to model changing parameters of cloud
     * environments at runtime
     * 
     * @param newProcessingRate
     *            The new processing rate of this resource
     */
    public void setProcessingRate(String newProcessingRate) {
        this.processingRate = newProcessingRate;
    }

    public ProcessingResourceSpecification getActiveResource() {
        return this.activeResource;
    }

    /**
     * Returns the failure time for this resource (or -1.0 if the resource cannot fail).
     * 
     * @return the failure time for the resource
     */
    public double getFailureTime() {
        if (!canBeUnavailable) {
            throw new RuntimeException("getFailureTime() should not be invoked as resource cannot fail");
        }
        final double failureTimeSample = Context.evaluateStatic("Exp(1 / " + "(" + this.mttf + ")" + ")", Double.class);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Resource " + this.getDescription() + " will fail at sim time +" + failureTimeSample);
        }
        return failureTimeSample;
    }

    /**
     * Returns the repair time for this resource (or -1.0 if the resource cannot fail).
     * 
     * @return the repair time for the resource
     */
    public double getRepairTime() {
        if (!canBeUnavailable) {
            throw new RuntimeException("getRepairTime() should not be invoked as resource cannot fail");
        }
        final double repairTimeSample = Context.evaluateStatic("Exp(1/" + this.mttr + ")", Double.class);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Resource " + this.getDescription() + " will be repaired at sim time +" + repairTimeSample);
        }
        return repairTimeSample;
    }
}
