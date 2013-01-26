/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.InfrastructureProvidedRoleCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.InfrastructureRequiredRoleCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.OperationProvidedRoleCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.OperationRequiredRoleCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.SinkRoleCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.SourceRoleCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyEventConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyInfrastructureConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.EventChannelSinkConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.EventChannelSourceConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.InfrastructureProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.InfrastructureRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SinkRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SourceRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;

/**
 * The Class AssemblyContextItemSemanticEditPolicy.
 * 
 * @generated
 */
public class AssemblyContextItemSemanticEditPolicy extends PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new assembly context item semantic edit policy.
     * 
     * @generated
     */
    public AssemblyContextItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.AssemblyContext_3006);
    }

    /**
     * Gets the creates the command.
     * 
     * @param req
     *            the req
     * @return the creates the command
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.OperationProvidedRole_3007 == req.getElementType()) {
            return getGEFWrapper(new OperationProvidedRoleCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.OperationRequiredRole_3008 == req.getElementType()) {
            return getGEFWrapper(new OperationRequiredRoleCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.SourceRole_3013 == req.getElementType()) {
            return getGEFWrapper(new SourceRoleCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.SinkRole_3014 == req.getElementType()) {
            return getGEFWrapper(new SinkRoleCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.InfrastructureProvidedRole_3015 == req.getElementType()) {
            return getGEFWrapper(new InfrastructureProvidedRoleCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.InfrastructureRequiredRole_3016 == req.getElementType()) {
            return getGEFWrapper(new InfrastructureRequiredRoleCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

    // TODO: write javadoc and annotations
    /**
     * Gets the destroy element command.
     * 
     * @param req
     *            the req
     * @return the destroy element command
     * @generated not
     */
    protected Command getDestroyElementCommand(DestroyElementRequest req) {
        CompoundCommand cc = new CompoundCommand();
        Collection allEdges = new ArrayList();
        View view = (View) getHost().getModel();
        for (Object p : getHost().getChildren()) {
            if (p instanceof BorderedBorderItemEditPart) {
                BorderedBorderItemEditPart borderItem = (BorderedBorderItemEditPart) p;
                if (borderItem.getModel() != null && borderItem.getModel() instanceof View) {
                    allEdges.addAll(((View) borderItem.getModel()).getSourceEdges());
                    allEdges.addAll(((View) borderItem.getModel()).getTargetEdges());
                }
            }
        }
        for (Iterator it = allEdges.iterator(); it.hasNext();) {
            Edge nextEdge = (Edge) it.next();
            EditPart nextEditPart = (EditPart) getHost().getViewer().getEditPartRegistry().get(nextEdge);
            EditCommandRequestWrapper editCommandRequest = new EditCommandRequestWrapper(new DestroyElementRequest(
                    ((AssemblyContextEditPart) getHost()).getEditingDomain(), req.isConfirmationRequired()),
                    Collections.EMPTY_MAP);
            cc.add(nextEditPart.getCommand(editCommandRequest));
        }
        cc.add(getGEFWrapper(new DestroyElementCommand(req)));
        return cc;
    }

    /**
     * Adds the destroy child nodes command.
     * 
     * @param cmd
     *            the cmd
     * @generated
     */
    private void addDestroyChildNodesCommand(ICompositeCommand cmd) {
        View view = (View) getHost().getModel();
        for (Iterator nit = view.getChildren().iterator(); nit.hasNext();) {
            Node node = (Node) nit.next();
            switch (PalladioComponentModelVisualIDRegistry.getVisualID(node)) {
            case OperationProvidedRoleEditPart.VISUAL_ID:
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
                        false))); // directlyOwned: false
                // don't need explicit deletion of node as parent's view deletion would clean child
                // views as well
                // cmd.add(new
                // org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(),
                // node));
                break;
            case OperationRequiredRoleEditPart.VISUAL_ID:
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
                        false))); // directlyOwned: false
                // don't need explicit deletion of node as parent's view deletion would clean child
                // views as well
                // cmd.add(new
                // org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(),
                // node));
                break;
            case SourceRoleEditPart.VISUAL_ID:
                for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
                    Edge outgoingLink = (Edge) it.next();
                    if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == EventChannelSourceConnectorEditPart.VISUAL_ID) {
                        DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
                        cmd.add(new DestroyElementCommand(r));
                        cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                        continue;
                    }
                    if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == AssemblyEventConnectorEditPart.VISUAL_ID) {
                        DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
                        cmd.add(new DestroyElementCommand(r));
                        cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                        continue;
                    }
                }
                cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(),
                        false))); // directlyOwned: false
                // don't need explicit deletion of node as parent's view deletion would clean child
                // views as well
                // cmd.add(new
                // org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(),
                // node));
                break;
            case SinkRoleEditPart.VISUAL_ID:
                for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
                    Edge incomingLink = (Edge) it.next();
                    if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AssemblyEventConnectorEditPart.VISUAL_ID) {
                        DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
                        cmd.add(new DestroyElementCommand(r));
                        cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                        continue;
                    }
                }
                for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
                    Edge outgoingLink = (Edge) it.next();
                    if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == EventChannelSinkConnectorEditPart.VISUAL_ID) {
                        DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
                        cmd.add(new DestroyElementCommand(r));
                        cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                        continue;
                    }
                }
                cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(),
                        false))); // directlyOwned: false
                // don't need explicit deletion of node as parent's view deletion would clean child
                // views as well
                // cmd.add(new
                // org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(),
                // node));
                break;
            case InfrastructureProvidedRoleEditPart.VISUAL_ID:
                for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
                    Edge incomingLink = (Edge) it.next();
                    if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AssemblyInfrastructureConnectorEditPart.VISUAL_ID) {
                        DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
                        cmd.add(new DestroyElementCommand(r));
                        cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                        continue;
                    }
                }
                cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(),
                        false))); // directlyOwned: false
                // don't need explicit deletion of node as parent's view deletion would clean child
                // views as well
                // cmd.add(new
                // org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(),
                // node));
                break;
            case InfrastructureRequiredRoleEditPart.VISUAL_ID:
                for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
                    Edge outgoingLink = (Edge) it.next();
                    if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == AssemblyInfrastructureConnectorEditPart.VISUAL_ID) {
                        DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
                        cmd.add(new DestroyElementCommand(r));
                        cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                        continue;
                    }
                }
                cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(),
                        false))); // directlyOwned: false
                // don't need explicit deletion of node as parent's view deletion would clean child
                // views as well
                // cmd.add(new
                // org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(),
                // node));
                break;
            }
        }
    }

}
