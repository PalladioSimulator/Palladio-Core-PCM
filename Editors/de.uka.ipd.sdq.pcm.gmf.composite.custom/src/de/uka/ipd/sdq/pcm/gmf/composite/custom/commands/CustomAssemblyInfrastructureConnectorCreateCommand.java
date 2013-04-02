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

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyInfrastructureConnector;
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyInfrastructureConnectorCreateCommand;

public class CustomAssemblyInfrastructureConnectorCreateCommand extends AssemblyInfrastructureConnectorCreateCommand {
    public CustomAssemblyInfrastructureConnectorCreateCommand(
			CreateRelationshipRequest request, EObject source, EObject target) {
		super(request, source, target);
	}

	/**
     * Adapted to use correct assembly contexts.
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
        if (!canExecute()) {
            throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
        }

        AssemblyInfrastructureConnector newElement = CompositionFactory.eINSTANCE
                .createAssemblyInfrastructureConnector();
        getContainer().getConnectors__ComposedStructure().add(newElement);
        newElement.setRequiredRole__AssemblyInfrastructureConnector(getSource());
        newElement.setProvidedRole__AssemblyInfrastructureConnector(getTarget());

        // add assembly contexts
        CreateRelationshipRequest req = (CreateRelationshipRequest) this.getRequest();
        newElement.setRequiringAssemblyContext__AssemblyInfrastructureConnector((AssemblyContext) req
                .getParameter("SOURCE_ASSEMBLY_CONTEXT"));
        newElement.setProvidingAssemblyContext__AssemblyInfrastructureConnector((AssemblyContext) req
                .getParameter("TARGET_ASSEMBLY_CONTEXT"));

        doConfigure(newElement, monitor, info);
        ((CreateElementRequest) getRequest()).setNewElement(newElement);
        return CommandResult.newOKCommandResult(newElement);

    }
}
