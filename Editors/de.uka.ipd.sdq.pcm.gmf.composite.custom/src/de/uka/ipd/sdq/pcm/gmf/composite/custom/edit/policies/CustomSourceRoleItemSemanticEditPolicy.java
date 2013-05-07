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
import de.uka.ipd.sdq.pcm.gmf.composite.custom.commands.CustomEventChannelSourceConnectorCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyEventConnectorCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.SourceRoleItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.repository.SourceRole;

/**
 * The Class CustomSourceRoleItemSemanticEditPolicy.
 */
public class CustomSourceRoleItemSemanticEditPolicy extends SourceRoleItemSemanticEditPolicy {
    /**
     * Get the create relationship command or null / UnexecutableCommand instance if this is not an
     * valid end for the connector creation.
     * 
     * @param req
     *            The request object to create the command
     * @return The prepared creation command object
     * 
     * @generated not
     */
    @Override
    protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.AssemblyEventConnector_4007 == req.getElementType()) {
            return req.getTarget() == null ? getStartCreateRelationshipCommandEventConnectors(req) : null;
        } else if (PalladioComponentModelElementTypes.EventChannelSourceConnector_4009 == req.getElementType()) {
            return req.getTarget() == null ? getStartCreateRelationshipCommandEventConnectors(req) : null;
        }
        return super.getCreateRelationshipCommand(req);
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
        EObject sourceEObject = req.getSource();
        if (!(sourceEObject instanceof SourceRole)) {
            return UnexecutableCommand.INSTANCE;
        }
        SourceRole source = (SourceRole) sourceEObject;
        ComposedStructure container = (ComposedStructure) getRelationshipContainer(source,
                CompositionPackage.eINSTANCE.getComposedStructure(), req.getElementType());
        if (container == null) {
            return UnexecutableCommand.INSTANCE;
        }
        if (!PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints.canCreateAssemblyEventConnector_4007(
                container, source, null)) {
            return UnexecutableCommand.INSTANCE;
        }
        if (!PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
                .canCreateEventChannelSourceConnector_4009(container, source, null)) {
            return UnexecutableCommand.INSTANCE;
        }
        req.setParameter("SOURCE_CONTEXT", ((View) getHost().getParent().getModel()).getElement());
        return new Command() {
        };
    }

    /**
     * Gets the start create relationship command.
     * 
     * @param req
     *            the req
     * @return the start create relationship command
     * @see de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.SourceRoleItemSemanticEditPolicy#getStartCreateRelationshipCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest)
     */
    protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.EventChannelSourceConnector_4009 == req.getElementType()) {
            return getGEFWrapper(new CustomEventChannelSourceConnectorCreateCommand(req, req.getSource(),
                    req.getTarget()));
        }
        if (PalladioComponentModelElementTypes.AssemblyEventConnector_4007 == req.getElementType()) {
            return getGEFWrapper(new AssemblyEventConnectorCreateCommand(req, req.getSource(), req.getTarget()));
        }
        return null;
    }
}
