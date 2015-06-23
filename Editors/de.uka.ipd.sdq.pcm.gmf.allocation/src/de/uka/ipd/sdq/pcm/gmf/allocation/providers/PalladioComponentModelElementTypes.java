/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.providers;

/**
 * @generated
 */
public class PalladioComponentModelElementTypes {

		/**
 * @generated
 */
private PalladioComponentModelElementTypes() {
}
	
		/**
 * @generated
 */
private static java.util.Map<org.eclipse.gmf.runtime.emf.type.core.IElementType, org.eclipse.emf.ecore.ENamedElement> elements;

	/**
 * @generated
 */
private static org.eclipse.jface.resource.ImageRegistry imageRegistry;

	/**
 * @generated
 */
private static java.util.Set<org.eclipse.gmf.runtime.emf.type.core.IElementType> KNOWN_ELEMENT_TYPES;
	
				/**
 * @generated
 */
public static final org.eclipse.gmf.runtime.emf.type.core.IElementType Allocation_1000 = getElementType("de.uka.ipd.sdq.pcm.gmf.allocation.Allocation_1000");  //$NON-NLS-1$
				/**
 * @generated
 */
public static final org.eclipse.gmf.runtime.emf.type.core.IElementType ResourceContainer_2003 = getElementType("de.uka.ipd.sdq.pcm.gmf.allocation.ResourceContainer_2003");  //$NON-NLS-1$
				/**
 * @generated
 */
public static final org.eclipse.gmf.runtime.emf.type.core.IElementType AllocationContext_3002 = getElementType("de.uka.ipd.sdq.pcm.gmf.allocation.AllocationContext_3002");  //$NON-NLS-1$
		
		/**
 * @generated
 */
private static org.eclipse.jface.resource.ImageRegistry getImageRegistry() {
	if (imageRegistry == null) {
		imageRegistry = new org.eclipse.jface.resource.ImageRegistry();
	}
	return imageRegistry;
}

		/**
 * @generated
 */
private static String getImageRegistryKey(org.eclipse.emf.ecore.ENamedElement element) {
	return element.getName();
}

		/**
 * @generated
 */
private static org.eclipse.jface.resource.ImageDescriptor getProvidedImageDescriptor(org.eclipse.emf.ecore.ENamedElement element) {
	if (element instanceof org.eclipse.emf.ecore.EStructuralFeature) {
		org.eclipse.emf.ecore.EStructuralFeature feature = ((org.eclipse.emf.ecore.EStructuralFeature) element);
		org.eclipse.emf.ecore.EClass eContainingClass = feature.getEContainingClass();
		org.eclipse.emf.ecore.EClassifier eType = feature.getEType();
		if (eContainingClass != null && !eContainingClass.isAbstract()){
			element = eContainingClass;
		} else if (eType instanceof org.eclipse.emf.ecore.EClass && !((org.eclipse.emf.ecore.EClass)eType).isAbstract()){
			element = eType;
		}
	}
	if (element instanceof org.eclipse.emf.ecore.EClass) {
		org.eclipse.emf.ecore.EClass eClass = (org.eclipse.emf.ecore.EClass) element;
		if (!eClass.isAbstract()) {
			return de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.getInstance().getItemImageDescriptor(
				eClass.getEPackage().getEFactoryInstance().create(eClass));
		}
	}
	// TODO : support structural features
	return null;
}

		/**
 * @generated
 */
public static org.eclipse.jface.resource.ImageDescriptor getImageDescriptor(org.eclipse.emf.ecore.ENamedElement element) {
	String key = getImageRegistryKey(element);
	org.eclipse.jface.resource.ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
	if (imageDescriptor == null) {
		imageDescriptor = getProvidedImageDescriptor(element);
if (imageDescriptor == null) {
	imageDescriptor = org.eclipse.jface.resource.ImageDescriptor.getMissingImageDescriptor();
}
getImageRegistry().put(key, imageDescriptor);
	}
	return imageDescriptor;
}

		/**
 * @generated
 */
public static org.eclipse.swt.graphics.Image getImage(org.eclipse.emf.ecore.ENamedElement element) {
	String key = getImageRegistryKey(element);
	org.eclipse.swt.graphics.Image image = getImageRegistry().get(key);
	if (image == null) {
		org.eclipse.jface.resource.ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
if (imageDescriptor == null) {
	imageDescriptor = org.eclipse.jface.resource.ImageDescriptor.getMissingImageDescriptor();
}
getImageRegistry().put(key, imageDescriptor);
		image = getImageRegistry().get(key);
	}
	return image;
}

		/**
 * @generated
 */
public static org.eclipse.jface.resource.ImageDescriptor getImageDescriptor(org.eclipse.core.runtime.IAdaptable hint) {
	org.eclipse.emf.ecore.ENamedElement element = getElement(hint);
if (element == null) {
	return null;
}
	return getImageDescriptor(element);
}

		/**
 * @generated
 */
public static org.eclipse.swt.graphics.Image getImage(org.eclipse.core.runtime.IAdaptable hint) {
	org.eclipse.emf.ecore.ENamedElement element = getElement(hint);
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
public static org.eclipse.emf.ecore.ENamedElement getElement(org.eclipse.core.runtime.IAdaptable hint) {
	Object type = hint.getAdapter(org.eclipse.gmf.runtime.emf.type.core.IElementType.class);
	if (elements == null) {
		elements = new java.util.IdentityHashMap<org.eclipse.gmf.runtime.emf.type.core.IElementType, org.eclipse.emf.ecore.ENamedElement>();
		
	elements.put(Allocation_1000, org.palladiosimulator.pcm.allocation.AllocationPackage.eINSTANCE.getAllocation());
					
	
	elements.put(ResourceContainer_2003, org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage.eINSTANCE.getResourceContainer());
					
	
	elements.put(AllocationContext_3002, org.palladiosimulator.pcm.allocation.AllocationPackage.eINSTANCE.getAllocationContext());
					}
	return (org.eclipse.emf.ecore.ENamedElement) elements.get(type);
}

		/**
 * @generated
 */
private static org.eclipse.gmf.runtime.emf.type.core.IElementType getElementType(String id) {
	return org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry.getInstance().getType(id);
}

		/**
 * @generated
 */
public static boolean isKnownElementType(org.eclipse.gmf.runtime.emf.type.core.IElementType elementType) {
	if (KNOWN_ELEMENT_TYPES == null) {
		KNOWN_ELEMENT_TYPES = new java.util.HashSet<org.eclipse.gmf.runtime.emf.type.core.IElementType>();
			KNOWN_ELEMENT_TYPES.add(Allocation_1000);
		KNOWN_ELEMENT_TYPES.add(ResourceContainer_2003);
		KNOWN_ELEMENT_TYPES.add(AllocationContext_3002);
		}
	return KNOWN_ELEMENT_TYPES.contains(elementType);
}
	
		/**
 * @generated
 */
	public static org.eclipse.gmf.runtime.emf.type.core.IElementType getElementType(int visualID) {
		switch (visualID) {
				case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.VISUAL_ID:		return Allocation_1000;
	case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEditPart.VISUAL_ID:		return ResourceContainer_2003;
	case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEditPart.VISUAL_ID:		return AllocationContext_3002;
		}
		return null;
	}

	}
