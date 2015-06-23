/*
 * Copyright 2009, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.resource.providers;

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

import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.CommunicationLinkResourceSpecificationEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.LinkingResourceConnectedResourceContainers_LinkingResourceEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.LinkingResourceEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ProcessingResourceSpecificationEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ResourceContainer2EditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ResourceContainerEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ResourceEnvironmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.part.PalladioComponentModelDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

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
    private static Map<IElementType, ENamedElement> elements;

    /**
     * @generated
     */
    private static ImageRegistry imageRegistry;

    /**
     * @generated
     */
    private static Set<IElementType> KNOWN_ELEMENT_TYPES;

    /**
     * @generated
     */
    public static final IElementType ResourceEnvironment_1000 = getElementType("de.uka.ipd.sdq.pcm.gmf.resource.ResourceEnvironment_1000"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType ResourceContainer_2004 = getElementType("de.uka.ipd.sdq.pcm.gmf.resource.ResourceContainer_2004"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IElementType LinkingResource_2005 = getElementType("de.uka.ipd.sdq.pcm.gmf.resource.LinkingResource_2005"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IElementType ProcessingResourceSpecification_3003 = getElementType("de.uka.ipd.sdq.pcm.gmf.resource.ProcessingResourceSpecification_3003"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IElementType ResourceContainer_3005 = getElementType("de.uka.ipd.sdq.pcm.gmf.resource.ResourceContainer_3005"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IElementType CommunicationLinkResourceSpecification_3004 = getElementType("de.uka.ipd.sdq.pcm.gmf.resource.CommunicationLinkResourceSpecification_3004"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IElementType LinkingResourceConnectedResourceContainers_LinkingResource_4003 = getElementType("de.uka.ipd.sdq.pcm.gmf.resource.LinkingResourceConnectedResourceContainers_LinkingResource_4003"); //$NON-NLS-1$

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
    private static ImageDescriptor getProvidedImageDescriptor(ENamedElement element) {
        if (element instanceof EStructuralFeature) {
            EStructuralFeature feature = ((EStructuralFeature) element);
            EClass eContainingClass = feature.getEContainingClass();
            EClassifier eType = feature.getEType();
            if (eContainingClass != null && !eContainingClass.isAbstract()) {
                element = eContainingClass;
            } else if (eType instanceof EClass && !((EClass) eType).isAbstract()) {
                element = eType;
            }
        }
        if (element instanceof EClass) {
            EClass eClass = (EClass) element;
            if (!eClass.isAbstract()) {
                return PalladioComponentModelDiagramEditorPlugin.getInstance().getItemImageDescriptor(
                        eClass.getEPackage().getEFactoryInstance().create(eClass));
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
     * @generated
     */
    public static ENamedElement getElement(IAdaptable hint) {
        Object type = hint.getAdapter(IElementType.class);
        if (elements == null) {
            elements = new IdentityHashMap<IElementType, ENamedElement>();

            elements.put(ResourceEnvironment_1000, ResourceenvironmentPackage.eINSTANCE.getResourceEnvironment());

            elements.put(ResourceContainer_2004, ResourceenvironmentPackage.eINSTANCE.getResourceContainer());

            elements.put(LinkingResource_2005, ResourceenvironmentPackage.eINSTANCE.getLinkingResource());

            elements.put(ProcessingResourceSpecification_3003,
                    ResourceenvironmentPackage.eINSTANCE.getProcessingResourceSpecification());

            elements.put(ResourceContainer_3005, ResourceenvironmentPackage.eINSTANCE.getResourceContainer());

            elements.put(CommunicationLinkResourceSpecification_3004,
                    ResourceenvironmentPackage.eINSTANCE.getCommunicationLinkResourceSpecification());

            elements.put(LinkingResourceConnectedResourceContainers_LinkingResource_4003,
                    ResourceenvironmentPackage.eINSTANCE
                            .getLinkingResource_ConnectedResourceContainers_LinkingResource());
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
            KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
            KNOWN_ELEMENT_TYPES.add(ResourceEnvironment_1000);
            KNOWN_ELEMENT_TYPES.add(ResourceContainer_2004);
            KNOWN_ELEMENT_TYPES.add(LinkingResource_2005);
            KNOWN_ELEMENT_TYPES.add(ProcessingResourceSpecification_3003);
            KNOWN_ELEMENT_TYPES.add(ResourceContainer_3005);
            KNOWN_ELEMENT_TYPES.add(CommunicationLinkResourceSpecification_3004);
            KNOWN_ELEMENT_TYPES.add(LinkingResourceConnectedResourceContainers_LinkingResource_4003);
        }
        return KNOWN_ELEMENT_TYPES.contains(elementType);
    }

    /**
     * @generated
     */
    public static IElementType getElementType(int visualID) {
        switch (visualID) {
        case ResourceEnvironmentEditPart.VISUAL_ID:
            return ResourceEnvironment_1000;
        case ResourceContainerEditPart.VISUAL_ID:
            return ResourceContainer_2004;
        case LinkingResourceEditPart.VISUAL_ID:
            return LinkingResource_2005;
        case ProcessingResourceSpecificationEditPart.VISUAL_ID:
            return ProcessingResourceSpecification_3003;
        case ResourceContainer2EditPart.VISUAL_ID:
            return ResourceContainer_3005;
        case CommunicationLinkResourceSpecificationEditPart.VISUAL_ID:
            return CommunicationLinkResourceSpecification_3004;
        case LinkingResourceConnectedResourceContainers_LinkingResourceEditPart.VISUAL_ID:
            return LinkingResourceConnectedResourceContainers_LinkingResource_4003;
        }
        return null;
    }

}
