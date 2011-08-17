/*
 *by SDQ, IPD, U Karlrsuhe (TH), 2006
 */
package de.uka.ipd.sdq.pcm.gmf.system.providers;

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
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;

import de.uka.ipd.sdq.pcm.gmf.system.part.SystemDiagramEditorPlugin;

import de.uka.ipd.sdq.pcm.system.SystemPackage;

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
				return SystemDiagramEditorPlugin.getInstance()
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
			elements.put(System_79, SystemPackage.eINSTANCE.getSystem());
			elements.put(AssemblyContext_1001, CompositionPackage.eINSTANCE
					.getAssemblyContext());
			elements.put(SystemProvidedRole_1002, SystemPackage.eINSTANCE
					.getSystemProvidedRole());
			elements.put(SystemRequiredRole_1003, SystemPackage.eINSTANCE
					.getSystemRequiredRole());
			elements.put(AssemblyConnector_3001, CompositionPackage.eINSTANCE
					.getAssemblyConnector());
			elements.put(ProvidedDelegationConnector_3002,
					CompositionPackage.eINSTANCE
							.getProvidedDelegationConnector());
			elements.put(RequiredDelegationConnector_3003,
					CompositionPackage.eINSTANCE
							.getRequiredDelegationConnector());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	public static final IElementType System_79 = getElementType("de.uka.ipd.sdq.pcm.gmf.system.System_79"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Node_2001 = getElementType("de.uka.ipd.sdq.pcm.gmf.system.Node_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Node_2002 = getElementType("de.uka.ipd.sdq.pcm.gmf.system.Node_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AssemblyContext_1001 = getElementType("de.uka.ipd.sdq.pcm.gmf.system.AssemblyContext_1001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SystemProvidedRole_1002 = getElementType("de.uka.ipd.sdq.pcm.gmf.system.SystemProvidedRole_1002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SystemRequiredRole_1003 = getElementType("de.uka.ipd.sdq.pcm.gmf.system.SystemRequiredRole_1003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AssemblyConnector_3001 = getElementType("de.uka.ipd.sdq.pcm.gmf.system.AssemblyConnector_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ProvidedDelegationConnector_3002 = getElementType("de.uka.ipd.sdq.pcm.gmf.system.ProvidedDelegationConnector_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RequiredDelegationConnector_3003 = getElementType("de.uka.ipd.sdq.pcm.gmf.system.RequiredDelegationConnector_3003"); //$NON-NLS-1$

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
			KNOWN_ELEMENT_TYPES.add(System_79);
			KNOWN_ELEMENT_TYPES.add(Node_2001);
			KNOWN_ELEMENT_TYPES.add(Node_2002);
			KNOWN_ELEMENT_TYPES.add(AssemblyContext_1001);
			KNOWN_ELEMENT_TYPES.add(SystemProvidedRole_1002);
			KNOWN_ELEMENT_TYPES.add(SystemRequiredRole_1003);
			KNOWN_ELEMENT_TYPES.add(AssemblyConnector_3001);
			KNOWN_ELEMENT_TYPES.add(ProvidedDelegationConnector_3002);
			KNOWN_ELEMENT_TYPES.add(RequiredDelegationConnector_3003);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}
}
