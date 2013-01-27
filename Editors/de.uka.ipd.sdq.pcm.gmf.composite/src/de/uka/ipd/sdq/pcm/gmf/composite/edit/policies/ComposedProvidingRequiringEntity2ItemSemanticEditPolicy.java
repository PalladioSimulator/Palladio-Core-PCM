/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.OperationProvidedRole2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.OperationRequiredRole2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.EventChannelEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.EventChannelSinkConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.EventChannelSourceConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class ComposedProvidingRequiringEntity2ItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public ComposedProvidingRequiringEntity2ItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.ComposedProvidingRequiringEntity_2002);
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.OperationProvidedRole_3011 == req.getElementType()) {
            return getGEFWrapper(new OperationProvidedRole2CreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.OperationRequiredRole_3012 == req.getElementType()) {
            return getGEFWrapper(new OperationRequiredRole2CreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

    /**
     * @generated
     */
    protected Command getDestroyElementCommand(DestroyElementRequest req) {
        View view = (View) getHost().getModel();
        CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
        cmd.setTransactionNestingEnabled(false);
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
        for (Iterator nit = view.getChildren().iterator(); nit.hasNext();) {
            Node node = (Node) nit.next();
            switch (PalladioComponentModelVisualIDRegistry.getVisualID(node)) {
            case OperationProvidedRole2EditPart.VISUAL_ID:
                for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
                    Edge incomingLink = (Edge) it.next();
                    if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AssemblyConnectorEditPart.VISUAL_ID) {
                        DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
                        cmd.add(new DestroyElementCommand(r));
                        cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                        continue;
                    }
                    if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == ProvidedDelegationConnectorEditPart.VISUAL_ID) {
                        DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
                        cmd.add(new DestroyElementCommand(r));
                        cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                        continue;
                    }
                }
                for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
                    Edge outgoingLink = (Edge) it.next();
                    if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == ProvidedDelegationConnectorEditPart.VISUAL_ID) {
                        DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
                        cmd.add(new DestroyElementCommand(r));
                        cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                        continue;
                    }
                }
                cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(),
                        false))); // directlyOwned: true
                // don't need explicit deletion of node as parent's view deletion would clean child
                // views as well
                // cmd.add(new
                // org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(),
                // node));
                break;
            case OperationRequiredRole2EditPart.VISUAL_ID:
                for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
                    Edge incomingLink = (Edge) it.next();
                    if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == RequiredDelegationConnectorEditPart.VISUAL_ID) {
                        DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
                        cmd.add(new DestroyElementCommand(r));
                        cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                        continue;
                    }
                }
                for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
                    Edge outgoingLink = (Edge) it.next();
                    if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == AssemblyConnectorEditPart.VISUAL_ID) {
                        DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
                        cmd.add(new DestroyElementCommand(r));
                        cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                        continue;
                    }
                    if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == RequiredDelegationConnectorEditPart.VISUAL_ID) {
                        DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
                        cmd.add(new DestroyElementCommand(r));
                        cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                        continue;
                    }
                }
                cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(),
                        false))); // directlyOwned: true
                // don't need explicit deletion of node as parent's view deletion would clean child
                // views as well
                // cmd.add(new
                // org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(),
                // node));
                break;
            case ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart.VISUAL_ID:
                for (Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
                    Node cnode = (Node) cit.next();
                    switch (PalladioComponentModelVisualIDRegistry.getVisualID(cnode)) {
                    case AssemblyContextEditPart.VISUAL_ID:
                        cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode
                                .getElement(), false))); // directlyOwned: true
                        // don't need explicit deletion of cnode as parent's view deletion would
                        // clean child views as well
                        // cmd.add(new
                        // org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(),
                        // cnode));
                        break;
                    case EventChannelEditPart.VISUAL_ID:
                        for (Iterator it = cnode.getTargetEdges().iterator(); it.hasNext();) {
                            Edge incomingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == EventChannelSinkConnectorEditPart.VISUAL_ID) {
                                DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
                                cmd.add(new DestroyElementCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                                continue;
                            }
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == EventChannelSourceConnectorEditPart.VISUAL_ID) {
                                DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
                                cmd.add(new DestroyElementCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                                continue;
                            }
                        }
                        cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode
                                .getElement(), false))); // directlyOwned: true
                        // don't need explicit deletion of cnode as parent's view deletion would
                        // clean child views as well
                        // cmd.add(new
                        // org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(),
                        // cnode));
                        break;
                    }
                }
                break;
            }
        }
    }

}
