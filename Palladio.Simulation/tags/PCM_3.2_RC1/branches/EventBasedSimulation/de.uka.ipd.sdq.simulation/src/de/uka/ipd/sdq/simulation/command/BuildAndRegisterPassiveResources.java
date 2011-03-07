package de.uka.ipd.sdq.simulation.command;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.resources.passive.SimSimpleFairPassiveResource;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.resources.SimulatedPassiveResource;

public class BuildAndRegisterPassiveResources implements IPCMCommand<Void> {

    private EventSimModel model;

    public BuildAndRegisterPassiveResources(EventSimModel model) {
        this.model = model;
    }

    /*
     * TODO the whole method should be improved!
     */
    @Override
    public Void execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        for (AllocationContext ctx : pcm.getAllocationModel().getAllocationContexts_Allocation()) {
            RepositoryComponent c = ctx.getAssemblyContext_AllocationContext()
                    .getEncapsulatedComponent_AssemblyContext();
            if (RepositoryPackage.eINSTANCE.getBasicComponent().isInstance(c)) {
                BasicComponent component = (BasicComponent) c;
                for (PassiveResource p : component.getPassiveResource_BasicComponent()) {
                    PCMRandomVariable capacitySpecification = p.getCapacity_PassiveResource();
                    // TODO is this way of evaluation valid!?
                    int capacity = StackContext.evaluateStatic(capacitySpecification.getSpecification(), Integer.class);

                    IPassiveResource resource = new SimSimpleFairPassiveResource(capacity, p.getEntityName(), p.getId());
                    SimulatedPassiveResource simResource = new SimulatedPassiveResource(resource);

                    model.getPassiveResourceRegistry().registerResource(simResource, p,
                            ctx.getAssemblyContext_AllocationContext());
                }
            }
        }
        return null;
    }

    @Override
    public boolean cachable() {
        return false;
    }

}
