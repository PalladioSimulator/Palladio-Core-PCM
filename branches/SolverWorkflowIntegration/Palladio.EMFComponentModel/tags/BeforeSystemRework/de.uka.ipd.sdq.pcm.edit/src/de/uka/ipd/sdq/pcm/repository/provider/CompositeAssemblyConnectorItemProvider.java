/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.provider;


import de.uka.ipd.sdq.pcm.assembly.provider.PcmEditPlugin;

import de.uka.ipd.sdq.pcm.core.connectors.provider.ConnectorItemProvider;

import de.uka.ipd.sdq.pcm.repository.CompositeAssemblyConnector;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

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
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.pcm.repository.CompositeAssemblyConnector} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CompositeAssemblyConnectorItemProvider
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
	public CompositeAssemblyConnectorItemProvider(AdapterFactory adapterFactory) {
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

			addRequiringChildComponentContext_CompositeAssemblyConnectorPropertyDescriptor(object);
			addProvidingChildComponentContext_CompositeAssemblyConnectorPropertyDescriptor(object);
			addProvidedRole_CompositeAssemblyConnectorPropertyDescriptor(object);
			addRequiredRole_CompositeAssemblyConnectorPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Requiring Child Component Context Composite Assembly Connector feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequiringChildComponentContext_CompositeAssemblyConnectorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CompositeAssemblyConnector_requiringChildComponentContext_CompositeAssemblyConnector_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CompositeAssemblyConnector_requiringChildComponentContext_CompositeAssemblyConnector_feature", "_UI_CompositeAssemblyConnector_type"),
				 RepositoryPackage.Literals.COMPOSITE_ASSEMBLY_CONNECTOR__REQUIRING_CHILD_COMPONENT_CONTEXT_COMPOSITE_ASSEMBLY_CONNECTOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Providing Child Component Context Composite Assembly Connector feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProvidingChildComponentContext_CompositeAssemblyConnectorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CompositeAssemblyConnector_providingChildComponentContext_CompositeAssemblyConnector_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CompositeAssemblyConnector_providingChildComponentContext_CompositeAssemblyConnector_feature", "_UI_CompositeAssemblyConnector_type"),
				 RepositoryPackage.Literals.COMPOSITE_ASSEMBLY_CONNECTOR__PROVIDING_CHILD_COMPONENT_CONTEXT_COMPOSITE_ASSEMBLY_CONNECTOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Provided Role Composite Assembly Connector feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProvidedRole_CompositeAssemblyConnectorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CompositeAssemblyConnector_providedRole_CompositeAssemblyConnector_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CompositeAssemblyConnector_providedRole_CompositeAssemblyConnector_feature", "_UI_CompositeAssemblyConnector_type"),
				 RepositoryPackage.Literals.COMPOSITE_ASSEMBLY_CONNECTOR__PROVIDED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Required Role Composite Assembly Connector feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequiredRole_CompositeAssemblyConnectorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CompositeAssemblyConnector_requiredRole_CompositeAssemblyConnector_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CompositeAssemblyConnector_requiredRole_CompositeAssemblyConnector_feature", "_UI_CompositeAssemblyConnector_type"),
				 RepositoryPackage.Literals.COMPOSITE_ASSEMBLY_CONNECTOR__REQUIRED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns CompositeAssemblyConnector.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CompositeAssemblyConnector"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((CompositeAssemblyConnector)object).getId();
		return label == null || label.length() == 0 ?
			getString("_UI_CompositeAssemblyConnector_type") :
			getString("_UI_CompositeAssemblyConnector_type") + " " + label;
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
