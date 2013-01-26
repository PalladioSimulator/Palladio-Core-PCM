/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
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
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyInfrastructureConnectorCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyInfrastructureConnectorReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyInfrastructureConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;

/**
 * The Class InfrastructureProvidedRoleItemSemanticEditPolicy.
 * 
 * @generated
 */
public class InfrastructureProvidedRoleItemSemanticEditPolicy extends PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new infrastructure provided role item semantic edit policy.
     * 
     * @generated
     */
    public InfrastructureProvidedRoleItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.InfrastructureProvidedRole_3015);
    }

    /**
     * Gets the destroy element command.
     * 
     * @param req
     *            the req
     * @return the destroy element command
     * @generated
     */
    protected Command getDestroyElementCommand(DestroyElementRequest req) {
        View view = (View) getHost().getModel();
        CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
        cmd.setTransactionNestingEnabled(false);
        for (Iterator it = view.getTargetEdges().iterator(); it.hasNext();) {
            Edge incomingLink = (Edge) it.next();
            if (PalladioComponentModelVisualIDRegistry.getVisualID(incomingLink) == AssemblyInfrastructureConnectorEditPart.VISUAL_ID) {
                DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
                cmd.add(new DestroyElementCommand(r));
                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
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
     * Gets the creates the relationship command.
     * 
     * @param req
     *            the req
     * @return the creates the relationship command
     * @generated
     */
    protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
        Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
                : getCompleteCreateRelationshipCommand(req);
        return command != null ? command : super.getCreateRelationshipCommand(req);
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
        if (PalladioComponentModelElementTypes.AssemblyInfrastructureConnector_4008 == req.getElementType()) {
            return null;
        }
        return null;
    }

    /**
     * Adapted to transfer information on containing component and assembly context of target.
     * 
     * @param req
     *            the req
     * @return the complete create relationship command
     * @generated not
     */
    protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.AssemblyInfrastructureConnector_4008 == req.getElementType()) {

            // set the container
            ComposedStructure container = (ComposedStructure) getRelationshipContainer(req.getSource(),
                    CompositionPackage.eINSTANCE.getComposedStructure(), req.getElementType());
            if (container == null) {
                return UnexecutableCommand.INSTANCE;
            }
            req.setParameter("CONTAINER", container);

            // set assembly context
            req.setParameter("TARGET_ASSEMBLY_CONTEXT", ((View) getHost().getParent().getModel()).getElement());
            return getGEFWrapper(new AssemblyInfrastructureConnectorCreateCommand(req, req.getSource(), req.getTarget()));
        }
        return null;
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
    protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
        switch (getVisualID(req)) {
        case AssemblyInfrastructureConnectorEditPart.VISUAL_ID:
            return getGEFWrapper(new AssemblyInfrastructureConnectorReorientCommand(req));
        }
        return super.getReorientRelationshipCommand(req);
    }

}
