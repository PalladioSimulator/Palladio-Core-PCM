package de.uka.ipd.sdq.simulation.command;

import java.util.HashMap;
import java.util.Map;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.SimulatedComponentInstance;
import de.uka.ipd.sdq.simulation.SimulatedRole;

public class BuildComponentInstances implements IPCMCommand<Map<String, SimulatedComponentInstance>> {

    @Override
    public Map<String, SimulatedComponentInstance> execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        // create component instances and provided services
        Map<String, SimulatedComponentInstance> componentsMap = new HashMap<String, SimulatedComponentInstance>();
        for (AllocationContext a : pcm.getAllocationModel().getAllocationContexts_Allocation()) {
            AssemblyContext assemblyCtx = a.getAssemblyContext_AllocationContext();
            RepositoryComponent c = assemblyCtx.getEncapsulatedComponent_AssemblyContext();
            if (RepositoryPackage.eINSTANCE.getBasicComponent().isInstance(c)) {

                BasicComponent basicComponent = (BasicComponent) c;
                SimulatedComponentInstance componentInstance = new SimulatedComponentInstance(basicComponent, assemblyCtx);
                componentsMap.put(assemblyCtx.getId(), componentInstance);
                
                // ...and add provided services
//                for (ServiceEffectSpecification s : basicComponent.getServiceEffectSpecifications__BasicComponent()) {
//                    if (s.getSeffTypeID().equals("1")) {
//                        ResourceDemandingSEFF seff = (ResourceDemandingSEFF) s;
//                        componentInstance.addProvidedService((OperationSignature) seff.getDescribedService__SEFF(),
//                                seff);
//                    } else {
//                        throw new UnexpectedModelStructureException("Found an unknown SEFF type.");
//                    }
//                }
            }
        }
        
        // link provided and required services
        for(AssemblyConnector c : pcm.getSystemModel().getAssemblyConnectors_ComposedStructure()) {
            SimulatedComponentInstance provComp = componentsMap.get(c.getProvidingAssemblyContext_AssemblyConnector().getId());
            SimulatedComponentInstance reqComp = componentsMap.get(c.getRequiringAssemblyContext_AssemblyConnector().getId());
            SimulatedRole provRole = provComp.getProvidedRoleById(c.getProvidedRole_AssemblyConnector().getId());
            SimulatedRole reqRole = reqComp.getRequiredRoleById(c.getRequiredRole_AssemblyConnector().getId());
            SimulatedRole.linkRoles(provRole, reqRole);
        }

        return componentsMap;
    }

    @Override
    public boolean cachable() {
        return false;
    }

}
