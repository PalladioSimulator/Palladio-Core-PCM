/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.RequiredRoleCreateCommand;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

public class CustomRequiredRoleCreateCommand extends RequiredRoleCreateCommand {
    public CustomRequiredRoleCreateCommand(CreateElementRequest req) {
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
     * @generated NOT
     */
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
        RequiredRole newElement = RepositoryFactory.eINSTANCE.createOperationRequiredRole(); // changed
                                                                                             // createRequiredRole
                                                                                             // to

        InterfaceRequiringEntity owner = (InterfaceRequiringEntity) getElementToEdit();
        owner.getRequiredRoles_InterfaceRequiringEntity().add(newElement);

        doConfigure(newElement, monitor, info);

        ((CreateElementRequest) getRequest()).setNewElement(newElement);
        return CommandResult.newOKCommandResult(newElement);
    }
}
