/*
 *by SDQ, IPD, U Karlrsuhe (TH), 2006
 */
package de.uka.ipd.sdq.pcm.gmf.system.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.AssemblyConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.AssemblyContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.AssemblyContextEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.ProvidedDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.ReqRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.ReqRoleLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.RequiredDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.RoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.RoleLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.SystemEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.SystemNodeCompEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.SystemNodeEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.SystemProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.SystemProvidedRoleLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.SystemRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.SystemRequiredRoleLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.part.PcmVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.system.view.factories.AssemblyConnectorViewFactory;
import de.uka.ipd.sdq.pcm.gmf.system.view.factories.AssemblyContextEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.system.view.factories.AssemblyContextViewFactory;
import de.uka.ipd.sdq.pcm.gmf.system.view.factories.ProvidedDelegationConnectorViewFactory;
import de.uka.ipd.sdq.pcm.gmf.system.view.factories.ReqRoleLabelViewFactory;
import de.uka.ipd.sdq.pcm.gmf.system.view.factories.ReqRoleViewFactory;
import de.uka.ipd.sdq.pcm.gmf.system.view.factories.RequiredDelegationConnectorViewFactory;
import de.uka.ipd.sdq.pcm.gmf.system.view.factories.RoleLabelViewFactory;
import de.uka.ipd.sdq.pcm.gmf.system.view.factories.RoleViewFactory;
import de.uka.ipd.sdq.pcm.gmf.system.view.factories.SystemNodeCompViewFactory;
import de.uka.ipd.sdq.pcm.gmf.system.view.factories.SystemNodeViewFactory;
import de.uka.ipd.sdq.pcm.gmf.system.view.factories.SystemProvidedRoleLabelViewFactory;
import de.uka.ipd.sdq.pcm.gmf.system.view.factories.SystemProvidedRoleViewFactory;
import de.uka.ipd.sdq.pcm.gmf.system.view.factories.SystemRequiredRoleLabelViewFactory;
import de.uka.ipd.sdq.pcm.gmf.system.view.factories.SystemRequiredRoleViewFactory;
import de.uka.ipd.sdq.pcm.gmf.system.view.factories.SystemViewFactory;

/**
 * @generated
 */
public class PcmViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter,
			String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (SystemEditPart.MODEL_ID.equals(diagramKind)
				&& PcmVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
			return SystemViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		if (containerView == null) {
			return null;
		}
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (elementType != null
				&& !PcmElementTypes.isKnownElementType(elementType)) {
			return null;
		}
		EClass semanticType = getSemanticEClass(semanticAdapter);
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int nodeVID = PcmVisualIDRegistry.getNodeVisualID(containerView,
				semanticElement, semanticType, semanticHint);
		switch (nodeVID) {
		case AssemblyContextEditPart.VISUAL_ID:
			return AssemblyContextViewFactory.class;
		case AssemblyContextEntityNameEditPart.VISUAL_ID:
			return AssemblyContextEntityNameViewFactory.class;
		case SystemNodeEditPart.VISUAL_ID:
			return SystemNodeViewFactory.class;
		case SystemNodeCompEditPart.VISUAL_ID:
			return SystemNodeCompViewFactory.class;
		case RoleEditPart.VISUAL_ID:
			return RoleViewFactory.class;
		case RoleLabelEditPart.VISUAL_ID:
			return RoleLabelViewFactory.class;
		case ReqRoleEditPart.VISUAL_ID:
			return ReqRoleViewFactory.class;
		case ReqRoleLabelEditPart.VISUAL_ID:
			return ReqRoleLabelViewFactory.class;
		case SystemProvidedRoleEditPart.VISUAL_ID:
			return SystemProvidedRoleViewFactory.class;
		case SystemProvidedRoleLabelEditPart.VISUAL_ID:
			return SystemProvidedRoleLabelViewFactory.class;
		case SystemRequiredRoleEditPart.VISUAL_ID:
			return SystemRequiredRoleViewFactory.class;
		case SystemRequiredRoleLabelEditPart.VISUAL_ID:
			return SystemRequiredRoleLabelViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (elementType != null
				&& !PcmElementTypes.isKnownElementType(elementType)) {
			return null;
		}
		EClass semanticType = getSemanticEClass(semanticAdapter);
		if (semanticType == null) {
			return null;
		}
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int linkVID = PcmVisualIDRegistry.getLinkWithClassVisualID(
				semanticElement, semanticType);
		switch (linkVID) {
		case AssemblyConnectorEditPart.VISUAL_ID:
			return AssemblyConnectorViewFactory.class;
		case ProvidedDelegationConnectorEditPart.VISUAL_ID:
			return ProvidedDelegationConnectorViewFactory.class;
		case RequiredDelegationConnectorEditPart.VISUAL_ID:
			return RequiredDelegationConnectorViewFactory.class;
		}
		return getUnrecognizedConnectorViewClass(semanticAdapter,
				containerView, semanticHint);
	}

	/**
	 * @generated
	 */
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (IElementType) semanticAdapter.getAdapter(IElementType.class);
	}

	/**
	 * @generated
	 */
	private Class getUnrecognizedConnectorViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		// Handle unrecognized child node classes here
		return null;
	}

}
