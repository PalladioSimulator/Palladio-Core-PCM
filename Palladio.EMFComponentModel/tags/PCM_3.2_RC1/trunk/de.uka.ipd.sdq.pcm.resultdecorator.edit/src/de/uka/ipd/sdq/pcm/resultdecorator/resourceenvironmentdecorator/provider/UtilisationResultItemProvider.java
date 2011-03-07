/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.provider;


import de.uka.ipd.sdq.pcm.core.entity.provider.NamedElementItemProvider;

import de.uka.ipd.sdq.pcm.resultdecorator.provider.ResultdecoratorEditPlugin;

import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;

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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UtilisationResultItemProvider
	extends NamedElementItemProvider
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
	public UtilisationResultItemProvider(AdapterFactory adapterFactory) {
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

			addNormalisedResourceUtilisationPropertyDescriptor(object);
			addNormalisedWaitTimePropertyDescriptor(object);
			addResourceUtilisationPropertyDescriptor(object);
			addAverageWaitTimePropertyDescriptor(object);
			addAverageQueueLengthPropertyDescriptor(object);
			addMaxQueueLengthPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Normalised Resource Utilisation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNormalisedResourceUtilisationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UtilisationResult_normalisedResourceUtilisation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UtilisationResult_normalisedResourceUtilisation_feature", "_UI_UtilisationResult_type"),
				 ResourceenvironmentdecoratorPackage.Literals.UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Normalised Wait Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNormalisedWaitTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UtilisationResult_normalisedWaitTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UtilisationResult_normalisedWaitTime_feature", "_UI_UtilisationResult_type"),
				 ResourceenvironmentdecoratorPackage.Literals.UTILISATION_RESULT__NORMALISED_WAIT_TIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Resource Utilisation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResourceUtilisationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UtilisationResult_resourceUtilisation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UtilisationResult_resourceUtilisation_feature", "_UI_UtilisationResult_type"),
				 ResourceenvironmentdecoratorPackage.Literals.UTILISATION_RESULT__RESOURCE_UTILISATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Average Wait Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAverageWaitTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UtilisationResult_averageWaitTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UtilisationResult_averageWaitTime_feature", "_UI_UtilisationResult_type"),
				 ResourceenvironmentdecoratorPackage.Literals.UTILISATION_RESULT__AVERAGE_WAIT_TIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Average Queue Length feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAverageQueueLengthPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UtilisationResult_averageQueueLength_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UtilisationResult_averageQueueLength_feature", "_UI_UtilisationResult_type"),
				 ResourceenvironmentdecoratorPackage.Literals.UTILISATION_RESULT__AVERAGE_QUEUE_LENGTH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Queue Length feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxQueueLengthPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UtilisationResult_maxQueueLength_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UtilisationResult_maxQueueLength_feature", "_UI_UtilisationResult_type"),
				 ResourceenvironmentdecoratorPackage.Literals.UTILISATION_RESULT__MAX_QUEUE_LENGTH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
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
		String label = ((UtilisationResult)object).getEntityName();
		return label == null || label.length() == 0 ?
			getString("_UI_UtilisationResult_type") :
			getString("_UI_UtilisationResult_type") + " " + label;
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

		switch (notification.getFeatureID(UtilisationResult.class)) {
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION:
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_WAIT_TIME:
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__RESOURCE_UTILISATION:
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__AVERAGE_WAIT_TIME:
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__AVERAGE_QUEUE_LENGTH:
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__MAX_QUEUE_LENGTH:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ResultdecoratorEditPlugin.INSTANCE;
	}

}
