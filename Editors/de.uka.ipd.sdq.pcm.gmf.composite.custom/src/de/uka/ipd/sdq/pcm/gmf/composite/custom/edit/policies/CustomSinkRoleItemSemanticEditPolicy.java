/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.gmf.composite.custom.commands.CustomEventChannelSinkConnectorCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyEventConnectorCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.SinkRoleItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.repository.SinkRole;

public class CustomSinkRoleItemSemanticEditPolicy extends SinkRoleItemSemanticEditPolicy {
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
    
    protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.EventChannelSinkConnector_4010 == req.getElementType()) {
            return getGEFWrapper(new CustomEventChannelSinkConnectorCreateCommand(req, req.getSource(), req.getTarget()));
        }
        if (PalladioComponentModelElementTypes.AssemblyEventConnector_4007 == req.getElementType()) {
            return null;
        }
        return null;
    }

}
