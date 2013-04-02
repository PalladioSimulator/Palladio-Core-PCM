/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.RequiredDelegationConnectorCreateCommand;

public class CustomRequiredDelegationConnectorCreateCommand extends RequiredDelegationConnectorCreateCommand {
    public CustomRequiredDelegationConnectorCreateCommand(
			CreateRelationshipRequest request, EObject source, EObject target) {
		super(request, source, target);
	}

	/**
     * Create a new RequiredDelegationConnector.
     * 
     * This method has been adopted manually, to set the source assembly context in the required
     * delegation connector.
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
    @Override
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
        if (!canExecute()) {
            throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
        }

        RequiredDelegationConnector newElement = CompositionFactory.eINSTANCE.createRequiredDelegationConnector();
        getContainer().getConnectors__ComposedStructure().add(newElement);
        newElement.setInnerRequiredRole_RequiredDelegationConnector(getSource());
        newElement.setOuterRequiredRole_RequiredDelegationConnector(getTarget());

        // get the assembly context out of the request
        // it has been set in the OperationRequiredRoleItemSemanticEditPolicy previously
        IEditCommandRequest request = getRequest();
        AssemblyContext assemblyContext = (AssemblyContext) request.getParameter("CHILD_CONTEXT");
        newElement.setAssemblyContext_RequiredDelegationConnector(assemblyContext);

        doConfigure(newElement, monitor, info);
        ((CreateElementRequest) getRequest()).setNewElement(newElement);
        return CommandResult.newOKCommandResult(newElement);

    }
}
