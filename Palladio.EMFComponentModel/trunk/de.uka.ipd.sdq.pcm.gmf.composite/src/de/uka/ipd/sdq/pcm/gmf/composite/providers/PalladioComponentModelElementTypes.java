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
	public static final IElementType ComposedProvidingRequiringEntity_2001 = getElementType("de.uka.ipd.sdq.pcm.gmf.composite.ComposedProvidingRequiringEntity_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType AssemblyContext_3002 = getElementType("de.uka.ipd.sdq.pcm.gmf.composite.AssemblyContext_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ProvidedRole_3001 = getElementType("de.uka.ipd.sdq.pcm.gmf.composite.ProvidedRole_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ProvidedRole_3003 = getElementType("de.uka.ipd.sdq.pcm.gmf.composite.ProvidedRole_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RequiredRole_3005 = getElementType("de.uka.ipd.sdq.pcm.gmf.composite.RequiredRole_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AssemblyConnector_4001 = getElementType("de.uka.ipd.sdq.pcm.gmf.composite.AssemblyConnector_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RequiredDelegationConnector_4002 = getElementType("de.uka.ipd.sdq.pcm.gmf.composite.RequiredDelegationConnector_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ProvidedDelegationConnector_4003 = getElementType("de.uka.ipd.sdq.pcm.gmf.composite.ProvidedDelegationConnector_4003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RequiredRole_3004 = getElementType("de.uka.ipd.sdq.pcm.gmf.composite.RequiredRole_3004"); //$NON-NLS-1$

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

			elements.put(ComposedProvidingRequiringEntity_2001,
					EntityPackage.eINSTANCE
							.getComposedProvidingRequiringEntity());

			elements.put(AssemblyContext_3002, CompositionPackage.eINSTANCE
					.getAssemblyContext());

			elements.put(ProvidedRole_3001, RepositoryPackage.eINSTANCE
					.getProvidedRole());

			elements.put(RequiredRole_3004, RepositoryPackage.eINSTANCE
					.getRequiredRole());

			elements.put(ProvidedRole_3003, RepositoryPackage.eINSTANCE
					.getProvidedRole());

			elements.put(RequiredRole_3005, RepositoryPackage.eINSTANCE
					.getRequiredRole());

			elements.put(AssemblyConnector_4001, CompositionPackage.eINSTANCE
					.getAssemblyConnector());

			elements.put(RequiredDelegationConnector_4002,
					CompositionPackage.eINSTANCE
							.getRequiredDelegationConnector());

			elements.put(ProvidedDelegationConnector_4003,
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
			KNOWN_ELEMENT_TYPES.add(ComposedProvidingRequiringEntity_2001);
			KNOWN_ELEMENT_TYPES.add(AssemblyContext_3002);
			KNOWN_ELEMENT_TYPES.add(ProvidedRole_3001);
			KNOWN_ELEMENT_TYPES.add(RequiredRole_3004);
			KNOWN_ELEMENT_TYPES.add(ProvidedRole_3003);
			KNOWN_ELEMENT_TYPES.add(RequiredRole_3005);
			KNOWN_ELEMENT_TYPES.add(AssemblyConnector_4001);
			KNOWN_ELEMENT_TYPES.add(RequiredDelegationConnector_4002);
			KNOWN_ELEMENT_TYPES.add(ProvidedDelegationConnector_4003);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

}
