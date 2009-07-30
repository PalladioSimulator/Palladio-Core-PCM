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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.CommunicationLinkResourceSpecificationEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.LinkingResourceEditPart;
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
			int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(
					view, childElement);
			if (visualID == ProcessingResourceSpecificationEditPart.VISUAL_ID) {
				result.add(new PalladioComponentModelNodeDescriptor(childElement,
						visualID));
				continue;
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
		ResourceEnvironment modelElement = (ResourceEnvironment) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getResourceContainer_ResourceEnvironment()
				.iterator(); it.hasNext();) {
			ResourceContainer childElement = (ResourceContainer) it.next();
			int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(
					view, childElement);
			if (visualID == ResourceContainerEditPart.VISUAL_ID) {
				result.add(new PalladioComponentModelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		Resource resource = modelElement.eResource();
		for (Iterator semanticIterator = getPhantomNodesIterator(resource); semanticIterator
				.hasNext();) {
			EObject childElement = (EObject) semanticIterator.next();
			if (childElement == modelElement) {
				continue;
			}
			if (PalladioComponentModelVisualIDRegistry.getNodeVisualID(view,
					childElement) == CommunicationLinkResourceSpecificationEditPart.VISUAL_ID) {
				result.add(new PalladioComponentModelNodeDescriptor(childElement,
						CommunicationLinkResourceSpecificationEditPart.VISUAL_ID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Iterator getPhantomNodesIterator(Resource resource) {
		return resource.getAllContents();
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
		case CommunicationLinkResourceSpecificationEditPart.VISUAL_ID:
			return getCommunicationLinkResourceSpecification_2002ContainedLinks(view);
		case ProcessingResourceSpecificationEditPart.VISUAL_ID:
			return getProcessingResourceSpecification_3001ContainedLinks(view);
		case LinkingResourceEditPart.VISUAL_ID:
			return getLinkingResource_4001ContainedLinks(view);
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
		case CommunicationLinkResourceSpecificationEditPart.VISUAL_ID:
			return getCommunicationLinkResourceSpecification_2002IncomingLinks(view);
		case ProcessingResourceSpecificationEditPart.VISUAL_ID:
			return getProcessingResourceSpecification_3001IncomingLinks(view);
		case LinkingResourceEditPart.VISUAL_ID:
			return getLinkingResource_4001IncomingLinks(view);
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
		case CommunicationLinkResourceSpecificationEditPart.VISUAL_ID:
			return getCommunicationLinkResourceSpecification_2002OutgoingLinks(view);
		case ProcessingResourceSpecificationEditPart.VISUAL_ID:
			return getProcessingResourceSpecification_3001OutgoingLinks(view);
		case LinkingResourceEditPart.VISUAL_ID:
			return getLinkingResource_4001OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getResourceEnvironment_1000ContainedLinks(View view) {
		ResourceEnvironment modelElement = (ResourceEnvironment) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_LinkingResource_4001(modelElement));
		return result;
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
	public static List getCommunicationLinkResourceSpecification_2002ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
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
	public static List getLinkingResource_4001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getResourceContainer_2001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCommunicationLinkResourceSpecification_2002IncomingLinks(
			View view) {
		CommunicationLinkResourceSpecification modelElement = (CommunicationLinkResourceSpecification) view
				.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_LinkingResource_4001(
				modelElement, crossReferences));
		return result;
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
	public static List getLinkingResource_4001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getResourceContainer_2001OutgoingLinks(View view) {
		ResourceContainer modelElement = (ResourceContainer) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_LinkingResource_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCommunicationLinkResourceSpecification_2002OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
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
	public static List getLinkingResource_4001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_LinkingResource_4001(
			ResourceEnvironment container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getLinkingresource().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof LinkingResource) {
				continue;
			}
			LinkingResource link = (LinkingResource) linkObject;
			if (LinkingResourceEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			CommunicationLinkResourceSpecification dst = link
					.getCommunicationLinkResourceSpecifications_LinkingResource();
			List sources = link.getFromResourceContainer_LinkingResource();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof ResourceContainer) {
				continue;
			}
			ResourceContainer src = (ResourceContainer) theSource;
			result.add(new PalladioComponentModelLinkDescriptor(src, dst, link,
					PalladioComponentModelElementTypes.LinkingResource_4001,
					LinkingResourceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_LinkingResource_4001(
			CommunicationLinkResourceSpecification target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != ResourceenvironmentPackage.eINSTANCE
					.getLinkingResource_CommunicationLinkResourceSpecifications_LinkingResource()
					|| false == setting.getEObject() instanceof LinkingResource) {
				continue;
			}
			LinkingResource link = (LinkingResource) setting.getEObject();
			if (LinkingResourceEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getFromResourceContainer_LinkingResource();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof ResourceContainer) {
				continue;
			}
			ResourceContainer src = (ResourceContainer) theSource;
			result.add(new PalladioComponentModelLinkDescriptor(src, target, link,
					PalladioComponentModelElementTypes.LinkingResource_4001,
					LinkingResourceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_LinkingResource_4001(
			ResourceContainer source) {
		ResourceEnvironment container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof ResourceEnvironment) {
				container = (ResourceEnvironment) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getLinkingresource().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof LinkingResource) {
				continue;
			}
			LinkingResource link = (LinkingResource) linkObject;
			if (LinkingResourceEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			CommunicationLinkResourceSpecification dst = link
					.getCommunicationLinkResourceSpecifications_LinkingResource();
			List sources = link.getFromResourceContainer_LinkingResource();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof ResourceContainer) {
				continue;
			}
			ResourceContainer src = (ResourceContainer) theSource;
			if (src != source) {
				continue;
			}
			result.add(new PalladioComponentModelLinkDescriptor(src, dst, link,
					PalladioComponentModelElementTypes.LinkingResource_4001,
					LinkingResourceEditPart.VISUAL_ID));
		}
		return result;
	}

}
