package edu.kit.ipd.sdq.eventsim.system.staticstructure.commands;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.scheduler.ISchedulingFactory;
import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.CommunicationLink;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.SimulatedResourceContainer;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.SimulatedResourceEnvironment;
import edu.kit.ipd.sdq.simcomp.component.IPCMModel;

/**
 * This command creates the {@link SimulatedResourceEnvironment}.
 * 
 * @author Philipp Merkle
 * 
 */
public class BuildSimulatedResourceEnvironment implements IPCMCommand<SimulatedResourceEnvironment> {

    private final AbstractEventSimModel model;

    /**
     * Constructs a command that builds the {@link SimulatedResourceEnvironment}.
     * 
     * @param model
     *            the simulation model
     */
    public BuildSimulatedResourceEnvironment(AbstractEventSimModel model) {
        this.model = model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimulatedResourceEnvironment execute(IPCMModel pcm, ICommandExecutor<IPCMModel> executor) {
        SimulatedResourceEnvironment environment = new SimulatedResourceEnvironment();

        // build resource container
        for (ResourceContainer containerSpecification : pcm.getResourceEnvironmentModel().getResourceContainer_ResourceEnvironment()) {
            // create the container according to the specification
            SimulatedResourceContainer container = createSimulatedResourceContainer(containerSpecification);

            // register the newly created resource container with the resource environment
            registerResourceContainers(environment, container);
        }

        // build linking resources
        for (LinkingResource linkSpecification : pcm.getResourceEnvironmentModel().getLinkingResources__ResourceEnvironment()) {
            // create the link according to the specification
            CommunicationLink link = createCommunicationLinks(linkSpecification, environment);

            // register the newly created link with all connected resource containers
            for (SimulatedResourceContainer container : link.getConnectedContainer()) {
                container.registerCommunicationLink(link);
            }
        }
        return environment;
    }

    private void registerResourceContainers(SimulatedResourceEnvironment environment, SimulatedResourceContainer container) {
        environment.registerResourceContainer(container.getSpecification(), container);

        // recursively register nested resource containers
        for (SimulatedResourceContainer nestedContainer : container.getNestedContainers()) {
            registerResourceContainers(environment, nestedContainer);
        }
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
     * registered with the created resource container. TODO (SimComp) adjust me
     * 
     * @param specification
     *            the resource container specification
     * @return the created resource container
     */
    private SimulatedResourceContainer createSimulatedResourceContainer(ResourceContainer specification) {
        return createSimulatedResourceContainer(specification, null);
    }

    private SimulatedResourceContainer createSimulatedResourceContainer(ResourceContainer specification, SimulatedResourceContainer parent) {
        SimulatedResourceContainer container = new SimulatedResourceContainer(specification, parent);
//        // create active resources
//        for (ProcessingResourceSpecification s : specification.getActiveResourceSpecifications_ResourceContainer()) {
//            // create resource
//            ResourceType resourceType = s.getActiveResourceType_ActiveResourceSpecification();
//            SimActiveResource resource = ResourceFactory.createActiveResource(this.model, schedulingFactory, s);
//            resource.setDescription(specification.getEntityName() + " [" + resourceType.getEntityName() + "] <" + specification.getId() + ">");
//
//            // register the created resource
//            container.registerResource(resource, resourceType);
//        }

        // recursively create nested resource containers, if there are any
        for (ResourceContainer nestedSpecification : specification.getNestedResourceContainers__ResourceContainer()) {
            SimulatedResourceContainer nestedContainer = createSimulatedResourceContainer(nestedSpecification, container);
            container.addNestedContainer(nestedContainer);
        }

        return container;
    }

    private CommunicationLink createCommunicationLinks(LinkingResource linkSpecification, SimulatedResourceEnvironment environment) {
        // find all resource containers connected by the passed link
        List<SimulatedResourceContainer> connectedContainer = new ArrayList<SimulatedResourceContainer>();
        for (ResourceContainer containerSpecification : linkSpecification.getConnectedResourceContainers_LinkingResource()) {
            SimulatedResourceContainer container = environment.getResourceContainer(containerSpecification);
            connectedContainer.add(container);
        }

        // create the link
        CommunicationLink link = new CommunicationLink(connectedContainer, linkSpecification.getCommunicationLinkResourceSpecifications_LinkingResource());

        return link;
    }

}
