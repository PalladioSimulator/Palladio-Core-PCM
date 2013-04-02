/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyConnectorReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.ProvidedDelegationConnectorCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.ProvidedDelegationConnectorReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class OperationProvidedRole2ItemSemanticEditPolicy extends PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public OperationProvidedRole2ItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.OperationProvidedRole_3011);
    }

    /**
     * @generated
     */
    @Override
    protected Command getDestroyElementCommand(DestroyElementRequest req) {
        View view = (View) getHost().getModel();
        CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
        cmd.setTransactionNestingEnabled(false);
        for (Iterator it = view.getTargetEdges().iterator(); it.hasNext();) {
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
        for (Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
            Edge outgoingLink = (Edge) it.next();
            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == ProvidedDelegationConnectorEditPart.VISUAL_ID) {
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
    @Override
    protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
        Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
                : getCompleteCreateRelationshipCommand(req);
        return command != null ? command : super.getCreateRelationshipCommand(req);
    }

    /**
     * @generated
     */
    private Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		// FIXME is only referenced in getCreateRelatioshipCommand? / regenerate
		return null;
	}

	/**
     * @generated
     */
    protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.AssemblyConnector_4004 == req.getElementType()) {
            return null;
        }
        if (PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006 == req.getElementType()) {
            return getGEFWrapper(new ProvidedDelegationConnectorCreateCommand(req, req.getSource(), req.getTarget()));
        }
        return null;
    }

    /**
     * @generated
     */
    @Override
    protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
        switch (getVisualID(req)) {
        case AssemblyConnectorEditPart.VISUAL_ID:
            return getGEFWrapper(new AssemblyConnectorReorientCommand(req));
        case ProvidedDelegationConnectorEditPart.VISUAL_ID:
            return getGEFWrapper(new ProvidedDelegationConnectorReorientCommand(req));
        }
        return super.getReorientRelationshipCommand(req);
    }

}
