package de.uka.ipd.sdq.simulation.resources;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.simulation.command.allocation.BuildResourceAllocation;
import de.uka.ipd.sdq.simulation.util.PCMEntityHelper;

public class ResourceAllocation {

    private static Logger logger = Logger.getLogger(BuildResourceAllocation.class);

    private final Map<AssemblyContext, SimulatedResourceContainer> allocationMap;

    public ResourceAllocation() {
        this.allocationMap = new HashMap<AssemblyContext, SimulatedResourceContainer>();
    }

    public void allocate(final AssemblyContext assemblyCtx, final SimulatedResourceContainer resourceContainer) {
        if (logger.isDebugEnabled()) {
            logger.debug("Allocating " + PCMEntityHelper.toString(assemblyCtx) + " to "
                    + PCMEntityHelper.toString(resourceContainer.getResourceContainer()));
        }
        this.allocationMap.put(assemblyCtx, resourceContainer);
    }

    public SimulatedResourceContainer getAllocatedResourceContainer(final AssemblyContext assemblyCtx) {
        return this.allocationMap.get(assemblyCtx);
    }

}
