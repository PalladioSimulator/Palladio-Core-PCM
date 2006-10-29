/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.provider;


import de.uka.ipd.sdq.pcm.assembly.provider.PcmEditPlugin;

import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;

import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

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
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EntryLevelSystemCallItemProvider
	extends AbstractUserActionItemProvider
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
	public EntryLevelSystemCallItemProvider(AdapterFactory adapterFactory) {
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

			addSystemProvidedRole_EntryLevelSystemCallPropertyDescriptor(object);
			addSignature_EntryLevelSystemCallPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the System Provided Role Entry Level System Call feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSystemProvidedRole_EntryLevelSystemCallPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntryLevelSystemCall_systemProvidedRole_EntryLevelSystemCall_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntryLevelSystemCall_systemProvidedRole_EntryLevelSystemCall_feature", "_UI_EntryLevelSystemCall_type"),
				 UsagemodelPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL__SYSTEM_PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Signature Entry Level System Call feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSignature_EntryLevelSystemCallPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntryLevelSystemCall_signature_EntryLevelSystemCall_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntryLevelSystemCall_signature_EntryLevelSystemCall_feature", "_UI_EntryLevelSystemCall_type"),
				 UsagemodelPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL__SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL,
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
			childrenFeatures.add(UsagemodelPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL__ACTUAL_PARAMETER_USAGE_ENTRY_LEVEL_SYSTEM_CALL);
		}
		return childrenFeatures;
	}

	/**
	 * This returns EntryLevelSystemCall.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/EntryLevelSystemCall"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		return getString("_UI_EntryLevelSystemCall_type");
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

		switch (notification.getFeatureID(EntryLevelSystemCall.class)) {
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__ACTUAL_PARAMETER_USAGE_ENTRY_LEVEL_SYSTEM_CALL:
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
				(UsagemodelPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL__ACTUAL_PARAMETER_USAGE_ENTRY_LEVEL_SYSTEM_CALL,
				 ParameterFactory.eINSTANCE.createParameterUsage()));

		newChildDescriptors.add
			(createChildParameter
				(UsagemodelPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL__ACTUAL_PARAMETER_USAGE_ENTRY_LEVEL_SYSTEM_CALL,
				 ParameterFactory.eINSTANCE.createCompositeParameterUsage()));

		newChildDescriptors.add
			(createChildParameter
				(UsagemodelPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL__ACTUAL_PARAMETER_USAGE_ENTRY_LEVEL_SYSTEM_CALL,
				 ParameterFactory.eINSTANCE.createCollectionParameterUsage()));
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
