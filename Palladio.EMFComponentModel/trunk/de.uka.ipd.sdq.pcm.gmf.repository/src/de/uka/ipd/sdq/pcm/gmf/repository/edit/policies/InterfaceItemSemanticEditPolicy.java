/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.ProvidedRoleTypeLinkCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.RequiredRoleTypeLinkCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.repository.Interface;

/**
 * @generated
 */
public class InterfaceItemSemanticEditPolicy extends
		PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = new CompoundCommand();
		Collection allEdges = new ArrayList();
		View view = (View) getHost().getModel();
		allEdges.addAll(view.getSourceEdges());
		allEdges.addAll(view.getTargetEdges());
		for (Iterator it = allEdges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			EditPart nextEditPart = (EditPart) getHost().getViewer()
					.getEditPartRegistry().get(nextEdge);
			EditCommandRequestWrapper editCommandRequest = new EditCommandRequestWrapper(
					new DestroyElementRequest(((InterfaceEditPart) getHost())
							.getEditingDomain(), req.isConfirmationRequired()),
					Collections.EMPTY_MAP);
			cc.add(nextEditPart.getCommand(editCommandRequest));
		}
		cc.add(getMSLWrapper(new DestroyElementCommand(req) {

			protected EObject getElementToDestroy() {
				View view = (View) getHost().getModel();
				EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
				if (annotation != null) {
					return view;
				}
				return super.getElementToDestroy();
			}

		}));
		return cc;
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (PalladioComponentModelElementTypes.ProvidedRole_4101 == req
				.getElementType()) {
			return req.getTarget() == null ? null
					: getCreateCompleteIncomingProvidedRole_4101Command(req);
		}
		if (PalladioComponentModelElementTypes.RequiredRole_4102 == req
				.getElementType()) {
			return req.getTarget() == null ? null
					: getCreateCompleteIncomingRequiredRole_4102Command(req);
		}
		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingProvidedRole_4101Command(
			CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		EObject targetEObject = req.getTarget();
		if (false == sourceEObject instanceof InterfaceProvidingEntity
				|| false == targetEObject instanceof Interface) {
			return UnexecutableCommand.INSTANCE;
		}
		InterfaceProvidingEntity source = (InterfaceProvidingEntity) sourceEObject;
		Interface target = (Interface) targetEObject;
		if (!PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateProvidedRole_4101(source, target)) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req
					.setContainmentFeature(EntityPackage.eINSTANCE
							.getInterfaceProvidingEntity_ProvidedRoles_InterfaceProvidingEntity());
		}
		return getMSLWrapper(new ProvidedRoleTypeLinkCreateCommand(req, source,
				target));
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingRequiredRole_4102Command(
			CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		EObject targetEObject = req.getTarget();
		if (false == sourceEObject instanceof InterfaceRequiringEntity
				|| false == targetEObject instanceof Interface) {
			return UnexecutableCommand.INSTANCE;
		}
		InterfaceRequiringEntity source = (InterfaceRequiringEntity) sourceEObject;
		Interface target = (Interface) targetEObject;
		if (!PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateRequiredRole_4102(source, target)) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req
					.setContainmentFeature(EntityPackage.eINSTANCE
							.getInterfaceRequiringEntity_RequiredRoles_InterfaceRequiringEntity());
		}
		return getMSLWrapper(new RequiredRoleTypeLinkCreateCommand(req, source,
				target));
	}

}
