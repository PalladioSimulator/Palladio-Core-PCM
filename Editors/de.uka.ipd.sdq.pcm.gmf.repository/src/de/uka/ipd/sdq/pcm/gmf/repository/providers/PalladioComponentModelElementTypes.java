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
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.EventGroupEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.EventTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ImplementationComponentTypeParentCompleteComponentTypesEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureInterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureSignatureEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceParentInterfaces__InterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationInterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationSignatureEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.PassiveResourceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesComponentTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RepositoryEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SinkRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SourceRoleEditPart;
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
    public static final IElementType Repository_1000 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.Repository_1000"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IElementType OperationInterface_2107 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.OperationInterface_2107"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IElementType EventGroup_2108 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.EventGroup_2108"); //$NON-NLS-1$

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
    public static final IElementType InfrastructureInterface_2109 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.InfrastructureInterface_2109"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IElementType OperationSignature_3106 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.OperationSignature_3106"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IElementType EventType_3107 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.EventType_3107"); //$NON-NLS-1$

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
    public static final IElementType InfrastructureSignature_3108 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.InfrastructureSignature_3108"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IElementType OperationProvidedRole_4105 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.OperationProvidedRole_4105"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IElementType InfrastructureProvidedRole_4111 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.InfrastructureProvidedRole_4111"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IElementType InfrastructureRequiredRole_4112 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.InfrastructureRequiredRole_4112"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IElementType SinkRole_4109 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.SinkRole_4109"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IElementType OperationRequiredRole_4106 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.OperationRequiredRole_4106"); //$NON-NLS-1$

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
    public static final IElementType SourceRole_4110 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.SourceRole_4110"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IElementType InterfaceParentInterfaces__Interface_4113 = getElementType("de.uka.ipd.sdq.pcm.gmf.repository.InterfaceParentInterfaces__Interface_4113"); //$NON-NLS-1$

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
                return PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().getItemImageDescriptor(
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
     * Returns 'type' of the ecore object associated with the hint.
     * 
     * @generated
     */
    public static ENamedElement getElement(IAdaptable hint) {
        Object type = hint.getAdapter(IElementType.class);
        if (elements == null) {
            elements = new IdentityHashMap<IElementType, ENamedElement>();

            elements.put(Repository_1000, RepositoryPackage.eINSTANCE.getRepository());

            elements.put(OperationInterface_2107, RepositoryPackage.eINSTANCE.getOperationInterface());

            elements.put(EventGroup_2108, RepositoryPackage.eINSTANCE.getEventGroup());

            elements.put(BasicComponent_2102, RepositoryPackage.eINSTANCE.getBasicComponent());

            elements.put(CompositeComponent_2103, RepositoryPackage.eINSTANCE.getCompositeComponent());

            elements.put(CompleteComponentType_2104, RepositoryPackage.eINSTANCE.getCompleteComponentType());

            elements.put(ProvidesComponentType_2105, RepositoryPackage.eINSTANCE.getProvidesComponentType());

            elements.put(SubSystem_2106, SubsystemPackage.eINSTANCE.getSubSystem());

            elements.put(InfrastructureInterface_2109, RepositoryPackage.eINSTANCE.getInfrastructureInterface());

            elements.put(OperationSignature_3106, RepositoryPackage.eINSTANCE.getOperationSignature());

            elements.put(EventType_3107, RepositoryPackage.eINSTANCE.getEventType());

            elements.put(ResourceDemandingSEFF_3102, SeffPackage.eINSTANCE.getResourceDemandingSEFF());

            elements.put(PassiveResource_3103, RepositoryPackage.eINSTANCE.getPassiveResource());

            elements.put(VariableUsage_3104, ParameterPackage.eINSTANCE.getVariableUsage());

            elements.put(VariableCharacterisation_3105, ParameterPackage.eINSTANCE.getVariableCharacterisation());

            elements.put(InfrastructureSignature_3108, RepositoryPackage.eINSTANCE.getInfrastructureSignature());

            elements.put(OperationProvidedRole_4105, RepositoryPackage.eINSTANCE.getOperationProvidedRole());

            elements.put(InfrastructureProvidedRole_4111, RepositoryPackage.eINSTANCE.getInfrastructureProvidedRole());

            elements.put(InfrastructureRequiredRole_4112, RepositoryPackage.eINSTANCE.getInfrastructureRequiredRole());

            elements.put(SinkRole_4109, RepositoryPackage.eINSTANCE.getSinkRole());

            elements.put(OperationRequiredRole_4106, RepositoryPackage.eINSTANCE.getOperationRequiredRole());

            elements.put(ImplementationComponentTypeParentCompleteComponentTypes_4103,
                    RepositoryPackage.eINSTANCE.getImplementationComponentType_ParentCompleteComponentTypes());

            elements.put(CompleteComponentTypeParentProvidesComponentTypes_4104,
                    RepositoryPackage.eINSTANCE.getCompleteComponentType_ParentProvidesComponentTypes());

            elements.put(SourceRole_4110, RepositoryPackage.eINSTANCE.getSourceRole());

            elements.put(InterfaceParentInterfaces__Interface_4113,
                    RepositoryPackage.eINSTANCE.getInterface_ParentInterfaces__Interface());
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
            KNOWN_ELEMENT_TYPES.add(Repository_1000);
            KNOWN_ELEMENT_TYPES.add(OperationInterface_2107);
            KNOWN_ELEMENT_TYPES.add(EventGroup_2108);
            KNOWN_ELEMENT_TYPES.add(BasicComponent_2102);
            KNOWN_ELEMENT_TYPES.add(CompositeComponent_2103);
            KNOWN_ELEMENT_TYPES.add(CompleteComponentType_2104);
            KNOWN_ELEMENT_TYPES.add(ProvidesComponentType_2105);
            KNOWN_ELEMENT_TYPES.add(SubSystem_2106);
            KNOWN_ELEMENT_TYPES.add(InfrastructureInterface_2109);
            KNOWN_ELEMENT_TYPES.add(OperationSignature_3106);
            KNOWN_ELEMENT_TYPES.add(EventType_3107);
            KNOWN_ELEMENT_TYPES.add(ResourceDemandingSEFF_3102);
            KNOWN_ELEMENT_TYPES.add(PassiveResource_3103);
            KNOWN_ELEMENT_TYPES.add(VariableUsage_3104);
            KNOWN_ELEMENT_TYPES.add(VariableCharacterisation_3105);
            KNOWN_ELEMENT_TYPES.add(InfrastructureSignature_3108);
            KNOWN_ELEMENT_TYPES.add(OperationProvidedRole_4105);
            KNOWN_ELEMENT_TYPES.add(InfrastructureProvidedRole_4111);
            KNOWN_ELEMENT_TYPES.add(InfrastructureRequiredRole_4112);
            KNOWN_ELEMENT_TYPES.add(SinkRole_4109);
            KNOWN_ELEMENT_TYPES.add(OperationRequiredRole_4106);
            KNOWN_ELEMENT_TYPES.add(ImplementationComponentTypeParentCompleteComponentTypes_4103);
            KNOWN_ELEMENT_TYPES.add(CompleteComponentTypeParentProvidesComponentTypes_4104);
            KNOWN_ELEMENT_TYPES.add(SourceRole_4110);
            KNOWN_ELEMENT_TYPES.add(InterfaceParentInterfaces__Interface_4113);
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
        case OperationInterfaceEditPart.VISUAL_ID:
            return OperationInterface_2107;
        case EventGroupEditPart.VISUAL_ID:
            return EventGroup_2108;
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
        case InfrastructureInterfaceEditPart.VISUAL_ID:
            return InfrastructureInterface_2109;
        case OperationSignatureEditPart.VISUAL_ID:
            return OperationSignature_3106;
        case EventTypeEditPart.VISUAL_ID:
            return EventType_3107;
        case ResourceDemandingSEFFEditPart.VISUAL_ID:
            return ResourceDemandingSEFF_3102;
        case PassiveResourceEditPart.VISUAL_ID:
            return PassiveResource_3103;
        case VariableUsageEditPart.VISUAL_ID:
            return VariableUsage_3104;
        case VariableCharacterisationEditPart.VISUAL_ID:
            return VariableCharacterisation_3105;
        case InfrastructureSignatureEditPart.VISUAL_ID:
            return InfrastructureSignature_3108;
        case OperationProvidedRoleEditPart.VISUAL_ID:
            return OperationProvidedRole_4105;
        case InfrastructureProvidedRoleEditPart.VISUAL_ID:
            return InfrastructureProvidedRole_4111;
        case InfrastructureRequiredRoleEditPart.VISUAL_ID:
            return InfrastructureRequiredRole_4112;
        case SinkRoleEditPart.VISUAL_ID:
            return SinkRole_4109;
        case OperationRequiredRoleEditPart.VISUAL_ID:
            return OperationRequiredRole_4106;
        case ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID:
            return ImplementationComponentTypeParentCompleteComponentTypes_4103;
        case CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID:
            return CompleteComponentTypeParentProvidesComponentTypes_4104;
        case SourceRoleEditPart.VISUAL_ID:
            return SourceRole_4110;
        case InterfaceParentInterfaces__InterfaceEditPart.VISUAL_ID:
            return InterfaceParentInterfaces__Interface_4113;
        }
        return null;
    }

}
