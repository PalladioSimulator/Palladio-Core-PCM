/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration.provider;


import de.uka.ipd.sdq.identifier.provider.IdentifierItemProvider;

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
import org.eclipse.emf.edit.provider.ViewerNotification;

import scheduler.configuration.ConfigurationFactory;
import scheduler.configuration.ConfigurationPackage;
import scheduler.configuration.SchedulerConfiguration;

import scheduler.provider.SchedulerConfigurationEditPlugin;

/**
 * This is the item provider adapter for a {@link scheduler.configuration.SchedulerConfiguration} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SchedulerConfigurationItemProvider
	extends IdentifierItemProvider
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
	public SchedulerConfigurationItemProvider(AdapterFactory adapterFactory) {
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
			addInFrontAfterWaitingPropertyDescriptor(object);
			addWindowsPropertyDescriptor(object);
			addIntervalPropertyDescriptor(object);
			addStarvationBoostPropertyDescriptor(object);
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
				 getString("_UI_SchedulerConfiguration_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SchedulerConfiguration_name_feature", "_UI_SchedulerConfiguration_type"),
				 ConfigurationPackage.Literals.SCHEDULER_CONFIGURATION__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the In Front After Waiting feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInFrontAfterWaitingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SchedulerConfiguration_inFrontAfterWaiting_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SchedulerConfiguration_inFrontAfterWaiting_feature", "_UI_SchedulerConfiguration_type"),
				 ConfigurationPackage.Literals.SCHEDULER_CONFIGURATION__IN_FRONT_AFTER_WAITING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Windows feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWindowsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SchedulerConfiguration_Windows_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SchedulerConfiguration_Windows_feature", "_UI_SchedulerConfiguration_type"),
				 ConfigurationPackage.Literals.SCHEDULER_CONFIGURATION__WINDOWS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Interval feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIntervalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SchedulerConfiguration_interval_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SchedulerConfiguration_interval_feature", "_UI_SchedulerConfiguration_type"),
				 ConfigurationPackage.Literals.SCHEDULER_CONFIGURATION__INTERVAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Starvation Boost feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStarvationBoostPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SchedulerConfiguration_starvationBoost_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SchedulerConfiguration_starvationBoost_feature", "_UI_SchedulerConfiguration_type"),
				 ConfigurationPackage.Literals.SCHEDULER_CONFIGURATION__STARVATION_BOOST,
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
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ConfigurationPackage.Literals.SCHEDULER_CONFIGURATION__PRIORITY_CONFIGURATION);
			childrenFeatures.add(ConfigurationPackage.Literals.SCHEDULER_CONFIGURATION__PREEMPTION_CONFIGURATION);
			childrenFeatures.add(ConfigurationPackage.Literals.SCHEDULER_CONFIGURATION__QUEUEING_CONFIGURATION);
			childrenFeatures.add(ConfigurationPackage.Literals.SCHEDULER_CONFIGURATION__STARVATION_BOOST);
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
	 * This returns SchedulerConfiguration.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SchedulerConfiguration"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((SchedulerConfiguration)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_SchedulerConfiguration_type") :
			getString("_UI_SchedulerConfiguration_type") + " " + label;
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

		switch (notification.getFeatureID(SchedulerConfiguration.class)) {
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__NAME:
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__IN_FRONT_AFTER_WAITING:
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__WINDOWS:
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__INTERVAL:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__PRIORITY_CONFIGURATION:
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__PREEMPTION_CONFIGURATION:
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__QUEUEING_CONFIGURATION:
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__STARVATION_BOOST:
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
				(ConfigurationPackage.Literals.SCHEDULER_CONFIGURATION__PRIORITY_CONFIGURATION,
				 ConfigurationFactory.eINSTANCE.createPriorityConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationPackage.Literals.SCHEDULER_CONFIGURATION__PREEMPTION_CONFIGURATION,
				 ConfigurationFactory.eINSTANCE.createPreemptionConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationPackage.Literals.SCHEDULER_CONFIGURATION__QUEUEING_CONFIGURATION,
				 ConfigurationFactory.eINSTANCE.createMultipleQueueConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationPackage.Literals.SCHEDULER_CONFIGURATION__QUEUEING_CONFIGURATION,
				 ConfigurationFactory.eINSTANCE.createSingleQueueConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationPackage.Literals.SCHEDULER_CONFIGURATION__STARVATION_BOOST,
				 ConfigurationFactory.eINSTANCE.createStarvationBoost()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return SchedulerConfigurationEditPlugin.INSTANCE;
	}

}
