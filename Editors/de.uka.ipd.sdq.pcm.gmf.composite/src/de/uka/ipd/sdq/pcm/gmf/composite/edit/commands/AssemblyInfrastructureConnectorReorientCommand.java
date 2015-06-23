/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyInfrastructureConnector;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;

/**
 * @generated
 */
public class AssemblyInfrastructureConnectorReorientCommand extends EditElementCommand {

    /**
     * @generated
     */
    private final int reorientDirection;

    /**
     * @generated
     */
    private final EObject oldEnd;

    /**
     * @generated
     */
    private final EObject newEnd;

    /**
     * @generated
     */
    public AssemblyInfrastructureConnectorReorientCommand(ReorientRelationshipRequest request) {
        super(request.getLabel(), request.getRelationship(), request);
        reorientDirection = request.getDirection();
        oldEnd = request.getOldRelationshipEnd();
        newEnd = request.getNewRelationshipEnd();
    }

    /**
     * @generated
     */
    public boolean canExecute() {
        if (false == getElementToEdit() instanceof AssemblyInfrastructureConnector) {
            return false;
        }
        if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
            return canReorientSource();
        }
        if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
            return canReorientTarget();
        }
        return false;
    }

    /**
     * @generated
     */
    protected boolean canReorientSource() {
        if (!(oldEnd instanceof InfrastructureRequiredRole && newEnd instanceof InfrastructureRequiredRole)) {
            return false;
        }
        InfrastructureProvidedRole target = getLink().getProvidedRole__AssemblyInfrastructureConnector();
        if (!(getLink().eContainer() instanceof ComposedStructure)) {
            return false;
        }
        ComposedStructure container = (ComposedStructure) getLink().eContainer();
        return PalladioComponentModelBaseItemSemanticEditPolicy.getLinkConstraints()
                .canExistAssemblyInfrastructureConnector_4008(container, getLink(), getNewSource(), target);
    }

    /**
     * @generated
     */
    protected boolean canReorientTarget() {
        if (!(oldEnd instanceof InfrastructureProvidedRole && newEnd instanceof InfrastructureProvidedRole)) {
            return false;
        }
        InfrastructureRequiredRole source = getLink().getRequiredRole__AssemblyInfrastructureConnector();
        if (!(getLink().eContainer() instanceof ComposedStructure)) {
            return false;
        }
        ComposedStructure container = (ComposedStructure) getLink().eContainer();
        return PalladioComponentModelBaseItemSemanticEditPolicy.getLinkConstraints()
                .canExistAssemblyInfrastructureConnector_4008(container, getLink(), source, getNewTarget());
    }

    /**
     * @generated
     */
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
        if (!canExecute()) {
            throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
        }
        if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
            return reorientSource();
        }
        if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
            return reorientTarget();
        }
        throw new IllegalStateException();
    }

    /**
     * @generated
     */
    protected CommandResult reorientSource() throws ExecutionException {
        getLink().setRequiredRole__AssemblyInfrastructureConnector(getNewSource());
        return CommandResult.newOKCommandResult(getLink());
    }

    /**
     * @generated
     */
    protected CommandResult reorientTarget() throws ExecutionException {
        getLink().setProvidedRole__AssemblyInfrastructureConnector(getNewTarget());
        return CommandResult.newOKCommandResult(getLink());
    }

    /**
     * @generated
     */
    protected AssemblyInfrastructureConnector getLink() {
        return (AssemblyInfrastructureConnector) getElementToEdit();
    }

    /**
     * @generated
     */
    protected InfrastructureRequiredRole getOldSource() {
        return (InfrastructureRequiredRole) oldEnd;
    }

    /**
     * @generated
     */
    protected InfrastructureRequiredRole getNewSource() {
        return (InfrastructureRequiredRole) newEnd;
    }

    /**
     * @generated
     */
    protected InfrastructureProvidedRole getOldTarget() {
        return (InfrastructureProvidedRole) oldEnd;
    }

    /**
     * @generated
     */
    protected InfrastructureProvidedRole getNewTarget() {
        return (InfrastructureProvidedRole) newEnd;
    }
}
