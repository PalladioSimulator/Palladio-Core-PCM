/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyConnectorReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyConnectorTypeLinkCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.ProvidedDelegationConnectorReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.ProvidedDelegationConnectorTypeLinkCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

/**
 * @generated
 */
public class ProvidedRole2ItemSemanticEditPolicy extends
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
					new DestroyElementRequest(
							((ProvidedRole2EditPart) getHost())
									.getEditingDomain(), req
									.isConfirmationRequired()),
					Collections.EMPTY_MAP);
			cc.add(nextEditPart.getCommand(editCommandRequest));
		}
		cc.add(getMSLWrapper(new DestroyElementCommand(req)));
		return cc;
	}

	/**
	 * @generated not
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (PalladioComponentModelElementTypes.ProvidedDelegationConnector_4003 == req
				.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingProvidedDelegationConnector_4003Command(req)
					: null;
		}
		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingAssemblyConnector_4001Command(
			CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		EObject targetEObject = req.getTarget();
		if (false == sourceEObject instanceof RequiredRole
				|| false == targetEObject instanceof ProvidedRole) {
			return UnexecutableCommand.INSTANCE;
		}
		RequiredRole source = (RequiredRole) sourceEObject;
		ProvidedRole target = (ProvidedRole) targetEObject;
		ComposedStructure container = (ComposedStructure) getRelationshipContainer(
				source, CompositionPackage.eINSTANCE.getComposedStructure(),
				req.getElementType());
		if (container == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (!PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateAssemblyConnector_4001(container, source, target)) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req
					.setContainmentFeature(CompositionPackage.eINSTANCE
							.getComposedStructure_AssemblyConnectors_ComposedStructure());
		}
		return getMSLWrapper(new AssemblyConnectorTypeLinkCreateCommand(req,
				container, source, target));
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingProvidedDelegationConnector_4003Command(
			CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		if (false == sourceEObject instanceof ProvidedRole) {
			return UnexecutableCommand.INSTANCE;
		}
		ProvidedRole source = (ProvidedRole) sourceEObject;
		ComposedStructure container = (ComposedStructure) getRelationshipContainer(
				source, CompositionPackage.eINSTANCE.getComposedStructure(),
				req.getElementType());
		if (container == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (!PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateProvidedDelegationConnector_4003(container, source,
						null)) {
			return UnexecutableCommand.INSTANCE;
		}
		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingProvidedDelegationConnector_4003Command(
			CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		EObject targetEObject = req.getTarget();
		if (false == sourceEObject instanceof ProvidedRole
				|| false == targetEObject instanceof ProvidedRole) {
			return UnexecutableCommand.INSTANCE;
		}
		ProvidedRole source = (ProvidedRole) sourceEObject;
		ProvidedRole target = (ProvidedRole) targetEObject;
		ComposedStructure container = (ComposedStructure) getRelationshipContainer(
				source, CompositionPackage.eINSTANCE.getComposedStructure(),
				req.getElementType());
		if (container == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (!PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateProvidedDelegationConnector_4003(container, source,
						target)) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req
					.setContainmentFeature(CompositionPackage.eINSTANCE
							.getComposedStructure_ProvidedDelegationConnectors_ComposedStructure());
		}
		return getMSLWrapper(new ProvidedDelegationConnectorTypeLinkCreateCommand(
				req, container, source, target));
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
		case AssemblyConnectorEditPart.VISUAL_ID:
			return getMSLWrapper(new AssemblyConnectorReorientCommand(req));
		case ProvidedDelegationConnectorEditPart.VISUAL_ID:
			return getMSLWrapper(new ProvidedDelegationConnectorReorientCommand(
					req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
