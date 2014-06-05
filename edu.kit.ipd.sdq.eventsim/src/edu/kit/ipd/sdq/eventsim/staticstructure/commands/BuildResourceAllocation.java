package edu.kit.ipd.sdq.eventsim.staticstructure.commands;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import edu.kit.ipd.sdq.eventsim.PCMModel;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.staticstructure.AllocationRegistry;
import edu.kit.ipd.sdq.eventsim.staticstructure.SimulatedResourceContainer;
import edu.kit.ipd.sdq.eventsim.staticstructure.SimulatedResourceEnvironment;

/**
 * This command allocates each {@link AssemblyContext} to the resource container instance (
 * {@link SimulatedResourceContainer}) on which it is supposed to be deployed on.
 * 
 * @author Philipp Merkle
 * 
 */
public class BuildResourceAllocation implements IPCMCommand<AllocationRegistry> {

    private SimulatedResourceEnvironment environment;

    /**
     * Constructs a command that allocates {@link AssemblyContext} to resource container instances
     * in accordance with the {@link Allocation} model.
     * 
     * @param environment
     *            the resource environment containing the resource container instances that are to
     *            be allocated
     */
    public BuildResourceAllocation(SimulatedResourceEnvironment environment) {
        this.environment = environment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AllocationRegistry execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        AllocationRegistry registry = new AllocationRegistry();

        // for each allocation
        for (AllocationContext a : pcm.getAllocationModel().getAllocationContexts_Allocation()) {
            ResourceContainer containerSpecification = a.getResourceContainer_AllocationContext();
            AssemblyContext assemblyCtx = a.getAssemblyContext_AllocationContext();

            // obtain the resource container instance for the container specification
            SimulatedResourceContainer containerInstance = environment.getResourceContainer(containerSpecification);

            // allocate the assembly context to the container instance
            registry.allocate(assemblyCtx, containerInstance);
        }

        return registry;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cachable() {
        return false;
    }

}
