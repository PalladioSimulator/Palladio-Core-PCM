/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.gmf.composite.custom.commands.CustomAssemblyConnectorReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.custom.commands.CustomRequiredDelegationConnectorCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyConnectorCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.RequiredDelegationConnectorReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.OperationRequiredRoleItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;

/**
 * The Class CustomOperationRequiredRoleItemSemanticEditPolicy.
 */
public class CustomOperationRequiredRoleItemSemanticEditPolicy extends OperationRequiredRoleItemSemanticEditPolicy {
    /**
     * Get the create relationship command or null / UnexecutableCommand instance if this is not an
     * valid end for the connector creation.
     * 
     * @param req
     *            The request object to create the command
     * @return The prepared creation command object
     * 
     * @generated not
     */
    @Override
    protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.AssemblyConnector_4004 == req.getElementType()) {
            return req.getTarget() == null ? getStartCreateRelationshipCommandAssemblyConnector(req) : null;
        }
        if (PalladioComponentModelElementTypes.RequiredDelegationConnector_4005 == req.getElementType()) {
            return req.getTarget() == null ? getStartCreateRelationshipCommandRequiredDelegationConnector(req) : null;
        }
        return super.getCreateRelationshipCommand(req);
    }

    /**
     * Helper to create an instance of an outgoing assembly connector.
     * 
     * @param req
     *            The request describing the command to be created.
     * @return The prepared command to create an AssemblyConnector
     * 
     * @generated not
     */
    protected Command getStartCreateRelationshipCommandAssemblyConnector(CreateRelationshipRequest req) {
        EObject sourceEObject = req.getSource();
        if (!(sourceEObject instanceof OperationRequiredRole)) {
            return UnexecutableCommand.INSTANCE;
        }
        OperationRequiredRole source = (OperationRequiredRole) sourceEObject;
        ComposedStructure container = (ComposedStructure) getRelationshipContainer(source,
                CompositionPackage.eINSTANCE.getComposedStructure(), req.getElementType());
        if (container == null) {
            return UnexecutableCommand.INSTANCE;
        }
        if (!PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints.canCreateAssemblyConnector_4004(
                container, source, null)) {
            return UnexecutableCommand.INSTANCE;
        }
        req.setParameter("REQ_CHILD_CONTEXT", ((View) getHost().getParent().getModel()).getElement());
        return new Command() {
        };
    }

    /**
     * Get a command to create a required delegation connector.
     * 
     * @param req
     *            The request object to build up the command.
     * @return The prepared command.
     * 
     * @generated not
     */
    protected Command getStartCreateRelationshipCommandRequiredDelegationConnector(CreateRelationshipRequest req) {
        EObject sourceEObject = req.getSource();
        if (!(sourceEObject instanceof OperationRequiredRole)) {
            return UnexecutableCommand.INSTANCE;
        }
        OperationRequiredRole source = (OperationRequiredRole) sourceEObject;
        ComposedStructure container = (ComposedStructure) getRelationshipContainer(source,
                CompositionPackage.eINSTANCE.getComposedStructure(), req.getElementType());
        if (container == null) {
            return UnexecutableCommand.INSTANCE;
        }
        req.setParameter("CHILD_CONTEXT", ((View) getHost().getParent().getModel()).getElement());
        if (!PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
                .canCreateRequiredDelegationConnector_4005(container, source, null)) {
            return UnexecutableCommand.INSTANCE;
        }
        return new Command() {
        };
    }

    /**
     * Gets the start create relationship command.
     * 
     * @param req
     *            the req
     * @return the start create relationship command
     * @see de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.OperationRequiredRoleItemSemanticEditPolicy#getStartCreateRelationshipCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest)
     */
    protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.AssemblyConnector_4004 == req.getElementType()) {
            return getGEFWrapper(new AssemblyConnectorCreateCommand(req, req.getSource(), req.getTarget()));
        }
        if (PalladioComponentModelElementTypes.RequiredDelegationConnector_4005 == req.getElementType()) {
            return getGEFWrapper(new CustomRequiredDelegationConnectorCreateCommand(req, req.getSource(),
                    req.getTarget()));
        }
        return null;
    }

    /**
     * Gets the reorient relationship command.
     * 
     * @param req
     *            the req
     * @return the reorient relationship command
     * @see de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.OperationRequiredRoleItemSemanticEditPolicy#getReorientRelationshipCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest)
     */
    @Override
    protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
        switch (getVisualID(req)) {
        case AssemblyConnectorEditPart.VISUAL_ID:
            return getGEFWrapper(new CustomAssemblyConnectorReorientCommand(req));
        case RequiredDelegationConnectorEditPart.VISUAL_ID:
            return getGEFWrapper(new RequiredDelegationConnectorReorientCommand(req));
        }
        return super.getReorientRelationshipCommand(req);
    }

    /**
     * Gets the complete create relationship command.
     * 
     * @param req
     *            the req
     * @return the complete create relationship command
     * @see de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.OperationRequiredRoleItemSemanticEditPolicy#getCompleteCreateRelationshipCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest)
     */
    protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.AssemblyConnector_4004 == req.getElementType()) {
            return null;
        }
        if (PalladioComponentModelElementTypes.RequiredDelegationConnector_4005 == req.getElementType()) {
            return getGEFWrapper(new CustomRequiredDelegationConnectorCreateCommand(req, req.getSource(),
                    req.getTarget()));
        }
        return null;
    }
}