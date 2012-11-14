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
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyConnectorTypeLinkCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.ProvidedDelegationConnectorCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.ProvidedDelegationConnectorReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.ProvidedDelegationConnectorTypeLinkCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;

/**
 * The Class OperationProvidedRoleItemSemanticEditPolicy.
 *
 * @generated
 */
public class OperationProvidedRoleItemSemanticEditPolicy extends
		PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * Instantiates a new operation provided role item semantic edit policy.
	 *
	 * @generated
	 */
	public OperationProvidedRoleItemSemanticEditPolicy() {
		super(PalladioComponentModelElementTypes.OperationProvidedRole_3007);
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
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(
				getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (PalladioComponentModelVisualIDRegistry
					.getVisualID(incomingLink) == AssemblyConnectorEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (PalladioComponentModelVisualIDRegistry
					.getVisualID(incomingLink) == ProvidedDelegationConnectorEditPart.VISUAL_ID) {
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
					.getVisualID(outgoingLink) == ProvidedDelegationConnectorEditPart.VISUAL_ID) {
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
	 * @param req the req
	 * @return the creates the relationship command
	 * @generated not
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (PalladioComponentModelElementTypes.AssemblyConnector_4004 == req
				.getElementType()) {
			return req.getTarget() == null ? null
					: getCompleteCreateRelationshipCommandAssemblyConnector(req);
		}
		if (PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006 == req
				.getElementType()) {
			return req.getTarget() == null ? null
					: getCompleteCreateRelationshipCommandProvidedDelegationConnector(req);
		}
		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * Get the complete create relationship command if the relationship is about an internal
	 * assembly connector.
	 * 
	 * @param req
	 *            The request object for this command request
	 * @return The prepared command.
	 * 
	 * @generated not
	 */
	protected Command getCompleteCreateRelationshipCommandAssemblyConnector(
			CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		EObject targetEObject = req.getTarget();
		if (false == sourceEObject instanceof OperationRequiredRole
				|| false == targetEObject instanceof OperationProvidedRole) {
			return UnexecutableCommand.INSTANCE;
		}
		OperationRequiredRole source = (OperationRequiredRole) sourceEObject;
		OperationProvidedRole target = (OperationProvidedRole) targetEObject;
		ComposedStructure container = (ComposedStructure) getRelationshipContainer(
				source, CompositionPackage.eINSTANCE.getComposedStructure(),
				req.getElementType());
		if (container == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (!PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateAssemblyConnector_4004(container, source, target)) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req.setContainmentFeature(CompositionPackage.eINSTANCE
					.getComposedStructure_Connectors__ComposedStructure());
		}
		req.setParameter("PROV_CHILD_CONTEXT", ((View) getHost().getParent()
				.getModel()).getElement());
		return getGEFWrapper(new AssemblyConnectorTypeLinkCreateCommand(req,
				container, source, target));
	}

	/**
	 * Get the complete create relationship command if the relationship is about a operation
	 * provided delegation connector.
	 * 
	 * @param req
	 *            The request object for this command request
	 * @return The prepared command.
	 * 
	 * @generated not
	 */
	protected Command getCompleteCreateRelationshipCommandProvidedDelegationConnector(
			CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		EObject targetEObject = req.getTarget();
		if (false == sourceEObject instanceof OperationProvidedRole
				|| false == targetEObject instanceof OperationProvidedRole) {
			return UnexecutableCommand.INSTANCE;
		}
		OperationProvidedRole source = (OperationProvidedRole) sourceEObject;
		OperationProvidedRole target = (OperationProvidedRole) targetEObject;
		ComposedStructure container = (ComposedStructure) getRelationshipContainer(
				source, CompositionPackage.eINSTANCE.getComposedStructure(),
				req.getElementType());
		if (container == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (!PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateProvidedDelegationConnector_4006(container, source,
						target)) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req.setContainmentFeature(CompositionPackage.eINSTANCE
					.getComposedStructure_Connectors__ComposedStructure());
		}
		req.setParameter("CHILD_CONTEXT", ((View) getHost().getParent()
				.getModel()).getElement());
		return getGEFWrapper(new ProvidedDelegationConnectorTypeLinkCreateCommand(
				req, container, source, target));
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
			return null;
		}
		if (PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006 == req
				.getElementType()) {
			return getGEFWrapper(new ProvidedDelegationConnectorCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		return null;
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
			return getGEFWrapper(new AssemblyConnectorCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006 == req
				.getElementType()) {
			return getGEFWrapper(new ProvidedDelegationConnectorCreateCommand(
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
	protected Command getReorientRelationshipCommand(
			ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case AssemblyConnectorEditPart.VISUAL_ID:
			return getGEFWrapper(new AssemblyConnectorReorientCommand(req));
		case ProvidedDelegationConnectorEditPart.VISUAL_ID:
			return getGEFWrapper(new ProvidedDelegationConnectorReorientCommand(
					req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
