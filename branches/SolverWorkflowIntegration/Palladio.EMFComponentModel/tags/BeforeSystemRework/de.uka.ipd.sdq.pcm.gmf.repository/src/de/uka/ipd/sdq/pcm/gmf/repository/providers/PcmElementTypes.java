/*
 *Copyright 2006 Institute for Software-Design and Quality, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.repository.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import de.uka.ipd.sdq.pcm.gmf.repository.part.RepositoryDiagramEditorPlugin;

import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * @generated
 */
public class PcmElementTypes {

	/**
	 * @generated
	 */
	private PcmElementTypes() {
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
			element = ((EStructuralFeature) element).getEContainingClass();
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return RepositoryDiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
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
			elements.put(Repository_79, RepositoryPackage.eINSTANCE
					.getRepository());
			elements.put(Signature_2001, RepositoryPackage.eINSTANCE
					.getSignature());
			elements.put(ResourceDemandingSEFF_2002, SeffPackage.eINSTANCE
					.getResourceDemandingSEFF());
			elements.put(Interface_1001, RepositoryPackage.eINSTANCE
					.getInterface());
			elements.put(BasicComponent_1002, RepositoryPackage.eINSTANCE
					.getBasicComponent());
			elements.put(ProvidedRole_3001, RepositoryPackage.eINSTANCE
					.getProvidedRole());
			elements.put(RequiredRole_3002, RepositoryPackage.eINSTANCE
					.getRequiredRole());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	public static final IElementType Repository_79 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.Repository_79"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Signature_2001 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.Signature_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ResourceDemandingSEFF_2002 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.ResourceDemandingSEFF_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Interface_1001 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.Interface_1001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType BasicComponent_1002 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.BasicComponent_1002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ProvidedRole_3001 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.ProvidedRole_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RequiredRole_3002 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.RequiredRole_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(Repository_79);
			KNOWN_ELEMENT_TYPES.add(Signature_2001);
			KNOWN_ELEMENT_TYPES.add(ResourceDemandingSEFF_2002);
			KNOWN_ELEMENT_TYPES.add(Interface_1001);
			KNOWN_ELEMENT_TYPES.add(BasicComponent_1002);
			KNOWN_ELEMENT_TYPES.add(ProvidedRole_3001);
			KNOWN_ELEMENT_TYPES.add(RequiredRole_3002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}
}
