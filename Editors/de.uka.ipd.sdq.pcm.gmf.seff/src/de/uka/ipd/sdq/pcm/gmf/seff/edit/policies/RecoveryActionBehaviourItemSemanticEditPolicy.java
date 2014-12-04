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

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AbstractActionSuccessor_AbstractActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AcquireAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.EmitEventAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class RecoveryActionBehaviourItemSemanticEditPolicy extends PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public RecoveryActionBehaviourItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.RecoveryActionBehaviour_3062);
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
            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourEditPart.VISUAL_ID) {
                DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
                        incomingLink.getTarget().getElement(), false);
                cmd.add(new DestroyReferenceCommand(r));
                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                continue;
            }
        }
        for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
            Edge outgoingLink = (Edge) it.next();
            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourEditPart.VISUAL_ID) {
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
            case RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart.VISUAL_ID:
                for (Iterator<?> cit = node.getChildren().iterator(); cit.hasNext();) {
                    Node cnode = (Node) cit.next();
                    switch (PalladioComponentModelVisualIDRegistry.getVisualID(cnode)) {
                    case StartAction2EditPart.VISUAL_ID:
                        for (Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
                            Edge incomingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource()
                                        .getElement(), null, incomingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                                continue;
                            }
                        }
                        for (Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
                            Edge outgoingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource()
                                        .getElement(), null, outgoingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                                continue;
                            }
                        }
                        cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode
                                .getElement(), false))); // directlyOwned: true
                        // don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
                        // cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
                        break;
                    case StopAction2EditPart.VISUAL_ID:
                        for (Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
                            Edge incomingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource()
                                        .getElement(), null, incomingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                                continue;
                            }
                        }
                        for (Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
                            Edge outgoingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource()
                                        .getElement(), null, outgoingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                                continue;
                            }
                        }
                        cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode
                                .getElement(), false))); // directlyOwned: true
                        // don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
                        // cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
                        break;
                    case LoopAction2EditPart.VISUAL_ID:
                        for (Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
                            Edge incomingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource()
                                        .getElement(), null, incomingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                                continue;
                            }
                        }
                        for (Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
                            Edge outgoingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource()
                                        .getElement(), null, outgoingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                                continue;
                            }
                        }
                        cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode
                                .getElement(), false))); // directlyOwned: true
                        // don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
                        // cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
                        break;
                    case InternalAction2EditPart.VISUAL_ID:
                        for (Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
                            Edge incomingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource()
                                        .getElement(), null, incomingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                                continue;
                            }
                        }
                        for (Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
                            Edge outgoingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource()
                                        .getElement(), null, outgoingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                                continue;
                            }
                        }
                        cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode
                                .getElement(), false))); // directlyOwned: true
                        // don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
                        // cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
                        break;
                    case BranchAction2EditPart.VISUAL_ID:
                        for (Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
                            Edge incomingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource()
                                        .getElement(), null, incomingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                                continue;
                            }
                        }
                        for (Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
                            Edge outgoingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource()
                                        .getElement(), null, outgoingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                                continue;
                            }
                        }
                        cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode
                                .getElement(), false))); // directlyOwned: true
                        // don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
                        // cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
                        break;
                    case ExternalCallAction2EditPart.VISUAL_ID:
                        for (Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
                            Edge incomingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource()
                                        .getElement(), null, incomingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                                continue;
                            }
                        }
                        for (Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
                            Edge outgoingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource()
                                        .getElement(), null, outgoingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                                continue;
                            }
                        }
                        cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode
                                .getElement(), false))); // directlyOwned: true
                        // don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
                        // cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
                        break;
                    case EmitEventAction2EditPart.VISUAL_ID:
                        for (Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
                            Edge incomingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource()
                                        .getElement(), null, incomingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                                continue;
                            }
                        }
                        for (Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
                            Edge outgoingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource()
                                        .getElement(), null, outgoingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                                continue;
                            }
                        }
                        cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode
                                .getElement(), false))); // directlyOwned: true
                        // don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
                        // cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
                        break;
                    case CollectionIteratorAction2EditPart.VISUAL_ID:
                        for (Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
                            Edge incomingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource()
                                        .getElement(), null, incomingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                                continue;
                            }
                        }
                        for (Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
                            Edge outgoingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource()
                                        .getElement(), null, outgoingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                                continue;
                            }
                        }
                        cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode
                                .getElement(), false))); // directlyOwned: true
                        // don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
                        // cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
                        break;
                    case AcquireAction2EditPart.VISUAL_ID:
                        for (Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
                            Edge incomingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource()
                                        .getElement(), null, incomingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                                continue;
                            }
                        }
                        for (Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
                            Edge outgoingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource()
                                        .getElement(), null, outgoingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                                continue;
                            }
                        }
                        cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode
                                .getElement(), false))); // directlyOwned: true
                        // don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
                        // cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
                        break;
                    case ReleaseAction2EditPart.VISUAL_ID:
                        for (Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
                            Edge incomingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource()
                                        .getElement(), null, incomingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                                continue;
                            }
                        }
                        for (Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
                            Edge outgoingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource()
                                        .getElement(), null, outgoingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                                continue;
                            }
                        }
                        cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode
                                .getElement(), false))); // directlyOwned: true
                        // don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
                        // cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
                        break;
                    case ForkAction2EditPart.VISUAL_ID:
                        for (Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
                            Edge incomingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource()
                                        .getElement(), null, incomingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                                continue;
                            }
                        }
                        for (Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
                            Edge outgoingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource()
                                        .getElement(), null, outgoingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                                continue;
                            }
                        }
                        cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode
                                .getElement(), false))); // directlyOwned: true
                        // don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
                        // cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
                        break;
                    case SetVariableAction2EditPart.VISUAL_ID:
                        for (Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
                            Edge incomingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource()
                                        .getElement(), null, incomingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                                continue;
                            }
                        }
                        for (Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
                            Edge outgoingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource()
                                        .getElement(), null, outgoingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                                continue;
                            }
                        }
                        cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode
                                .getElement(), false))); // directlyOwned: true
                        // don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
                        // cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
                        break;
                    case RecoveryAction2EditPart.VISUAL_ID:
                        for (Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
                            Edge incomingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource()
                                        .getElement(), null, incomingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                                continue;
                            }
                        }
                        for (Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
                            Edge outgoingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource()
                                        .getElement(), null, outgoingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                                continue;
                            }
                        }
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
        if (PalladioComponentModelElementTypes.RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004 == req
                .getElementType()) {
            return getGEFWrapper(new RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourCreateCommand(
                    req, req.getSource(), req.getTarget()));
        }
        return null;
    }

    /**
     * @generated
     */
    protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004 == req
                .getElementType()) {
            return getGEFWrapper(new RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourCreateCommand(
                    req, req.getSource(), req.getTarget()));
        }
        return null;
    }

    /**
     * @generated
     */
    protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
        switch (getVisualID(req)) {
        case RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourEditPart.VISUAL_ID:
            return getGEFWrapper(new RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourReorientCommand(
                    req));
        }
        return super.getReorientReferenceRelationshipCommand(req);
    }

}
