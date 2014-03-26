package de.uka.ipd.sdq.simucomframework.resources;

import java.io.Serializable;
import java.util.Map;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simucomframework.exceptions.FailureException;
import de.uka.ipd.sdq.simucomframework.exceptions.ThroughputZeroOrNegativeException;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

/**
 * Realizes a LinkingResource. Adds the latency time to the
 * passed demand in {@link #consumeResource(SimuComSimProcess, double)},
 * and they is loaded by latency + demand / throughput.
 * 
 * @author hauck, brosch, merkle
 * 
 */
public class SimulatedLinkingResource extends AbstractScheduledResource {

    protected static Logger logger = Logger
            .getLogger(SimulatedLinkingResource.class.getName());

    private final String throughput;
    private final String latencySpec;
    private static long resourceId = 1;
    private final String id;

    private boolean utilizationSet = false;

    // private SimpleTimeSpanSensor demandedTimeSensor;
    // private OverallUtilisationSensor utilisationSensor;

    public SimulatedLinkingResource(final String id, final SimuComModel simuComModel,
            final String typeID, final String resourceContainerID, final String resourceTypeID,
            final String description, final String d, final String latencySpec,
            final Double failureProbability) {
        super(simuComModel, typeID, resourceContainerID, resourceTypeID,
                description, SchedulingStrategy.FCFS, 1, false);
        this.id = id;
        this.latencySpec = latencySpec;
        this.throughput = d;
        this.failureProbability = failureProbability;
        this.canFail = (simuComModel.getConfiguration().getSimulateFailures() && this.failureProbability > 0.0);

    }

    public String getId() {
        return id;
    }

    @Override
    protected IActiveResource createActiveResource(final SimuComModel simuComModel) {
        // this.demandedTimeSensor = new SimpleTimeSpanSensor(simuComModel,
        // "Demanded time at " + description);
        final IActiveResource aResource = getModel().getSchedulingFactory()
                .createSimFCFSResource(SchedulingStrategy.FCFS.toString(),
                        getNextResourceId());

        // utilisationSensor = new OverallUtilisationSensor(simuComModel,
        // "Utilisation of " + typeID + " " + description);
        return aResource;
    }

    @Override
    protected double calculateDemand(final double demand) {
        final double calculatedThroughput = NumberConverter.toDouble(StackContext
                .evaluateStatic(throughput));
        if (calculatedThroughput <= 0) {
            throw new ThroughputZeroOrNegativeException(
                    "Throughput at resource " + getName()
                    + " was less or equal zero");
        }

        final double result = NumberConverter.toDouble(StackContext
                .evaluateStatic(latencySpec))
                + demand / calculatedThroughput;
        if(logger.isDebugEnabled()) {
            logger.debug("A network load of " + result + " has been determined.");
        }

        return result;
    }


    /**
     * @param abstractDemand: may be zero, in that case only the latency is considered.
     */
    @Override
    public void consumeResource(final SimuComSimProcess process, final int resourceServiceID,
            final Map<String, Serializable> parameterMap, final double abstractDemand) {

        // If the resource can fail, simulate a failure with the given
        // probability.
        // This works for communication link resources (LAN), but only if the
        // "simulate linking resources" option is activated. Otherwise, the
        // commlink failure is triggered out of the OAW generated code.
        if (canFail) {
            if (Math.random() < failureProbability) {
                FailureException
                .raise(this.getModel(),this.getModel().getFailureStatistics()
                        .getInternalNetworkFailureType(id,
                                this.resourceTypeID));
            }
        }

        // registerProcessWindows(process, aResource);
        // logger.info("Demanding " + abstractDemand);

        // Consider throughput spec and add latency to the demand.
        final double concreteDemand = calculateDemand(abstractDemand);

        if (concreteDemand <= 0){
            // Do nothing.
            // TODO throw an exception or add a warning?
            return;
        }

        // logger.info("Recording " + concreteDemand);
        fireDemand(concreteDemand);
        aResource.process(process, resourceServiceID, parameterMap, concreteDemand);
    }

    @Override
    public double getRemainingDemandForProcess(final SimuComSimProcess thread) {
        return aResource.getRemainingDemand(thread);
    }

    @Override
    public void updateDemand(final SimuComSimProcess thread, final double demand) {
        aResource.updateDemand(thread, demand);
    }

    @Override
    public IActiveResource getScheduledResource() {
        return aResource;
        // return null;
    }

    @Override
    public void activateResource() {
        aResource.start();
    }

    @Override
    public void deactivateResource() {
        if (utilizationSet == false) {
            // this.utilisationSensor.setTotalResourceDemand(totalDemandedTime,
            // 1);
            utilizationSet = true;
        }
        aResource.stop();
    }

    public static String getNextResourceId() {
        return "NETWORK_" + Long.toString(resourceId++);
    }
}