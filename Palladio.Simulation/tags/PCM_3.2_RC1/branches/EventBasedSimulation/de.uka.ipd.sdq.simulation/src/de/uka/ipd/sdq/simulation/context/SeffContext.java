package de.uka.ipd.sdq.simulation.context;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.resources.SimulatedPassiveResource;
import de.uka.ipd.sdq.simulation.resources.SimulatedResourceContainer;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.util.PCMEntityHelper;

public class SeffContext extends Context {

    private static final long serialVersionUID = -3207535919953809048L;

    public SeffContext(EventSimModel model, TraversalState<?> state, UsageContext usageContext) {
        super(model, state);
        this.stack = usageContext.getStack();
    }

    /**
     * Lookup method to find the resource container in which the given components assembly context
     * is deployed TODO Adjust!
     * 
     * @param assemblyContextID
     *            The ID of the assembly context for which its deployment is queried
     * @return The resource container in which the given assembly context is deployed
     */
    public SimulatedResourceContainer getResourceContainer() {
        final AssemblyContext assemblyCtx = this.getAssemblyContext();
        final SimulatedResourceContainer container = this.model.getResourceAllocation().getAllocatedResourceContainer(
                assemblyCtx);
        if (container == null) {
            // TODO was: ResourceContainerNotFound exception
            throw new RuntimeException("Resource container for assembly context "
                    + PCMEntityHelper.toString(assemblyCtx) + " not found. Check your allocation model.");
        }
        return container;
    }

    /**
     * Lookup method to find the linking resource container that belongs to the given container id.
     * 
     * @param linkingResourceContainerID
     *            the container id
     * @return the linking resource container
     */
    // public SimulatedLinkingResourceContainer findLinkingResource(
    // String linkingResourceContainerID) {
    // AbstractSimulatedResourceContainer container = registry
    // .getResourceContainer(linkingResourceContainerID);
    // if ((container == null)
    // || !(container instanceof SimulatedLinkingResourceContainer)) {
    // throw new ResourceContainerNotFound(
    // "Linking resource container for container ID "
    // + linkingResourceContainerID + " not found.");
    // }
    // return (SimulatedLinkingResourceContainer) container;
    // }

    public SimulatedPassiveResource getPassiveResource(final PassiveResource resource) {
        final AssemblyContext assemblyCtx = this.getAssemblyContext();
        final SimulatedPassiveResource simResource = this.model.getPassiveResourceRegistry()
                .getPassiveResourceInContext(resource, assemblyCtx);
        if (simResource == null) {
            throw new RuntimeException("Passive resource " + PCMEntityHelper.toString(resource)
                    + " for assembly context " + PCMEntityHelper.toString(assemblyCtx) + " not found.");
        }
        return simResource;
    }

    private AssemblyContext getAssemblyContext() {
        return this.state.getStack().currentScope().getComponent().getAssemblyCtx();
    }

}
