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
import de.uka.ipd.sdq.pcm.core.composition.EventChannelSinkConnector;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.EventChannelSinkConnectorCreateCommand;

/**
 * The Class CustomEventChannelSinkConnectorCreateCommand.
 */
public class CustomEventChannelSinkConnectorCreateCommand extends EventChannelSinkConnectorCreateCommand {

    /**
     * Instantiates a new custom event channel sink connector create command.
     * 
     * @param request
     *            the request
     * @param source
     *            the source
     * @param target
     *            the target
     */
    public CustomEventChannelSinkConnectorCreateCommand(CreateRelationshipRequest request, EObject source,
            EObject target) {
        super(request, source, target);
    }

    /**
     * Execute the command to build up the new assembly event connector.
     * 
     * This has been manually modified to set the additional assembly context references
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

        EventChannelSinkConnector newElement = CompositionFactory.eINSTANCE.createEventChannelSinkConnector();
        getContainer().getConnectors__ComposedStructure().add(newElement);
        newElement.setSinkRole__EventChannelSinkConnector(getSource());
        newElement.setEventChannel__EventChannelSinkConnector(getTarget());

        // set the assembly contexts.
        CreateRelationshipRequest req = (CreateRelationshipRequest) this.getRequest();
        newElement.setAssemblyContext__EventChannelSinkConnector((AssemblyContext) req.getParameter("SINK_CONTEXT"));

        doConfigure(newElement, monitor, info);
        ((CreateElementRequest) getRequest()).setNewElement(newElement);
        return CommandResult.newOKCommandResult(newElement);

    }

}
