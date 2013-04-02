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
import de.uka.ipd.sdq.pcm.gmf.composite.custom.commands.CustomAssemblyConnectorTypeLinkCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.custom.commands.CustomProvidedDelegationConnectorTypeLinkCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.ProvidedDelegationConnectorReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.OperationProvidedRoleItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;

public class CustomOperationProvidedRoleItemSemanticEditPolicy extends OperationProvidedRoleItemSemanticEditPolicy {
    /**
     * Get the create relationship command or null / UnexecutableCommand instance if this is not an
     * valid end for the connector creation.
     * 
     * @param req
     *            the req
     * @return the creates the relationship command
     * @generated not
     */
    @Override
    protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.AssemblyConnector_4004 == req.getElementType()) {
            return req.getTarget() == null ? null : getCompleteCreateRelationshipCommandAssemblyConnector(req);
        }
        if (PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006 == req.getElementType()) {
            return req.getTarget() == null ? null
                    : getCompleteCreateRelationshipCommandProvidedDelegationConnector(req);
        }
        return super.getCreateRelationshipCommand(req);
    }

    /**
     * Get the complete create relationship command if the relationship is about an internal
     * assembly connector.
     * 
     * @param req
     *            The request object for this command request
     * @return The prepared command.
     * 
     * @generated not
     */
    protected Command getCompleteCreateRelationshipCommandAssemblyConnector(CreateRelationshipRequest req) {
        EObject sourceEObject = req.getSource();
        EObject targetEObject = req.getTarget();
        if (!(sourceEObject instanceof OperationRequiredRole) || !(targetEObject instanceof OperationProvidedRole)) {
            return UnexecutableCommand.INSTANCE;
        }
        OperationRequiredRole source = (OperationRequiredRole) sourceEObject;
        OperationProvidedRole target = (OperationProvidedRole) targetEObject;
        ComposedStructure container = (ComposedStructure) getRelationshipContainer(source,
                CompositionPackage.eINSTANCE.getComposedStructure(), req.getElementType());
        if (container == null) {
            return UnexecutableCommand.INSTANCE;
        }
        if (!PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints.canCreateAssemblyConnector_4004(
                container, source, target)) {
            return UnexecutableCommand.INSTANCE;
        }
        if (req.getContainmentFeature() == null) {
            req.setContainmentFeature(CompositionPackage.eINSTANCE.getComposedStructure_Connectors__ComposedStructure());
        }
        req.setParameter("PROV_CHILD_CONTEXT", ((View) getHost().getParent().getModel()).getElement());
        return getGEFWrapper(new CustomAssemblyConnectorTypeLinkCreateCommand(req, container, source, target));
    }

    /**
     * Get the complete create relationship command if the relationship is about a operation
     * provided delegation connector.
     * 
     * @param req
     *            The request object for this command request
     * @return The prepared command.
     * 
     * @generated not
     */
    protected Command getCompleteCreateRelationshipCommandProvidedDelegationConnector(CreateRelationshipRequest req) {
        EObject sourceEObject = req.getSource();
        EObject targetEObject = req.getTarget();
        if (!(sourceEObject instanceof OperationProvidedRole) || !(targetEObject instanceof OperationProvidedRole)) {
            return UnexecutableCommand.INSTANCE;
        }
        OperationProvidedRole source = (OperationProvidedRole) sourceEObject;
        OperationProvidedRole target = (OperationProvidedRole) targetEObject;
        ComposedStructure container = (ComposedStructure) getRelationshipContainer(source,
                CompositionPackage.eINSTANCE.getComposedStructure(), req.getElementType());
        if (container == null) {
            return UnexecutableCommand.INSTANCE;
        }
        if (!PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
                .canCreateProvidedDelegationConnector_4006(container, source, target)) {
            return UnexecutableCommand.INSTANCE;
        }
        if (req.getContainmentFeature() == null) {
            req.setContainmentFeature(CompositionPackage.eINSTANCE.getComposedStructure_Connectors__ComposedStructure());
        }
        req.setParameter("CHILD_CONTEXT", ((View) getHost().getParent().getModel()).getElement());
        return getGEFWrapper(new CustomProvidedDelegationConnectorTypeLinkCreateCommand(req, container, source, target));
    }
    
    @Override
    protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
        switch (getVisualID(req)) {
        case AssemblyConnectorEditPart.VISUAL_ID:
            return getGEFWrapper(new CustomAssemblyConnectorReorientCommand(req));
        case ProvidedDelegationConnectorEditPart.VISUAL_ID:
            return getGEFWrapper(new ProvidedDelegationConnectorReorientCommand(req));
        }
        return super.getReorientRelationshipCommand(req);
    }

}
