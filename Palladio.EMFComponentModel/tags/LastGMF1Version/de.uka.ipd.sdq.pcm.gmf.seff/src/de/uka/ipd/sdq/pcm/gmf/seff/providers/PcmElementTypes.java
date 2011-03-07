/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.providers;

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

import de.uka.ipd.sdq.pcm.gmf.seff.part.PcmDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
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
			elements.put(ResourceDemandingSEFF_79, SeffPackage.eINSTANCE
					.getResourceDemandingSEFF());
			elements.put(VariableUsage_2001, ParameterPackage.eINSTANCE
					.getVariableUsage());
			elements.put(VariableCharacterisation_2002,
					ParameterPackage.eINSTANCE.getVariableCharacterisation());
			elements.put(ResourceDemandingBehaviour_2003, SeffPackage.eINSTANCE
					.getResourceDemandingBehaviour());
			elements.put(StartAction_2004, SeffPackage.eINSTANCE
					.getStartAction());
			elements
					.put(StopAction_2005, SeffPackage.eINSTANCE.getStopAction());
			elements
					.put(LoopAction_2006, SeffPackage.eINSTANCE.getLoopAction());
			elements.put(InternalAction_2007, SeffPackage.eINSTANCE
					.getInternalAction());
			elements.put(ParametricResourceDemand_2008, SeffPackage.eINSTANCE
					.getParametricResourceDemand());
			elements.put(BranchAction_2009, SeffPackage.eINSTANCE
					.getBranchAction());
			elements.put(ProbabilisticBranchTransition_2010,
					SeffPackage.eINSTANCE.getProbabilisticBranchTransition());
			elements.put(ResourceDemandingBehaviour_2011, SeffPackage.eINSTANCE
					.getResourceDemandingBehaviour());
			elements.put(ExternalCallAction_2012, SeffPackage.eINSTANCE
					.getExternalCallAction());
			elements.put(StartAction_1001, SeffPackage.eINSTANCE
					.getStartAction());
			elements
					.put(StopAction_1002, SeffPackage.eINSTANCE.getStopAction());
			elements.put(ExternalCallAction_1003, SeffPackage.eINSTANCE
					.getExternalCallAction());
			elements
					.put(LoopAction_1004, SeffPackage.eINSTANCE.getLoopAction());
			elements.put(BranchAction_1005, SeffPackage.eINSTANCE
					.getBranchAction());
			elements.put(InternalAction_1006, SeffPackage.eINSTANCE
					.getInternalAction());
			elements.put(AbstractActionSuccessor_AbstractAction_3001,
					SeffPackage.eINSTANCE
							.getAbstractAction_Successor_AbstractAction());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	public static final IElementType ResourceDemandingSEFF_79 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.ResourceDemandingSEFF_79"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType VariableUsage_2001 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.VariableUsage_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType VariableCharacterisation_2002 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.VariableCharacterisation_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ResourceDemandingBehaviour_2003 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.ResourceDemandingBehaviour_2003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType StartAction_2004 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.StartAction_2004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType StopAction_2005 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.StopAction_2005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LoopAction_2006 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.LoopAction_2006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InternalAction_2007 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.InternalAction_2007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ParametricResourceDemand_2008 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.ParametricResourceDemand_2008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType BranchAction_2009 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.BranchAction_2009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ProbabilisticBranchTransition_2010 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.ProbabilisticBranchTransition_2010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ResourceDemandingBehaviour_2011 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.ResourceDemandingBehaviour_2011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ExternalCallAction_2012 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.ExternalCallAction_2012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType StartAction_1001 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.StartAction_1001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType StopAction_1002 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.StopAction_1002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ExternalCallAction_1003 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.ExternalCallAction_1003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LoopAction_1004 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.LoopAction_1004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType BranchAction_1005 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.BranchAction_1005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InternalAction_1006 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.InternalAction_1006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AbstractActionSuccessor_AbstractAction_3001 = getElementType("de.uka.ipd.sdq.pcm.gmf.seff.AbstractActionSuccessor_AbstractAction_3001"); //$NON-NLS-1$

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
			KNOWN_ELEMENT_TYPES.add(ResourceDemandingSEFF_79);
			KNOWN_ELEMENT_TYPES.add(VariableUsage_2001);
			KNOWN_ELEMENT_TYPES.add(VariableCharacterisation_2002);
			KNOWN_ELEMENT_TYPES.add(ResourceDemandingBehaviour_2003);
			KNOWN_ELEMENT_TYPES.add(StartAction_2004);
			KNOWN_ELEMENT_TYPES.add(StopAction_2005);
			KNOWN_ELEMENT_TYPES.add(LoopAction_2006);
			KNOWN_ELEMENT_TYPES.add(InternalAction_2007);
			KNOWN_ELEMENT_TYPES.add(ParametricResourceDemand_2008);
			KNOWN_ELEMENT_TYPES.add(BranchAction_2009);
			KNOWN_ELEMENT_TYPES.add(ProbabilisticBranchTransition_2010);
			KNOWN_ELEMENT_TYPES.add(ResourceDemandingBehaviour_2011);
			KNOWN_ELEMENT_TYPES.add(ExternalCallAction_2012);
			KNOWN_ELEMENT_TYPES.add(StartAction_1001);
			KNOWN_ELEMENT_TYPES.add(StopAction_1002);
			KNOWN_ELEMENT_TYPES.add(ExternalCallAction_1003);
			KNOWN_ELEMENT_TYPES.add(LoopAction_1004);
			KNOWN_ELEMENT_TYPES.add(BranchAction_1005);
			KNOWN_ELEMENT_TYPES.add(InternalAction_1006);
			KNOWN_ELEMENT_TYPES
					.add(AbstractActionSuccessor_AbstractAction_3001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}
}
