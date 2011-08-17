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

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.CommunicationLinkResourceSpecificationEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.LinkingResource2EditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.LinkingResourceConnectedResourceContainers_LinkingResourceEditPart;
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
	public static List getSemanticChildren(View view) {
		switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
		case ResourceContainerResourceContainerCompartmentEditPart.VISUAL_ID:
			return getResourceContainerResourceContainerCompartment_7001SemanticChildren(view);
		case LinkingResourceNetworkSwitchCompartmentEditPart.VISUAL_ID:
			return getLinkingResourceNetworkSwitchCompartment_7003SemanticChildren(view);
		case ResourceEnvironmentEditPart.VISUAL_ID:
			return getResourceEnvironment_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getResourceContainerResourceContainerCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		ResourceContainer modelElement = (ResourceContainer) containerView
				.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement
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
	public static List getLinkingResourceNetworkSwitchCompartment_7003SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		LinkingResource modelElement = (LinkingResource) containerView
				.getElement();
		List result = new LinkedList();
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
	public static List getResourceEnvironment_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		ResourceEnvironment modelElement = (ResourceEnvironment) view
				.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement
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
		for (Iterator it = modelElement
				.getLinkingResources__ResourceEnvironment().iterator(); it
				.hasNext();) {
			LinkingResource childElement = (LinkingResource) it.next();
			int visualID = PalladioComponentModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == LinkingResource2EditPart.VISUAL_ID) {
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
	public static List getContainedLinks(View view) {
		switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
		case ResourceEnvironmentEditPart.VISUAL_ID:
			return getResourceEnvironment_1000ContainedLinks(view);
		case ResourceContainerEditPart.VISUAL_ID:
			return getResourceContainer_2001ContainedLinks(view);
		case LinkingResource2EditPart.VISUAL_ID:
			return getLinkingResource_2003ContainedLinks(view);
		case ProcessingResourceSpecificationEditPart.VISUAL_ID:
			return getProcessingResourceSpecification_3001ContainedLinks(view);
		case CommunicationLinkResourceSpecificationEditPart.VISUAL_ID:
			return getCommunicationLinkResourceSpecification_3002ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
		case ResourceContainerEditPart.VISUAL_ID:
			return getResourceContainer_2001IncomingLinks(view);
		case LinkingResource2EditPart.VISUAL_ID:
			return getLinkingResource_2003IncomingLinks(view);
		case ProcessingResourceSpecificationEditPart.VISUAL_ID:
			return getProcessingResourceSpecification_3001IncomingLinks(view);
		case CommunicationLinkResourceSpecificationEditPart.VISUAL_ID:
			return getCommunicationLinkResourceSpecification_3002IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
		case ResourceContainerEditPart.VISUAL_ID:
			return getResourceContainer_2001OutgoingLinks(view);
		case LinkingResource2EditPart.VISUAL_ID:
			return getLinkingResource_2003OutgoingLinks(view);
		case ProcessingResourceSpecificationEditPart.VISUAL_ID:
			return getProcessingResourceSpecification_3001OutgoingLinks(view);
		case CommunicationLinkResourceSpecificationEditPart.VISUAL_ID:
			return getCommunicationLinkResourceSpecification_3002OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getResourceEnvironment_1000ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getResourceContainer_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getLinkingResource_2003ContainedLinks(View view) {
		LinkingResource modelElement = (LinkingResource) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_LinkingResource_ConnectedResourceContainers_LinkingResource_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProcessingResourceSpecification_3001ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCommunicationLinkResourceSpecification_3002ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getResourceContainer_2001IncomingLinks(View view) {
		ResourceContainer modelElement = (ResourceContainer) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_LinkingResource_ConnectedResourceContainers_LinkingResource_4002(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getLinkingResource_2003IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProcessingResourceSpecification_3001IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCommunicationLinkResourceSpecification_3002IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getResourceContainer_2001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getLinkingResource_2003OutgoingLinks(View view) {
		LinkingResource modelElement = (LinkingResource) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_LinkingResource_ConnectedResourceContainers_LinkingResource_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProcessingResourceSpecification_3001OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCommunicationLinkResourceSpecification_3002OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_LinkingResource_ConnectedResourceContainers_LinkingResource_4002(
			ResourceContainer target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == ResourceenvironmentPackage.eINSTANCE
					.getLinkingResource_ConnectedResourceContainers_LinkingResource()) {
				result
						.add(new PalladioComponentModelLinkDescriptor(
								setting.getEObject(),
								target,
								PalladioComponentModelElementTypes.LinkingResourceConnectedResourceContainers_LinkingResource_4002,
								LinkingResourceConnectedResourceContainers_LinkingResourceEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_LinkingResource_ConnectedResourceContainers_LinkingResource_4002(
			LinkingResource source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source
				.getConnectedResourceContainers_LinkingResource().iterator(); destinations
				.hasNext();) {
			ResourceContainer destination = (ResourceContainer) destinations
					.next();
			result
					.add(new PalladioComponentModelLinkDescriptor(
							source,
							destination,
							PalladioComponentModelElementTypes.LinkingResourceConnectedResourceContainers_LinkingResource_4002,
							LinkingResourceConnectedResourceContainers_LinkingResourceEditPart.VISUAL_ID));
		}
		return result;
	}

}
