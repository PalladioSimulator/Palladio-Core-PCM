/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package LqnCore.provider;


import LqnCore.EntryType;
import LqnCore.LqnCoreFactory;
import LqnCore.LqnCorePackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link LqnCore.EntryType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EntryTypeItemProvider
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
	public EntryTypeItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
			addOpenArrivalRatePropertyDescriptor(object);
			addPriorityPropertyDescriptor(object);
			addSemaphorePropertyDescriptor(object);
			addTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntryType_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntryType_name_feature", "_UI_EntryType_type"),
				 LqnCorePackage.Literals.ENTRY_TYPE__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Open Arrival Rate feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOpenArrivalRatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntryType_openArrivalRate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntryType_openArrivalRate_feature", "_UI_EntryType_type"),
				 LqnCorePackage.Literals.ENTRY_TYPE__OPEN_ARRIVAL_RATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Priority feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPriorityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntryType_priority_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntryType_priority_feature", "_UI_EntryType_type"),
				 LqnCorePackage.Literals.ENTRY_TYPE__PRIORITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Semaphore feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSemaphorePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntryType_semaphore_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntryType_semaphore_feature", "_UI_EntryType_type"),
				 LqnCorePackage.Literals.ENTRY_TYPE__SEMAPHORE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntryType_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntryType_type_feature", "_UI_EntryType_type"),
				 LqnCorePackage.Literals.ENTRY_TYPE__TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(LqnCorePackage.Literals.ENTRY_TYPE__RESULT_ENTRY);
			childrenFeatures.add(LqnCorePackage.Literals.ENTRY_TYPE__SERVICE_TIME_DISTRIBUTION);
			childrenFeatures.add(LqnCorePackage.Literals.ENTRY_TYPE__FORWARDING);
			childrenFeatures.add(LqnCorePackage.Literals.ENTRY_TYPE__ENTRY_ACTIVITY_GRAPH);
			childrenFeatures.add(LqnCorePackage.Literals.ENTRY_TYPE__ENTRY_PHASE_ACTIVITIES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns EntryType.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/EntryType"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((EntryType)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_EntryType_type") :
			getString("_UI_EntryType_type") + " " + label;
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

		switch (notification.getFeatureID(EntryType.class)) {
			case LqnCorePackage.ENTRY_TYPE__NAME:
			case LqnCorePackage.ENTRY_TYPE__OPEN_ARRIVAL_RATE:
			case LqnCorePackage.ENTRY_TYPE__PRIORITY:
			case LqnCorePackage.ENTRY_TYPE__SEMAPHORE:
			case LqnCorePackage.ENTRY_TYPE__TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case LqnCorePackage.ENTRY_TYPE__RESULT_ENTRY:
			case LqnCorePackage.ENTRY_TYPE__SERVICE_TIME_DISTRIBUTION:
			case LqnCorePackage.ENTRY_TYPE__FORWARDING:
			case LqnCorePackage.ENTRY_TYPE__ENTRY_ACTIVITY_GRAPH:
			case LqnCorePackage.ENTRY_TYPE__ENTRY_PHASE_ACTIVITIES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
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

		newChildDescriptors.add
			(createChildParameter
				(LqnCorePackage.Literals.ENTRY_TYPE__RESULT_ENTRY,
				 LqnCoreFactory.eINSTANCE.createOutputResultType()));

		newChildDescriptors.add
			(createChildParameter
				(LqnCorePackage.Literals.ENTRY_TYPE__SERVICE_TIME_DISTRIBUTION,
				 LqnCoreFactory.eINSTANCE.createOutputEntryDistributionType()));

		newChildDescriptors.add
			(createChildParameter
				(LqnCorePackage.Literals.ENTRY_TYPE__FORWARDING,
				 LqnCoreFactory.eINSTANCE.createEntryMakingCallType()));

		newChildDescriptors.add
			(createChildParameter
				(LqnCorePackage.Literals.ENTRY_TYPE__ENTRY_ACTIVITY_GRAPH,
				 LqnCoreFactory.eINSTANCE.createEntryActivityGraph()));

		newChildDescriptors.add
			(createChildParameter
				(LqnCorePackage.Literals.ENTRY_TYPE__ENTRY_PHASE_ACTIVITIES,
				 LqnCoreFactory.eINSTANCE.createPhaseActivities()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return LqnEditPlugin.INSTANCE;
	}

}
