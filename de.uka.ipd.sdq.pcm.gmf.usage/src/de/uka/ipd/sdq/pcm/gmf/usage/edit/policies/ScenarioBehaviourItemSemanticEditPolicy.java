/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.AbstractUserActionSuccessorEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.DelayEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.EntryLevelSystemCallEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.LoopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StartEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelElementTypes;

/**
 * The Class ScenarioBehaviourItemSemanticEditPolicy.
 *
 * @generated
 */
public class ScenarioBehaviourItemSemanticEditPolicy extends PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new scenario behaviour item semantic edit policy.
     *
     * @generated
     */
    public ScenarioBehaviourItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.ScenarioBehaviour_3014);
    }

    /**
     * Gets the destroy element command.
     *
     * @param req the req
     * @return the destroy element command
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
     * Adds the destroy child nodes command.
     *
     * @param cmd the cmd
     * @generated
     */
    private void addDestroyChildNodesCommand(ICompositeCommand cmd) {
        View view = (View) getHost().getModel();
        for (Iterator nit = view.getChildren().iterator(); nit.hasNext();) {
            Node node = (Node) nit.next();
            switch (PalladioComponentModelVisualIDRegistry.getVisualID(node)) {
            case ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart.VISUAL_ID:
                for (Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
                    Node cnode = (Node) cit.next();
                    switch (PalladioComponentModelVisualIDRegistry.getVisualID(cnode)) {
                    case StartEditPart.VISUAL_ID:
                        for (Iterator it = cnode.getTargetEdges().iterator(); it.hasNext();) {
                            Edge incomingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AbstractUserActionSuccessorEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource()
                                        .getElement(), null, incomingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                                continue;
                            }
                        }
                        for (Iterator it = cnode.getSourceEdges().iterator(); it.hasNext();) {
                            Edge outgoingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == AbstractUserActionSuccessorEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource()
                                        .getElement(), null, outgoingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
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
                    case StopEditPart.VISUAL_ID:
                        for (Iterator it = cnode.getTargetEdges().iterator(); it.hasNext();) {
                            Edge incomingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AbstractUserActionSuccessorEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource()
                                        .getElement(), null, incomingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                                continue;
                            }
                        }
                        for (Iterator it = cnode.getSourceEdges().iterator(); it.hasNext();) {
                            Edge outgoingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == AbstractUserActionSuccessorEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource()
                                        .getElement(), null, outgoingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
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
                    case EntryLevelSystemCallEditPart.VISUAL_ID:
                        for (Iterator it = cnode.getTargetEdges().iterator(); it.hasNext();) {
                            Edge incomingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AbstractUserActionSuccessorEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource()
                                        .getElement(), null, incomingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                                continue;
                            }
                        }
                        for (Iterator it = cnode.getSourceEdges().iterator(); it.hasNext();) {
                            Edge outgoingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == AbstractUserActionSuccessorEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource()
                                        .getElement(), null, outgoingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
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
                    case LoopEditPart.VISUAL_ID:
                        for (Iterator it = cnode.getTargetEdges().iterator(); it.hasNext();) {
                            Edge incomingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AbstractUserActionSuccessorEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource()
                                        .getElement(), null, incomingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                                continue;
                            }
                        }
                        for (Iterator it = cnode.getSourceEdges().iterator(); it.hasNext();) {
                            Edge outgoingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == AbstractUserActionSuccessorEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource()
                                        .getElement(), null, outgoingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
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
                    case BranchEditPart.VISUAL_ID:
                        for (Iterator it = cnode.getTargetEdges().iterator(); it.hasNext();) {
                            Edge incomingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AbstractUserActionSuccessorEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource()
                                        .getElement(), null, incomingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                                continue;
                            }
                        }
                        for (Iterator it = cnode.getSourceEdges().iterator(); it.hasNext();) {
                            Edge outgoingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == AbstractUserActionSuccessorEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource()
                                        .getElement(), null, outgoingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
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
                    case DelayEditPart.VISUAL_ID:
                        for (Iterator it = cnode.getTargetEdges().iterator(); it.hasNext();) {
                            Edge incomingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AbstractUserActionSuccessorEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource()
                                        .getElement(), null, incomingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                                continue;
                            }
                        }
                        for (Iterator it = cnode.getSourceEdges().iterator(); it.hasNext();) {
                            Edge outgoingLink = (Edge) it.next();
                            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == AbstractUserActionSuccessorEditPart.VISUAL_ID) {
                                DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource()
                                        .getElement(), null, outgoingLink.getTarget().getElement(), false);
                                cmd.add(new DestroyReferenceCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
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
