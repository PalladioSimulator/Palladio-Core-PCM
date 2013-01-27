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
import de.uka.ipd.sdq.pcm.core.composition.AssemblyInfrastructureConnector;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;

/**
 * @generated
 */
public class AssemblyInfrastructureConnectorCreateCommand extends EditElementCommand {

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
     * @generated
     */
    public AssemblyInfrastructureConnectorCreateCommand(CreateRelationshipRequest request, EObject source,
            EObject target) {
        super(request.getLabel(), null, request);
        this.source = source;
        this.target = target;
        container = deduceContainer(source, target);
    }

    /**
     * @generated
     */
    public boolean canExecute() {
        if (source == null && target == null) {
            return false;
        }
        if (source != null && false == source instanceof InfrastructureRequiredRole) {
            return false;
        }
        if (target != null && false == target instanceof InfrastructureProvidedRole) {
            return false;
        }
        if (getSource() == null) {
            return true; // link creation is in progress; source is not defined yet
        }
        // target may be null here but it's possible to check constraint
        if (getContainer() == null) {
            return false;
        }
        return PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
                .canCreateAssemblyInfrastructureConnector_4008(getContainer(), getSource(), getTarget());
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

    /**
     * @generated
     */
    protected void doConfigure(AssemblyInfrastructureConnector newElement, IProgressMonitor monitor, IAdaptable info)
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
    protected InfrastructureRequiredRole getSource() {
        return (InfrastructureRequiredRole) source;
    }

    /**
     * @generated
     */
    protected InfrastructureProvidedRole getTarget() {
        return (InfrastructureProvidedRole) target;
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
