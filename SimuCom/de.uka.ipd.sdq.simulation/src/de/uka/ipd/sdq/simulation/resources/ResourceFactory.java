package de.uka.ipd.sdq.simulation.resources;

import java.util.concurrent.atomic.AtomicLong;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ContainerOperatingSystem;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulingFactory;
import de.uka.ipd.sdq.scheduler.resources.passive.SimSimpleFairPassiveResource;
import de.uka.ipd.sdq.simucomframework.resources.SchedulingStrategy;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.entities.SimActiveResource;
import de.uka.ipd.sdq.simulation.entities.SimPassiveResource;
import de.uka.ipd.sdq.simulation.exceptions.unchecked.EventSimException;

public class ResourceFactory {

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
    public static SimActiveResource createActiveResource(EventSimModel model,
            ProcessingResourceSpecification specification) {
        // TODO reliability stuff
        // double mttf = specification.getMTTF();
        // double mttr = specification.getMTTR();
        int numberOfReplicas = specification.getNumberOfReplicas();
        PCMRandomVariable processingRate = specification.getProcessingRate_ProcessingResourceSpecification();
        SchedulingPolicy schedulingPolicy = specification.getSchedulingPolicy();

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

        SimActiveResource r = new SimActiveResource(model, resource, processingRate.getSpecification(),
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
     * @return the created resource
     */
    public static SimPassiveResource createPassiveResource(EventSimModel model, PassiveResource specification,
            ContainerOperatingSystem operatingSystem) {
        // obtain capacity by evaluating the associated StoEx
        PCMRandomVariable capacitySpecification = specification.getCapacity_PassiveResource();
        int capacity = StackContext.evaluateStatic(capacitySpecification.getSpecification(), Integer.class);

        String name = specification.getEntityName();
        String id = specification.getId();

        // create the scheduler resource for the operating system
        IPassiveResource schedulerResource = null;
        switch (operatingSystem) {
        case ABSTRACT:
            schedulerResource = new SimSimpleFairPassiveResource(capacity, name, id);
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
