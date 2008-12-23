/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.provider;


import de.uka.ipd.sdq.pcm.allocation.provider.AllocationConnectorItemProvider;

import de.uka.ipd.sdq.pcm.core.provider.PalladioComponentModelEditPlugin;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceProvidedRoleConnector} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ResourceProvidedRoleConnectorItemProvider
	extends AllocationConnectorItemProvider
	implements	
		IEditingDomainItemProvider,	
		IStructuredItemContentProvider,	
		ITreeItemContentProvider,	
		IItemLabelProvider,	
		IItemPropertySource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceProvidedRoleConnectorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addResourceProvidedRole_ResourceProvidedRoleAllocationConnectorPropertyDescriptor(object);
			addRequiringControllerInstance_ControllerAllocationConnectorPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Resource Provided Role Resource Provided Role Allocation Connector feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResourceProvidedRole_ResourceProvidedRoleAllocationConnectorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ResourceProvidedRoleConnector_resourceProvidedRole_ResourceProvidedRoleAllocationConnector_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ResourceProvidedRoleConnector_resourceProvidedRole_ResourceProvidedRoleAllocationConnector_feature", "_UI_ResourceProvidedRoleConnector_type"),
				 ResourceenvironmentPackage.Literals.RESOURCE_PROVIDED_ROLE_CONNECTOR__RESOURCE_PROVIDED_ROLE_RESOURCE_PROVIDED_ROLE_ALLOCATION_CONNECTOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Requiring Controller Instance Controller Allocation Connector feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequiringControllerInstance_ControllerAllocationConnectorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ResourceProvidedRoleConnector_requiringControllerInstance_ControllerAllocationConnector_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ResourceProvidedRoleConnector_requiringControllerInstance_ControllerAllocationConnector_feature", "_UI_ResourceProvidedRoleConnector_type"),
				 ResourceenvironmentPackage.Literals.RESOURCE_PROVIDED_ROLE_CONNECTOR__REQUIRING_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_ResourceProvidedRoleConnector_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return PalladioComponentModelEditPlugin.INSTANCE;
	}

}
