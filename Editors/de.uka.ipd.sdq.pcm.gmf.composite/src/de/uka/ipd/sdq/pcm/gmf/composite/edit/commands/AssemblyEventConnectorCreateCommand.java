/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.repository.SinkRole;
import de.uka.ipd.sdq.pcm.repository.SourceRole;

/**
 * @generated
 */
public class AssemblyEventConnectorCreateCommand extends EditElementCommand {

    /**
     * @generated
     */
    private final EObject source;

    /**
     * @generated
     */
    private final EObject target;

    /**
     * @generated
     */
    private final ComposedStructure container;

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
    public AssemblyEventConnectorCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
        super(request.getLabel(), null, request);
        this.source = source;
        this.target = target;

        // The container has been placed in the request during the SinkRoleItemSemanticEditPolicy
        container = (ComposedStructure) request.getParameter("CONTAINER");
    }

    /**
     * @generated
     */
    public boolean canExecute() {
        if (source == null && target == null) {
            return false;
        }
        if (source != null && false == source instanceof SourceRole) {
            return false;
        }
        if (target != null && false == target instanceof SinkRole) {
            return false;
        }
        if (getSource() == null) {
            return true; // link creation is in progress; source is not defined yet
        }
        // target may be null here but it's possible to check constraint
        if (getContainer() == null) {
            return false;
        }
        return PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints.canCreateAssemblyEventConnector_4007(
                getContainer(), getSource(), getTarget());
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

        // set the assembly contexts.
        CreateRelationshipRequest req = (CreateRelationshipRequest) this.getRequest();
        newElement.setSourceAssemblyContext__AssemblyEventConnector((AssemblyContext) req
                .getParameter("SOURCE_CONTEXT"));
        newElement.setSinkAssemblyContext__AssemblyEventConnector((AssemblyContext) req.getParameter("SINK_CONTEXT"));

        doConfigure(newElement, monitor, info);
        ((CreateElementRequest) getRequest()).setNewElement(newElement);
        return CommandResult.newOKCommandResult(newElement);

    }

    /**
     * @generated
     */
    protected void doConfigure(AssemblyEventConnector newElement, IProgressMonitor monitor, IAdaptable info)
            throws ExecutionException {
        IElementType elementType = ((CreateElementRequest) getRequest()).getElementType();
        ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
        configureRequest.setClientContext(((CreateElementRequest) getRequest()).getClientContext());
        configureRequest.addParameters(getRequest().getParameters());
        configureRequest.setParameter(CreateRelationshipRequest.SOURCE, getSource());
        configureRequest.setParameter(CreateRelationshipRequest.TARGET, getTarget());
        ICommand configureCommand = elementType.getEditCommand(configureRequest);
        if (configureCommand != null && configureCommand.canExecute()) {
            configureCommand.execute(monitor, info);
        }
    }

    /**
     * @generated
     */
    protected void setElementToEdit(EObject element) {
        throw new UnsupportedOperationException();
    }

    /**
     * @generated
     */
    protected SourceRole getSource() {
        return (SourceRole) source;
    }

    /**
     * @generated
     */
    protected SinkRole getTarget() {
        return (SinkRole) target;
    }

    /**
     * @generated
     */
    public ComposedStructure getContainer() {
        return container;
    }

    /**
     * @generated
     */
    private static ComposedStructure deduceContainer(EObject source, EObject target) {
        // Find container element for the new link.
        // Climb up by containment hierarchy starting from the source
        // and return the first element that is instance of the container class.
        for (EObject element = source; element != null; element = element.eContainer()) {
            if (element instanceof ComposedStructure) {
                return (ComposedStructure) element;
            }
        }
        return null;
    }

}
