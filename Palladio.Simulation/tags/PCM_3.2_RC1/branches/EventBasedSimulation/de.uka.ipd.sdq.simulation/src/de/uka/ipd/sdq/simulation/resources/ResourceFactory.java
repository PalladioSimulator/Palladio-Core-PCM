package de.uka.ipd.sdq.simulation.resources;

import java.util.concurrent.atomic.AtomicLong;

import scheduler.SchedulerLibrary;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulingFactory;
import de.uka.ipd.sdq.scheduler.resources.passive.SimSimpleFairPassiveResource;
import de.uka.ipd.sdq.simucomframework.resources.SchedulingStrategy;

public class ResourceFactory {

    private static AtomicLong idGenerator = new AtomicLong(0);

    public static SimulatedActiveResource createActiveResource(SchedulerLibrary library,
            SchedulingPolicy schedulingPolicy, PCMRandomVariable processingRate, int numberOfReplicas, double mttf,
            double mttr) {

        IActiveResource resource = null;
        String resourceName;
        switch (schedulingPolicy) {
        case FCFS:
            resourceName = SchedulingStrategy.FCFS.toString();
            resource = ISchedulingFactory.eINSTANCE.createSimFCFSResource(resourceName, getNextId());
            break;
        case DELAY:
            resourceName = SchedulingStrategy.DELAY.toString();
            resource = ISchedulingFactory.eINSTANCE.createSimDelayResource(resourceName, getNextId());
            break;
        case PROCESSOR_SHARING:
            resourceName = SchedulingStrategy.PROCESSOR_SHARING.toString();
            resource = ISchedulingFactory.eINSTANCE.createSimProcessorSharingResource(resourceName, getNextId(),
                    numberOfReplicas);
            break;
        case EXACT:
            // TODO
            throw new RuntimeException("Exact resources are not supported yet.");
        }

        SimulatedActiveResource r = new SimulatedActiveResource(resource, processingRate.getSpecification(),
                numberOfReplicas);

        return r;
    }

    public static SimulatedPassiveResource createPassiveResource(int capacity) {
        IPassiveResource resource = null;

        String name = "test";
        String id = getNextId();

        resource = new SimSimpleFairPassiveResource(capacity, name, id);

        SimulatedPassiveResource r = new SimulatedPassiveResource(resource);
        return r;
    }

    private static String getNextId() {
        return Long.toString(idGenerator.incrementAndGet());
    }
}
