package de.uka.ipd.sdq.simucomframework.resources;

import java.io.Serializable;
import java.util.Map;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simucomframework.exceptions.FailureException;
import de.uka.ipd.sdq.simucomframework.exceptions.ThroughputZeroOrNegativeException;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

/**
 * Realizes a LinkingResource. Adds the latency time to the passed demand in
 * {@link #consumeResource(SimuComSimProcess, double)}, and they is loaded by latency + demand /
 * throughput.
 * 
 * @author hauck, brosch, merkle, Sebastian Lehrig
 */
public class SimulatedLinkingResource extends AbstractScheduledResource {

    private static Logger LOGGER = Logger.getLogger(SimulatedLinkingResource.class.getName());

    private static long resourceId = 1;

    private final LinkingResource linkingResource;
    private final String throughput;
    private final String latencySpec;

    // For resources that can fail (SimulatedLinkingResources):
    private final boolean canFail;
    private final double failureProbability;

    private boolean utilizationSet = false;

    // private SimpleTimeSpanSensor demandedTimeSensor;
    // private OverallUtilisationSensor utilisationSensor;

    public SimulatedLinkingResource(final LinkingResource linkingResource, final SimuComModel simuComModel,
            final String resourceContainerID) {
        super(simuComModel, linkingResource.getCommunicationLinkResourceSpecifications_LinkingResource()
                .getCommunicationLinkResourceType_CommunicationLinkResourceSpecification().getEntityName(), // typeID
                resourceContainerID, // resourceContainerID
                linkingResource.getCommunicationLinkResourceSpecifications_LinkingResource()
                        .getCommunicationLinkResourceType_CommunicationLinkResourceSpecification().getId(), // resourceTypeID
                linkingResource.getEntityName()
                        + " ["
                        + linkingResource.getCommunicationLinkResourceSpecifications_LinkingResource()
                                .getCommunicationLinkResourceType_CommunicationLinkResourceSpecification()
                                .getEntityName() + "] <" + linkingResource.getId() + ">", // description
                SchedulingStrategy.FCFS, 1, false);

        this.linkingResource = linkingResource;
        this.latencySpec = this.linkingResource.getCommunicationLinkResourceSpecifications_LinkingResource()
                .getLatency_CommunicationLinkResourceSpecification().getSpecification();
        this.throughput = this.linkingResource.getCommunicationLinkResourceSpecifications_LinkingResource()
                .getThroughput_CommunicationLinkResourceSpecification().getSpecification();

        this.failureProbability = this.linkingResource.getCommunicationLinkResourceSpecifications_LinkingResource()
                .getFailureProbability();
        this.canFail = simuComModel.getConfiguration().getSimulateFailures() && failureProbability > 0.0;
    }

    public String getId() {
        return this.linkingResource.getId();
    }

    @Override
    protected IActiveResource createActiveResource(final SimuComModel simuComModel) {
        // this.demandedTimeSensor = new SimpleTimeSpanSensor(simuComModel,
        // "Demanded time at " + description);
        final IActiveResource aResource = getModel().getSchedulingFactory().createSimFCFSResource(
                SchedulingStrategy.FCFS.toString(), getNextResourceId());

        // utilisationSensor = new OverallUtilisationSensor(simuComModel,
        // "Utilisation of " + typeID + " " + description);
        return aResource;
    }

    @Override
    protected double calculateDemand(final double demand) {
        final double calculatedThroughput = NumberConverter.toDouble(StackContext.evaluateStatic(throughput));
        if (calculatedThroughput <= 0) {
            throw new ThroughputZeroOrNegativeException("Throughput at resource " + getName()
                    + " was less or equal zero");
        }

        final double result = NumberConverter.toDouble(StackContext.evaluateStatic(latencySpec)) + demand
                / calculatedThroughput;
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("A network load of " + result + " has been determined.");
        }

        return result;
    }

    /**
     * @param abstractDemand
     *            : may be zero, in that case only the latency is considered.
     */
    @Override
    public void consumeResource(final SimuComSimProcess process, final int resourceServiceID,
            final Map<String, Serializable> parameterMap, final double abstractDemand) {

        // If the resource can fail, simulate a failure with the given
        // probability.
        // This works for communication link resources (LAN), but only if the
        // "simulate linking resources" option is activated. Otherwise, the
        // commlink failure is triggered out of the OAW generated code.

        if (this.canFail) {
            if (Math.random() < this.failureProbability) {
                FailureException.raise(this.getModel(), this.getModel().getFailureStatistics()
                        .getInternalNetworkFailureType(this.linkingResource.getId(), getResourceTypeId()));
            }
        }

        // registerProcessWindows(process, aResource);
        // LOGGER.info("Demanding " + abstractDemand);

        // Consider throughput spec and add latency to the demand.
        final double concreteDemand = calculateDemand(abstractDemand);

        if (concreteDemand <= 0) {
            // Do nothing.
            // TODO throw an exception or add a warning?
            return;
        }

        // LOGGER.info("Recording " + concreteDemand);
        fireDemand(concreteDemand);
        getUnderlyingResource().process(process, resourceServiceID, parameterMap, concreteDemand);
    }

    @Override
    public double getRemainingDemandForProcess(final SimuComSimProcess thread) {
        return getUnderlyingResource().getRemainingDemand(thread);
    }

    @Override
    public void updateDemand(final SimuComSimProcess thread, final double demand) {
        getUnderlyingResource().updateDemand(thread, demand);
    }

    @Override
    public IActiveResource getScheduledResource() {
        return getUnderlyingResource();
        // return null;
    }

    @Override
    public void activateResource() {
        getUnderlyingResource().start();
    }

    @Override
    public void deactivateResource() {
        if (utilizationSet == false) {
            // this.utilisationSensor.setTotalResourceDemand(totalDemandedTime,
            // 1);
            utilizationSet = true;
        }
        getUnderlyingResource().stop();
    }

    public static String getNextResourceId() {
        return "NETWORK_" + Long.toString(resourceId++);
    }

    public LinkingResource getLinkingResource() {
        return this.linkingResource;
    }
}