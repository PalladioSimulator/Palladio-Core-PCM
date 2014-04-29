package edu.kit.ipd.sdq.eventsim.system.staticstructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.commands.BuildSimulatedResourceEnvironment;

/**
 * This class serves a registry for {@link SimulatedResourceContainer}s by mapping resource
 * container specifications to resource container instances. In this way, it represents the resource
 * environment of a PCM model.
 * <p>
 * Notice the distinction between container specifications and container instances:
 * <ul>
 * <li>specification: {@link ResourceContainer}</li>
 * <li>instance: {@link SimulatedResourceContainer}</li>
 * </ul>
 * 
 * @author Philipp Merkle
 * 
 * @see BuildSimulatedResourceEnvironment
 */
public class SimulatedResourceEnvironment {

    // maps ResourceContainer ID -> SimulatedResourceContainer
    private Map<String, SimulatedResourceContainer> map;

    /**
     * Constructs a new registry for {@link SimulatedResourceContainer}s which represents the
     * resource environment.
     */
    public SimulatedResourceEnvironment() {
        map = new HashMap<String, SimulatedResourceContainer>();
    }

    /**
     * Registers a {@link SimulatedResourceContainer} by mapping the given resource container
     * specification to the specified resource container instance.
     * 
     * @param specification
     *            the resource container specification
     * @param instance
     *            the resource container instance
     */
    public void registerResourceContainer(ResourceContainer specification, SimulatedResourceContainer instance) {
        map.put(specification.getId(), instance);
    }

    /**
     * Returns the resource container instance for the given resource container specification
     * 
     * @param specification
     *            the resource container specification
     * @return the resource container instance for the passed specification
     */
    public SimulatedResourceContainer getResourceContainer(ResourceContainer specification) {
        return map.get(specification.getId());
    }

    /**
     * Returns all resource container instances, which has been added before.
     * 
     * @return a list of all resource container instances
     */
    public List<SimulatedResourceContainer> getResourceContainers() {
        List<SimulatedResourceContainer> containers = new ArrayList<SimulatedResourceContainer>();
        containers.addAll(map.values());
        return containers;
    }

}
