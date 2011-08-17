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
import de.uka.ipd.sdq.simulation.exceptions.unchecked.UnexpectedModelStructureException;
import de.uka.ipd.sdq.simulation.util.PCMEntityHelper;

/**
 * This command returns the {@link AssemblyContext} that provides a specified
 * {@link EntryLevelSystemCall}. More precisely, the AssemblyContext is returned that is wired to
 * the system's {@link OperationProvidedRole} which is called by the EntryLevelSystemCall.
 * 
 * @author Philipp Merkle
 * 
 */
public class FindAssemblyContextForSystemCall implements IPCMCommand<AssemblyContext> {

    private EntryLevelSystemCall call;

    /**
     * Constructs a new command that returns the AssemblyContext providing the specified call.
     * 
     * @param call
     *            the call, for which the providing AssemblyContext is to be searched
     */
    public FindAssemblyContextForSystemCall(EntryLevelSystemCall call) {
        this.call = call;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AssemblyContext execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        // find the system which provides the call
        InterfaceProvidingEntity entity = call.getProvidedRole_EntryLevelSystemCall().getProvidingEntity_ProvidedRole();
        System system = castToSystemOrThrowException(entity);

        // find delegation connector pointing to the assembly context
        OperationProvidedRole wantedRole = call.getProvidedRole_EntryLevelSystemCall();
        ProvidedDelegationConnector delegationConnector = findDelegationConnectorForRole(system, wantedRole);

        AssemblyContext assemblyCtx = delegationConnector.getAssemblyContext_ProvidedDelegationConnector();

        return assemblyCtx;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cachable() {
        return false;
    }

    /**
     * Tries to cast the passed entity to a {@link System}.
     * 
     * @param entity
     *            the entity
     * @return the System, if the cast is valid; otherwise an exception is thrown
     * @throws UnexpectedModelStructureException
     *             if it is not valid to cast the specified entity to a System
     */
    private System castToSystemOrThrowException(InterfaceProvidingEntity entity) {
        if (SystemPackage.eINSTANCE.getSystem().isInstance(entity)) {
            return (System) entity;
        } else {
            throw new UnexpectedModelStructureException(SystemPackage.eINSTANCE.getSystem(), entity.eClass());
        }
    }

    /**
     * Returns the ProvidedDelegationConnector that delegates the specified system's
     * OperationProvidedRole to an AssemblyContext.
     * 
     * @param system
     *            the system providing the role
     * @param role
     *            the system role that delegates calls to an inner AssemblyContext
     * @return the connector delegating system calls
     */
    private ProvidedDelegationConnector findDelegationConnectorForRole(System system, OperationProvidedRole role) {
        ProvidedDelegationConnector delegationConnector = null;
        for (ProvidedDelegationConnector c : system.getProvidedDelegationConnectors_ComposedStructure()) {
            OperationProvidedRole outerRole = c.getOuterProvidedRole_ProvidedDelegationConnector();
            OperationProvidedRole wantedRole = call.getProvidedRole_EntryLevelSystemCall();
            if (outerRole.getId().equals(wantedRole.getId())) {
                delegationConnector = c;
                // we have found the connector, so leave the "for" loop
                break;
            }
        }
        if (delegationConnector == null) {
            throw new UnexpectedModelStructureException("Could not find the delegation connector of the provided role "
                    + PCMEntityHelper.toString(call.getProvidedRole_EntryLevelSystemCall()));
        }
        return delegationConnector;
    }

}
