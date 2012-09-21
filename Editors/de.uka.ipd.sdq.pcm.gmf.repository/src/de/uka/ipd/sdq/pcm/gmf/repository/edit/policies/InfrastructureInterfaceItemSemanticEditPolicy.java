/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
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
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.InfrastructureProvidedRoleCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.InfrastructureProvidedRoleReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.InfrastructureRequiredRoleCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.InfrastructureRequiredRoleReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.InterfaceParentInterfaces__InterfaceCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.InterfaceParentInterfaces__InterfaceReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureInterfaceInfrastructureSignatureListEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureSignatureEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceParentInterfaces__InterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class InfrastructureInterfaceItemSemanticEditPolicy extends PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public InfrastructureInterfaceItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.InfrastructureInterface_2109);
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
            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == InfrastructureProvidedRoleEditPart.VISUAL_ID) {
                DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
                cmd.add(new DestroyElementCommand(r));
                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                continue;
            }
            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == InfrastructureRequiredRoleEditPart.VISUAL_ID) {
                DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
                cmd.add(new DestroyElementCommand(r));
                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                continue;
            }
            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == InterfaceParentInterfaces__InterfaceEditPart.VISUAL_ID) {
                DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
                        incomingLink.getTarget().getElement(), false);
                cmd.add(new DestroyReferenceCommand(r));
                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                continue;
            }
        }
        for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
            Edge outgoingLink = (Edge) it.next();
            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == InterfaceParentInterfaces__InterfaceEditPart.VISUAL_ID) {
                DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
                        outgoingLink.getTarget().getElement(), false);
                cmd.add(new DestroyReferenceCommand(r));
                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                continue;
            }
        }
        EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
        if (annotation == null) {
            // there are indirectly referenced children, need extra commands: false
            addDestroyChildNodesCommand(cmd);
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
    private void addDestroyChildNodesCommand(ICompositeCommand cmd) {
        View view = (View) getHost().getModel();
        for (Iterator<?> nit = view.getChildren().iterator(); nit.hasNext();) {
            Node node = (Node) nit.next();
            switch (PalladioComponentModelVisualIDRegistry.getVisualID(node)) {
            case InfrastructureInterfaceInfrastructureSignatureListEditPart.VISUAL_ID:
                for (Iterator<?> cit = node.getChildren().iterator(); cit.hasNext();) {
                    Node cnode = (Node) cit.next();
                    switch (PalladioComponentModelVisualIDRegistry.getVisualID(cnode)) {
                    case InfrastructureSignatureEditPart.VISUAL_ID:
                        cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode
                                .getElement(), false))); // directlyOwned: true
                        // don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
                        // cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
                        break;
                    }
                }
                break;
            }
        }
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
        if (PalladioComponentModelElementTypes.InfrastructureProvidedRole_4111 == req.getElementType()) {
            return null;
        }
        if (PalladioComponentModelElementTypes.InfrastructureRequiredRole_4112 == req.getElementType()) {
            return null;
        }
        if (PalladioComponentModelElementTypes.InterfaceParentInterfaces__Interface_4113 == req.getElementType()) {
            return getGEFWrapper(new InterfaceParentInterfaces__InterfaceCreateCommand(req, req.getSource(),
                    req.getTarget()));
        }
        return null;
    }

    /**
     * @generated
     */
    protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.InfrastructureProvidedRole_4111 == req.getElementType()) {
            return getGEFWrapper(new InfrastructureProvidedRoleCreateCommand(req, req.getSource(), req.getTarget()));
        }
        if (PalladioComponentModelElementTypes.InfrastructureRequiredRole_4112 == req.getElementType()) {
            return getGEFWrapper(new InfrastructureRequiredRoleCreateCommand(req, req.getSource(), req.getTarget()));
        }
        if (PalladioComponentModelElementTypes.InterfaceParentInterfaces__Interface_4113 == req.getElementType()) {
            return getGEFWrapper(new InterfaceParentInterfaces__InterfaceCreateCommand(req, req.getSource(),
                    req.getTarget()));
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
        case InfrastructureProvidedRoleEditPart.VISUAL_ID:
            return getGEFWrapper(new InfrastructureProvidedRoleReorientCommand(req));
        case InfrastructureRequiredRoleEditPart.VISUAL_ID:
            return getGEFWrapper(new InfrastructureRequiredRoleReorientCommand(req));
        }
        return super.getReorientRelationshipCommand(req);
    }

    /**
     * Returns command to reorient EReference based link. New link target or source
     * should be the domain model element associated with this node.
     * 
     * @generated
     */
    protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
        switch (getVisualID(req)) {
        case InterfaceParentInterfaces__InterfaceEditPart.VISUAL_ID:
            return getGEFWrapper(new InterfaceParentInterfaces__InterfaceReorientCommand(req));
        }
        return super.getReorientReferenceRelationshipCommand(req);
    }

}
