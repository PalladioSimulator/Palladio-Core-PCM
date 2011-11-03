package de.uka.ipd.sdq.simulation.resources;

import java.util.concurrent.atomic.AtomicLong;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ContainerOperatingSystem;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulingFactory;
import de.uka.ipd.sdq.simucomframework.resources.SchedulingStrategy;
import de.uka.ipd.sdq.simucomframework.resources.SimSimpleFairPassiveResource;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.entities.SimActiveResource;
import de.uka.ipd.sdq.simulation.entities.SimPassiveResource;
import de.uka.ipd.sdq.simulation.exceptions.unchecked.EventSimException;

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
        final SchedulingPolicy schedulingPolicy = specification.getSchedulingPolicy();

        IActiveResource resource = null;
        String resourceName;
        switch (schedulingPolicy) {
        case FCFS:
            resourceName = SchedulingStrategy.FCFS.toString();
            resource = ISchedulingFactory.eINSTANCE.createSimFCFSResource(resourceName, getNextResourceId());
            break;
        case DELAY:
            resourceName = SchedulingStrategy.DELAY.toString();
            resource = ISchedulingFactory.eINSTANCE.createSimDelayResource(resourceName, getNextResourceId());
            break;
        case PROCESSOR_SHARING:
            resourceName = SchedulingStrategy.PROCESSOR_SHARING.toString();
            resource = ISchedulingFactory.eINSTANCE.createSimProcessorSharingResource(resourceName,
                    getNextResourceId(), numberOfReplicas);
            break;
        case EXACT:
            // TODO support exact resource
            throw new EventSimException("Exact resources are not yet supported.");
        default:
            throw new EventSimException("Unknown scheduling policy: " + schedulingPolicy.toString());
        }

        final SimActiveResource r = new SimActiveResource(model, resource, processingRate.getSpecification(),
                numberOfReplicas, schedulingPolicy);

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
            final PassiveResource specification, final ContainerOperatingSystem operatingSystem,
            final AssemblyContext assemblyCtx) {
        // obtain capacity by evaluating the associated StoEx
        final PCMRandomVariable capacitySpecification = specification.getCapacity_PassiveResource();
        final int capacity = StackContext.evaluateStatic(capacitySpecification.getSpecification(), Integer.class);

        final String name = specification.getEntityName();
        final String resourceId = specification.getId();
        final String assemblyContextId = assemblyCtx.getId();
        final String combinedId = resourceId + ":" + assemblyContextId;

        // create the scheduler resource for the operating system
        IPassiveResource schedulerResource = null;
        switch (operatingSystem) {
        case ABSTRACT:
            schedulerResource = new SimSimpleFairPassiveResource<EventSimModel>(model, capacity, name, resourceId,
                    assemblyContextId, combinedId, SIMULATE_FAILURES);
            break;
        default:
            throw new EventSimException("Passive resources are currently supported only for "
                    + "ABSTRACT operating systems.");
        }
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
