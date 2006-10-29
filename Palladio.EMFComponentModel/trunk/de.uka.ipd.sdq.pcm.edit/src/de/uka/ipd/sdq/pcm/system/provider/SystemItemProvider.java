/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.system.provider;


import de.uka.ipd.sdq.pcm.assembly.provider.PcmEditPlugin;

import de.uka.ipd.sdq.pcm.core.entity.provider.EntityItemProvider;

import de.uka.ipd.sdq.pcm.system.SystemFactory;
import de.uka.ipd.sdq.pcm.system.SystemPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.pcm.system.System} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SystemItemProvider
	extends EntityItemProvider
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
	public SystemItemProvider(AdapterFactory adapterFactory) {
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

			addAssembly_SystemPropertyDescriptor(object);
			addAllocation_SystemPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Assembly System feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAssembly_SystemPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_System_assembly_System_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_System_assembly_System_feature", "_UI_System_type"),
				 SystemPackage.Literals.SYSTEM__ASSEMBLY_SYSTEM,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Allocation System feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAllocation_SystemPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_System_allocation_System_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_System_allocation_System_feature", "_UI_System_type"),
				 SystemPackage.Literals.SYSTEM__ALLOCATION_SYSTEM,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(SystemPackage.Literals.SYSTEM__SYSTEM_PROVIDED_ROLE_SYSTEM);
			childrenFeatures.add(SystemPackage.Literals.SYSTEM__PROVIDED_DELEGATION_CONNECTOR_SYSTEM);
			childrenFeatures.add(SystemPackage.Literals.SYSTEM__REQUIRED_DELEGATION_CONNECTOR_SYSTEM);
			childrenFeatures.add(SystemPackage.Literals.SYSTEM__SYSTEM_REQUIRED_ROLE_SYSTEM);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns System.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/System"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((de.uka.ipd.sdq.pcm.system.System)object).getId();
		return label == null || label.length() == 0 ?
			getString("_UI_System_type") :
			getString("_UI_System_type") + " " + label;
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

		switch (notification.getFeatureID(de.uka.ipd.sdq.pcm.system.System.class)) {
			case SystemPackage.SYSTEM__SYSTEM_PROVIDED_ROLE_SYSTEM:
			case SystemPackage.SYSTEM__PROVIDED_DELEGATION_CONNECTOR_SYSTEM:
			case SystemPackage.SYSTEM__REQUIRED_DELEGATION_CONNECTOR_SYSTEM:
			case SystemPackage.SYSTEM__SYSTEM_REQUIRED_ROLE_SYSTEM:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
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

		newChildDescriptors.add
			(createChildParameter
				(SystemPackage.Literals.SYSTEM__SYSTEM_PROVIDED_ROLE_SYSTEM,
				 SystemFactory.eINSTANCE.createSystemProvidedRole()));

		newChildDescriptors.add
			(createChildParameter
				(SystemPackage.Literals.SYSTEM__PROVIDED_DELEGATION_CONNECTOR_SYSTEM,
				 SystemFactory.eINSTANCE.createSystemProvidedDelegationConnector()));

		newChildDescriptors.add
			(createChildParameter
				(SystemPackage.Literals.SYSTEM__REQUIRED_DELEGATION_CONNECTOR_SYSTEM,
				 SystemFactory.eINSTANCE.createSystemRequiredDelegationConnector()));

		newChildDescriptors.add
			(createChildParameter
				(SystemPackage.Literals.SYSTEM__SYSTEM_REQUIRED_ROLE_SYSTEM,
				 SystemFactory.eINSTANCE.createSystemRequiredRole()));
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
