/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.system.provider;


import de.uka.ipd.sdq.pcm.assembly.provider.PcmEditPlugin;

import de.uka.ipd.sdq.pcm.system.SystemPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.pcm.system.SystemRequiredDelegationConnector} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SystemRequiredDelegationConnectorItemProvider
	extends ItemProviderAdapter
	implements	
		IEditingDomainItemProvider,	
		IStructuredItemContentProvider,	
		ITreeItemContentProvider,	
		IItemLabelProvider,	
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemRequiredDelegationConnectorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addSystemRequiredRole_SystemRequiredDelegationConnectorPropertyDescriptor(object);
			addAssemblyContext_SystemRequiredDelegationConnectorPropertyDescriptor(object);
			addRequiredRole_SystemRequiredDelegationConnectorPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the System Required Role System Required Delegation Connector feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSystemRequiredRole_SystemRequiredDelegationConnectorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SystemRequiredDelegationConnector_systemRequiredRole_SystemRequiredDelegationConnector_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SystemRequiredDelegationConnector_systemRequiredRole_SystemRequiredDelegationConnector_feature", "_UI_SystemRequiredDelegationConnector_type"),
				 SystemPackage.Literals.SYSTEM_REQUIRED_DELEGATION_CONNECTOR__SYSTEM_REQUIRED_ROLE_SYSTEM_REQUIRED_DELEGATION_CONNECTOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Assembly Context System Required Delegation Connector feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAssemblyContext_SystemRequiredDelegationConnectorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SystemRequiredDelegationConnector_assemblyContext_SystemRequiredDelegationConnector_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SystemRequiredDelegationConnector_assemblyContext_SystemRequiredDelegationConnector_feature", "_UI_SystemRequiredDelegationConnector_type"),
				 SystemPackage.Literals.SYSTEM_REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SYSTEM_REQUIRED_DELEGATION_CONNECTOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Required Role System Required Delegation Connector feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequiredRole_SystemRequiredDelegationConnectorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SystemRequiredDelegationConnector_requiredRole_SystemRequiredDelegationConnector_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SystemRequiredDelegationConnector_requiredRole_SystemRequiredDelegationConnector_feature", "_UI_SystemRequiredDelegationConnector_type"),
				 SystemPackage.Literals.SYSTEM_REQUIRED_DELEGATION_CONNECTOR__REQUIRED_ROLE_SYSTEM_REQUIRED_DELEGATION_CONNECTOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns SystemRequiredDelegationConnector.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SystemRequiredDelegationConnector"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		return getString("_UI_SystemRequiredDelegationConnector_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		super.notifyChanged(notification);
	}

	/**
	 * This adds to the collection of {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing all of the children that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return PcmEditPlugin.INSTANCE;
	}

}
