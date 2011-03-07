/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeParentProvidesComponentTypesEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompositeComponentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ImplementationComponentTypeParentCompleteComponentTypesEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.PassiveResourceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesComponentTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RepositoryEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SignatureEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SubSystemEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelRepositoryDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.subsystem.SubsystemPackage;

/**
 * @generated
 */
public class PalladioComponentModelElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private PalladioComponentModelElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Repository_1000 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.Repository_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Interface_2101 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.Interface_2101"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType BasicComponent_2102 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.BasicComponent_2102"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CompositeComponent_2103 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.CompositeComponent_2103"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CompleteComponentType_2104 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.CompleteComponentType_2104"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ProvidesComponentType_2105 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.ProvidesComponentType_2105"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SubSystem_2106 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.SubSystem_2106"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Signature_3101 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.Signature_3101"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ResourceDemandingSEFF_3102 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.ResourceDemandingSEFF_3102"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PassiveResource_3103 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.PassiveResource_3103"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType VariableUsage_3104 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.VariableUsage_3104"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType VariableCharacterisation_3105 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.VariableCharacterisation_3105"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ProvidedRole_4101 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.ProvidedRole_4101"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RequiredRole_4102 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.RequiredRole_4102"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ImplementationComponentTypeParentCompleteComponentTypes_4103 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.ImplementationComponentTypeParentCompleteComponentTypes_4103"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CompleteComponentTypeParentProvidesComponentTypes_4104 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.CompleteComponentTypeParentProvidesComponentTypes_4104"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return PalladioComponentModelRepositoryDiagramEditorPlugin
						.getInstance().getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap();

			elements.put(Repository_1000, RepositoryPackage.eINSTANCE
					.getRepository());

			elements.put(Interface_2101, RepositoryPackage.eINSTANCE
					.getInterface());

			elements.put(BasicComponent_2102, RepositoryPackage.eINSTANCE
					.getBasicComponent());

			elements.put(CompositeComponent_2103, RepositoryPackage.eINSTANCE
					.getCompositeComponent());

			elements.put(CompleteComponentType_2104,
					RepositoryPackage.eINSTANCE.getCompleteComponentType());

			elements.put(ProvidesComponentType_2105,
					RepositoryPackage.eINSTANCE.getProvidesComponentType());

			elements.put(SubSystem_2106, SubsystemPackage.eINSTANCE
					.getSubSystem());

			elements.put(Signature_3101, RepositoryPackage.eINSTANCE
					.getSignature());

			elements.put(ResourceDemandingSEFF_3102, SeffPackage.eINSTANCE
					.getResourceDemandingSEFF());

			elements.put(PassiveResource_3103, RepositoryPackage.eINSTANCE
					.getPassiveResource());

			elements.put(VariableUsage_3104, ParameterPackage.eINSTANCE
					.getVariableUsage());

			elements.put(VariableCharacterisation_3105,
					ParameterPackage.eINSTANCE.getVariableCharacterisation());

			elements.put(ProvidedRole_4101, RepositoryPackage.eINSTANCE
					.getProvidedRole());

			elements.put(RequiredRole_4102, RepositoryPackage.eINSTANCE
					.getRequiredRole());

			elements
					.put(
							ImplementationComponentTypeParentCompleteComponentTypes_4103,
							RepositoryPackage.eINSTANCE
									.getImplementationComponentType_ParentCompleteComponentTypes());

			elements
					.put(
							CompleteComponentTypeParentProvidesComponentTypes_4104,
							RepositoryPackage.eINSTANCE
									.getCompleteComponentType_ParentProvidesComponentTypes());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(Repository_1000);
			KNOWN_ELEMENT_TYPES.add(Interface_2101);
			KNOWN_ELEMENT_TYPES.add(BasicComponent_2102);
			KNOWN_ELEMENT_TYPES.add(CompositeComponent_2103);
			KNOWN_ELEMENT_TYPES.add(CompleteComponentType_2104);
			KNOWN_ELEMENT_TYPES.add(ProvidesComponentType_2105);
			KNOWN_ELEMENT_TYPES.add(SubSystem_2106);
			KNOWN_ELEMENT_TYPES.add(Signature_3101);
			KNOWN_ELEMENT_TYPES.add(ResourceDemandingSEFF_3102);
			KNOWN_ELEMENT_TYPES.add(PassiveResource_3103);
			KNOWN_ELEMENT_TYPES.add(VariableUsage_3104);
			KNOWN_ELEMENT_TYPES.add(VariableCharacterisation_3105);
			KNOWN_ELEMENT_TYPES.add(ProvidedRole_4101);
			KNOWN_ELEMENT_TYPES.add(RequiredRole_4102);
			KNOWN_ELEMENT_TYPES
					.add(ImplementationComponentTypeParentCompleteComponentTypes_4103);
			KNOWN_ELEMENT_TYPES
					.add(CompleteComponentTypeParentProvidesComponentTypes_4104);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case RepositoryEditPart.VISUAL_ID:
			return Repository_1000;
		case InterfaceEditPart.VISUAL_ID:
			return Interface_2101;
		case BasicComponentEditPart.VISUAL_ID:
			return BasicComponent_2102;
		case CompositeComponentEditPart.VISUAL_ID:
			return CompositeComponent_2103;
		case CompleteComponentTypeEditPart.VISUAL_ID:
			return CompleteComponentType_2104;
		case ProvidesComponentTypeEditPart.VISUAL_ID:
			return ProvidesComponentType_2105;
		case SubSystemEditPart.VISUAL_ID:
			return SubSystem_2106;
		case SignatureEditPart.VISUAL_ID:
			return Signature_3101;
		case ResourceDemandingSEFFEditPart.VISUAL_ID:
			return ResourceDemandingSEFF_3102;
		case PassiveResourceEditPart.VISUAL_ID:
			return PassiveResource_3103;
		case VariableUsageEditPart.VISUAL_ID:
			return VariableUsage_3104;
		case VariableCharacterisationEditPart.VISUAL_ID:
			return VariableCharacterisation_3105;
		case ProvidedRoleEditPart.VISUAL_ID:
			return ProvidedRole_4101;
		case RequiredRoleEditPart.VISUAL_ID:
			return RequiredRole_4102;
		case ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID:
			return ImplementationComponentTypeParentCompleteComponentTypes_4103;
		case CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID:
			return CompleteComponentTypeParentProvidesComponentTypes_4104;
		}
		return null;
	}

}
