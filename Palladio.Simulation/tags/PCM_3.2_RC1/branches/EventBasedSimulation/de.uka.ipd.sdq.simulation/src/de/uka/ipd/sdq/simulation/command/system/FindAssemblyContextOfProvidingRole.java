package de.uka.ipd.sdq.simulation.command.system;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;
import de.uka.ipd.sdq.simulation.exceptions.concrete.UnexpectedModelStructureException;

public class FindAssemblyContextOfProvidingRole implements IPCMCommand<AssemblyContext> {

    private AssemblyContext assemblyCtx;
    private OperationRequiredRole requiredRole;
    
    public FindAssemblyContextOfProvidingRole(AssemblyContext assemblyCtx, OperationRequiredRole requiredRole) {
        this.assemblyCtx = assemblyCtx;
        this.requiredRole = requiredRole;
    }

    @Override
    public AssemblyContext execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        // find assembly context providing the required role
        AssemblyContext ctx = null;
        for(AssemblyConnector c : pcm.getSystemModel().getAssemblyConnectors_ComposedStructure()) {
            if(c.getRequiringAssemblyContext_AssemblyConnector().getId().equals(assemblyCtx.getId())) {
//                    getProvidedRole_AssemblyConnector().getId().equals(requiredRole.getId())) {
                ctx = c.getProvidingAssemblyContext_AssemblyConnector();
                break;
            }
            // TODO more detailed error message
            throw new UnexpectedModelStructureException("Could not find an assembly context");
        }
        
        return ctx;
        
//        ResourceDemandingSEFF seff = executor.execute(new FindRDSEFFForAssemblyContext(ctx));
//        
//        return seff;
    }
    
    @Override
    public boolean cachable() {
        return false;
    }

}
