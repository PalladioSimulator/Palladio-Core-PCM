/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation.provider;


import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentAllocationConnector;

import de.uka.ipd.sdq.pcm.core.connectors.provider.ConnectorItemProvider;

import de.uka.ipd.sdq.pcm.core.provider.PalladioComponentModelEditPlugin;

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
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentAllocationConnector} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class InfrastructureComponentAllocationConnectorItemProvider
	extends ConnectorItemProvider
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
	public InfrastructureComponentAllocationConnectorItemProvider(AdapterFactory adapterFactory) {
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

			addResourceRequiredRole_AllocationConnectorPropertyDescriptor(object);
			addResourceContainer_AllocationConnectorPropertyDescriptor(object);
			addAssemblyContext_AllocationConnectorPropertyDescriptor(object);
			addProvidedRole_AllocationConnectorPropertyDescriptor(object);
			addInfrastructureComponentScope_InfrastructureComponentAllocationConnectorPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Resource Required Role Allocation Connector feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResourceRequiredRole_AllocationConnectorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllocationConnector_resourceRequiredRole_AllocationConnector_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllocationConnector_resourceRequiredRole_AllocationConnector_feature", "_UI_AllocationConnector_type"),
				 AllocationPackage.Literals.ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Resource Container Allocation Connector feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResourceContainer_AllocationConnectorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllocationConnector_resourceContainer_AllocationConnector_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllocationConnector_resourceContainer_AllocationConnector_feature", "_UI_AllocationConnector_type"),
				 AllocationPackage.Literals.ALLOCATION_CONNECTOR__RESOURCE_CONTAINER_ALLOCATION_CONNECTOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Assembly Context Allocation Connector feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAssemblyContext_AllocationConnectorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllocationConnector_assemblyContext_AllocationConnector_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllocationConnector_assemblyContext_AllocationConnector_feature", "_UI_AllocationConnector_type"),
				 AllocationPackage.Literals.ALLOCATION_CONNECTOR__ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Provided Role Allocation Connector feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProvidedRole_AllocationConnectorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InfrastructureComponentAllocationConnector_providedRole_AllocationConnector_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InfrastructureComponentAllocationConnector_providedRole_AllocationConnector_feature", "_UI_InfrastructureComponentAllocationConnector_type"),
				 AllocationPackage.Literals.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__PROVIDED_ROLE_ALLOCATION_CONNECTOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Infrastructure Component Scope Infrastructure Component Allocation Connector feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInfrastructureComponentScope_InfrastructureComponentAllocationConnectorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InfrastructureComponentAllocationConnector_infrastructureComponentScope_InfrastructureComponentAllocationConnector_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InfrastructureComponentAllocationConnector_infrastructureComponentScope_InfrastructureComponentAllocationConnector_feature", "_UI_InfrastructureComponentAllocationConnector_type"),
				 AllocationPackage.Literals.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__INFRASTRUCTURE_COMPONENT_SCOPE_INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns InfrastructureComponentAllocationConnector.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/InfrastructureComponentAllocationConnector"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((InfrastructureComponentAllocationConnector)object).getId();
		return label == null || label.length() == 0 ?
			getString("_UI_InfrastructureComponentAllocationConnector_type") :
			getString("_UI_InfrastructureComponentAllocationConnector_type") + " " + label;
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
