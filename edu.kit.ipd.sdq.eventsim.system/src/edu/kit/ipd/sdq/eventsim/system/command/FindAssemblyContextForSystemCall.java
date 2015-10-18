package edu.kit.ipd.sdq.eventsim.system.command;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.Connector;
import org.palladiosimulator.pcm.core.composition.ProvidedDelegationConnector;
import org.palladiosimulator.pcm.core.entity.InterfaceProvidingEntity;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.system.System;
import org.palladiosimulator.pcm.system.SystemPackage;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;

import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.exceptions.unchecked.UnexpectedModelStructureException;
import edu.kit.ipd.sdq.eventsim.middleware.simulation.PCMModel;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;

/**
 * This command returns the {@link AssemblyContext} that provides a specified
 * {@link EntryLevelSystemCall}. More precisely, the AssemblyContext is returned that is wired to
 * the system's {@link OperationProvidedRole} which is called by the EntryLevelSystemCall.
 * 
 * @author Philipp Merkle
 * 
 */
public class FindAssemblyContextForSystemCall implements IPCMCommand<AssemblyContext> {

    private static final Logger logger = Logger.getLogger(FindAssemblyContextForSystemCall.class);

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
        // find the system which is referred to by the call
        InterfaceProvidingEntity entity = call.getProvidedRole_EntryLevelSystemCall().getProvidingEntity_ProvidedRole();
        System system = castToSystemOrThrowException(entity);

        // throw an exception, if the call refers to another system as specified by the simulation
        // parameters
        if (!system.getId().equals(pcm.getSystemModel().getId())) {
            throw new RuntimeException(
                    "The system call "
                            + PCMEntityHelper.toString(call)
                            + " refers to a system different from the system specified in the simulation configuration. Expected "
                            + PCMEntityHelper.toString(pcm.getSystemModel()) + ", but encountered "
                            + PCMEntityHelper.toString(system) + ".");
        }

        // find delegation connector pointing to the assembly context
        OperationProvidedRole providedRole = call.getProvidedRole_EntryLevelSystemCall();
        ProvidedDelegationConnector delegationConnector = findDelegationConnectorForRole(system, providedRole);

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
        for (Connector c : system.getConnectors__ComposedStructure()) {
            if (ProvidedDelegationConnector.class.isInstance(c)) {
                ProvidedDelegationConnector pdc = (ProvidedDelegationConnector) c;
                OperationProvidedRole outerRole = pdc.getOuterProvidedRole_ProvidedDelegationConnector();
                if (outerRole != null && outerRole.getId().equals(role.getId())) {
                    delegationConnector = pdc;
                    // we have found the connector, so leave the "for" loop
                    break;
                } else if (outerRole == null) {
                	if(logger.isEnabledFor(Level.WARN))
                		logger.warn("Found provided delegation connector who is missing an outer provided role: "
                            + PCMEntityHelper.toString(pdc));
                }
            }
        }
        if (delegationConnector == null) {
            throw new UnexpectedModelStructureException("Could not find the delegation connector of the provided role "
                    + PCMEntityHelper.toString(call.getProvidedRole_EntryLevelSystemCall()));
        }
        return delegationConnector;
    }
}
