package de.uka.ipd.sdq.simulation.staticstructure.commands;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;
import de.uka.ipd.sdq.simulation.entities.SimActiveResource;
import de.uka.ipd.sdq.simulation.resources.ResourceFactory;
import de.uka.ipd.sdq.simulation.staticstructure.SimulatedResourceContainer;
import de.uka.ipd.sdq.simulation.staticstructure.SimulatedResourceEnvironment;

/**
 * This command creates the {@link SimulatedResourceEnvironment}.
 * 
 * @author Philipp Merkle
 * 
 */
public class BuildSimulatedResourceEnvironment implements IPCMCommand<SimulatedResourceEnvironment> {

    private final EventSimModel model;

    /**
     * Constructs a command that builds the {@link SimulatedResourceEnvironment}.
     * 
     * @param model
     *            the simulation model
     */
    public BuildSimulatedResourceEnvironment(EventSimModel model) {
        this.model = model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimulatedResourceEnvironment execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        // TODO linking resources
        SimulatedResourceEnvironment environment = new SimulatedResourceEnvironment();
        for (ResourceContainer c : pcm.getResourceEnvironmentModel().getResourceContainer_ResourceEnvironment()) {
            environment.registerResourceContainer(c, createSimulatedResourceContainer(c));
        }
        return environment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cachable() {
        return false;
    }

    /**
     * Creates a simulated resource container in accordance with the given specification. For each
     * resource type contained in the specification, a {@link SimActiveResource} is created and
     * registered with the created resource container.
     * 
     * @param specification
     *            the resource container specification
     * @return the created resource container
     */
    private SimulatedResourceContainer createSimulatedResourceContainer(ResourceContainer specification) {
        SimulatedResourceContainer container = new SimulatedResourceContainer(specification);
        for (ProcessingResourceSpecification s : specification.getActiveResourceSpecifications_ResourceContainer()) {
            // create resource
            ResourceType resourceType = s.getActiveResourceType_ActiveResourceSpecification();
            SimActiveResource resource = ResourceFactory.createActiveResource(this.model, s);
            resource.setDescription(specification.getEntityName() + " [" + resourceType.getEntityName() + "] <"
                    + specification.getId() + ">");

            // register the created resource
            container.registerResource(resource, resourceType);
        }
        return container;
    }

}
