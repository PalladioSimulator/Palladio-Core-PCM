package de.uka.ipd.sdq.simulation.command.usage;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;

public class FindRDSEFFForAssemblyContext implements IPCMCommand<ResourceDemandingSEFF> {

    public static enum SEFFType {
        RESOURCE_DEMANDING_SEFF
    };

    private SEFFType type;
    private AssemblyContext assemblyCtx;

    public FindRDSEFFForAssemblyContext(AssemblyContext assemblyCtx) {
        this.type = SEFFType.RESOURCE_DEMANDING_SEFF;
        this.assemblyCtx = assemblyCtx;
    }

    @Override
    public ResourceDemandingSEFF execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        // find basic component (TODO: support composite components etc.)
        BasicComponent basicComponent = findBasicComponent(assemblyCtx);

        // find seff (TODO: choose SEFF of the requested type)
        ResourceDemandingSEFF seff = (ResourceDemandingSEFF) basicComponent
                .getServiceEffectSpecifications__BasicComponent().get(0);

        return seff;
    }

    private BasicComponent findBasicComponent(AssemblyContext assemblyCtx) {
        RepositoryComponent component = assemblyCtx.getEncapsulatedComponent_AssemblyContext();
        BasicComponent basicComponent = null;
        if (RepositoryPackage.eINSTANCE.getBasicComponent().isInstance(component)) {
            basicComponent = (BasicComponent) component;
        } else {
            throw new RuntimeException("Currently only components of type BasicComponent are supported.");
        }
        return basicComponent;
    }

    @Override
    public boolean cachable() {
        return false;
    }

}
