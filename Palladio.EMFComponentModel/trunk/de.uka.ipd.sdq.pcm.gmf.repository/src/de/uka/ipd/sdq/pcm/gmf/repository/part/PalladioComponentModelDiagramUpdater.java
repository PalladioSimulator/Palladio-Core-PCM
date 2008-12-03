/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.part;

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

import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentComponentParameterCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentPassiveResourceCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentSEFFCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeParentProvidesComponentTypesEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompositeComponentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ImplementationComponentTypeParentCompleteComponentTypesEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceSignatureListEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.PassiveResourceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesComponentTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RepositoryEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SignatureEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SubSystemEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableUsageComponentParameterVariableCharacterisationCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.CompleteComponentType;
import de.uka.ipd.sdq.pcm.repository.CompositeComponent;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.subsystem.SubSystem;

/**
 * @generated
 */
public class PalladioComponentModelDiagramUpdater {

	/**
	 * @generated
	 */
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null
				|| view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
		case InterfaceSignatureListEditPart.VISUAL_ID:
			return getInterfaceSignatureList_7101SemanticChildren(view);
		case BasicComponentSEFFCompartmentEditPart.VISUAL_ID:
			return getBasicComponentSEFFCompartment_7102SemanticChildren(view);
		case BasicComponentPassiveResourceCompartmentEditPart.VISUAL_ID:
			return getBasicComponentPassiveResourceCompartment_7103SemanticChildren(view);
		case BasicComponentComponentParameterCompartmentEditPart.VISUAL_ID:
			return getBasicComponentComponentParameterCompartment_7104SemanticChildren(view);
		case VariableUsageComponentParameterVariableCharacterisationCompartmentEditPart.VISUAL_ID:
			return getVariableUsageComponentParameterVariableCharacterisationCompartment_7105SemanticChildren(view);
		case RepositoryEditPart.VISUAL_ID:
			return getRepository_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInterfaceSignatureList_7101SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interface modelElement = (Interface) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getSignatures__Interface().iterator(); it
				.hasNext();) {
			Signature childElement = (Signature) it.next();
			int visualID = PalladioComponentModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == SignatureEditPart.VISUAL_ID) {
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
	public static List getBasicComponentSEFFCompartment_7102SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		BasicComponent modelElement = (BasicComponent) containerView
				.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement
				.getServiceEffectSpecifications__BasicComponent().iterator(); it
				.hasNext();) {
			ServiceEffectSpecification childElement = (ServiceEffectSpecification) it
					.next();
			int visualID = PalladioComponentModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == ResourceDemandingSEFFEditPart.VISUAL_ID) {
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
	public static List getBasicComponentPassiveResourceCompartment_7103SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		BasicComponent modelElement = (BasicComponent) containerView
				.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getPassiveResource_BasicComponent()
				.iterator(); it.hasNext();) {
			PassiveResource childElement = (PassiveResource) it.next();
			int visualID = PalladioComponentModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == PassiveResourceEditPart.VISUAL_ID) {
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
	public static List getBasicComponentComponentParameterCompartment_7104SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		BasicComponent modelElement = (BasicComponent) containerView
				.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement
				.getComponentParameterUsage_ImplementationComponentType()
				.iterator(); it.hasNext();) {
			VariableUsage childElement = (VariableUsage) it.next();
			int visualID = PalladioComponentModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == VariableUsageEditPart.VISUAL_ID) {
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
	public static List getVariableUsageComponentParameterVariableCharacterisationCompartment_7105SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		VariableUsage modelElement = (VariableUsage) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement
				.getVariableCharacterisation_VariableUsage().iterator(); it
				.hasNext();) {
			VariableCharacterisation childElement = (VariableCharacterisation) it
					.next();
			int visualID = PalladioComponentModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == VariableCharacterisationEditPart.VISUAL_ID) {
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
	public static List getRepository_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Repository modelElement = (Repository) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getInterfaces__Repository().iterator(); it
				.hasNext();) {
			Interface childElement = (Interface) it.next();
			int visualID = PalladioComponentModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == InterfaceEditPart.VISUAL_ID) {
				result.add(new PalladioComponentModelNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getComponents__Repository().iterator(); it
				.hasNext();) {
			RepositoryComponent childElement = (RepositoryComponent) it.next();
			int visualID = PalladioComponentModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == BasicComponentEditPart.VISUAL_ID) {
				result.add(new PalladioComponentModelNodeDescriptor(
						childElement, visualID));
				continue;
			}
			if (visualID == CompositeComponentEditPart.VISUAL_ID) {
				result.add(new PalladioComponentModelNodeDescriptor(
						childElement, visualID));
				continue;
			}
			if (visualID == CompleteComponentTypeEditPart.VISUAL_ID) {
				result.add(new PalladioComponentModelNodeDescriptor(
						childElement, visualID));
				continue;
			}
			if (visualID == ProvidesComponentTypeEditPart.VISUAL_ID) {
				result.add(new PalladioComponentModelNodeDescriptor(
						childElement, visualID));
				continue;
			}
			if (visualID == SubSystemEditPart.VISUAL_ID) {
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
		case RepositoryEditPart.VISUAL_ID:
			return getRepository_1000ContainedLinks(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_2101ContainedLinks(view);
		case BasicComponentEditPart.VISUAL_ID:
			return getBasicComponent_2102ContainedLinks(view);
		case CompositeComponentEditPart.VISUAL_ID:
			return getCompositeComponent_2103ContainedLinks(view);
		case CompleteComponentTypeEditPart.VISUAL_ID:
			return getCompleteComponentType_2104ContainedLinks(view);
		case ProvidesComponentTypeEditPart.VISUAL_ID:
			return getProvidesComponentType_2105ContainedLinks(view);
		case SubSystemEditPart.VISUAL_ID:
			return getSubSystem_2106ContainedLinks(view);
		case SignatureEditPart.VISUAL_ID:
			return getSignature_3101ContainedLinks(view);
		case ResourceDemandingSEFFEditPart.VISUAL_ID:
			return getResourceDemandingSEFF_3102ContainedLinks(view);
		case PassiveResourceEditPart.VISUAL_ID:
			return getPassiveResource_3103ContainedLinks(view);
		case VariableUsageEditPart.VISUAL_ID:
			return getVariableUsage_3104ContainedLinks(view);
		case VariableCharacterisationEditPart.VISUAL_ID:
			return getVariableCharacterisation_3105ContainedLinks(view);
		case ProvidedRoleEditPart.VISUAL_ID:
			return getProvidedRole_4101ContainedLinks(view);
		case RequiredRoleEditPart.VISUAL_ID:
			return getRequiredRole_4102ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_2101IncomingLinks(view);
		case BasicComponentEditPart.VISUAL_ID:
			return getBasicComponent_2102IncomingLinks(view);
		case CompositeComponentEditPart.VISUAL_ID:
			return getCompositeComponent_2103IncomingLinks(view);
		case CompleteComponentTypeEditPart.VISUAL_ID:
			return getCompleteComponentType_2104IncomingLinks(view);
		case ProvidesComponentTypeEditPart.VISUAL_ID:
			return getProvidesComponentType_2105IncomingLinks(view);
		case SubSystemEditPart.VISUAL_ID:
			return getSubSystem_2106IncomingLinks(view);
		case SignatureEditPart.VISUAL_ID:
			return getSignature_3101IncomingLinks(view);
		case ResourceDemandingSEFFEditPart.VISUAL_ID:
			return getResourceDemandingSEFF_3102IncomingLinks(view);
		case PassiveResourceEditPart.VISUAL_ID:
			return getPassiveResource_3103IncomingLinks(view);
		case VariableUsageEditPart.VISUAL_ID:
			return getVariableUsage_3104IncomingLinks(view);
		case VariableCharacterisationEditPart.VISUAL_ID:
			return getVariableCharacterisation_3105IncomingLinks(view);
		case ProvidedRoleEditPart.VISUAL_ID:
			return getProvidedRole_4101IncomingLinks(view);
		case RequiredRoleEditPart.VISUAL_ID:
			return getRequiredRole_4102IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_2101OutgoingLinks(view);
		case BasicComponentEditPart.VISUAL_ID:
			return getBasicComponent_2102OutgoingLinks(view);
		case CompositeComponentEditPart.VISUAL_ID:
			return getCompositeComponent_2103OutgoingLinks(view);
		case CompleteComponentTypeEditPart.VISUAL_ID:
			return getCompleteComponentType_2104OutgoingLinks(view);
		case ProvidesComponentTypeEditPart.VISUAL_ID:
			return getProvidesComponentType_2105OutgoingLinks(view);
		case SubSystemEditPart.VISUAL_ID:
			return getSubSystem_2106OutgoingLinks(view);
		case SignatureEditPart.VISUAL_ID:
			return getSignature_3101OutgoingLinks(view);
		case ResourceDemandingSEFFEditPart.VISUAL_ID:
			return getResourceDemandingSEFF_3102OutgoingLinks(view);
		case PassiveResourceEditPart.VISUAL_ID:
			return getPassiveResource_3103OutgoingLinks(view);
		case VariableUsageEditPart.VISUAL_ID:
			return getVariableUsage_3104OutgoingLinks(view);
		case VariableCharacterisationEditPart.VISUAL_ID:
			return getVariableCharacterisation_3105OutgoingLinks(view);
		case ProvidedRoleEditPart.VISUAL_ID:
			return getProvidedRole_4101OutgoingLinks(view);
		case RequiredRoleEditPart.VISUAL_ID:
			return getRequiredRole_4102OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRepository_1000ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInterface_2101ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBasicComponent_2102ContainedLinks(View view) {
		BasicComponent modelElement = (BasicComponent) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_ProvidedRole_4101(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_RequiredRole_4102(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_ImplementationComponentType_ParentCompleteComponentTypes_4103(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCompositeComponent_2103ContainedLinks(View view) {
		CompositeComponent modelElement = (CompositeComponent) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_ProvidedRole_4101(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_RequiredRole_4102(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_ImplementationComponentType_ParentCompleteComponentTypes_4103(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCompleteComponentType_2104ContainedLinks(View view) {
		CompleteComponentType modelElement = (CompleteComponentType) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_ProvidedRole_4101(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_RequiredRole_4102(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_CompleteComponentType_ParentProvidesComponentTypes_4104(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProvidesComponentType_2105ContainedLinks(View view) {
		ProvidesComponentType modelElement = (ProvidesComponentType) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_ProvidedRole_4101(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_RequiredRole_4102(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSubSystem_2106ContainedLinks(View view) {
		SubSystem modelElement = (SubSystem) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_ProvidedRole_4101(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_RequiredRole_4102(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSignature_3101ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getResourceDemandingSEFF_3102ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPassiveResource_3103ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getVariableUsage_3104ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getVariableCharacterisation_3105ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProvidedRole_4101ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRequiredRole_4102ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInterface_2101IncomingLinks(View view) {
		Interface modelElement = (Interface) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ProvidedRole_4101(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_RequiredRole_4102(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getBasicComponent_2102IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCompositeComponent_2103IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCompleteComponentType_2104IncomingLinks(View view) {
		CompleteComponentType modelElement = (CompleteComponentType) view
				.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_ImplementationComponentType_ParentCompleteComponentTypes_4103(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProvidesComponentType_2105IncomingLinks(View view) {
		ProvidesComponentType modelElement = (ProvidesComponentType) view
				.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_CompleteComponentType_ParentProvidesComponentTypes_4104(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSubSystem_2106IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getSignature_3101IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getResourceDemandingSEFF_3102IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPassiveResource_3103IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getVariableUsage_3104IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getVariableCharacterisation_3105IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProvidedRole_4101IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRequiredRole_4102IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInterface_2101OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBasicComponent_2102OutgoingLinks(View view) {
		BasicComponent modelElement = (BasicComponent) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_ProvidedRole_4101(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_RequiredRole_4102(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_ImplementationComponentType_ParentCompleteComponentTypes_4103(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCompositeComponent_2103OutgoingLinks(View view) {
		CompositeComponent modelElement = (CompositeComponent) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_ProvidedRole_4101(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_RequiredRole_4102(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_ImplementationComponentType_ParentCompleteComponentTypes_4103(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCompleteComponentType_2104OutgoingLinks(View view) {
		CompleteComponentType modelElement = (CompleteComponentType) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_ProvidedRole_4101(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_RequiredRole_4102(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_CompleteComponentType_ParentProvidesComponentTypes_4104(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProvidesComponentType_2105OutgoingLinks(View view) {
		ProvidesComponentType modelElement = (ProvidesComponentType) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_ProvidedRole_4101(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_RequiredRole_4102(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSubSystem_2106OutgoingLinks(View view) {
		SubSystem modelElement = (SubSystem) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_ProvidedRole_4101(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_RequiredRole_4102(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSignature_3101OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getResourceDemandingSEFF_3102OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPassiveResource_3103OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getVariableUsage_3104OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getVariableCharacterisation_3105OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProvidedRole_4101OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRequiredRole_4102OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_ProvidedRole_4101(
			InterfaceProvidingEntity container) {
		Collection result = new LinkedList();
		for (Iterator links = container
				.getProvidedRoles_InterfaceProvidingEntity().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ProvidedRole) {
				continue;
			}
			ProvidedRole link = (ProvidedRole) linkObject;
			if (ProvidedRoleEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Interface dst = link.getProvidedInterface__ProvidedRole();
			result.add(new PalladioComponentModelLinkDescriptor(container, dst,
					link, PalladioComponentModelElementTypes.ProvidedRole_4101,
					ProvidedRoleEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_RequiredRole_4102(
			InterfaceRequiringEntity container) {
		Collection result = new LinkedList();
		for (Iterator links = container
				.getRequiredRoles_InterfaceRequiringEntity().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof RequiredRole) {
				continue;
			}
			RequiredRole link = (RequiredRole) linkObject;
			if (RequiredRoleEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Interface dst = link.getRequiredInterface__RequiredRole();
			result.add(new PalladioComponentModelLinkDescriptor(container, dst,
					link, PalladioComponentModelElementTypes.RequiredRole_4102,
					RequiredRoleEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_ProvidedRole_4101(
			Interface target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != RepositoryPackage.eINSTANCE
					.getProvidedRole_ProvidedInterface__ProvidedRole()
					|| false == setting.getEObject() instanceof ProvidedRole) {
				continue;
			}
			ProvidedRole link = (ProvidedRole) setting.getEObject();
			if (ProvidedRoleEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof InterfaceProvidingEntity) {
				continue;
			}
			InterfaceProvidingEntity container = (InterfaceProvidingEntity) link
					.eContainer();
			result.add(new PalladioComponentModelLinkDescriptor(container,
					target, link,
					PalladioComponentModelElementTypes.ProvidedRole_4101,
					ProvidedRoleEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_RequiredRole_4102(
			Interface target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != RepositoryPackage.eINSTANCE
					.getRequiredRole_RequiredInterface__RequiredRole()
					|| false == setting.getEObject() instanceof RequiredRole) {
				continue;
			}
			RequiredRole link = (RequiredRole) setting.getEObject();
			if (RequiredRoleEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof InterfaceRequiringEntity) {
				continue;
			}
			InterfaceRequiringEntity container = (InterfaceRequiringEntity) link
					.eContainer();
			result.add(new PalladioComponentModelLinkDescriptor(container,
					target, link,
					PalladioComponentModelElementTypes.RequiredRole_4102,
					RequiredRoleEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_ImplementationComponentType_ParentCompleteComponentTypes_4103(
			CompleteComponentType target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == RepositoryPackage.eINSTANCE
					.getImplementationComponentType_ParentCompleteComponentTypes()) {
				result
						.add(new PalladioComponentModelLinkDescriptor(
								setting.getEObject(),
								target,
								PalladioComponentModelElementTypes.ImplementationComponentTypeParentCompleteComponentTypes_4103,
								ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_CompleteComponentType_ParentProvidesComponentTypes_4104(
			ProvidesComponentType target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == RepositoryPackage.eINSTANCE
					.getCompleteComponentType_ParentProvidesComponentTypes()) {
				result
						.add(new PalladioComponentModelLinkDescriptor(
								setting.getEObject(),
								target,
								PalladioComponentModelElementTypes.CompleteComponentTypeParentProvidesComponentTypes_4104,
								CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_ImplementationComponentType_ParentCompleteComponentTypes_4103(
			ImplementationComponentType source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getParentCompleteComponentTypes()
				.iterator(); destinations.hasNext();) {
			CompleteComponentType destination = (CompleteComponentType) destinations
					.next();
			result
					.add(new PalladioComponentModelLinkDescriptor(
							source,
							destination,
							PalladioComponentModelElementTypes.ImplementationComponentTypeParentCompleteComponentTypes_4103,
							ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_CompleteComponentType_ParentProvidesComponentTypes_4104(
			CompleteComponentType source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getParentProvidesComponentTypes()
				.iterator(); destinations.hasNext();) {
			ProvidesComponentType destination = (ProvidesComponentType) destinations
					.next();
			result
					.add(new PalladioComponentModelLinkDescriptor(
							source,
							destination,
							PalladioComponentModelElementTypes.CompleteComponentTypeParentProvidesComponentTypes_4104,
							CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID));
		}
		return result;
	}

}
