/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
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
import de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyContextCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyEventConnectorCreateCommand;

public class CustomAssemblyEventConnectorCreateCommand extends AssemblyEventConnectorCreateCommand {

    /**
     * Constructor to set the default attributes for connector elements.
     * 
     * This has been modified to deduce the container from the request, while the assembly connector
     * is not accessible from source or target. Note: The request object is not accessible by the
     * deduceContainer() method. For this, the container is deduced directly in the contructor.
     * 
     * @param request
     *            the request
     * @param source
     *            the source
     * @param target
     *            the target
     * @generated not
     */
    public CustomAssemblyEventConnectorCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
        // We need to call directly modified constructor, since this constructor here cannot have
        // access to container attribute.
        super(request, source, target);
        // super(request.getLabel(), null, request);
        // this.source = source;
        // this.target = target;
        //
        // // The container has been placed in the request during the SinkRoleItemSemanticEditPolicy
        // // container = deduceContainer(source, target);
        // container = (ComposedStructure) request.getParameter("CONTAINER");
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

        AssemblyEventConnector newElement = CompositionFactory.eINSTANCE.createAssemblyEventConnector();

        getContainer().getConnectors__ComposedStructure().add(newElement);
        newElement.setSourceRole__AssemblyEventConnector(getSource());
        newElement.setSinkRole__AssemblyEventConnector(getTarget());

        // Added the following 3 lines to set the assembly contexts.
        CreateRelationshipRequest req = (CreateRelationshipRequest) this.getRequest();
        newElement.setSourceAssemblyContext__AssemblyEventConnector((AssemblyContext) req
                .getParameter("SOURCE_CONTEXT"));
        newElement.setSinkAssemblyContext__AssemblyEventConnector((AssemblyContext) req.getParameter("SINK_CONTEXT"));

        doConfigure(newElement, monitor, info);
        ((CreateElementRequest) getRequest()).setNewElement(newElement);
        return CommandResult.newOKCommandResult(newElement);

    }
}
