/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.providers;

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

import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelSeffDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.performance.PerformancePackage;

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
	public static final IElementType ResourceDemandingSEFF_1000 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.ResourceDemandingSEFF_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType StartAction_2001 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.StartAction_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType StopAction_2002 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.StopAction_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ExternalCallAction_2003 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.ExternalCallAction_2003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType LoopAction_2004 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.LoopAction_2004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType BranchAction_2005 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.BranchAction_2005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType InternalAction_2006 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.InternalAction_2006"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType CollectionIteratorAction_2007 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.CollectionIteratorAction_2007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SetVariableAction_2008 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.SetVariableAction_2008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AcquireAction_2012 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.AcquireAction_2012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ReleaseAction_2010 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.ReleaseAction_2010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ForkAction_2011 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.ForkAction_2011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType VariableUsage_3032 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.VariableUsage_3032"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType VariableCharacterisation_3033 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.VariableCharacterisation_3033"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType VariableUsage_3034 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.VariableUsage_3034"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType VariableCharacterisation_3035 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.VariableCharacterisation_3035"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ResourceDemandingBehaviour_3003 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.ResourceDemandingBehaviour_3003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType StartAction_3004 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.StartAction_3004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType StopAction_3005 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.StopAction_3005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType LoopAction_3006 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.LoopAction_3006"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType InternalAction_3007 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.InternalAction_3007"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ParametricResourceDemand_3031 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.ParametricResourceDemand_3031"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType BranchAction_3009 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.BranchAction_3009"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ProbabilisticBranchTransition_3010 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.ProbabilisticBranchTransition_3010"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ResourceDemandingBehaviour_3011 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.ResourceDemandingBehaviour_3011"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ExternalCallAction_3012 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.ExternalCallAction_3012"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType AcquireAction_3026 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.AcquireAction_3026"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ReleaseAction_3020 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.ReleaseAction_3020"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ForkAction_3023 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.ForkAction_3023"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ForkedBehaviour_3027 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.ForkedBehaviour_3027"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType GuardedBranchTransition_3017 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.GuardedBranchTransition_3017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ResourceDemandingBehaviour_3018 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.ResourceDemandingBehaviour_3018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CollectionIteratorAction_3013 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.CollectionIteratorAction_3013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ResourceDemandingBehaviour_3014 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.ResourceDemandingBehaviour_3014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SetVariableAction_3024 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.SetVariableAction_3024"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType VariableUsage_3036 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.VariableUsage_3036"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType VariableCharacterisation_3037 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.VariableCharacterisation_3037"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AbstractActionSuccessor_AbstractAction_4001 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.AbstractActionSuccessor_AbstractAction_4001"); //$NON-NLS-1$

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
				return PalladioComponentModelSeffDiagramEditorPlugin
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

			elements.put(ResourceDemandingSEFF_1000, SeffPackage.eINSTANCE
					.getResourceDemandingSEFF());

			elements.put(StartAction_2001, SeffPackage.eINSTANCE
					.getStartAction());

			elements
					.put(StopAction_2002, SeffPackage.eINSTANCE.getStopAction());

			elements.put(ExternalCallAction_2003, SeffPackage.eINSTANCE
					.getExternalCallAction());

			elements
					.put(LoopAction_2004, SeffPackage.eINSTANCE.getLoopAction());

			elements.put(BranchAction_2005, SeffPackage.eINSTANCE
					.getBranchAction());

			elements.put(InternalAction_2006, SeffPackage.eINSTANCE
					.getInternalAction());

			elements.put(CollectionIteratorAction_2007, SeffPackage.eINSTANCE
					.getCollectionIteratorAction());

			elements.put(SetVariableAction_2008, SeffPackage.eINSTANCE
					.getSetVariableAction());

			elements.put(AcquireAction_2012, SeffPackage.eINSTANCE
					.getAcquireAction());

			elements.put(ReleaseAction_2010, SeffPackage.eINSTANCE
					.getReleaseAction());

			elements
					.put(ForkAction_2011, SeffPackage.eINSTANCE.getForkAction());

			elements.put(VariableUsage_3032, ParameterPackage.eINSTANCE
					.getVariableUsage());

			elements.put(VariableCharacterisation_3033,
					ParameterPackage.eINSTANCE.getVariableCharacterisation());

			elements.put(VariableUsage_3034, ParameterPackage.eINSTANCE
					.getVariableUsage());

			elements.put(VariableCharacterisation_3035,
					ParameterPackage.eINSTANCE.getVariableCharacterisation());

			elements.put(ResourceDemandingBehaviour_3003, SeffPackage.eINSTANCE
					.getResourceDemandingBehaviour());

			elements.put(StartAction_3004, SeffPackage.eINSTANCE
					.getStartAction());

			elements
					.put(StopAction_3005, SeffPackage.eINSTANCE.getStopAction());

			elements
					.put(LoopAction_3006, SeffPackage.eINSTANCE.getLoopAction());

			elements.put(InternalAction_3007, SeffPackage.eINSTANCE
					.getInternalAction());

			elements.put(ParametricResourceDemand_3031,
					PerformancePackage.eINSTANCE.getParametricResourceDemand());

			elements.put(BranchAction_3009, SeffPackage.eINSTANCE
					.getBranchAction());

			elements.put(ProbabilisticBranchTransition_3010,
					SeffPackage.eINSTANCE.getProbabilisticBranchTransition());

			elements.put(ResourceDemandingBehaviour_3011, SeffPackage.eINSTANCE
					.getResourceDemandingBehaviour());

			elements.put(ExternalCallAction_3012, SeffPackage.eINSTANCE
					.getExternalCallAction());

			elements.put(AcquireAction_3026, SeffPackage.eINSTANCE
					.getAcquireAction());

			elements.put(ReleaseAction_3020, SeffPackage.eINSTANCE
					.getReleaseAction());

			elements
					.put(ForkAction_3023, SeffPackage.eINSTANCE.getForkAction());

			elements.put(ForkedBehaviour_3027, SeffPackage.eINSTANCE
					.getForkedBehaviour());

			elements.put(CollectionIteratorAction_3013, SeffPackage.eINSTANCE
					.getCollectionIteratorAction());

			elements.put(ResourceDemandingBehaviour_3014, SeffPackage.eINSTANCE
					.getResourceDemandingBehaviour());

			elements.put(SetVariableAction_3024, SeffPackage.eINSTANCE
					.getSetVariableAction());

			elements.put(VariableUsage_3036, ParameterPackage.eINSTANCE
					.getVariableUsage());

			elements.put(VariableCharacterisation_3037,
					ParameterPackage.eINSTANCE.getVariableCharacterisation());

			elements.put(GuardedBranchTransition_3017, SeffPackage.eINSTANCE
					.getGuardedBranchTransition());

			elements.put(ResourceDemandingBehaviour_3018, SeffPackage.eINSTANCE
					.getResourceDemandingBehaviour());

			elements.put(AbstractActionSuccessor_AbstractAction_4001,
					SeffPackage.eINSTANCE
							.getAbstractAction_Successor_AbstractAction());
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
			KNOWN_ELEMENT_TYPES.add(ResourceDemandingSEFF_1000);
			KNOWN_ELEMENT_TYPES.add(StartAction_2001);
			KNOWN_ELEMENT_TYPES.add(StopAction_2002);
			KNOWN_ELEMENT_TYPES.add(ExternalCallAction_2003);
			KNOWN_ELEMENT_TYPES.add(LoopAction_2004);
			KNOWN_ELEMENT_TYPES.add(BranchAction_2005);
			KNOWN_ELEMENT_TYPES.add(InternalAction_2006);
			KNOWN_ELEMENT_TYPES.add(CollectionIteratorAction_2007);
			KNOWN_ELEMENT_TYPES.add(SetVariableAction_2008);
			KNOWN_ELEMENT_TYPES.add(AcquireAction_2012);
			KNOWN_ELEMENT_TYPES.add(ReleaseAction_2010);
			KNOWN_ELEMENT_TYPES.add(ForkAction_2011);
			KNOWN_ELEMENT_TYPES.add(VariableUsage_3032);
			KNOWN_ELEMENT_TYPES.add(VariableCharacterisation_3033);
			KNOWN_ELEMENT_TYPES.add(VariableUsage_3034);
			KNOWN_ELEMENT_TYPES.add(VariableCharacterisation_3035);
			KNOWN_ELEMENT_TYPES.add(ResourceDemandingBehaviour_3003);
			KNOWN_ELEMENT_TYPES.add(StartAction_3004);
			KNOWN_ELEMENT_TYPES.add(StopAction_3005);
			KNOWN_ELEMENT_TYPES.add(LoopAction_3006);
			KNOWN_ELEMENT_TYPES.add(InternalAction_3007);
			KNOWN_ELEMENT_TYPES.add(ParametricResourceDemand_3031);
			KNOWN_ELEMENT_TYPES.add(BranchAction_3009);
			KNOWN_ELEMENT_TYPES.add(ProbabilisticBranchTransition_3010);
			KNOWN_ELEMENT_TYPES.add(ResourceDemandingBehaviour_3011);
			KNOWN_ELEMENT_TYPES.add(ExternalCallAction_3012);
			KNOWN_ELEMENT_TYPES.add(AcquireAction_3026);
			KNOWN_ELEMENT_TYPES.add(ReleaseAction_3020);
			KNOWN_ELEMENT_TYPES.add(ForkAction_3023);
			KNOWN_ELEMENT_TYPES.add(ForkedBehaviour_3027);
			KNOWN_ELEMENT_TYPES.add(CollectionIteratorAction_3013);
			KNOWN_ELEMENT_TYPES.add(ResourceDemandingBehaviour_3014);
			KNOWN_ELEMENT_TYPES.add(SetVariableAction_3024);
			KNOWN_ELEMENT_TYPES.add(VariableUsage_3036);
			KNOWN_ELEMENT_TYPES.add(VariableCharacterisation_3037);
			KNOWN_ELEMENT_TYPES.add(GuardedBranchTransition_3017);
			KNOWN_ELEMENT_TYPES.add(ResourceDemandingBehaviour_3018);
			KNOWN_ELEMENT_TYPES
					.add(AbstractActionSuccessor_AbstractAction_4001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

}
