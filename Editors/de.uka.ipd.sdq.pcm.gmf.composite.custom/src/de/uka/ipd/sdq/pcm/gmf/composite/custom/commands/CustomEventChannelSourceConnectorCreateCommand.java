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
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.core.composition.EventChannelSourceConnector;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.EventChannelSourceConnectorCreateCommand;

public class CustomEventChannelSourceConnectorCreateCommand extends EventChannelSourceConnectorCreateCommand {
    public CustomEventChannelSourceConnectorCreateCommand(
			CreateRelationshipRequest request, EObject source, EObject target) {
		super(request, source, target);
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
        if (!canExecute()) {
            throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
        }

        EventChannelSourceConnector newElement = CompositionFactory.eINSTANCE.createEventChannelSourceConnector();
        getContainer().getConnectors__ComposedStructure().add(newElement);
        newElement.setSourceRole__EventChannelSourceRole(getSource());
        newElement.setEventChannel__EventChannelSourceConnector(getTarget());

        // set the assembly contexts.
        CreateRelationshipRequest req = (CreateRelationshipRequest) this.getRequest();
        newElement
                .setAssemblyContext__EventChannelSourceConnector((AssemblyContext) req.getParameter("SOURCE_CONTEXT"));

        doConfigure(newElement, monitor, info);
        ((CreateElementRequest) getRequest()).setNewElement(newElement);
        return CommandResult.newOKCommandResult(newElement);

    }
}
