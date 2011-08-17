package de.uka.ipd.sdq.simulation.staticstructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimulatedSystem {

    private PassiveResourceRegistry passiveResourceRegistry;
    private SimulatedResourceEnvironment resourceEnvironment;
    private AllocationRegistry resourceAllocation;
    private Map<String, ComponentInstance> componentRegistry;

    public SimulatedSystem() {
        componentRegistry = new HashMap<String, ComponentInstance>();
        
    }

    public void addComponentInstance(ComponentInstance component, String assemblyContextId) {
        componentRegistry.put(assemblyContextId, component);
    }

    public List<ComponentInstance> getComponentInstances() {
        List<ComponentInstance> components = new ArrayList<ComponentInstance>();
        components.addAll(componentRegistry.values());
        return components;
    }

    public ComponentInstance getComponentInstance(String assemblyContextId) {
        return componentRegistry.get(assemblyContextId);
    }

    public SimulatedResourceEnvironment getSimulatedResourceEnvironment() {
        return resourceEnvironment;
    }

}
