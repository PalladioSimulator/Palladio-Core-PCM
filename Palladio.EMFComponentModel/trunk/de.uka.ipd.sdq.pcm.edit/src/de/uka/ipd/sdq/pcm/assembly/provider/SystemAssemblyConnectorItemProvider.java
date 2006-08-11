/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.assembly.provider;


import de.uka.ipd.sdq.pcm.assembly.AssemblyPackage;
import de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector;

import de.uka.ipd.sdq.pcm.core.connectors.provider.ConnectorItemProvider;

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

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SystemAssemblyConnectorItemProvider
	extends ConnectorItemProvider
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
	public SystemAssemblyConnectorItemProvider(AdapterFactory adapterFactory) {
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

			addProvidingContext_SystemAssemblyConnectorPropertyDescriptor(object);
			addRequiringContext_SystemAssemblyConnectorPropertyDescriptor(object);
			addProvidedRole_SystemAssemblyConnectorPropertyDescriptor(object);
			addRequiredRole_SystemAssemblyConnectorPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Providing Context System Assembly Connector feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProvidingContext_SystemAssemblyConnectorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SystemAssemblyConnector_providingContext_SystemAssemblyConnector_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SystemAssemblyConnector_providingContext_SystemAssemblyConnector_feature", "_UI_SystemAssemblyConnector_type"),
				 AssemblyPackage.Literals.SYSTEM_ASSEMBLY_CONNECTOR__PROVIDING_CONTEXT_SYSTEM_ASSEMBLY_CONNECTOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Requiring Context System Assembly Connector feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequiringContext_SystemAssemblyConnectorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SystemAssemblyConnector_requiringContext_SystemAssemblyConnector_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SystemAssemblyConnector_requiringContext_SystemAssemblyConnector_feature", "_UI_SystemAssemblyConnector_type"),
				 AssemblyPackage.Literals.SYSTEM_ASSEMBLY_CONNECTOR__REQUIRING_CONTEXT_SYSTEM_ASSEMBLY_CONNECTOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Provided Role System Assembly Connector feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProvidedRole_SystemAssemblyConnectorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SystemAssemblyConnector_providedRole_SystemAssemblyConnector_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SystemAssemblyConnector_providedRole_SystemAssemblyConnector_feature", "_UI_SystemAssemblyConnector_type"),
				 AssemblyPackage.Literals.SYSTEM_ASSEMBLY_CONNECTOR__PROVIDED_ROLE_SYSTEM_ASSEMBLY_CONNECTOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Required Role System Assembly Connector feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequiredRole_SystemAssemblyConnectorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SystemAssemblyConnector_requiredRole_SystemAssemblyConnector_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SystemAssemblyConnector_requiredRole_SystemAssemblyConnector_feature", "_UI_SystemAssemblyConnector_type"),
				 AssemblyPackage.Literals.SYSTEM_ASSEMBLY_CONNECTOR__REQUIRED_ROLE_SYSTEM_ASSEMBLY_CONNECTOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns SystemAssemblyConnector.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SystemAssemblyConnector"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((SystemAssemblyConnector)object).getId();
		return label == null || label.length() == 0 ?
			getString("_UI_SystemAssemblyConnector_type") :
			getString("_UI_SystemAssemblyConnector_type") + " " + label;
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
