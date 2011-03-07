package de.uka.ipd.sdq.simulation.command.allocation;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;
import de.uka.ipd.sdq.simulation.resources.ResourceAllocation;
import de.uka.ipd.sdq.simulation.resources.SimulatedResourceEnvironment;

public class BuildResourceAllocation implements IPCMCommand<ResourceAllocation> {

    private SimulatedResourceEnvironment environment;

    public BuildResourceAllocation(SimulatedResourceEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public ResourceAllocation execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        ResourceAllocation resourceAllocation = new ResourceAllocation();

        Allocation allocation = pcm.getAllocationModel();
        for (AllocationContext a : allocation.getAllocationContexts_Allocation()) {
            ResourceContainer resourceContainer = a.getResourceContainer_AllocationContext();
            AssemblyContext assemblyCtx = a.getAssemblyContext_AllocationContext();

            resourceAllocation.allocate(assemblyCtx, environment.getResourceContainer(resourceContainer));
        }

        return resourceAllocation;
    }

    @Override
    public boolean cachable() {
        return false;
    }

}
