package de.uka.ipd.sdq.simulation.resources;

import java.util.HashMap;
import java.util.Map;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.simulation.util.PCMEntityHelper;

public class PassiveResourceRegistry {

    private Map<String, SimulatedPassiveResource> map;

    public PassiveResourceRegistry() {
        this.map = new HashMap<String, SimulatedPassiveResource>();
    }

    // TODO maybe pass the passv res id as argument
    public void registerResource(SimulatedPassiveResource simResource, PassiveResource resource,
            AssemblyContext assemblyCtx) {
        map.put(assemblyCtx.getId() + resource.getId(), simResource);
    }

    public SimulatedPassiveResource getPassiveResourceInContext(PassiveResource resource, AssemblyContext assemblyCtx) {
        SimulatedPassiveResource r = map.get(assemblyCtx.getId() + resource.getId());
        if (r == null) {
            throw new RuntimeException("Could not find the passive resource " + PCMEntityHelper.toString(resource)
                    + " in " + PCMEntityHelper.toString(assemblyCtx));
        }
        return r;
    }

}
