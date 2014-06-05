package edu.kit.ipd.sdq.eventsim.staticstructure;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import edu.kit.ipd.sdq.eventsim.staticstructure.commands.BuildResourceAllocation;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;

/**
 * This class serves as a registry for resource allocations, i.e. for the deployment of
 * {@link AssemblyContext} on {@link SimulatedResourceContainer}s.
 * <p>
 * Use {@code allocate()} to add an allocation. Existing allocations can be returned by using the
 * {@code getResourceContainer()} method.
 * 
 * @author Philipp Merkle
 * 
 * @see BuildResourceAllocation
 */
public class AllocationRegistry {

    private static Logger logger = Logger.getLogger(AllocationRegistry.class);

    // maps AssemblyContext ID -> SimulatedResourceContainer
    private final Map<String, SimulatedResourceContainer> allocationMap;

    /**
     * Constructs an empty registry for resource allocations.
     */
    public AllocationRegistry() {
        this.allocationMap = new HashMap<String, SimulatedResourceContainer>();
    }

    /**
     * Allocates the given AssemblyContext to the specified resource container.
     * 
     * @param assemblyCtx
     *            the AssemblyContext
     * @param resourceContainer
     *            the resource container
     */
    public void allocate(final AssemblyContext assemblyCtx, final SimulatedResourceContainer resourceContainer) {
        if (logger.isDebugEnabled()) {
            logger.debug("Allocating " + PCMEntityHelper.toString(assemblyCtx) + " to " + resourceContainer.toString());
        }
        this.allocationMap.put(assemblyCtx.getId(), resourceContainer);
    }

    /**
     * Returns the resource container that has been allocated to the specified AssemblyContext.
     * 
     * @param assemblyCtx
     *            the AssemblyContext
     * @return the resource container on which the given AssemblyContext is deployed
     */
    public SimulatedResourceContainer getResourceContainer(final AssemblyContext assemblyCtx) {
        final SimulatedResourceContainer container = this.allocationMap.get(assemblyCtx.getId());
        if (container == null) {
        	if(logger.isEnabledFor(Level.WARN))
        		logger.warn("Could not find resource container for assembly context "
                    + PCMEntityHelper.toString(assemblyCtx));
        }
        return container;
    }

}
