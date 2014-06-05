package edu.kit.ipd.sdq.eventsim.resources;

import java.util.concurrent.atomic.AtomicLong;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.simucomframework.resources.SchedulingStrategy;
import de.uka.ipd.sdq.simucomframework.resources.SimSimpleFairPassiveResource;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.entities.SimActiveResource;
import edu.kit.ipd.sdq.eventsim.entities.SimLinkingResource;
import edu.kit.ipd.sdq.eventsim.entities.SimPassiveResource;
import edu.kit.ipd.sdq.eventsim.exceptions.unchecked.EventSimException;

public class ResourceFactory {

    private static final boolean SIMULATE_FAILURES = false;
    private static AtomicLong idGenerator = new AtomicLong(0);

    /**
     * Creates an active resource in accordance with the given resource specification.
     * 
     * @param model
     *            the simulation model
     * @param specification
     *            the resource specification
     * @return the created resource
     */
    public static SimActiveResource createActiveResource(final EventSimModel model,
            final ProcessingResourceSpecification specification) {
        // TODO reliability stuff
        // double mttf = specification.getMTTF();
        // double mttr = specification.getMTTR();
        final int numberOfReplicas = specification.getNumberOfReplicas();
        final PCMRandomVariable processingRate = specification.getProcessingRate_ProcessingResourceSpecification();
        final SchedulingPolicy schedulingPolicy = SchedulingPolicy.getPolicyForId(specification.getSchedulingPolicy()
                .getId());

        IActiveResource resource = null;
        String resourceName;
        switch (schedulingPolicy) {
        case FCFS:
            resourceName = SchedulingStrategy.FCFS.toString();
            resource = model.getSchedulingFactory().createSimFCFSResource(resourceName, getNextResourceId());
            break;
        case DELAY:
            resourceName = SchedulingStrategy.DELAY.toString();
            resource = model.getSchedulingFactory().createSimDelayResource(resourceName, getNextResourceId());
            break;
        case PROCESSOR_SHARING:
            resourceName = SchedulingStrategy.PROCESSOR_SHARING.toString();
            resource = model.getSchedulingFactory().createSimProcessorSharingResource(resourceName,
                    getNextResourceId(), numberOfReplicas);
            break;
        default:
            throw new EventSimException("Unknown scheduling policy: " + schedulingPolicy.toString());
        }

        final SimActiveResource r = new SimActiveResource(model, resource, processingRate.getSpecification(),
                numberOfReplicas, schedulingPolicy);

        return r;
    }

    /**
     * Creates a linking resource in accordance with the given resource specification.
     * 
     * @param model
     *            the simulation model
     * @param specification
     *            the resource specification
     * @return the created resource
     */
    public static SimLinkingResource createLinkingResource(final EventSimModel model,
            final CommunicationLinkResourceSpecification specification) {

        final PCMRandomVariable latency = specification.getLatency_CommunicationLinkResourceSpecification();
        final PCMRandomVariable throughput = specification.getThroughput_CommunicationLinkResourceSpecification();

        String resourceName = SchedulingStrategy.FCFS.toString();
        IActiveResource resource = model.getSchedulingFactory()
                .createSimFCFSResource(resourceName, getNextResourceId());

        final SimLinkingResource r = new SimLinkingResource(model, resource, latency.getSpecification(),
                throughput.getSpecification());

        return r;
    }

    /**
     * Creates a passive resource in accordance with the given resource specification.
     * 
     * @param model
     *            the simulation model
     * @param specification
     *            the resource specification
     * @param operatingSystem
     *            the operating system managing the passive resource
     * @param assemblyCtx
     *            the assembly context in which the passive resource is created
     * @return the created resource
     */
    public static SimPassiveResource createPassiveResource(final EventSimModel model,
            final PassiveResource specification, final AssemblyContext assemblyCtx) {
        // obtain capacity by evaluating the associated StoEx
        final PCMRandomVariable capacitySpecification = specification.getCapacity_PassiveResource();
        final int capacity = StackContext.evaluateStatic(capacitySpecification.getSpecification(), Integer.class);

        final String name = specification.getEntityName();
        final String resourceId = specification.getId();
        final String assemblyContextId = assemblyCtx.getId();
        final String combinedId = resourceId + ":" + assemblyContextId;

        // create the scheduler resource for the operating system
        IPassiveResource schedulerResource = new SimSimpleFairPassiveResource(model, capacity, name, resourceId,
                assemblyContextId, combinedId, SIMULATE_FAILURES);

        return new SimPassiveResource(model, schedulerResource);
    }

    /**
     * Creates a unique resource ID.
     * 
     * @return the ID
     */
    private static String getNextResourceId() {
        return Long.toString(idGenerator.incrementAndGet());
    }

}
