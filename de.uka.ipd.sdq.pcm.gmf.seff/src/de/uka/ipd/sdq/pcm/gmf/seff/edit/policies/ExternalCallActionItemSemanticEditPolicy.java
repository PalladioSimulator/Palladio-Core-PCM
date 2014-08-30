/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

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
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.AbstractActionSuccessor_AbstractActionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.AbstractActionSuccessor_AbstractActionReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AbstractActionSuccessor_AbstractActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionInputVariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionOutputVariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class ExternalCallActionItemSemanticEditPolicy extends PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public ExternalCallActionItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.ExternalCallAction_2003);
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
            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
                        incomingLink.getTarget().getElement(), false);
                cmd.add(new DestroyReferenceCommand(r));
                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                continue;
            }
        }
        for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
            Edge outgoingLink = (Edge) it.next();
            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
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
            case ExternalCallActionInputVariableUsageEditPart.VISUAL_ID:
                for (Iterator<?> cit = node.getChildren().iterator(); cit.hasNext();) {
                    Node cnode = (Node) cit.next();
                    switch (PalladioComponentModelVisualIDRegistry.getVisualID(cnode)) {
                    case VariableUsageEditPart.VISUAL_ID:
                        cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode
                                .getElement(), false))); // directlyOwned: true
                        // don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
                        // cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
                        break;
                    }
                }
                break;
            case ExternalCallActionOutputVariableUsageEditPart.VISUAL_ID:
                for (Iterator<?> cit = node.getChildren().iterator(); cit.hasNext();) {
                    Node cnode = (Node) cit.next();
                    switch (PalladioComponentModelVisualIDRegistry.getVisualID(cnode)) {
                    case VariableUsage2EditPart.VISUAL_ID:
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
        if (PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001 == req.getElementType()) {
            return getGEFWrapper(new AbstractActionSuccessor_AbstractActionCreateCommand(req, req.getSource(),
                    req.getTarget()));
        }
        return null;
    }

    /**
     * @generated
     */
    protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001 == req.getElementType()) {
            return getGEFWrapper(new AbstractActionSuccessor_AbstractActionCreateCommand(req, req.getSource(),
                    req.getTarget()));
        }
        return null;
    }

    /**
     * @generated
     */
    protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
        switch (getVisualID(req)) {
        case AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID:
            return getGEFWrapper(new AbstractActionSuccessor_AbstractActionReorientCommand(req));
        }
        return super.getReorientReferenceRelationshipCommand(req);
    }

}
