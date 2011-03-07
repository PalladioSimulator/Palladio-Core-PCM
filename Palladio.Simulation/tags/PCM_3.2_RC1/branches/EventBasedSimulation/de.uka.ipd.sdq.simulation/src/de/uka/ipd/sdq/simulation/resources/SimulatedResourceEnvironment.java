package de.uka.ipd.sdq.simulation.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

/*
 * TODO maybe remove the entity extension
 */
public class SimulatedResourceEnvironment { // extends AbstractSimEntity<EventSimModel> {

    private Map<ResourceContainer, SimulatedResourceContainer> map;

    public SimulatedResourceEnvironment() {
        // super(model, "ResourceEnvironment");
        map = new HashMap<ResourceContainer, SimulatedResourceContainer>();
    }

    public void addResourceContainer(ResourceContainer c, SimulatedResourceContainer resourceContainer) {
        map.put(c, resourceContainer);
    }

    public SimulatedResourceContainer getResourceContainer(ResourceContainer c) {
        return map.get(c);
    }

    public List<SimulatedResourceContainer> getResourceContainers() {
        List<SimulatedResourceContainer> containers = new ArrayList<SimulatedResourceContainer>();
        containers.addAll(map.values());
        return containers;
    }

}
