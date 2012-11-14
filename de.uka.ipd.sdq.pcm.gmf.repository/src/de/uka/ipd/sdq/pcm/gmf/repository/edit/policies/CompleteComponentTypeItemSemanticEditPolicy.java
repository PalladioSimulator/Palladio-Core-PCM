/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.CompleteComponentTypeParentProvidesComponentTypesCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.CompleteComponentTypeParentProvidesComponentTypesReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.ImplementationComponentTypeParentCompleteComponentTypesCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.ImplementationComponentTypeParentCompleteComponentTypesReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.InfrastructureProvidedRoleCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.InfrastructureProvidedRoleReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.InfrastructureRequiredRoleCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.InfrastructureRequiredRoleReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.OperationProvidedRoleCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.OperationProvidedRoleReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.OperationRequiredRoleCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.OperationRequiredRoleReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.SinkRoleCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.SinkRoleReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.SourceRoleCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.SourceRoleReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeParentProvidesComponentTypesEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ImplementationComponentTypeParentCompleteComponentTypesEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SinkRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SourceRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class CompleteComponentTypeItemSemanticEditPolicy extends PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public CompleteComponentTypeItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.CompleteComponentType_2104);
    }

    /**
     * @generated
     */
    protected Command getDestroyElementCommand(DestroyElementRequest req) {
        View view = (View) getHost().getModel();
        CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
        cmd.setTransactionNestingEnabled(false);
        for (Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
            Edge incomingLink = (Edge) it.next();
            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID) {
                DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
                        incomingLink.getTarget().getElement(), false);
                cmd.add(new DestroyReferenceCommand(r));
                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                continue;
            }
        }
        for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
            Edge outgoingLink = (Edge) it.next();
            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == OperationProvidedRoleEditPart.VISUAL_ID) {
                DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
                cmd.add(new DestroyElementCommand(r));
                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                continue;
            }
            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == InfrastructureProvidedRoleEditPart.VISUAL_ID) {
                DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
                cmd.add(new DestroyElementCommand(r));
                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                continue;
            }
            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == InfrastructureRequiredRoleEditPart.VISUAL_ID) {
                DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
                cmd.add(new DestroyElementCommand(r));
                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                continue;
            }
            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == SinkRoleEditPart.VISUAL_ID) {
                DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
                cmd.add(new DestroyElementCommand(r));
                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                continue;
            }
            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == OperationRequiredRoleEditPart.VISUAL_ID) {
                DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
                cmd.add(new DestroyElementCommand(r));
                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                continue;
            }
            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID) {
                DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
                        outgoingLink.getTarget().getElement(), false);
                cmd.add(new DestroyReferenceCommand(r));
                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                continue;
            }
            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == SourceRoleEditPart.VISUAL_ID) {
                DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
                cmd.add(new DestroyElementCommand(r));
                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                continue;
            }
        }
        EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
        if (annotation == null) {
            // there are indirectly referenced children, need extra commands: false
            addDestroyShortcutsCommand(cmd, view);
            // delete host element
            cmd.add(new DestroyElementCommand(req));
        } else {
            cmd.add(new DeleteCommand(getEditingDomain(), view));
        }
        return getGEFWrapper(cmd.reduce());
    }

    /**
     * @generated
     */
    protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
        Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
                : getCompleteCreateRelationshipCommand(req);
        return command != null ? command : super.getCreateRelationshipCommand(req);
    }

    /**
     * @generated
     */
    protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.OperationProvidedRole_4105 == req.getElementType()) {
            return getGEFWrapper(new OperationProvidedRoleCreateCommand(req, req.getSource(), req.getTarget()));
        }
        if (PalladioComponentModelElementTypes.InfrastructureProvidedRole_4111 == req.getElementType()) {
            return getGEFWrapper(new InfrastructureProvidedRoleCreateCommand(req, req.getSource(), req.getTarget()));
        }
        if (PalladioComponentModelElementTypes.InfrastructureRequiredRole_4112 == req.getElementType()) {
            return getGEFWrapper(new InfrastructureRequiredRoleCreateCommand(req, req.getSource(), req.getTarget()));
        }
        if (PalladioComponentModelElementTypes.SinkRole_4109 == req.getElementType()) {
            return getGEFWrapper(new SinkRoleCreateCommand(req, req.getSource(), req.getTarget()));
        }
        if (PalladioComponentModelElementTypes.OperationRequiredRole_4106 == req.getElementType()) {
            return getGEFWrapper(new OperationRequiredRoleCreateCommand(req, req.getSource(), req.getTarget()));
        }
        if (PalladioComponentModelElementTypes.ImplementationComponentTypeParentCompleteComponentTypes_4103 == req
                .getElementType()) {
            return null;
        }
        if (PalladioComponentModelElementTypes.CompleteComponentTypeParentProvidesComponentTypes_4104 == req
                .getElementType()) {
            return getGEFWrapper(new CompleteComponentTypeParentProvidesComponentTypesCreateCommand(req,
                    req.getSource(), req.getTarget()));
        }
        if (PalladioComponentModelElementTypes.SourceRole_4110 == req.getElementType()) {
            return getGEFWrapper(new SourceRoleCreateCommand(req, req.getSource(), req.getTarget()));
        }
        return null;
    }

    /**
     * @generated
     */
    protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.OperationProvidedRole_4105 == req.getElementType()) {
            return null;
        }
        if (PalladioComponentModelElementTypes.InfrastructureProvidedRole_4111 == req.getElementType()) {
            return null;
        }
        if (PalladioComponentModelElementTypes.InfrastructureRequiredRole_4112 == req.getElementType()) {
            return null;
        }
        if (PalladioComponentModelElementTypes.SinkRole_4109 == req.getElementType()) {
            return null;
        }
        if (PalladioComponentModelElementTypes.OperationRequiredRole_4106 == req.getElementType()) {
            return null;
        }
        if (PalladioComponentModelElementTypes.ImplementationComponentTypeParentCompleteComponentTypes_4103 == req
                .getElementType()) {
            return getGEFWrapper(new ImplementationComponentTypeParentCompleteComponentTypesCreateCommand(req,
                    req.getSource(), req.getTarget()));
        }
        if (PalladioComponentModelElementTypes.CompleteComponentTypeParentProvidesComponentTypes_4104 == req
                .getElementType()) {
            return null;
        }
        if (PalladioComponentModelElementTypes.SourceRole_4110 == req.getElementType()) {
            return null;
        }
        return null;
    }

    /**
     * Returns command to reorient EClass based link. New link target or source should be the domain
     * model element associated with this node.
     * 
     * @generated
     */
    protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
        switch (getVisualID(req)) {
        case OperationProvidedRoleEditPart.VISUAL_ID:
            return getGEFWrapper(new OperationProvidedRoleReorientCommand(req));
        case InfrastructureProvidedRoleEditPart.VISUAL_ID:
            return getGEFWrapper(new InfrastructureProvidedRoleReorientCommand(req));
        case InfrastructureRequiredRoleEditPart.VISUAL_ID:
            return getGEFWrapper(new InfrastructureRequiredRoleReorientCommand(req));
        case SinkRoleEditPart.VISUAL_ID:
            return getGEFWrapper(new SinkRoleReorientCommand(req));
        case OperationRequiredRoleEditPart.VISUAL_ID:
            return getGEFWrapper(new OperationRequiredRoleReorientCommand(req));
        case SourceRoleEditPart.VISUAL_ID:
            return getGEFWrapper(new SourceRoleReorientCommand(req));
        }
        return super.getReorientRelationshipCommand(req);
    }

    /**
     * Returns command to reorient EReference based link. New link target or source should be the
     * domain model element associated with this node.
     * 
     * @generated
     */
    protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
        switch (getVisualID(req)) {
        case ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID:
            return getGEFWrapper(new ImplementationComponentTypeParentCompleteComponentTypesReorientCommand(req));
        case CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID:
            return getGEFWrapper(new CompleteComponentTypeParentProvidesComponentTypesReorientCommand(req));
        }
        return super.getReorientReferenceRelationshipCommand(req);
    }

}
