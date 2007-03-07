package de.uka.ipd.sdq.pcm.gmf.allocation.providers;

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
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;

import de.uka.ipd.sdq.pcm.gmf.allocation.part.PcmDiagramEditorPlugin;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

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
				return PcmDiagramEditorPlugin.getInstance()
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
			elements.put(Allocation_79, AllocationPackage.eINSTANCE
					.getAllocation());
			elements.put(AllocationContext_2001, AllocationPackage.eINSTANCE
					.getAllocationContext());
			elements
					.put(ResourceContainer_1001,
							ResourceenvironmentPackage.eINSTANCE
									.getResourceContainer());
			elements.put(AllocationContext_1002, AllocationPackage.eINSTANCE
					.getAllocationContext());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	public static final IElementType Allocation_79 = getElementType("de.uka.ipd.sdq.pcm.gmf.allocation.Allocation_79"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AllocationContext_2001 = getElementType("de.uka.ipd.sdq.pcm.gmf.allocation.AllocationContext_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ResourceContainer_1001 = getElementType("de.uka.ipd.sdq.pcm.gmf.allocation.ResourceContainer_1001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AllocationContext_1002 = getElementType("de.uka.ipd.sdq.pcm.gmf.allocation.AllocationContext_1002"); //$NON-NLS-1$

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
			KNOWN_ELEMENT_TYPES.add(Allocation_79);
			KNOWN_ELEMENT_TYPES.add(AllocationContext_2001);
			KNOWN_ELEMENT_TYPES.add(ResourceContainer_1001);
			KNOWN_ELEMENT_TYPES.add(AllocationContext_1002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}
}
