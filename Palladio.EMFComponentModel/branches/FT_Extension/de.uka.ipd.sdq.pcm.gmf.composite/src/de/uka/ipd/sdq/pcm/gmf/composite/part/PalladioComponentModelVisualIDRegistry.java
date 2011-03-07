/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntity2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedRoleEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedRoleEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredRoleEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredRoleEntityNameEditPart;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

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
	private static final String DEBUG_KEY = PalladioComponentModelComposedStructureDiagramEditorPlugin
			.getInstance().getBundle().getSymbolicName()
			+ "/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (ComposedProvidingRequiringEntityEditPart.MODEL_ID.equals(view
					.getType())) {
				return ComposedProvidingRequiringEntityEditPart.VISUAL_ID;
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
				PalladioComponentModelComposedStructureDiagramEditorPlugin
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
		if (EntityPackage.eINSTANCE.getComposedProvidingRequiringEntity()
				.isSuperTypeOf(domainElementMetaclass)
				&& isDiagramComposedProvidingRequiringEntity_1000((ComposedProvidingRequiringEntity) domainElement)) {
			return ComposedProvidingRequiringEntityEditPart.VISUAL_ID;
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
		if (!ComposedProvidingRequiringEntityEditPart.MODEL_ID
				.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (ComposedProvidingRequiringEntityEditPart.MODEL_ID
				.equals(containerModelID)) {
			containerVisualID = getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ComposedProvidingRequiringEntityEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		int nodeVisualID = semanticHint != null ? getVisualID(semanticHint)
				: -1;
		switch (containerVisualID) {
		case ComposedProvidingRequiringEntity2EditPart.VISUAL_ID:
			if (ComposedProvidingRequiringEntityEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return ComposedProvidingRequiringEntityEntityNameEditPart.VISUAL_ID;
			}
			if (ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ProvidedRole2EditPart.VISUAL_ID == nodeVisualID)
					&& RepositoryPackage.eINSTANCE.getProvidedRole()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeProvidedRole_3003((ProvidedRole) domainElement))) {
				return ProvidedRole2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || RequiredRole2EditPart.VISUAL_ID == nodeVisualID)
					&& RepositoryPackage.eINSTANCE.getRequiredRole()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeRequiredRole_3005((RequiredRole) domainElement))) {
				return RequiredRole2EditPart.VISUAL_ID;
			}
			return getUnrecognizedComposedProvidingRequiringEntity_2001ChildNodeID(
					domainElement, semanticHint);
		case AssemblyContextEditPart.VISUAL_ID:
			if (AssemblyContextEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return AssemblyContextEntityNameEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ProvidedRoleEditPart.VISUAL_ID == nodeVisualID)
					&& RepositoryPackage.eINSTANCE.getProvidedRole()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeProvidedRole_3001((ProvidedRole) domainElement))) {
				return ProvidedRoleEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || RequiredRoleEditPart.VISUAL_ID == nodeVisualID)
					&& RepositoryPackage.eINSTANCE.getRequiredRole()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeRequiredRole_3004((RequiredRole) domainElement))) {
				return RequiredRoleEditPart.VISUAL_ID;
			}
			return getUnrecognizedAssemblyContext_3002ChildNodeID(
					domainElement, semanticHint);
		case ProvidedRoleEditPart.VISUAL_ID:
			if (ProvidedRoleEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return ProvidedRoleEntityNameEditPart.VISUAL_ID;
			}
			return getUnrecognizedProvidedRole_3001ChildNodeID(domainElement,
					semanticHint);
		case RequiredRoleEditPart.VISUAL_ID:
			if (RequiredRoleEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return RequiredRoleEntityNameEditPart.VISUAL_ID;
			}
			return getUnrecognizedRequiredRole_3004ChildNodeID(domainElement,
					semanticHint);
		case ProvidedRole2EditPart.VISUAL_ID:
			if (ProvidedRoleEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return ProvidedRoleEntityName2EditPart.VISUAL_ID;
			}
			return getUnrecognizedProvidedRole_3003ChildNodeID(domainElement,
					semanticHint);
		case RequiredRole2EditPart.VISUAL_ID:
			if (RequiredRoleEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return RequiredRoleEntityName2EditPart.VISUAL_ID;
			}
			return getUnrecognizedRequiredRole_3005ChildNodeID(domainElement,
					semanticHint);
		case ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart.VISUAL_ID:
			if ((semanticHint == null || AssemblyContextEditPart.VISUAL_ID == nodeVisualID)
					&& CompositionPackage.eINSTANCE.getAssemblyContext()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeAssemblyContext_3002((AssemblyContext) domainElement))) {
				return AssemblyContextEditPart.VISUAL_ID;
			}
			return getUnrecognizedComposedProvidingRequiringEntityCompositeStructureInnerCompartment_7001ChildNodeID(
					domainElement, semanticHint);
		case ComposedProvidingRequiringEntityEditPart.VISUAL_ID:
			if ((semanticHint == null || ComposedProvidingRequiringEntity2EditPart.VISUAL_ID == nodeVisualID)
					&& EntityPackage.eINSTANCE
							.getComposedProvidingRequiringEntity()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeComposedProvidingRequiringEntity_2001((ComposedProvidingRequiringEntity) domainElement))) {
				return ComposedProvidingRequiringEntity2EditPart.VISUAL_ID;
			}
			return getUnrecognizedComposedProvidingRequiringEntity_1000ChildNodeID(
					domainElement, semanticHint);
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
		if (CompositionPackage.eINSTANCE.getAssemblyConnector().isSuperTypeOf(
				domainElementMetaclass)
				&& (domainElement == null || isLinkWithClassAssemblyConnector_4001((AssemblyConnector) domainElement))) {
			return AssemblyConnectorEditPart.VISUAL_ID;
		} else if (CompositionPackage.eINSTANCE
				.getRequiredDelegationConnector().isSuperTypeOf(
						domainElementMetaclass)
				&& (domainElement == null || isLinkWithClassRequiredDelegationConnector_4002((RequiredDelegationConnector) domainElement))) {
			return RequiredDelegationConnectorEditPart.VISUAL_ID;
		} else if (CompositionPackage.eINSTANCE
				.getProvidedDelegationConnector().isSuperTypeOf(
						domainElementMetaclass)
				&& (domainElement == null || isLinkWithClassProvidedDelegationConnector_4003((ProvidedDelegationConnector) domainElement))) {
			return ProvidedDelegationConnectorEditPart.VISUAL_ID;
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
	private static boolean isDiagramComposedProvidingRequiringEntity_1000(
			ComposedProvidingRequiringEntity element) {
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
	private static boolean isNodeComposedProvidingRequiringEntity_2001(
			ComposedProvidingRequiringEntity element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeAssemblyContext_3002(AssemblyContext element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeProvidedRole_3001(ProvidedRole element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeProvidedRole_3003(ProvidedRole element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeRequiredRole_3005(RequiredRole element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeRequiredRole_3004(RequiredRole element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedComposedProvidingRequiringEntity_2001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedAssemblyContext_3002ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedProvidedRole_3001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedProvidedRole_3003ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedRequiredRole_3005ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedComposedProvidingRequiringEntityCompositeStructureInnerCompartment_7001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedRequiredRole_3004ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedComposedProvidingRequiringEntity_1000ChildNodeID(
			EObject domainElement, String semanticHint) {
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
	private static boolean isLinkWithClassAssemblyConnector_4001(
			AssemblyConnector element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isLinkWithClassRequiredDelegationConnector_4002(
			RequiredDelegationConnector element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isLinkWithClassProvidedDelegationConnector_4003(
			ProvidedDelegationConnector element) {
		return true;
	}
}
