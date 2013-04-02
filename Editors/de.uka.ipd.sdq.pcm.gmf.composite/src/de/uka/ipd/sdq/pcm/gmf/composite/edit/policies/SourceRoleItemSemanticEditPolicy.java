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

import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyEventConnectorCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyEventConnectorReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.EventChannelSourceConnectorCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.EventChannelSourceConnectorReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyEventConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.EventChannelSourceConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class SourceRoleItemSemanticEditPolicy extends PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public SourceRoleItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.SourceRole_3013);
    }

    /**
     * @generated
     */
    @Override
    protected Command getDestroyElementCommand(DestroyElementRequest req) {
        View view = (View) getHost().getModel();
        CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
        cmd.setTransactionNestingEnabled(false);
        for (Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
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
    protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.EventChannelSourceConnector_4009 == req.getElementType()) {
            return getGEFWrapper(new EventChannelSourceConnectorCreateCommand(req, req.getSource(), req.getTarget()));
        }
        if (PalladioComponentModelElementTypes.AssemblyEventConnector_4007 == req.getElementType()) {
            return getGEFWrapper(new AssemblyEventConnectorCreateCommand(req, req.getSource(), req.getTarget()));
        }
        return null;
    }

    /**
     * @generated
     */
    protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.EventChannelSourceConnector_4009 == req.getElementType()) {
            return null;
        }
        if (PalladioComponentModelElementTypes.AssemblyEventConnector_4007 == req.getElementType()) {
            return null;
        }
        return null;
    }

    /**
     * @generated
     */
    @Override
    protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
        switch (getVisualID(req)) {
        case EventChannelSourceConnectorEditPart.VISUAL_ID:
            return getGEFWrapper(new EventChannelSourceConnectorReorientCommand(req));
        case AssemblyEventConnectorEditPart.VISUAL_ID:
            return getGEFWrapper(new AssemblyEventConnectorReorientCommand(req));
        }
        return super.getReorientRelationshipCommand(req);
    }

}
