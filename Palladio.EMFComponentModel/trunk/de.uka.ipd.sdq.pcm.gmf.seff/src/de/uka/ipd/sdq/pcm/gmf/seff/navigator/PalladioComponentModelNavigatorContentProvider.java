/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AbstractActionSuccessor_AbstractActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionBranchTransitionCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionBranchTransitionCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionParameterUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionParameterUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionResourceDemand2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionResourceDemandEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionBehaviourCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionBehaviourCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ProbabilisticBranchTransitionBehaviourCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ProbabilisticBranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBranchCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourLoopCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageVariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.part.Messages;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class PalladioComponentModelNavigatorContentProvider implements
		ICommonContentProvider {

	/**
	 * @generated
	 */
	private static final Object[] EMPTY_ARRAY = new Object[0];

	/**
	 * @generated
	 */
	public void dispose() {
	}

	/**
	 * @generated
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	/**
	 * @generated
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			AdapterFactoryEditingDomain editingDomain = (AdapterFactoryEditingDomain) GMFEditingDomainFactory.INSTANCE
					.createEditingDomain();
			editingDomain.setResourceToReadOnlyMap(new HashMap() {
				public Object get(Object key) {
					if (!containsKey(key)) {
						put(key, Boolean.TRUE);
					}
					return super.get(key);
				}
			});
			ResourceSet resourceSet = editingDomain.getResourceSet();

			org.eclipse.emf.common.util.URI fileURI = org.eclipse.emf.common.util.URI
					.createPlatformResourceURI(file.getFullPath().toString(),
							true);
			Resource resource = resourceSet.getResource(fileURI, true);
			Collection result = new ArrayList();
			result.addAll(createNavigatorItems(selectViewsByType(resource
					.getContents(), ResourceDemandingSEFFEditPart.MODEL_ID),
					file, false));
			return result.toArray();
		}

		if (parentElement instanceof PalladioComponentModelNavigatorGroup) {
			PalladioComponentModelNavigatorGroup group = (PalladioComponentModelNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof PalladioComponentModelNavigatorItem) {
			PalladioComponentModelNavigatorItem navigatorItem = (PalladioComponentModelNavigatorItem) parentElement;
			if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
				return EMPTY_ARRAY;
			}
			return getViewChildren(navigatorItem.getView(), parentElement);
		}

		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Object[] getViewChildren(View view, Object parentElement) {
		switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {

		case ResourceDemandingSEFFEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup links = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ResourceDemandingSEFF_1000_links,
					"icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view), StartActionEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					StopActionEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ExternalCallActionEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					LoopActionEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					BranchAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					InternalAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			links
					.addChildren(createNavigatorItems(connectedViews, links,
							false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case StartActionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_StartAction_2001_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_StartAction_2001_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case StopActionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_StopAction_2002_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_StopAction_2002_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case ExternalCallActionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ExternalCallAction_2003_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ExternalCallAction_2003_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					ExternalCallActionParameterUsageEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					VariableUsageEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case LoopActionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_LoopAction_2004_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_LoopAction_2004_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					LoopActionBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ResourceDemandingBehaviourEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case BranchAction2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_BranchAction_2005_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_BranchAction_2005_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ProbabilisticBranchTransitionEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case InternalAction2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_InternalAction_2006_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_InternalAction_2006_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					InternalActionResourceDemand2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ParametricResourceDemandEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case VariableUsageEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					VariableUsageVariableCharacterisationEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					VariableCharacterisationEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case ResourceDemandingBehaviourEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					StartAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BranchActionEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ProbabilisticBranchTransitionEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(
					connectedViews,
					ProbabilisticBranchTransitionBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ResourceDemandingBehaviour2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(
					connectedViews,
					ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					StartAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					StopAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BranchActionEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ProbabilisticBranchTransitionEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(
					connectedViews,
					ProbabilisticBranchTransitionBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ResourceDemandingBehaviour2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(
					connectedViews,
					ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					StopAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					LoopAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BranchActionEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ProbabilisticBranchTransitionEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(
					connectedViews,
					ProbabilisticBranchTransitionBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ResourceDemandingBehaviour2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(
					connectedViews,
					ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					LoopAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					InternalActionEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BranchActionEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ProbabilisticBranchTransitionEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(
					connectedViews,
					ProbabilisticBranchTransitionBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ResourceDemandingBehaviour2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(
					connectedViews,
					ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					InternalActionEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BranchActionEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BranchActionEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ProbabilisticBranchTransitionEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(
					connectedViews,
					ProbabilisticBranchTransitionBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ResourceDemandingBehaviour2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(
					connectedViews,
					ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ExternalCallAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ExternalCallAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case StartAction2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_StartAction_3004_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_StartAction_3004_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case StopAction2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_StopAction_3005_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_StopAction_3005_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case LoopAction2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_LoopAction_3006_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_LoopAction_3006_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					LoopActionBehaviourCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ResourceDemandingBehaviourEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case InternalActionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_InternalAction_3007_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_InternalAction_3007_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					InternalActionResourceDemandEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ParametricResourceDemandEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case BranchActionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_BranchAction_3009_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_BranchAction_3009_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ProbabilisticBranchTransitionEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case ProbabilisticBranchTransitionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			Collection connectedViews = getChildrenByType(
					Collections.singleton(view),
					ProbabilisticBranchTransitionBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ResourceDemandingBehaviour2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case ResourceDemandingBehaviour2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			Collection connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					StartAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					LoopAction2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					LoopActionBehaviourCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ResourceDemandingBehaviourEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					StartAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					StopAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					LoopAction2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					LoopActionBehaviourCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ResourceDemandingBehaviourEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					StopAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					LoopAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					LoopAction2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					LoopActionBehaviourCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ResourceDemandingBehaviourEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					InternalActionEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					InternalActionEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					LoopAction2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					LoopActionBehaviourCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ResourceDemandingBehaviourEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BranchActionEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BranchActionEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					LoopAction2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					LoopActionBehaviourCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ResourceDemandingBehaviourEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ExternalCallAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ExternalCallAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case ExternalCallAction2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ExternalCallAction_3012_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ExternalCallAction_3012_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					ExternalCallActionParameterUsage2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					VariableUsageEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_AbstractActionSuccessor_AbstractAction_4001_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_AbstractActionSuccessor_AbstractAction_4001_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections
					.singleton(view), StartActionEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					StopActionEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					ExternalCallActionEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					LoopActionEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					BranchAction2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					InternalAction2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					StartAction2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					StopAction2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					LoopAction2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					InternalActionEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					BranchActionEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					ExternalCallAction2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					StartActionEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					StopActionEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					ExternalCallActionEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					LoopActionEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					BranchAction2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					InternalAction2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					StartAction2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					StopAction2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					LoopAction2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					InternalActionEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					BranchActionEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					ExternalCallAction2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!source.isEmpty()) {
				result.add(source);
			}
			if (!target.isEmpty()) {
				result.add(target);
			}
			return result.toArray();
		}
		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Collection getLinksSourceByType(Collection edges, int visualID) {
		Collection result = new ArrayList();
		String type = PalladioComponentModelVisualIDRegistry.getType(visualID);
		for (Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType())
					&& isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getLinksTargetByType(Collection edges, int visualID) {
		Collection result = new ArrayList();
		String type = PalladioComponentModelVisualIDRegistry.getType(visualID);
		for (Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType())
					&& isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getOutgoingLinksByType(Collection nodes, int visualID) {
		Collection result = new ArrayList();
		String type = PalladioComponentModelVisualIDRegistry.getType(visualID);
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getIncomingLinksByType(Collection nodes, int visualID) {
		Collection result = new ArrayList();
		String type = PalladioComponentModelVisualIDRegistry.getType(visualID);
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getChildrenByType(Collection nodes, int visualID) {
		Collection result = new ArrayList();
		String type = PalladioComponentModelVisualIDRegistry.getType(visualID);
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getDiagramLinksByType(Collection diagrams, int visualID) {
		Collection result = new ArrayList();
		String type = PalladioComponentModelVisualIDRegistry.getType(visualID);
		for (Iterator it = diagrams.iterator(); it.hasNext();) {
			Diagram nextDiagram = (Diagram) it.next();
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection selectViewsByType(Collection views, String type) {
		Collection result = new ArrayList();
		for (Iterator it = views.iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return ResourceDemandingSEFFEditPart.MODEL_ID
				.equals(PalladioComponentModelVisualIDRegistry.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection createNavigatorItems(Collection views, Object parent,
			boolean isLeafs) {
		Collection result = new ArrayList();
		for (Iterator it = views.iterator(); it.hasNext();) {
			result.add(new PalladioComponentModelNavigatorItem(
					(View) it.next(), parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if (element instanceof PalladioComponentModelAbstractNavigatorItem) {
			PalladioComponentModelAbstractNavigatorItem abstractNavigatorItem = (PalladioComponentModelAbstractNavigatorItem) element;
			return abstractNavigatorItem.getParent();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean hasChildren(Object element) {
		return element instanceof IFile || getChildren(element).length > 0;
	}

}
