/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.providers;

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

import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyEventConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntity2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SinkRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SourceRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelComposedStructureDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

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
	public static final IElementType ComposedProvidingRequiringEntity_1000 = getElementType("de.uka.ipd.sdq.pcm.gmf.composite.ComposedProvidingRequiringEntity_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ComposedProvidingRequiringEntity_2002 = getElementType("de.uka.ipd.sdq.pcm.gmf.composite.ComposedProvidingRequiringEntity_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AssemblyContext_3006 = getElementType("de.uka.ipd.sdq.pcm.gmf.composite.AssemblyContext_3006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OperationProvidedRole_3007 = getElementType("de.uka.ipd.sdq.pcm.gmf.composite.OperationProvidedRole_3007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OperationRequiredRole_3008 = getElementType("de.uka.ipd.sdq.pcm.gmf.composite.OperationRequiredRole_3008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SourceRole_3013 = getElementType("de.uka.ipd.sdq.pcm.gmf.composite.SourceRole_3013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SinkRole_3014 = getElementType("de.uka.ipd.sdq.pcm.gmf.composite.SinkRole_3014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OperationProvidedRole_3011 = getElementType("de.uka.ipd.sdq.pcm.gmf.composite.OperationProvidedRole_3011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OperationRequiredRole_3012 = getElementType("de.uka.ipd.sdq.pcm.gmf.composite.OperationRequiredRole_3012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AssemblyConnector_4004 = getElementType("de.uka.ipd.sdq.pcm.gmf.composite.AssemblyConnector_4004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AssemblyEventConnector_4007 = getElementType("de.uka.ipd.sdq.pcm.gmf.composite.AssemblyEventConnector_4007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RequiredDelegationConnector_4005 = getElementType("de.uka.ipd.sdq.pcm.gmf.composite.RequiredDelegationConnector_4005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ProvidedDelegationConnector_4006 = getElementType("de.uka.ipd.sdq.pcm.gmf.composite.ProvidedDelegationConnector_4006"); //$NON-NLS-1$

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
				return PalladioComponentModelComposedStructureDiagramEditorPlugin
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

			elements.put(ComposedProvidingRequiringEntity_1000,
					EntityPackage.eINSTANCE
							.getComposedProvidingRequiringEntity());

			elements.put(ComposedProvidingRequiringEntity_2002,
					EntityPackage.eINSTANCE
							.getComposedProvidingRequiringEntity());

			elements.put(AssemblyContext_3006, CompositionPackage.eINSTANCE
					.getAssemblyContext());

			elements.put(OperationProvidedRole_3007,
					RepositoryPackage.eINSTANCE.getOperationProvidedRole());

			elements.put(OperationRequiredRole_3008,
					RepositoryPackage.eINSTANCE.getOperationRequiredRole());

			elements.put(SourceRole_3013, RepositoryPackage.eINSTANCE
					.getSourceRole());

			elements.put(SinkRole_3014, RepositoryPackage.eINSTANCE
					.getSinkRole());

			elements.put(OperationProvidedRole_3011,
					RepositoryPackage.eINSTANCE.getOperationProvidedRole());

			elements.put(OperationRequiredRole_3012,
					RepositoryPackage.eINSTANCE.getOperationRequiredRole());

			elements.put(AssemblyConnector_4004, CompositionPackage.eINSTANCE
					.getAssemblyConnector());

			elements.put(AssemblyEventConnector_4007,
					CompositionPackage.eINSTANCE.getAssemblyEventConnector());

			elements.put(RequiredDelegationConnector_4005,
					CompositionPackage.eINSTANCE
							.getRequiredDelegationConnector());

			elements.put(ProvidedDelegationConnector_4006,
					CompositionPackage.eINSTANCE
							.getProvidedDelegationConnector());
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
			KNOWN_ELEMENT_TYPES.add(ComposedProvidingRequiringEntity_1000);
			KNOWN_ELEMENT_TYPES.add(ComposedProvidingRequiringEntity_2002);
			KNOWN_ELEMENT_TYPES.add(AssemblyContext_3006);
			KNOWN_ELEMENT_TYPES.add(OperationProvidedRole_3007);
			KNOWN_ELEMENT_TYPES.add(OperationRequiredRole_3008);
			KNOWN_ELEMENT_TYPES.add(SourceRole_3013);
			KNOWN_ELEMENT_TYPES.add(SinkRole_3014);
			KNOWN_ELEMENT_TYPES.add(OperationProvidedRole_3011);
			KNOWN_ELEMENT_TYPES.add(OperationRequiredRole_3012);
			KNOWN_ELEMENT_TYPES.add(AssemblyConnector_4004);
			KNOWN_ELEMENT_TYPES.add(AssemblyEventConnector_4007);
			KNOWN_ELEMENT_TYPES.add(RequiredDelegationConnector_4005);
			KNOWN_ELEMENT_TYPES.add(ProvidedDelegationConnector_4006);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case ComposedProvidingRequiringEntityEditPart.VISUAL_ID:
			return ComposedProvidingRequiringEntity_1000;
		case ComposedProvidingRequiringEntity2EditPart.VISUAL_ID:
			return ComposedProvidingRequiringEntity_2002;
		case AssemblyContextEditPart.VISUAL_ID:
			return AssemblyContext_3006;
		case OperationProvidedRoleEditPart.VISUAL_ID:
			return OperationProvidedRole_3007;
		case OperationRequiredRoleEditPart.VISUAL_ID:
			return OperationRequiredRole_3008;
		case SourceRoleEditPart.VISUAL_ID:
			return SourceRole_3013;
		case SinkRoleEditPart.VISUAL_ID:
			return SinkRole_3014;
		case OperationProvidedRole2EditPart.VISUAL_ID:
			return OperationProvidedRole_3011;
		case OperationRequiredRole2EditPart.VISUAL_ID:
			return OperationRequiredRole_3012;
		case AssemblyConnectorEditPart.VISUAL_ID:
			return AssemblyConnector_4004;
		case AssemblyEventConnectorEditPart.VISUAL_ID:
			return AssemblyEventConnector_4007;
		case RequiredDelegationConnectorEditPart.VISUAL_ID:
			return RequiredDelegationConnector_4005;
		case ProvidedDelegationConnectorEditPart.VISUAL_ID:
			return ProvidedDelegationConnector_4006;
		}
		return null;
	}

}