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
				&& isDiagramRepository_1000((Repository) domainElement)) {
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
	 * @generated
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
			return getUnrecognizedInterface_2101ChildNodeID(domainElement,
					semanticHint);
		case BasicComponentEditPart.VISUAL_ID:
			if (BasicComponentEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return BasicComponentEntityNameEditPart.VISUAL_ID;
			}
			if (BasicComponentSEFFCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return BasicComponentSEFFCompartmentEditPart.VISUAL_ID;
			}
			return getUnrecognizedBasicComponent_2102ChildNodeID(domainElement,
					semanticHint);
		case CompleteComponentTypeEditPart.VISUAL_ID:
			if (CompleteComponentTypeEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return CompleteComponentTypeEntityNameEditPart.VISUAL_ID;
			}
			return getUnrecognizedCompleteComponentType_2103ChildNodeID(
					domainElement, semanticHint);
		case ProvidesComponentTypeEditPart.VISUAL_ID:
			if (ProvidesComponentTypeEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return ProvidesComponentTypeEntityNameEditPart.VISUAL_ID;
			}
			return getUnrecognizedProvidesComponentType_2104ChildNodeID(
					domainElement, semanticHint);
		case CompositeComponentEditPart.VISUAL_ID:
			return getUnrecognizedCompositeComponent_2105ChildNodeID(
					domainElement, semanticHint);
		case SignatureEditPart.VISUAL_ID:
			return getUnrecognizedSignature_3101ChildNodeID(domainElement,
					semanticHint);
		case ResourceDemandingSEFFEditPart.VISUAL_ID:
			return getUnrecognizedResourceDemandingSEFF_3102ChildNodeID(
					domainElement, semanticHint);
		case InterfaceSignatureListEditPart.VISUAL_ID:
			if ((semanticHint == null || SignatureEditPart.VISUAL_ID == nodeVisualID)
					&& RepositoryPackage.eINSTANCE.getSignature()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeSignature_3101((Signature) domainElement))) {
				return SignatureEditPart.VISUAL_ID;
			}
			return getUnrecognizedInterfaceSignatureList_7101ChildNodeID(
					domainElement, semanticHint);
		case BasicComponentSEFFCompartmentEditPart.VISUAL_ID:
			if ((semanticHint == null || ResourceDemandingSEFFEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getResourceDemandingSEFF()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeResourceDemandingSEFF_3102((ResourceDemandingSEFF) domainElement))) {
				return ResourceDemandingSEFFEditPart.VISUAL_ID;
			}
			return getUnrecognizedBasicComponentSEFFCompartment_7102ChildNodeID(
					domainElement, semanticHint);
		case RepositoryEditPart.VISUAL_ID:
			if ((semanticHint == null || InterfaceEditPart.VISUAL_ID == nodeVisualID)
					&& RepositoryPackage.eINSTANCE.getInterface()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeInterface_2101((Interface) domainElement))) {
				return InterfaceEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || BasicComponentEditPart.VISUAL_ID == nodeVisualID)
					&& RepositoryPackage.eINSTANCE.getBasicComponent()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeBasicComponent_2102((BasicComponent) domainElement))) {
				return BasicComponentEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || CompleteComponentTypeEditPart.VISUAL_ID == nodeVisualID)
					&& RepositoryPackage.eINSTANCE.getCompleteComponentType()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeCompleteComponentType_2103((CompleteComponentType) domainElement))) {
				return CompleteComponentTypeEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ProvidesComponentTypeEditPart.VISUAL_ID == nodeVisualID)
					&& RepositoryPackage.eINSTANCE.getProvidesComponentType()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeProvidesComponentType_2104((ProvidesComponentType) domainElement))) {
				return ProvidesComponentTypeEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || CompositeComponentEditPart.VISUAL_ID == nodeVisualID)
					&& RepositoryPackage.eINSTANCE.getCompositeComponent()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeCompositeComponent_2105((CompositeComponent) domainElement))) {
				return CompositeComponentEditPart.VISUAL_ID;
			}
			return getUnrecognizedRepository_1000ChildNodeID(domainElement,
					semanticHint);
		case ProvidedRoleEditPart.VISUAL_ID:
			if (ProvidesStereotypeLabelEditPart.VISUAL_ID == nodeVisualID) {
				return ProvidesStereotypeLabelEditPart.VISUAL_ID;
			}
			return getUnrecognizedProvidedRole_4101LinkLabelID(semanticHint);
		case RequiredRoleEditPart.VISUAL_ID:
			if (RequiresStereotypeLabelEditPart.VISUAL_ID == nodeVisualID) {
				return RequiresStereotypeLabelEditPart.VISUAL_ID;
			}
			return getUnrecognizedRequiredRole_4102LinkLabelID(semanticHint);
		case ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID:
			if (CompleteParentStereotypeLabelEditPart.VISUAL_ID == nodeVisualID) {
				return CompleteParentStereotypeLabelEditPart.VISUAL_ID;
			}
			return getUnrecognizedImplementationComponentTypeParentCompleteComponentTypes_4103LinkLabelID(semanticHint);
		case CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID:
			if (ProvidesParentStereotypeLabelEditPart.VISUAL_ID == nodeVisualID) {
				return ProvidesParentStereotypeLabelEditPart.VISUAL_ID;
			}
			return getUnrecognizedCompleteComponentTypeParentProvidesComponentTypes_4104LinkLabelID(semanticHint);
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
				&& (domainElement == null || isLinkWithClassProvidedRole_4101((ProvidedRole) domainElement))) {
			return ProvidedRoleEditPart.VISUAL_ID;
		} else if (RepositoryPackage.eINSTANCE.getRequiredRole().isSuperTypeOf(
				domainElementMetaclass)
				&& (domainElement == null || isLinkWithClassRequiredRole_4102((RequiredRole) domainElement))) {
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
	private static boolean isDiagramRepository_1000(Repository element) {
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
	private static boolean isNodeInterface_2101(Interface element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeBasicComponent_2102(BasicComponent element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeCompleteComponentType_2103(
			CompleteComponentType element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeProvidesComponentType_2104(
			ProvidesComponentType element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeCompositeComponent_2105(
			CompositeComponent element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeSignature_3101(Signature element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeResourceDemandingSEFF_3102(
			ResourceDemandingSEFF element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedInterface_2101ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedBasicComponent_2102ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedCompleteComponentType_2103ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedProvidesComponentType_2104ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedCompositeComponent_2105ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedSignature_3101ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedResourceDemandingSEFF_3102ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedInterfaceSignatureList_7101ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedBasicComponentSEFFCompartment_7102ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedRepository_1000ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedProvidedRole_4101LinkLabelID(
			String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedRequiredRole_4102LinkLabelID(
			String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedImplementationComponentTypeParentCompleteComponentTypes_4103LinkLabelID(
			String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedCompleteComponentTypeParentProvidesComponentTypes_4104LinkLabelID(
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
	private static boolean isLinkWithClassProvidedRole_4101(ProvidedRole element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isLinkWithClassRequiredRole_4102(RequiredRole element) {
		return true;
	}
}
