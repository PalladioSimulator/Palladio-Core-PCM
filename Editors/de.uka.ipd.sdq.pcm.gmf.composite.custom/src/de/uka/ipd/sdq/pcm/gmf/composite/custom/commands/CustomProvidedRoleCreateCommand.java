/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.ProvidedRoleCreateCommand;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;

/**
 * The Class CustomProvidedRoleCreateCommand.
 */
public class CustomProvidedRoleCreateCommand extends ProvidedRoleCreateCommand {

    /**
     * Instantiates a new custom provided role create command.
     * 
     * @param req
     *            the req
     */
    public CustomProvidedRoleCreateCommand(CreateElementRequest req) {
        super(req);
    }

    /**
     * Do execute with result.
     * 
     * @param monitor
     *            the monitor
     * @param info
     *            the info
     * @return the command result
     * @throws ExecutionException
     *             the execution exception
     * @generated not
     */
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
        ProvidedRole newElement = RepositoryFactory.eINSTANCE.createOperationProvidedRole(); // change
                                                                                             // createProvidedRole
                                                                                             // to
                                                                                             // OperationProvidedRole
                                                                                             // to

        InterfaceProvidingEntity owner = (InterfaceProvidingEntity) getElementToEdit();
        owner.getProvidedRoles_InterfaceProvidingEntity().add(newElement);

        doConfigure(newElement, monitor, info);

        ((CreateElementRequest) getRequest()).setNewElement(newElement);
        return CommandResult.newOKCommandResult(newElement);
    }
}
