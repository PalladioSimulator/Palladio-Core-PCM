/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.navigator;

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

import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentComponentParameterCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentPassiveResourceCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentSEFFCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeParentProvidesComponentTypesEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompositeComponentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ImplementationComponentTypeParentCompleteComponentTypesEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceSignatureListEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.PassiveResourceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesComponentTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RepositoryEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceInterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceInterfaceResourceServiceListEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceServiceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SignatureEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SubSystemEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableUsageComponentParameterVariableCharacterisationCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.part.Messages;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;

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
					.getContents(), RepositoryEditPart.MODEL_ID), file, false));
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

		case RepositoryEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			result.addAll(getForeignShortcuts((Diagram) view, parentElement));
			PalladioComponentModelNavigatorGroup links = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_Repository_1000_links,
					"icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view), InterfaceEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ResourceInterfaceEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					BasicComponentEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					CompositeComponentEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					CompleteComponentTypeEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ProvidesComponentTypeEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					SubSystemEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view),
					ProvidedRoleEditPart.VISUAL_ID);
			links
					.addChildren(createNavigatorItems(connectedViews, links,
							false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view),
					RequiredRoleEditPart.VISUAL_ID);
			links
					.addChildren(createNavigatorItems(connectedViews, links,
							false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(view),
					ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID);
			links
					.addChildren(createNavigatorItems(connectedViews, links,
							false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(view),
					CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID);
			links
					.addChildren(createNavigatorItems(connectedViews, links,
							false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view),
					ResourceRequiredRoleEditPart.VISUAL_ID);
			links
					.addChildren(createNavigatorItems(connectedViews, links,
							false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case InterfaceEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_Interface_2101_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view), InterfaceSignatureListEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					SignatureEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view), ProvidedRoleEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view), RequiredRoleEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case ResourceInterfaceEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ResourceInterface_2107_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					ResourceInterfaceResourceServiceListEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ResourceServiceEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view), ProvidedRoleEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					ResourceRequiredRoleEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case BasicComponentEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_BasicComponent_2102_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					BasicComponentSEFFCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					ResourceDemandingSEFFEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					BasicComponentPassiveResourceCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					PassiveResourceEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					BasicComponentComponentParameterCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					VariableUsageEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), ProvidedRoleEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), RequiredRoleEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ResourceRequiredRoleEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case CompositeComponentEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_CompositeComponent_2105_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getOutgoingLinksByType(Collections
					.singleton(view), ProvidedRoleEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), RequiredRoleEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ResourceRequiredRoleEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case CompleteComponentTypeEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_CompleteComponentType_2103_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_CompleteComponentType_2103_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getOutgoingLinksByType(Collections
					.singleton(view), ProvidedRoleEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), RequiredRoleEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ResourceRequiredRoleEditPart.VISUAL_ID);
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

		case ProvidesComponentTypeEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ProvidesComponentType_2104_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ProvidesComponentType_2104_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getOutgoingLinksByType(Collections
					.singleton(view), ProvidedRoleEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), RequiredRoleEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ResourceRequiredRoleEditPart.VISUAL_ID);
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

		case SubSystemEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_SubSystem_2106_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getOutgoingLinksByType(Collections
					.singleton(view), ProvidedRoleEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), RequiredRoleEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ResourceRequiredRoleEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case VariableUsageEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			Collection connectedViews = getChildrenByType(
					Collections.singleton(view),
					VariableUsageComponentParameterVariableCharacterisationCompartmentEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					VariableCharacterisationEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case ProvidedRoleEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ProvidedRole_4101_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ProvidedRole_4101_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections
					.singleton(view), InterfaceEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					ResourceInterfaceEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					BasicComponentEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					CompositeComponentEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					CompleteComponentTypeEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					ProvidesComponentTypeEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					SubSystemEditPart.VISUAL_ID);
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

		case RequiredRoleEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_RequiredRole_4102_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_RequiredRole_4102_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections
					.singleton(view), InterfaceEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					BasicComponentEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					CompositeComponentEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					CompleteComponentTypeEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					ProvidesComponentTypeEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					SubSystemEditPart.VISUAL_ID);
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

		case ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ImplementationComponentTypeParentCompleteComponentTypes_4103_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ImplementationComponentTypeParentCompleteComponentTypes_4103_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections
					.singleton(view), CompleteComponentTypeEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					BasicComponentEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					CompositeComponentEditPart.VISUAL_ID);
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

		case CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_CompleteComponentTypeParentProvidesComponentTypes_4104_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_CompleteComponentTypeParentProvidesComponentTypes_4104_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections
					.singleton(view), ProvidesComponentTypeEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					CompleteComponentTypeEditPart.VISUAL_ID);
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

		case ResourceRequiredRoleEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ResourceRequiredRole_4106_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
					Messages.NavigatorGroupName_ResourceRequiredRole_4106_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections
					.singleton(view), ResourceInterfaceEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					BasicComponentEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					CompositeComponentEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					CompleteComponentTypeEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					ProvidesComponentTypeEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					SubSystemEditPart.VISUAL_ID);
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
		return RepositoryEditPart.MODEL_ID
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
	private Collection getForeignShortcuts(Diagram diagram, Object parent) {
		Collection result = new ArrayList();
		for (Iterator it = diagram.getChildren().iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (!isOwnView(nextView)
					&& nextView.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				result.add(nextView);
			}
		}
		return createNavigatorItems(result, parent, false);
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