package de.uka.ipd.sdq.simulation.command.resourceenvironment;

import scheduler.SchedulerLibrary;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;
import de.uka.ipd.sdq.simulation.resources.ResourceFactory;
import de.uka.ipd.sdq.simulation.resources.SchedulerLibraryProxy;
import de.uka.ipd.sdq.simulation.resources.SimulatedActiveResource;
import de.uka.ipd.sdq.simulation.resources.SimulatedResourceContainer;
import de.uka.ipd.sdq.simulation.resources.SimulatedResourceEnvironment;

public class BuildSimulatedResourceEnvironment implements IPCMCommand<SimulatedResourceEnvironment> {

    private SchedulerLibrary schedulerLibrary;

    public BuildSimulatedResourceEnvironment(String pathToSchedulerLibrary) {
        schedulerLibrary = new SchedulerLibraryProxy(pathToSchedulerLibrary);
    }

    @Override
    public SimulatedResourceEnvironment execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        // TODO linking resources
        SimulatedResourceEnvironment environment = new SimulatedResourceEnvironment();
        for (ResourceContainer c : pcm.getResourceModel().getResourceContainer_ResourceEnvironment()) {
            environment.addResourceContainer(c, createSimulatedResourceContainer(c));
        }
        return environment;
    }

    private SimulatedResourceContainer createSimulatedResourceContainer(ResourceContainer c) {
        SimulatedResourceContainer container = new SimulatedResourceContainer(c);
        for (ProcessingResourceSpecification s : c.getActiveResourceSpecifications_ResourceContainer()) {
            // create resource
            ResourceType resourceType = s.getActiveResourceType_ActiveResourceSpecification();
            SimulatedActiveResource resource = createSimulatedActiveResource(s);
            resource.setDescription(c.getEntityName() + " [" + resourceType.getEntityName() + "] <" + c.getId() + ">");
            container.registerResource(resourceType, resource);
        }
        return container;
    }

    private SimulatedActiveResource createSimulatedActiveResource(ProcessingResourceSpecification s) {
        // parameters for creating the resource
        double mttf = s.getMTTF();
        double mttr = s.getMTTR();
        int numberOfReplicas = s.getNumberOfReplicas();
        PCMRandomVariable processingRate = s.getProcessingRate_ProcessingResourceSpecification();
        SchedulingPolicy schedulingPolicy = s.getSchedulingPolicy();

        return ResourceFactory.createActiveResource(schedulerLibrary, schedulingPolicy, processingRate,
                numberOfReplicas, mttf, mttr);
    }

    @Override
    public boolean cachable() {
        return false;
    }

}
