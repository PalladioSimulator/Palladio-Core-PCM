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

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;

/**
 * The Class AssemblyConnectorCreateCommand.
 * 
 * @generated
 */
public class AssemblyConnectorCreateCommand extends EditElementCommand {

    /** The source. @generated */
    private final EObject source;

    /** The target. @generated */
    private final EObject target;

    /** The container. @generated */
    private final ComposedStructure container;

    /**
     * Instantiates a new assembly connector create command.
     * 
     * @param request
     *            the request
     * @param source
     *            the source
     * @param target
     *            the target
     * @generated
     */
    public AssemblyConnectorCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
        super(request.getLabel(), null, request);
        this.source = source;
        this.target = target;
        container = deduceContainer(source, target);
    }

    /**
     * Can execute.
     * 
     * @return true, if successful
     * @generated
     */
    public boolean canExecute() {
        if (source == null && target == null) {
            return false;
        }
        if (source != null && false == source instanceof OperationRequiredRole) {
            return false;
        }
        if (target != null && false == target instanceof OperationProvidedRole) {
            return false;
        }
        if (getSource() == null) {
            return true; // link creation is in progress; source is not defined yet
        }
        // target may be null here but it's possible to check constraint
        if (getContainer() == null) {
            return false;
        }
        return PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints.canCreateAssemblyConnector_4004(
                getContainer(), getSource(), getTarget());
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
     * @generated
     */
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
        if (!canExecute()) {
            throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
        }

        AssemblyConnector newElement = CompositionFactory.eINSTANCE.createAssemblyConnector();
        getContainer().getConnectors__ComposedStructure().add(newElement);
        newElement.setRequiredRole_AssemblyConnector(getSource());
        newElement.setProvidedRole_AssemblyConnector(getTarget());
        doConfigure(newElement, monitor, info);
        ((CreateElementRequest) getRequest()).setNewElement(newElement);
        return CommandResult.newOKCommandResult(newElement);

    }

    /**
     * Do configure.
     * 
     * @param newElement
     *            the new element
     * @param monitor
     *            the monitor
     * @param info
     *            the info
     * @throws ExecutionException
     *             the execution exception
     * @generated
     */
    protected void doConfigure(AssemblyConnector newElement, IProgressMonitor monitor, IAdaptable info)
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
     * Sets the element to edit.
     * 
     * @param element
     *            the new element to edit
     * @generated
     */
    protected void setElementToEdit(EObject element) {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets the source.
     * 
     * @return the source
     * @generated
     */
    protected OperationRequiredRole getSource() {
        return (OperationRequiredRole) source;
    }

    /**
     * Gets the target.
     * 
     * @return the target
     * @generated
     */
    protected OperationProvidedRole getTarget() {
        return (OperationProvidedRole) target;
    }

    /**
     * Gets the container.
     * 
     * @return the container
     * @generated
     */
    public ComposedStructure getContainer() {
        return container;
    }

    /**
     * Default approach is to traverse ancestors of the source to find instance of container. Modify
     * with appropriate logic.
     * 
     * @param source
     *            the source
     * @param target
     *            the target
     * @return the composed structure
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
