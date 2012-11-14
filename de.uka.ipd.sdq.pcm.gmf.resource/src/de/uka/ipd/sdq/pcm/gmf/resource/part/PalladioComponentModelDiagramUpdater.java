/*
 * Copyright 2009, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.resource.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.CommunicationLinkResourceSpecificationEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.LinkingResourceConnectedResourceContainers_LinkingResourceEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.LinkingResourceEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.LinkingResourceNetworkSwitchCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ProcessingResourceSpecificationEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ResourceContainerEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ResourceContainerResourceContainerCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ResourceEnvironmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

/**
 * @generated
 */
public class PalladioComponentModelDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelNodeDescriptor> getSemanticChildren(
			View view) {
		switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
		case ResourceEnvironmentEditPart.VISUAL_ID:
			return getResourceEnvironment_1000SemanticChildren(view);
		case ResourceContainerResourceContainerCompartmentEditPart.VISUAL_ID:
			return getResourceContainerResourceContainerCompartment_7004SemanticChildren(view);
		case LinkingResourceNetworkSwitchCompartmentEditPart.VISUAL_ID:
			return getLinkingResourceNetworkSwitchCompartment_7006SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelNodeDescriptor> getResourceContainerResourceContainerCompartment_7004SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		ResourceContainer modelElement = (ResourceContainer) containerView
				.getElement();
		LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
		for (Iterator<?> it = modelElement
				.getActiveResourceSpecifications_ResourceContainer().iterator(); it
				.hasNext();) {
			ProcessingResourceSpecification childElement = (ProcessingResourceSpecification) it
					.next();
			int visualID = PalladioComponentModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == ProcessingResourceSpecificationEditPart.VISUAL_ID) {
				result.add(new PalladioComponentModelNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelNodeDescriptor> getLinkingResourceNetworkSwitchCompartment_7006SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		LinkingResource modelElement = (LinkingResource) containerView
				.getElement();
		LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
		{
			CommunicationLinkResourceSpecification childElement = modelElement
					.getCommunicationLinkResourceSpecifications_LinkingResource();
			int visualID = PalladioComponentModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == CommunicationLinkResourceSpecificationEditPart.VISUAL_ID) {
				result.add(new PalladioComponentModelNodeDescriptor(
						childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelNodeDescriptor> getResourceEnvironment_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ResourceEnvironment modelElement = (ResourceEnvironment) view
				.getElement();
		LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
		for (Iterator<?> it = modelElement
				.getResourceContainer_ResourceEnvironment().iterator(); it
				.hasNext();) {
			ResourceContainer childElement = (ResourceContainer) it.next();
			int visualID = PalladioComponentModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == ResourceContainerEditPart.VISUAL_ID) {
				result.add(new PalladioComponentModelNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement
				.getLinkingResources__ResourceEnvironment().iterator(); it
				.hasNext();) {
			LinkingResource childElement = (LinkingResource) it.next();
			int visualID = PalladioComponentModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == LinkingResourceEditPart.VISUAL_ID) {
				result.add(new PalladioComponentModelNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getContainedLinks(
			View view) {
		switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
		case ResourceEnvironmentEditPart.VISUAL_ID:
			return getResourceEnvironment_1000ContainedLinks(view);
		case ResourceContainerEditPart.VISUAL_ID:
			return getResourceContainer_2004ContainedLinks(view);
		case LinkingResourceEditPart.VISUAL_ID:
			return getLinkingResource_2005ContainedLinks(view);
		case ProcessingResourceSpecificationEditPart.VISUAL_ID:
			return getProcessingResourceSpecification_3003ContainedLinks(view);
		case CommunicationLinkResourceSpecificationEditPart.VISUAL_ID:
			return getCommunicationLinkResourceSpecification_3004ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getIncomingLinks(
			View view) {
		switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
		case ResourceContainerEditPart.VISUAL_ID:
			return getResourceContainer_2004IncomingLinks(view);
		case LinkingResourceEditPart.VISUAL_ID:
			return getLinkingResource_2005IncomingLinks(view);
		case ProcessingResourceSpecificationEditPart.VISUAL_ID:
			return getProcessingResourceSpecification_3003IncomingLinks(view);
		case CommunicationLinkResourceSpecificationEditPart.VISUAL_ID:
			return getCommunicationLinkResourceSpecification_3004IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getOutgoingLinks(
			View view) {
		switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
		case ResourceContainerEditPart.VISUAL_ID:
			return getResourceContainer_2004OutgoingLinks(view);
		case LinkingResourceEditPart.VISUAL_ID:
			return getLinkingResource_2005OutgoingLinks(view);
		case ProcessingResourceSpecificationEditPart.VISUAL_ID:
			return getProcessingResourceSpecification_3003OutgoingLinks(view);
		case CommunicationLinkResourceSpecificationEditPart.VISUAL_ID:
			return getCommunicationLinkResourceSpecification_3004OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getResourceEnvironment_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getResourceContainer_2004ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getLinkingResource_2005ContainedLinks(
			View view) {
		LinkingResource modelElement = (LinkingResource) view.getElement();
		LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_LinkingResource_ConnectedResourceContainers_LinkingResource_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getProcessingResourceSpecification_3003ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getCommunicationLinkResourceSpecification_3004ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getResourceContainer_2004IncomingLinks(
			View view) {
		ResourceContainer modelElement = (ResourceContainer) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_LinkingResource_ConnectedResourceContainers_LinkingResource_4003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getLinkingResource_2005IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getProcessingResourceSpecification_3003IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getCommunicationLinkResourceSpecification_3004IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getResourceContainer_2004OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getLinkingResource_2005OutgoingLinks(
			View view) {
		LinkingResource modelElement = (LinkingResource) view.getElement();
		LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_LinkingResource_ConnectedResourceContainers_LinkingResource_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getProcessingResourceSpecification_3003OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getCommunicationLinkResourceSpecification_3004OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<PalladioComponentModelLinkDescriptor> getIncomingFeatureModelFacetLinks_LinkingResource_ConnectedResourceContainers_LinkingResource_4003(
			ResourceContainer target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == ResourceenvironmentPackage.eINSTANCE
					.getLinkingResource_ConnectedResourceContainers_LinkingResource()) {
				result.add(new PalladioComponentModelLinkDescriptor(
						setting.getEObject(),
						target,
						PalladioComponentModelElementTypes.LinkingResourceConnectedResourceContainers_LinkingResource_4003,
						LinkingResourceConnectedResourceContainers_LinkingResourceEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<PalladioComponentModelLinkDescriptor> getOutgoingFeatureModelFacetLinks_LinkingResource_ConnectedResourceContainers_LinkingResource_4003(
			LinkingResource source) {
		LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
		for (Iterator<?> destinations = source
				.getConnectedResourceContainers_LinkingResource().iterator(); destinations
				.hasNext();) {
			ResourceContainer destination = (ResourceContainer) destinations
					.next();
			result.add(new PalladioComponentModelLinkDescriptor(
					source,
					destination,
					PalladioComponentModelElementTypes.LinkingResourceConnectedResourceContainers_LinkingResource_4003,
					LinkingResourceConnectedResourceContainers_LinkingResourceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */
		@Override
		public List<PalladioComponentModelNodeDescriptor> getSemanticChildren(
				View view) {
			return PalladioComponentModelDiagramUpdater
					.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<PalladioComponentModelLinkDescriptor> getContainedLinks(
				View view) {
			return PalladioComponentModelDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<PalladioComponentModelLinkDescriptor> getIncomingLinks(
				View view) {
			return PalladioComponentModelDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<PalladioComponentModelLinkDescriptor> getOutgoingLinks(
				View view) {
			return PalladioComponentModelDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
