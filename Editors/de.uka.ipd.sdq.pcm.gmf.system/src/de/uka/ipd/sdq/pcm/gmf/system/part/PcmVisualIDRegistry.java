/*
 *by SDQ, IPD, U Karlrsuhe (TH), 2006
 */
package de.uka.ipd.sdq.pcm.gmf.system.part;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;

import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;

import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.AssemblyConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.AssemblyContextComponent_Context_CompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.AssemblyContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.AssemblyContextEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.ComponentEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.ProvidedDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.ReqRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.ReqRoleLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.RequiredDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.RoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.RoleLabel2EditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.RoleLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.System2EditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.SystemEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.SystemProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.SystemProvidedRoleEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.SystemRequiredRoleEditPart;

import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.SystemRequiredRoleEntityNameEditPart;

import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.system.SystemProvidedRole;
import de.uka.ipd.sdq.pcm.system.SystemRequiredRole;

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
	private static final String DEBUG_KEY = SystemDiagramEditorPlugin
			.getInstance().getBundle().getSymbolicName()
			+ "/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (SystemEditPart.MODEL_ID.equals(view.getType())) {
				return SystemEditPart.VISUAL_ID;
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
				SystemDiagramEditorPlugin.getInstance().logError(
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
		if (SystemPackage.eINSTANCE.getSystem().isSuperTypeOf(
				domainElementMetaclass)
				&& isDiagramSystem_79((de.uka.ipd.sdq.pcm.system.System) domainElement)) {
			return SystemEditPart.VISUAL_ID;
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
		if (!SystemEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (SystemEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = SystemEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		int nodeVisualID = semanticHint != null ? getVisualID(semanticHint)
				: -1;
		switch (containerVisualID) {
		case AssemblyContextEditPart.VISUAL_ID:
			if (AssemblyContextEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return AssemblyContextEntityNameEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || RoleEditPart.VISUAL_ID == nodeVisualID)) {
				return RoleEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ReqRoleEditPart.VISUAL_ID == nodeVisualID)) {
				return ReqRoleEditPart.VISUAL_ID;
			}
			return getUnrecognizedAssemblyContext_1001ChildNodeID(
					domainElement, semanticHint);
		case SystemProvidedRoleEditPart.VISUAL_ID:
			if (SystemProvidedRoleEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return SystemProvidedRoleEntityNameEditPart.VISUAL_ID;
			}
			return getUnrecognizedSystemProvidedRole_1002ChildNodeID(
					domainElement, semanticHint);
		case SystemRequiredRoleEditPart.VISUAL_ID:
			if (SystemRequiredRoleEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return SystemRequiredRoleEntityNameEditPart.VISUAL_ID;
			}
			return getUnrecognizedSystemRequiredRole_1003ChildNodeID(
					domainElement, semanticHint);
		case RoleEditPart.VISUAL_ID:
			if (RoleLabelEditPart.VISUAL_ID == nodeVisualID) {
				return RoleLabelEditPart.VISUAL_ID;
			}
			return getUnrecognizedNode_2001ChildNodeID(domainElement,
					semanticHint);
		case ReqRoleEditPart.VISUAL_ID:
			if (ReqRoleLabelEditPart.VISUAL_ID == nodeVisualID) {
				return ReqRoleLabelEditPart.VISUAL_ID;
			}
			return getUnrecognizedNode_2002ChildNodeID(domainElement,
					semanticHint);
		case SystemEditPart.VISUAL_ID:
			if ((semanticHint == null || AssemblyContextEditPart.VISUAL_ID == nodeVisualID)
					&& CompositionPackage.eINSTANCE.getAssemblyContext()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeAssemblyContext_1001((AssemblyContext) domainElement))) {
				return AssemblyContextEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || SystemProvidedRoleEditPart.VISUAL_ID == nodeVisualID)
					&& SystemPackage.eINSTANCE.getSystemProvidedRole()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeSystemProvidedRole_1002((SystemProvidedRole) domainElement))) {
				return SystemProvidedRoleEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || SystemRequiredRoleEditPart.VISUAL_ID == nodeVisualID)
					&& SystemPackage.eINSTANCE.getSystemRequiredRole()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeSystemRequiredRole_1003((SystemRequiredRole) domainElement))) {
				return SystemRequiredRoleEditPart.VISUAL_ID;
			}
			return getUnrecognizedSystem_79ChildNodeID(domainElement,
					semanticHint);
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
				&& (domainElement == null || isLinkWithClassAssemblyConnector_3001((AssemblyConnector) domainElement))) {
			return AssemblyConnectorEditPart.VISUAL_ID;
		} else if (CompositionPackage.eINSTANCE
				.getProvidedDelegationConnector().isSuperTypeOf(
						domainElementMetaclass)
				&& (domainElement == null || isLinkWithClassProvidedDelegationConnector_3002((ProvidedDelegationConnector) domainElement))) {
			return ProvidedDelegationConnectorEditPart.VISUAL_ID;
		} else if (CompositionPackage.eINSTANCE
				.getRequiredDelegationConnector().isSuperTypeOf(
						domainElementMetaclass)
				&& (domainElement == null || isLinkWithClassRequiredDelegationConnector_3003((RequiredDelegationConnector) domainElement))) {
			return RequiredDelegationConnectorEditPart.VISUAL_ID;
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
	private static boolean isDiagramSystem_79(
			de.uka.ipd.sdq.pcm.system.System element) {
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
	private static boolean isNodeAssemblyContext_1001(AssemblyContext element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeSystemProvidedRole_1002(
			SystemProvidedRole element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeSystemRequiredRole_1003(
			SystemRequiredRole element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedAssemblyContext_1001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedSystemProvidedRole_1002ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedSystemRequiredRole_1003ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedNode_2001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedNode_2002ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedSystem_79ChildNodeID(
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
	private static boolean isLinkWithClassAssemblyConnector_3001(
			AssemblyConnector element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isLinkWithClassProvidedDelegationConnector_3002(
			ProvidedDelegationConnector element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isLinkWithClassRequiredDelegationConnector_3003(
			RequiredDelegationConnector element) {
		return true;
	}
}
