/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.CompleteComponentTypeParentProvidesComponentTypesCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.CompleteComponentTypeParentProvidesComponentTypesReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.ImplementationComponentTypeParentCompleteComponentTypesCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.ImplementationComponentTypeParentCompleteComponentTypesReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.ProvidedRoleCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.ProvidedRoleReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.RequiredRoleCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.RequiredRoleReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.ResourceRequiredRoleCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.ResourceRequiredRoleReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentComponentParameterCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentPassiveResourceCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentSEFFCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeParentProvidesComponentTypesEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ImplementationComponentTypeParentCompleteComponentTypesEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.PassiveResourceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class BasicComponentItemSemanticEditPolicy extends
		PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyChildNodesCommand(cc);
		addDestroyShortcutsCommand(cc);
		View view = (View) getHost().getModel();
		if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
			req.setElementToDestroy(view);
		}
		cc.add(getGEFWrapper(new DestroyElementCommand(req)));
		return cc.unwrap();
	}

	/**
	 * @generated
	 */
	protected void addDestroyChildNodesCommand(CompoundCommand cmd) {
		View view = (View) getHost().getModel();
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation != null) {
			return;
		}
		for (Iterator it = view.getChildren().iterator(); it.hasNext();) {
			Node node = (Node) it.next();
			switch (PalladioComponentModelVisualIDRegistry.getVisualID(node)) {
			case BasicComponentSEFFCompartmentEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit
						.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (PalladioComponentModelVisualIDRegistry
							.getVisualID(cnode)) {
					case ResourceDemandingSEFFEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					}
				}
				break;
			case BasicComponentPassiveResourceCompartmentEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit
						.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (PalladioComponentModelVisualIDRegistry
							.getVisualID(cnode)) {
					case PassiveResourceEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					}
				}
				break;
			case BasicComponentComponentParameterCompartmentEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit
						.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (PalladioComponentModelVisualIDRegistry
							.getVisualID(cnode)) {
					case VariableUsageEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					}
				}
				break;
			}
		}
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super
				.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (PalladioComponentModelElementTypes.ProvidedRole_4101 == req
				.getElementType()) {
			return getGEFWrapper(new ProvidedRoleCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (PalladioComponentModelElementTypes.RequiredRole_4102 == req
				.getElementType()) {
			return getGEFWrapper(new RequiredRoleCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (PalladioComponentModelElementTypes.ImplementationComponentTypeParentCompleteComponentTypes_4103 == req
				.getElementType()) {
			return getGEFWrapper(new ImplementationComponentTypeParentCompleteComponentTypesCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (PalladioComponentModelElementTypes.ResourceRequiredRole_4105 == req
				.getElementType()) {
			return getGEFWrapper(new ResourceRequiredRoleCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (PalladioComponentModelElementTypes.ProvidedRole_4101 == req
				.getElementType()) {
			return null;
		}
		if (PalladioComponentModelElementTypes.RequiredRole_4102 == req
				.getElementType()) {
			return null;
		}
		if (PalladioComponentModelElementTypes.ImplementationComponentTypeParentCompleteComponentTypes_4103 == req
				.getElementType()) {
			return null;
		}
		if (PalladioComponentModelElementTypes.ResourceRequiredRole_4105 == req
				.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(
			ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ProvidedRoleEditPart.VISUAL_ID:
			return getGEFWrapper(new ProvidedRoleReorientCommand(req));
		case RequiredRoleEditPart.VISUAL_ID:
			return getGEFWrapper(new RequiredRoleReorientCommand(req));
		case ResourceRequiredRoleEditPart.VISUAL_ID:
			return getGEFWrapper(new ResourceRequiredRoleReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(
			ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID:
			return getGEFWrapper(new ImplementationComponentTypeParentCompleteComponentTypesReorientCommand(
					req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
