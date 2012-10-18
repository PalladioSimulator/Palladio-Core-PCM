/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.providers;

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

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.AbstractUserActionSuccessorEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.DelayEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.EntryLevelSystemCallEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.LoopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.OpenWorkloadEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviour3EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StartEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenario2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelUsageDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

/**
 * The Class PalladioComponentModelElementTypes.
 *
 * @generated
 */
public class PalladioComponentModelElementTypes extends ElementInitializers {

    /**
     * Instantiates a new palladio component model element types.
     *
     * @generated
     */
    private PalladioComponentModelElementTypes() {
    }

    /** The elements. @generated */
    private static Map elements;

    /** The image registry. @generated */
    private static ImageRegistry imageRegistry;

    /** The known element types. @generated */
    private static Set KNOWN_ELEMENT_TYPES;

    /** The Constant UsageModel_1000. @generated */
    public static final IElementType UsageModel_1000 = getElementType("de.uka.ipd.sdq.pcm.gmf.usage.UsageModel_1000"); //$NON-NLS-1$

    /** The Constant UsageScenario_2004. @generated */
    public static final IElementType UsageScenario_2004 = getElementType("de.uka.ipd.sdq.pcm.gmf.usage.UsageScenario_2004"); //$NON-NLS-1$

    /** The Constant ScenarioBehaviour_3014. @generated */
    public static final IElementType ScenarioBehaviour_3014 = getElementType("de.uka.ipd.sdq.pcm.gmf.usage.ScenarioBehaviour_3014"); //$NON-NLS-1$

    /** The Constant Start_3001. @generated */
    public static final IElementType Start_3001 = getElementType("de.uka.ipd.sdq.pcm.gmf.usage.Start_3001"); //$NON-NLS-1$

    /** The Constant Stop_3002. @generated */
    public static final IElementType Stop_3002 = getElementType("de.uka.ipd.sdq.pcm.gmf.usage.Stop_3002"); //$NON-NLS-1$

    /** The Constant EntryLevelSystemCall_3003. @generated */
    public static final IElementType EntryLevelSystemCall_3003 = getElementType("de.uka.ipd.sdq.pcm.gmf.usage.EntryLevelSystemCall_3003"); //$NON-NLS-1$

    /** The Constant VariableUsage_3012. @generated */
    public static final IElementType VariableUsage_3012 = getElementType("de.uka.ipd.sdq.pcm.gmf.usage.VariableUsage_3012"); //$NON-NLS-1$

    /** The Constant VariableCharacterisation_3013. @generated */
    public static final IElementType VariableCharacterisation_3013 = getElementType("de.uka.ipd.sdq.pcm.gmf.usage.VariableCharacterisation_3013"); //$NON-NLS-1$

    /** The Constant Loop_3005. @generated */
    public static final IElementType Loop_3005 = getElementType("de.uka.ipd.sdq.pcm.gmf.usage.Loop_3005"); //$NON-NLS-1$

    /** The Constant ScenarioBehaviour_3007. @generated */
    public static final IElementType ScenarioBehaviour_3007 = getElementType("de.uka.ipd.sdq.pcm.gmf.usage.ScenarioBehaviour_3007"); //$NON-NLS-1$

    /** The Constant Branch_3008. @generated */
    public static final IElementType Branch_3008 = getElementType("de.uka.ipd.sdq.pcm.gmf.usage.Branch_3008"); //$NON-NLS-1$

    /** The Constant BranchTransition_3009. @generated */
    public static final IElementType BranchTransition_3009 = getElementType("de.uka.ipd.sdq.pcm.gmf.usage.BranchTransition_3009"); //$NON-NLS-1$

    /** The Constant ScenarioBehaviour_3010. @generated */
    public static final IElementType ScenarioBehaviour_3010 = getElementType("de.uka.ipd.sdq.pcm.gmf.usage.ScenarioBehaviour_3010"); //$NON-NLS-1$

    /** The Constant Delay_3017. @generated */
    public static final IElementType Delay_3017 = getElementType("de.uka.ipd.sdq.pcm.gmf.usage.Delay_3017"); //$NON-NLS-1$

    /** The Constant ClosedWorkload_3015. @generated */
    public static final IElementType ClosedWorkload_3015 = getElementType("de.uka.ipd.sdq.pcm.gmf.usage.ClosedWorkload_3015"); //$NON-NLS-1$

    /** The Constant OpenWorkload_3016. @generated */
    public static final IElementType OpenWorkload_3016 = getElementType("de.uka.ipd.sdq.pcm.gmf.usage.OpenWorkload_3016"); //$NON-NLS-1$

    /** The Constant AbstractUserActionSuccessor_4002. @generated */
    public static final IElementType AbstractUserActionSuccessor_4002 = getElementType("de.uka.ipd.sdq.pcm.gmf.usage.AbstractUserActionSuccessor_4002"); //$NON-NLS-1$

    /**
     * Gets the image registry.
     *
     * @return the image registry
     * @generated
     */
    private static ImageRegistry getImageRegistry() {
        if (imageRegistry == null) {
            imageRegistry = new ImageRegistry();
        }
        return imageRegistry;
    }

    /**
     * Gets the image registry key.
     *
     * @param element the element
     * @return the image registry key
     * @generated
     */
    private static String getImageRegistryKey(ENamedElement element) {
        return element.getName();
    }

    /**
     * Gets the provided image descriptor.
     *
     * @param element the element
     * @return the provided image descriptor
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
                return PalladioComponentModelUsageDiagramEditorPlugin.getInstance().getItemImageDescriptor(
                        eClass.getEPackage().getEFactoryInstance().create(eClass));
            }
        }
        // TODO : support structural features
        return null;
    }

    /**
     * Gets the image descriptor.
     *
     * @param element the element
     * @return the image descriptor
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
     * Gets the image.
     *
     * @param element the element
     * @return the image
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
     * Gets the image descriptor.
     *
     * @param hint the hint
     * @return the image descriptor
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
     * Gets the image.
     *
     * @param hint the hint
     * @return the image
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
     * @param hint the hint
     * @return the element
     * @generated
     */
    public static ENamedElement getElement(IAdaptable hint) {
        Object type = hint.getAdapter(IElementType.class);
        if (elements == null) {
            elements = new IdentityHashMap();

            elements.put(UsageModel_1000, UsagemodelPackage.eINSTANCE.getUsageModel());

            elements.put(UsageScenario_2004, UsagemodelPackage.eINSTANCE.getUsageScenario());

            elements.put(ScenarioBehaviour_3014, UsagemodelPackage.eINSTANCE.getScenarioBehaviour());

            elements.put(Start_3001, UsagemodelPackage.eINSTANCE.getStart());

            elements.put(Stop_3002, UsagemodelPackage.eINSTANCE.getStop());

            elements.put(EntryLevelSystemCall_3003, UsagemodelPackage.eINSTANCE.getEntryLevelSystemCall());

            elements.put(VariableUsage_3012, ParameterPackage.eINSTANCE.getVariableUsage());

            elements.put(VariableCharacterisation_3013, ParameterPackage.eINSTANCE.getVariableCharacterisation());

            elements.put(Loop_3005, UsagemodelPackage.eINSTANCE.getLoop());

            elements.put(ScenarioBehaviour_3007, UsagemodelPackage.eINSTANCE.getScenarioBehaviour());

            elements.put(Branch_3008, UsagemodelPackage.eINSTANCE.getBranch());

            elements.put(BranchTransition_3009, UsagemodelPackage.eINSTANCE.getBranchTransition());

            elements.put(ScenarioBehaviour_3010, UsagemodelPackage.eINSTANCE.getScenarioBehaviour());

            elements.put(Delay_3017, UsagemodelPackage.eINSTANCE.getDelay());

            elements.put(ClosedWorkload_3015, UsagemodelPackage.eINSTANCE.getClosedWorkload());

            elements.put(OpenWorkload_3016, UsagemodelPackage.eINSTANCE.getOpenWorkload());

            elements.put(AbstractUserActionSuccessor_4002,
                    UsagemodelPackage.eINSTANCE.getAbstractUserAction_Successor());
        }
        return (ENamedElement) elements.get(type);
    }

    /**
     * Gets the element type.
     *
     * @param id the id
     * @return the element type
     * @generated
     */
    private static IElementType getElementType(String id) {
        return ElementTypeRegistry.getInstance().getType(id);
    }

    /**
     * Checks if is known element type.
     *
     * @param elementType the element type
     * @return true, if is known element type
     * @generated
     */
    public static boolean isKnownElementType(IElementType elementType) {
        if (KNOWN_ELEMENT_TYPES == null) {
            KNOWN_ELEMENT_TYPES = new HashSet();
            KNOWN_ELEMENT_TYPES.add(UsageModel_1000);
            KNOWN_ELEMENT_TYPES.add(UsageScenario_2004);
            KNOWN_ELEMENT_TYPES.add(ScenarioBehaviour_3014);
            KNOWN_ELEMENT_TYPES.add(Start_3001);
            KNOWN_ELEMENT_TYPES.add(Stop_3002);
            KNOWN_ELEMENT_TYPES.add(EntryLevelSystemCall_3003);
            KNOWN_ELEMENT_TYPES.add(VariableUsage_3012);
            KNOWN_ELEMENT_TYPES.add(VariableCharacterisation_3013);
            KNOWN_ELEMENT_TYPES.add(Loop_3005);
            KNOWN_ELEMENT_TYPES.add(ScenarioBehaviour_3007);
            KNOWN_ELEMENT_TYPES.add(Branch_3008);
            KNOWN_ELEMENT_TYPES.add(BranchTransition_3009);
            KNOWN_ELEMENT_TYPES.add(ScenarioBehaviour_3010);
            KNOWN_ELEMENT_TYPES.add(Delay_3017);
            KNOWN_ELEMENT_TYPES.add(ClosedWorkload_3015);
            KNOWN_ELEMENT_TYPES.add(OpenWorkload_3016);
            KNOWN_ELEMENT_TYPES.add(AbstractUserActionSuccessor_4002);
        }
        return KNOWN_ELEMENT_TYPES.contains(elementType);
    }

    /**
     * Gets the element type.
     *
     * @param visualID the visual id
     * @return the element type
     * @generated
     */
    public static IElementType getElementType(int visualID) {
        switch (visualID) {
        case UsageScenarioEditPart.VISUAL_ID:
            return UsageModel_1000;
        case UsageScenario2EditPart.VISUAL_ID:
            return UsageScenario_2004;
        case ScenarioBehaviourEditPart.VISUAL_ID:
            return ScenarioBehaviour_3014;
        case StartEditPart.VISUAL_ID:
            return Start_3001;
        case StopEditPart.VISUAL_ID:
            return Stop_3002;
        case EntryLevelSystemCallEditPart.VISUAL_ID:
            return EntryLevelSystemCall_3003;
        case VariableUsageEditPart.VISUAL_ID:
            return VariableUsage_3012;
        case VariableCharacterisationEditPart.VISUAL_ID:
            return VariableCharacterisation_3013;
        case LoopEditPart.VISUAL_ID:
            return Loop_3005;
        case ScenarioBehaviour2EditPart.VISUAL_ID:
            return ScenarioBehaviour_3007;
        case BranchEditPart.VISUAL_ID:
            return Branch_3008;
        case BranchTransitionEditPart.VISUAL_ID:
            return BranchTransition_3009;
        case ScenarioBehaviour3EditPart.VISUAL_ID:
            return ScenarioBehaviour_3010;
        case DelayEditPart.VISUAL_ID:
            return Delay_3017;
        case ClosedWorkloadEditPart.VISUAL_ID:
            return ClosedWorkload_3015;
        case OpenWorkloadEditPart.VISUAL_ID:
            return OpenWorkload_3016;
        case AbstractUserActionSuccessorEditPart.VISUAL_ID:
            return AbstractUserActionSuccessor_4002;
        }
        return null;
    }

}
