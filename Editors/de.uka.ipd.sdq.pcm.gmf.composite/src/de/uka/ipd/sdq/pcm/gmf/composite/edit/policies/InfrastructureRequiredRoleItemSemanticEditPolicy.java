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
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyInfrastructureConnectorReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyInfrastructureConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;

/**
 * The Class InfrastructureRequiredRoleItemSemanticEditPolicy.
 *
 * @generated
 */
public class InfrastructureRequiredRoleItemSemanticEditPolicy extends
		PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * Instantiates a new infrastructure required role item semantic edit policy.
	 *
	 * @generated
	 */
	public InfrastructureRequiredRoleItemSemanticEditPolicy() {
		super(
				PalladioComponentModelElementTypes.InfrastructureRequiredRole_3016);
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
		for (Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (PalladioComponentModelVisualIDRegistry
					.getVisualID(outgoingLink) == AssemblyInfrastructureConnectorEditPart.VISUAL_ID) {
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
	 * Gets the creates the relationship command.
	 *
	 * @param req the req
	 * @return the creates the relationship command
	 * @generated
	 */
	@Override
    protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super
				.getCreateRelationshipCommand(req);
	}

	/**
	 * Gets the start create relationship command.
	 *
	 * @param req the req
	 * @return the start create relationship command
	 * @generated not
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (PalladioComponentModelElementTypes.AssemblyInfrastructureConnector_4008 == req
				.getElementType()) {
			EObject sourceEObject = req.getSource();
			if (!(sourceEObject instanceof InfrastructureRequiredRole)) {
				return UnexecutableCommand.INSTANCE;
			}
			InfrastructureRequiredRole source = (InfrastructureRequiredRole) sourceEObject;
			ComposedStructure container = (ComposedStructure) getRelationshipContainer(
					source,
					CompositionPackage.eINSTANCE.getComposedStructure(), req
							.getElementType());
			if (container == null) {
				return UnexecutableCommand.INSTANCE;
			}
			if (!PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
					.canCreateAssemblyInfrastructureConnector_4008(container,
							source, null)) {
				return UnexecutableCommand.INSTANCE;
			}
			// added to provide assembly context in addition to source and target role
			req.setParameter("SOURCE_ASSEMBLY_CONTEXT", ((View) getHost()
					.getParent().getModel()).getElement());

			return new Command() {
			};
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
		if (PalladioComponentModelElementTypes.AssemblyInfrastructureConnector_4008 == req
				.getElementType()) {
			return null;
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
		case AssemblyInfrastructureConnectorEditPart.VISUAL_ID:
			return getGEFWrapper(new AssemblyInfrastructureConnectorReorientCommand(
					req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
