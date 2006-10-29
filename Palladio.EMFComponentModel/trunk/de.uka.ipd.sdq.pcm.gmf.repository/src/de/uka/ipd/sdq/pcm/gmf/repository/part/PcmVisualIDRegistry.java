/*
 *Copyright 2006 Institute for Software-Design and Quality, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.repository.part;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentSEFFCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceSignatureListEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesStereotypeLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RepositoryEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RequiresStereotypeLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SignatureEditPart;

import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Signature;

import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import org.eclipse.core.runtime.Platform;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented 
 * by a domain model object.
 *
 * @generated
 */
public class PcmVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = RepositoryDiagramEditorPlugin
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
		return getVisualID(view.getType());
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
				RepositoryDiagramEditorPlugin.getInstance().logError(
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
		EClass domainElementMetaclass = domainElement.eClass();
		return getDiagramVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	private static int getDiagramVisualID(EObject domainElement,
			EClass domainElementMetaclass) {
		if (RepositoryPackage.eINSTANCE.getRepository().isSuperTypeOf(
				domainElementMetaclass)
				&& isDiagramRepository_79((Repository) domainElement)) {
			return RepositoryEditPart.VISUAL_ID;
		}
		return getUnrecognizedDiagramID(domainElement);
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getNodeVisualID(containerView, domainElement,
				domainElementMetaclass, null);
	}

	/**
	 * @generated not
	 */
	public static int getNodeVisualID(View containerView,
			EObject domainElement, EClass domainElementMetaclass,
			String semanticHint) {
		String containerModelID = getModelID(containerView);
		if (!RepositoryEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (RepositoryEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = RepositoryEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		if (semanticHint != null && semanticHint.equals(""))
			semanticHint = null;

		int nodeVisualID = semanticHint != null ? getVisualID(semanticHint)
				: -1;
		switch (containerVisualID) {
		case InterfaceEditPart.VISUAL_ID:
			if (InterfaceEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return InterfaceEntityNameEditPart.VISUAL_ID;
			}
			if (InterfaceSignatureListEditPart.VISUAL_ID == nodeVisualID) {
				return InterfaceSignatureListEditPart.VISUAL_ID;
			}
			return getUnrecognizedInterface_1001ChildNodeID(domainElement,
					semanticHint);
		case BasicComponentEditPart.VISUAL_ID:
			if (BasicComponentEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return BasicComponentEntityNameEditPart.VISUAL_ID;
			}
			if (BasicComponentSEFFCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return BasicComponentSEFFCompartmentEditPart.VISUAL_ID;
			}
			return getUnrecognizedBasicComponent_1002ChildNodeID(domainElement,
					semanticHint);
		case SignatureEditPart.VISUAL_ID:
			return getUnrecognizedSignature_2001ChildNodeID(domainElement,
					semanticHint);
		case ResourceDemandingSEFFEditPart.VISUAL_ID:
			return getUnrecognizedResourceDemandingSEFF_2002ChildNodeID(
					domainElement, semanticHint);
		case InterfaceSignatureListEditPart.VISUAL_ID:
			if ((semanticHint == null || SignatureEditPart.VISUAL_ID == nodeVisualID)
					&& RepositoryPackage.eINSTANCE.getSignature()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeSignature_2001((Signature) domainElement))) {
				return SignatureEditPart.VISUAL_ID;
			}
			return getUnrecognizedInterfaceSignatureList_5001ChildNodeID(
					domainElement, semanticHint);
		case BasicComponentSEFFCompartmentEditPart.VISUAL_ID:
			if ((semanticHint == null || ResourceDemandingSEFFEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getResourceDemandingSEFF()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeResourceDemandingSEFF_2002((ResourceDemandingSEFF) domainElement))) {
				return ResourceDemandingSEFFEditPart.VISUAL_ID;
			}
			return getUnrecognizedBasicComponentSEFFCompartment_5002ChildNodeID(
					domainElement, semanticHint);
		case RepositoryEditPart.VISUAL_ID:
			if ((semanticHint == null || InterfaceEditPart.VISUAL_ID == nodeVisualID)
					&& RepositoryPackage.eINSTANCE.getInterface()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeInterface_1001((Interface) domainElement))) {
				return InterfaceEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || BasicComponentEditPart.VISUAL_ID == nodeVisualID)
					&& RepositoryPackage.eINSTANCE.getBasicComponent()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeBasicComponent_1002((BasicComponent) domainElement))) {
				return BasicComponentEditPart.VISUAL_ID;
			}
			return getUnrecognizedRepository_79ChildNodeID(domainElement,
					semanticHint);
		case ProvidedRoleEditPart.VISUAL_ID:
			if (ProvidesStereotypeLabelEditPart.VISUAL_ID == nodeVisualID) {
				return ProvidesStereotypeLabelEditPart.VISUAL_ID;
			}
			return getUnrecognizedProvidedRole_3001LinkLabelID(semanticHint);
		case RequiredRoleEditPart.VISUAL_ID:
			if (RequiresStereotypeLabelEditPart.VISUAL_ID == nodeVisualID) {
				return RequiresStereotypeLabelEditPart.VISUAL_ID;
			}
			return getUnrecognizedRequiredRole_3002LinkLabelID(semanticHint);
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getLinkWithClassVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement,
			EClass domainElementMetaclass) {
		if (RepositoryPackage.eINSTANCE.getProvidedRole().isSuperTypeOf(
				domainElementMetaclass)
				&& (domainElement == null || isLinkWithClassProvidedRole_3001((ProvidedRole) domainElement))) {
			return ProvidedRoleEditPart.VISUAL_ID;
		} else if (RepositoryPackage.eINSTANCE.getRequiredRole().isSuperTypeOf(
				domainElementMetaclass)
				&& (domainElement == null || isLinkWithClassRequiredRole_3002((RequiredRole) domainElement))) {
			return RequiredRoleEditPart.VISUAL_ID;
		} else {
			return getUnrecognizedLinkWithClassID(domainElement);
		}
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isDiagramRepository_79(Repository element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedDiagramID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeInterface_1001(Interface element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeBasicComponent_1002(BasicComponent element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeSignature_2001(Signature element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeResourceDemandingSEFF_2002(
			ResourceDemandingSEFF element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedInterface_1001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedBasicComponent_1002ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedSignature_2001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedResourceDemandingSEFF_2002ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedInterfaceSignatureList_5001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedBasicComponentSEFFCompartment_5002ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedRepository_79ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedProvidedRole_3001LinkLabelID(
			String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedRequiredRole_3002LinkLabelID(
			String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedLinkWithClassID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isLinkWithClassProvidedRole_3001(ProvidedRole element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isLinkWithClassRequiredRole_3002(RequiredRole element) {
		return true;
	}
}
