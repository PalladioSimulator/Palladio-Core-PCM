/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyEventConnectorCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyEventConnectorReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.EventChannelSinkConnectorCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.EventChannelSinkConnectorReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyEventConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.EventChannelSinkConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.repository.SinkRole;

/**
 * The Class SinkRoleItemSemanticEditPolicy.
 * 
 * @generated
 */
public class SinkRoleItemSemanticEditPolicy extends PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new sink role item semantic edit policy.
     * 
     * @generated
     */
    public SinkRoleItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.SinkRole_3014);
    }

    /**
     * Gets the destroy element command.
     * 
     * @param req
     *            the req
     * @return the destroy element command
     * @generated
     */
    @Override
    protected Command getDestroyElementCommand(DestroyElementRequest req) {
        View view = (View) getHost().getModel();
        CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
        cmd.setTransactionNestingEnabled(false);
        for (Iterator it = view.getTargetEdges().iterator(); it.hasNext();) {
            Edge incomingLink = (Edge) it.next();
            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AssemblyEventConnectorEditPart.VISUAL_ID) {
                DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
                cmd.add(new DestroyElementCommand(r));
                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                continue;
            }
        }
        for (Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
            Edge outgoingLink = (Edge) it.next();
            if (PalladioComponentModelVisualIDRegistry.getVisualID(outgoingLink) == EventChannelSinkConnectorEditPart.VISUAL_ID) {
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
     * Get the create relationship command or null / UnexecutableCommand instance if this is not an
     * valid end for the connector creation.
     * 
     * This has been manually adopted to fix this connection for AssemblyEventConnectors
     * 
     * @param req
     *            the req
     * @return the creates the relationship command
     * @generated not
     */
    @Override
    protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {

        if (PalladioComponentModelElementTypes.EventChannelSinkConnector_4010 == req.getElementType()) {
            return req.getTarget() == null ? getStartCreateRelationshipCommandEventConnectors(req) : null;
        }

        Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
                : getCompleteCreateRelationshipCommand(req);
        return command != null ? command : super.getCreateRelationshipCommand(req);

    }

    /**
     * Helper to create an instance of an outgoing event connector.
     * 
     * @param req
     *            The request describing the command to be created.
     * @return The prepared command to create an AssemblyEventConnector
     * 
     * @generated not
     */
    protected Command getStartCreateRelationshipCommandEventConnectors(CreateRelationshipRequest req) {
        EObject sinkEObject = req.getSource();
        if (!(sinkEObject instanceof SinkRole)) {
            return UnexecutableCommand.INSTANCE;
        }
        SinkRole source = (SinkRole) sinkEObject;
        ComposedStructure container = (ComposedStructure) getRelationshipContainer(source,
                CompositionPackage.eINSTANCE.getComposedStructure(), req.getElementType());
        if (container == null) {
            return UnexecutableCommand.INSTANCE;
        }
        if (!PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints.canCreateEventChannelSinkConnector_4010(
                container, source, null)) {
            return UnexecutableCommand.INSTANCE;
        }
        req.setParameter("SINK_CONTEXT", ((View) getHost().getParent().getModel()).getElement());
        return new Command() {
        };
    }

    /**
     * Gets the start create relationship command.
     * 
     * @param req
     *            the req
     * @return the start create relationship command
     * @generated
     */
    protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.EventChannelSinkConnector_4010 == req.getElementType()) {
            return getGEFWrapper(new EventChannelSinkConnectorCreateCommand(req, req.getSource(), req.getTarget()));
        }
        if (PalladioComponentModelElementTypes.AssemblyEventConnector_4007 == req.getElementType()) {
            return null;
        }
        return null;
    }

    /**
     * Create the command to complete the relationship.
     * 
     * This has manually be adopted to set the container and contexts in the request.
     * 
     * @param req
     *            the req
     * @return the complete create relationship command
     * @generated not
     */
    protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.AssemblyEventConnector_4007 == req.getElementType()) {

            return getCompleteCreateRelationshipCommandAssemblyEventConnector(req);
        }
        return null;
    }

    /**
     * Create the command to complete the relationship.
     * 
     * This has manually be adopted to set the container and contexts in the request.
     * 
     * @param req
     *            The request object for this command request
     * @return The prepared command.
     * 
     * @generated not
     */
    protected Command getCompleteCreateRelationshipCommandAssemblyEventConnector(CreateRelationshipRequest req) {

        // set the container
        ComposedStructure container = (ComposedStructure) getRelationshipContainer(req.getSource(),
                CompositionPackage.eINSTANCE.getComposedStructure(), req.getElementType());
        if (container == null) {
            return UnexecutableCommand.INSTANCE;
        }
        req.setParameter("CONTAINER", container);

        // set the contexts
        req.setParameter("SINK_CONTEXT", ((View) getHost().getParent().getModel()).getElement());

        return getGEFWrapper(new AssemblyEventConnectorCreateCommand(req, req.getSource(), req.getTarget()));
    }

    /**
     * Returns command to reorient EClass based link. New link target or source should be the domain
     * model element associated with this node.
     * 
     * @param req
     *            the req
     * @return the reorient relationship command
     * @generated
     */
    @Override
    protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
        switch (getVisualID(req)) {
        case EventChannelSinkConnectorEditPart.VISUAL_ID:
            return getGEFWrapper(new EventChannelSinkConnectorReorientCommand(req));
        case AssemblyEventConnectorEditPart.VISUAL_ID:
            return getGEFWrapper(new AssemblyEventConnectorReorientCommand(req));
        }
        return super.getReorientRelationshipCommand(req);
    }

}
