/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentSEFFCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeParentProvidesComponentTypesEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteParentStereotypeLabel2EditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteParentStereotypeLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompositeComponentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ImplementationComponentTypeParentCompleteComponentTypesEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceSignatureListEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesComponentTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesComponentTypeEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesParentStereotypeLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesStereotypeLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RepositoryEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RequiresStereotypeLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SignatureEditPart;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.CompleteComponentType;
import de.uka.ipd.sdq.pcm.repository.CompositeComponent;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented 
 * by a domain model object.
 *
 * @generated
 */
public class PalladioComponentModelVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = PalladioComponentModelRepositoryDiagramEditorPlugin
			.getInstance().getBundle().getSymbolicName()
			+ "/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (RepositoryEditPart.MODEL_ID.equals(view.getType())) {
				return RepositoryEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				PalladioComponentModelRepositoryDiagramEditorPlugin
						.getInstance().logError(
								"Unable to parse view type as a visualID number: "
										+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (RepositoryPackage.eINSTANCE.getRepository().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((Repository) domainElement)) {
			return RepositoryEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null
				|| !RepositoryEditPart.MODEL_ID
						.equals(de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry
								.getModelID(containerView))) {
			return -1;
		}
		switch (de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry
				.getVisualID(containerView)) {
		case InterfaceSignatureListEditPart.VISUAL_ID:
			if (RepositoryPackage.eINSTANCE.getSignature().isSuperTypeOf(
					domainElement.eClass())) {
				return SignatureEditPart.VISUAL_ID;
			}
			break;
		case BasicComponentSEFFCompartmentEditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getResourceDemandingSEFF().isSuperTypeOf(
					domainElement.eClass())) {
				return ResourceDemandingSEFFEditPart.VISUAL_ID;
			}
			break;
		case RepositoryEditPart.VISUAL_ID:
			if (RepositoryPackage.eINSTANCE.getInterface().isSuperTypeOf(
					domainElement.eClass())) {
				return InterfaceEditPart.VISUAL_ID;
			}
			if (RepositoryPackage.eINSTANCE.getBasicComponent().isSuperTypeOf(
					domainElement.eClass())) {
				return BasicComponentEditPart.VISUAL_ID;
			}
			if (RepositoryPackage.eINSTANCE.getCompleteComponentType()
					.isSuperTypeOf(domainElement.eClass())) {
				return CompleteComponentTypeEditPart.VISUAL_ID;
			}
			if (RepositoryPackage.eINSTANCE.getProvidesComponentType()
					.isSuperTypeOf(domainElement.eClass())) {
				return ProvidesComponentTypeEditPart.VISUAL_ID;
			}
			if (RepositoryPackage.eINSTANCE.getCompositeComponent()
					.isSuperTypeOf(domainElement.eClass())) {
				return CompositeComponentEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry
				.getModelID(containerView);
		if (!RepositoryEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (RepositoryEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = RepositoryEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case InterfaceEditPart.VISUAL_ID:
			if (InterfaceEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceSignatureListEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BasicComponentEditPart.VISUAL_ID:
			if (BasicComponentEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BasicComponentSEFFCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CompleteComponentTypeEditPart.VISUAL_ID:
			if (CompleteComponentTypeEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProvidesComponentTypeEditPart.VISUAL_ID:
			if (ProvidesComponentTypeEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceSignatureListEditPart.VISUAL_ID:
			if (SignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BasicComponentSEFFCompartmentEditPart.VISUAL_ID:
			if (ResourceDemandingSEFFEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RepositoryEditPart.VISUAL_ID:
			if (InterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BasicComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CompleteComponentTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ProvidesComponentTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CompositeComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProvidedRoleEditPart.VISUAL_ID:
			if (ProvidesStereotypeLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequiredRoleEditPart.VISUAL_ID:
			if (RequiresStereotypeLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID:
			if (CompleteParentStereotypeLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID:
			if (ProvidesParentStereotypeLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (RepositoryPackage.eINSTANCE.getProvidedRole().isSuperTypeOf(
				domainElement.eClass())) {
			return ProvidedRoleEditPart.VISUAL_ID;
		}
		if (RepositoryPackage.eINSTANCE.getRequiredRole().isSuperTypeOf(
				domainElement.eClass())) {
			return RequiredRoleEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Repository element) {
		return true;
	}
}
