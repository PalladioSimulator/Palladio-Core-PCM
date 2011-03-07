package de.uka.ipd.sdq.simulation.command.usage;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.system.System;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;
import de.uka.ipd.sdq.simulation.exceptions.concrete.UnexpectedModelStructureException;
import de.uka.ipd.sdq.simulation.util.PCMEntityHelper;

public class FindAssemblyContextForCall implements IPCMCommand<AssemblyContext> {

    private EntryLevelSystemCall call;

    public FindAssemblyContextForCall(EntryLevelSystemCall call) {
        this.call = call;
    }

    @Override
    public AssemblyContext execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        // find the system which provides the call
        InterfaceProvidingEntity entity = call.getProvidedRole_EntryLevelSystemCall().getProvidingEntity_ProvidedRole();
        System system = castToSystem(entity);

        // find delegation connector pointing to the assembly context
        OperationProvidedRole wantedRole = call.getProvidedRole_EntryLevelSystemCall();
        ProvidedDelegationConnector delegationConnector = findDelegationConnectorForRole(system, wantedRole);

        AssemblyContext assemblyCtx = delegationConnector.getAssemblyContext_ProvidedDelegationConnector();

        return assemblyCtx;
    }

    private System castToSystem(InterfaceProvidingEntity entity) {
        if (SystemPackage.eINSTANCE.getSystem().isInstance(entity)) {
            return (System) entity;
        } else {
            throw new UnexpectedModelStructureException(SystemPackage.eINSTANCE.getSystem(), entity.eClass());
        }
    }

    private ProvidedDelegationConnector findDelegationConnectorForRole(System system, OperationProvidedRole role) {
        ProvidedDelegationConnector delegationConnector = null;
        for (ProvidedDelegationConnector c : system.getProvidedDelegationConnectors_ComposedStructure()) {
            OperationProvidedRole outerRole = c.getOuterProvidedRole_ProvidedDelegationConnector();
            OperationProvidedRole wantedRole = call.getProvidedRole_EntryLevelSystemCall();
            if (outerRole.getId().equals(wantedRole.getId())) {
                delegationConnector = c;
                // we have found the connector, leave the for loop
                break;
            }
        }
        if (delegationConnector == null) {
            throw new UnexpectedModelStructureException("Could not find the delegation connector of the provided role "
                    + PCMEntityHelper.toString(call.getProvidedRole_EntryLevelSystemCall()));
        }
        return delegationConnector;
    }

    @Override
    public boolean cachable() {
        return false;
    }

}
