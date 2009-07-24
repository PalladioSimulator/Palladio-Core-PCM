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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AbstractActionSuccessor_AbstractActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AcquireAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AcquireActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionBranchTransitionCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionBranchTransitionCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionInputVariableUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionInputVariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionOutputVariableUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionOutputVariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionForkedBehaviours2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionForkedBehavioursEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkedBehaviourBehaviourCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkedBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.GuardedBranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionResourceDemand2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionResourceDemandEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ProbabilisticBranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBehaviourCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBehaviourCompartment3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBehaviourCompartment4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBehaviourCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionVariableSetter2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionVariableSetterEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageVariableCharacterisation2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageVariableCharacterisation3EditPart;
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
	private Viewer myViewer;

	/**
	 * @generated
	 */
	private AdapterFactoryEditingDomain myEditingDomain;

	/**
	 * @generated
	 */
	private WorkspaceSynchronizer myWorkspaceSynchronizer;

	/**
	 * @generated
	 */
	private Runnable myViewerRefreshRunnable;

	/**
	 * @generated
	 */
	public PalladioComponentModelNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
				.createEditingDomain();
		myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
		myEditingDomain.setResourceToReadOnlyMap(new HashMap() {
			public Object get(Object key) {
				if (!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		myViewerRefreshRunnable = new Runnable() {
			public void run() {
				if (myViewer != null) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain,
				new WorkspaceSynchronizer.Delegate() {
					public void dispose() {
					}

					public boolean handleResourceChanged(final Resource resource) {
						for (Iterator it = myEditingDomain.getResourceSet()
								.getResources().iterator(); it.hasNext();) {
							Resource nextResource = (Resource) it.next();
							nextResource.unload();
						}
						if (myViewer != null) {
							myViewer.getControl().getDisplay().asyncExec(
									myViewerRefreshRunnable);
						}
						return true;
					}

					public boolean handleResourceDeleted(Resource resource) {
						for (Iterator it = myEditingDomain.getResourceSet()
								.getResources().iterator(); it.hasNext();) {
							Resource nextResource = (Resource) it.next();
							nextResource.unload();
						}
						if (myViewer != null) {
							myViewer.getControl().getDisplay().asyncExec(
									myViewerRefreshRunnable);
						}
						return true;
					}

					public boolean handleResourceMoved(Resource resource,
							final URI newURI) {
						for (Iterator it = myEditingDomain.getResourceSet()
								.getResources().iterator(); it.hasNext();) {
							Resource nextResource = (Resource) it.next();
							nextResource.unload();
						}
						if (myViewer != null) {
							myViewer.getControl().getDisplay().asyncExec(
									myViewerRefreshRunnable);
						}
						return true;
					}
				});
	}

	/**
	 * @generated
	 */
	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
		for (Iterator it = myEditingDomain.getResourceSet().getResources()
				.iterator(); it.hasNext();) {
			Resource resource = (Resource) it.next();
			resource.unload();
		}
		((TransactionalEditingDomain) myEditingDomain).dispose();
		myEditingDomain = null;
	}

	/**
	 * @generated
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		myViewer = viewer;
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
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath()
					.toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(
					fileURI, true);
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
					BranchActionEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					InternalActionEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					CollectionIteratorActionEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					SetVariableActionEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					AcquireActionEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ReleaseActionEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ForkActionEditPart.VISUAL_ID);
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
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_StartAction_2001_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_StartAction_2001_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
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
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case StopActionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_StopAction_2002_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_StopAction_2002_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
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
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ExternalCallActionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ExternalCallAction_2003_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ExternalCallAction_2003_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					ExternalCallActionInputVariableUsageEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					VariableUsageEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ExternalCallActionOutputVariableUsageEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					VariableUsage2EditPart.VISUAL_ID);
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
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case LoopActionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_LoopAction_2004_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_LoopAction_2004_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
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
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case BranchActionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_BranchAction_2005_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_BranchAction_2005_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ProbabilisticBranchTransitionEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					GuardedBranchTransitionEditPart.VISUAL_ID);
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
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case InternalActionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_InternalAction_2006_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_InternalAction_2006_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
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
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case CollectionIteratorActionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_CollectionIteratorAction_2007_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_CollectionIteratorAction_2007_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					ResourceDemandingBehaviour3EditPart.VISUAL_ID);
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
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case SetVariableActionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_SetVariableAction_2008_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_SetVariableAction_2008_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					SetVariableActionVariableSetter2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					VariableUsage3EditPart.VISUAL_ID);
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
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case AcquireActionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_AcquireAction_2012_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_AcquireAction_2012_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
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
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ReleaseActionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ReleaseAction_2010_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ReleaseAction_2010_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
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
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ForkActionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ForkAction_2011_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ForkAction_2011_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					ForkActionForkedBehaviours2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ForkedBehaviourEditPart.VISUAL_ID);
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
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
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

		case VariableUsage2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					VariableUsageVariableCharacterisation2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					VariableCharacterisation2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case ResourceDemandingBehaviourEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			Collection connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					StartAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					StopAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					LoopAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					InternalAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BranchAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ExternalCallAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					CollectionIteratorAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					AcquireAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ReleaseAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ForkAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					SetVariableAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case StartAction2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_StartAction_3004_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_StartAction_3004_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
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
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case StopAction2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_StopAction_3005_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_StopAction_3005_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
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
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case LoopAction2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_LoopAction_3006_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_LoopAction_3006_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
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
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case InternalAction2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_InternalAction_3007_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_InternalAction_3007_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
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
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case BranchAction2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_BranchAction_3009_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_BranchAction_3009_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ProbabilisticBranchTransitionEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					GuardedBranchTransitionEditPart.VISUAL_ID);
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
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ProbabilisticBranchTransitionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					ResourceDemandingBehaviour2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case ResourceDemandingBehaviour2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			Collection connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					StartAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					StopAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					LoopAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					InternalAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BranchAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ExternalCallAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					AcquireAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ReleaseAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ForkAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					CollectionIteratorAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					SetVariableAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case ExternalCallAction2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ExternalCallAction_3012_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ExternalCallAction_3012_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					ExternalCallActionInputVariableUsage2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					VariableUsageEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ExternalCallActionOutputVariableUsage2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					VariableUsage2EditPart.VISUAL_ID);
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
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case AcquireAction2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_AcquireAction_3026_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_AcquireAction_3026_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
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
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ReleaseAction2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ReleaseAction_3020_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ReleaseAction_3020_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
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
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ForkAction2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ForkAction_3023_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ForkAction_3023_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					ForkActionForkedBehavioursEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ForkedBehaviourEditPart.VISUAL_ID);
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
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ForkedBehaviourEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					StartAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					StopAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					LoopAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					InternalAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BranchAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ExternalCallAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					CollectionIteratorAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					AcquireAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ReleaseAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ForkAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case CollectionIteratorAction2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_CollectionIteratorAction_3013_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_CollectionIteratorAction_3013_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					ResourceDemandingBehaviour3EditPart.VISUAL_ID);
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
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ResourceDemandingBehaviour3EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			Collection connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					StartAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					StopAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					LoopAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					InternalAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BranchAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ExternalCallAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					CollectionIteratorAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					AcquireAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ReleaseAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ForkAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case SetVariableAction2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_SetVariableAction_3024_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_SetVariableAction_3024_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					SetVariableActionVariableSetterEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					VariableUsage3EditPart.VISUAL_ID);
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
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case VariableUsage3EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					VariableUsageVariableCharacterisation3EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					VariableCharacterisation3EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case GuardedBranchTransitionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					ResourceDemandingBehaviour4EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case ResourceDemandingBehaviour4EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			Collection connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					StartAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					StopAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					LoopAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					InternalAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					BranchAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ExternalCallAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					AcquireAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ReleaseAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ForkAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					CollectionIteratorAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					SetVariableAction2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_AbstractActionSuccessor_AbstractAction_4001_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_AbstractActionSuccessor_AbstractAction_4001_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
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
					BranchActionEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					InternalActionEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					CollectionIteratorActionEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					SetVariableActionEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					AcquireActionEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					ReleaseActionEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					ForkActionEditPart.VISUAL_ID);
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
					InternalAction2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					BranchAction2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					ExternalCallAction2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					AcquireAction2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					ReleaseAction2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					ForkAction2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					CollectionIteratorAction2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					SetVariableAction2EditPart.VISUAL_ID);
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
					BranchActionEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					InternalActionEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					CollectionIteratorActionEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					SetVariableActionEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					AcquireActionEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					ReleaseActionEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					ForkActionEditPart.VISUAL_ID);
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
					InternalAction2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					BranchAction2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					ExternalCallAction2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					AcquireAction2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					ReleaseAction2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					ForkAction2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					CollectionIteratorAction2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					SetVariableAction2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
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
