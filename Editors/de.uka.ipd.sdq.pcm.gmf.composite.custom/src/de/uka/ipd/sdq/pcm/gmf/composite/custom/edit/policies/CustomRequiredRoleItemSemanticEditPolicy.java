/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.RequiredRoleItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;

public class CustomRequiredRoleItemSemanticEditPolicy extends RequiredRoleItemSemanticEditPolicy {
    // TODO: write javadoc and annotations
    /**
     * Gets the creates the relationship command.
     * 
     * @param req
     *            the req
     * @return the creates the relationship command
     * @generated not
     */
    @Override
    protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.AssemblyConnector_4004 == req.getElementType()) {
            return req.getTarget() == null ? getCreateStartOutgoingAssemblyConnector_4001Command(req) : null;
        }
        if (PalladioComponentModelElementTypes.RequiredDelegationConnector_4005 == req.getElementType()) {
            return req.getTarget() == null ? getCreateStartOutgoingRequiredDelegationConnector_4002Command(req) : null;
        }
        return super.getCreateRelationshipCommand(req);
    }

    // TODO: write javadoc and annotations
    /**
     * Gets the creates the start outgoing assembly connector_4001 command.
     * 
     * @param req
     *            the req
     * @return the creates the start outgoing assembly connector_4001 command
     * @generated not
     */
    protected Command getCreateStartOutgoingAssemblyConnector_4001Command(CreateRelationshipRequest req) {
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

    // TODO: write javadoc and annotations
    /**
     * Gets the creates the start outgoing required delegation connector_4002 command.
     * 
     * @param req
     *            the req
     * @return the creates the start outgoing required delegation connector_4002 command
     * @generated not
     */
    protected Command getCreateStartOutgoingRequiredDelegationConnector_4002Command(CreateRelationshipRequest req) {
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

}
