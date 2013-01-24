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
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyConnectorCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyConnectorReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.RequiredDelegationConnectorCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.RequiredDelegationConnectorReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;

/**
 * Semantic edit policy for inner assembly context operation required roles.
 * 
 * @generated
 */
public class OperationRequiredRoleItemSemanticEditPolicy extends
		PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * Instantiates a new operation required role item semantic edit policy.
	 *
	 * @generated
	 */
	public OperationRequiredRoleItemSemanticEditPolicy() {
		super(PalladioComponentModelElementTypes.OperationRequiredRole_3008);
	}

	/**
	 * Gets the destroy element command.
	 *
	 * @param req the req
	 * @return the destroy element command
	 * @generated
	 */
	@Override
    protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(
				getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (PalladioComponentModelVisualIDRegistry
					.getVisualID(incomingLink) == RequiredDelegationConnectorEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (PalladioComponentModelVisualIDRegistry
					.getVisualID(outgoingLink) == AssemblyConnectorEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (PalladioComponentModelVisualIDRegistry
					.getVisualID(outgoingLink) == RequiredDelegationConnectorEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						outgoingLink.getElement(), false);
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
	 * @param req
	 *            The request object to create the command
	 * @return The prepared creation command object
	 * 
	 * @generated not
	 */
	@Override
    protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (PalladioComponentModelElementTypes.AssemblyConnector_4004 == req
				.getElementType()) {
			return req.getTarget() == null ? getStartCreateRelationshipCommandAssemblyConnector(req)
					: null;
		}
		if (PalladioComponentModelElementTypes.RequiredDelegationConnector_4005 == req
				.getElementType()) {
			return req.getTarget() == null ? getStartCreateRelationshipCommandRequiredDelegationConnector(req)
					: null;
		}
		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * Gets the start create relationship command.
	 *
	 * @param req the req
	 * @return the start create relationship command
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (PalladioComponentModelElementTypes.AssemblyConnector_4004 == req
				.getElementType()) {
			return getGEFWrapper(new AssemblyConnectorCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (PalladioComponentModelElementTypes.RequiredDelegationConnector_4005 == req
				.getElementType()) {
			return getGEFWrapper(new RequiredDelegationConnectorCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Helper to create an instance of an outgoing assembly connector.
	 * 
	 * @param req
	 *            The request describing the command to be created.
	 * @return The prepared command to create an AssemblyConnector
	 * 
	 * @generated not
	 */
	protected Command getStartCreateRelationshipCommandAssemblyConnector(
			CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		if (!(sourceEObject instanceof OperationRequiredRole)) {
			return UnexecutableCommand.INSTANCE;
		}
		OperationRequiredRole source = (OperationRequiredRole) sourceEObject;
		ComposedStructure container = (ComposedStructure) getRelationshipContainer(
				source, CompositionPackage.eINSTANCE.getComposedStructure(),
				req.getElementType());
		if (container == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (!PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateAssemblyConnector_4004(container, source, null)) {
			return UnexecutableCommand.INSTANCE;
		}
		req.setParameter("REQ_CHILD_CONTEXT", ((View) getHost().getParent()
				.getModel()).getElement());
		return new Command() {
		};
	}

	/**
	 * Get a command to create a required delegation connector.
	 * 
	 * @param req
	 *            The request object to build up the command.
	 * @return The prepared command.
	 * 
	 * @generated not
	 */
	protected Command getStartCreateRelationshipCommandRequiredDelegationConnector(
			CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		if (!(sourceEObject instanceof OperationRequiredRole)) {
			return UnexecutableCommand.INSTANCE;
		}
		OperationRequiredRole source = (OperationRequiredRole) sourceEObject;
		ComposedStructure container = (ComposedStructure) getRelationshipContainer(
				source, CompositionPackage.eINSTANCE.getComposedStructure(),
				req.getElementType());
		if (container == null) {
			return UnexecutableCommand.INSTANCE;
		}
		req.setParameter("CHILD_CONTEXT", ((View) getHost().getParent()
				.getModel()).getElement());
		if (!PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateRequiredDelegationConnector_4005(container, source,
						null)) {
			return UnexecutableCommand.INSTANCE;
		}
		return new Command() {
		};
	}

	/**
	 * Gets the complete create relationship command.
	 *
	 * @param req the req
	 * @return the complete create relationship command
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (PalladioComponentModelElementTypes.AssemblyConnector_4004 == req
				.getElementType()) {
			return null;
		}
		if (PalladioComponentModelElementTypes.RequiredDelegationConnector_4005 == req
				.getElementType()) {
			return getGEFWrapper(new RequiredDelegationConnectorCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source should be the domain
	 * model element associated with this node.
	 *
	 * @param req the req
	 * @return the reorient relationship command
	 * @generated
	 */
	@Override
    protected Command getReorientRelationshipCommand(
			ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case AssemblyConnectorEditPart.VISUAL_ID:
			return getGEFWrapper(new AssemblyConnectorReorientCommand(req));
		case RequiredDelegationConnectorEditPart.VISUAL_ID:
			return getGEFWrapper(new RequiredDelegationConnectorReorientCommand(
					req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
